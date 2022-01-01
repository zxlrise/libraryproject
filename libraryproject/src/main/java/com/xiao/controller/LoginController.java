package com.xiao.controller;

import com.xiao.codeutil.IVerifyCodeGen;
import com.xiao.codeutil.SimpleCharVerifyCodeGenImpl;
import com.xiao.codeutil.VerifyCode;
import com.xiao.po.Admin;
import com.xiao.po.ReaderCard;
import com.xiao.service.AdminService;
import com.xiao.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private ReaderService readerService;
    /**
     * 登录页面的转发
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 获取验证码方法
     * @param request
     * @param response
     */
    @RequestMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        try {
            //设置长宽
            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 28);
            String code = verifyCode.getCode();
//            LOGGER.info(code);
            //将VerifyCode绑定session
            request.getSession().setAttribute("VerifyCode", code);
            //设置响应头
            response.setHeader("Pragma", "no-cache");
            //设置响应头
            response.setHeader("Cache-Control", "no-cache");
            //在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
            //设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
//            LOGGER.info("", e);
            System.out.println("异常处理");
        }
    }

    /**
     * 登录验证方法
     */
    @RequestMapping("/loginIn")
    public String loginIn(HttpServletRequest request, Model model){
        //获取用户名和密码
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String code=request.getParameter("captcha");
        String type=request.getParameter("type");
        //验证登录是否超时
        HttpSession session=request.getSession();
        if(session==null){
            model.addAttribute("msg","登录超时了...");
            return "login";
        }

        //验证码是否正确
        String realCode= (String) session.getAttribute("VerifyCode");
        if(!realCode.toLowerCase().equals(code.toLowerCase())){
            model.addAttribute("msg","验证码不正确...");
            return "login";
        }

        if(type.equals("1")){//管理员信息
            //用户名和密码是否正确
            Admin user=adminService.queryUserByNameAndPassword(username,password);
            if(user==null){//该用户不存在
                model.addAttribute("msg","用户名或者密码错误...");
                return "login";
            }
            session.setAttribute("user",user);
            session.setAttribute("type","admin");
        }else{//来自读者信息表

            ReaderCard readerCard=readerService.queryUserInfoByNameAndPassword(username,password);
            if(readerCard==null){
                model.addAttribute("msg","用户名或者密码错误...");
                return "login";
            }
            session.setAttribute("user",readerCard);
            session.setAttribute("type","reader");
        }

        return "index";
    }


    /**
     * 退出功能
     */
    @GetMapping("/loginOut")
    public String loginOut(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.invalidate();;
        return "redirect:/login";
    }

}
