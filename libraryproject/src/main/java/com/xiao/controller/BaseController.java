package com.xiao.controller;

import com.github.pagehelper.PageInfo;
import com.xiao.po.BookInfo;
import com.xiao.po.Notice;
import com.xiao.service.BookInfoService;
import com.xiao.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BaseController {
    @Autowired
    private NoticeService noticeService;

    @Autowired
    private BookInfoService bookInfoService;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    /**
     * 欢迎页面转换
     */
    @GetMapping("/welcome")
    public String welcome(Model model)
    {
        //1、提供公告信息
          PageInfo<Notice> pageInfo=noticeService.queryNoticeAll(null,1,1);
          if(pageInfo!=null){
              if(pageInfo.getList().size()>0){
                  Notice notice=pageInfo.getList().get(0);
                  model.addAttribute("info",notice);
              }
          }
          //根据图书类型查询图书数量
          List <BookInfo> list=bookInfoService.getBookCountByType();
          model.addAttribute("list",list);
          return "welcome";
    }

}
