package com.xiao.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginIntercepter implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("执行后，返回前执行....");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //在处理过程中进行拦截
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //已经登录了就放行 否则进行拦截
        HttpSession session=request.getSession();
        if(session.getAttribute("user")!=null){
            return true;//放行
        }else{
            //没有登录 跳转到登录页面进行登录操作
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }
    }
}
