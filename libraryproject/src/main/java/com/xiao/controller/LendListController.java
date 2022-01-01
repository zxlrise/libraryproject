package com.xiao.controller;

import com.github.pagehelper.PageInfo;
import com.xiao.po.BookInfo;
import com.xiao.po.LendList;
import com.xiao.po.ReaderCard;
import com.xiao.service.BookInfoService;
import com.xiao.service.LendListService;
import com.xiao.service.ReaderService;
import com.xiao.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class LendListController {
    @Autowired
    private LendListService lendListService;
    @Autowired
    private ReaderService readerService;

    @Autowired
    private BookInfoService bookInfoService;

    @GetMapping("/lendListIndex")
    public String lendListIndex(){
        return "lend/lendListIndex";
    }

    /**
     * 查询所有的列表
     * 1 request获取
     * 2、参数绑定
     * 3、对象绑定
     */
    @ResponseBody
    @RequestMapping("/lendListAll")
    public R lendListAll(Integer type, String cardnumber, String name, Integer status,
                         @RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "15")Integer limit){

        LendList info=new LendList();
        info.setType(type);

        //创建读者对象
        ReaderCard reader=new ReaderCard();
        reader.setCardnumber(cardnumber);
        //把以上对象交给info
        info.setReader(reader);

       //图书对象
        BookInfo book=new BookInfo();
        book.setName(name);
        book.setStatus( status);
        info.setBookInfo(book);

        //分页查询所有的记录信息
        PageInfo pageInfo=lendListService.queryLendListAll(info,page,limit);
        return R.ok("ok",pageInfo.getTotal(),pageInfo.getList());
    }


    /**
     * 添加跳转
     */
    @GetMapping("/addLendList")
    public String addLendList(){
        return "lend/addLendList";
    }

    /**
     * 借书信息提交
     * 1判断借阅号码是否存在
     * 2、可借的数据是否大于等于当前的借书量
     * 3、添加借书记录，同时改变书的状态信息
     * cardnumber:借书号码
     * ids：字符串 书id的集合
     */
    @ResponseBody
    @RequestMapping("/addLend")
    public R addLend(String cardnumber,String ids){
        //获取图书id的集合
        List<String> list= Arrays.asList(ids.split(","));
        //判断卡号是否存在
        ReaderCard reader=new ReaderCard();
        reader.setCardnumber(cardnumber);
        PageInfo<ReaderCard> pageInfo=readerService.queryReaderAll(reader,1,1);
        if(pageInfo.getList().size()==0){
            return R.fail("卡号信息不存在");
        }else{
            //判断用户的可借书数是否大于等于当前要借数据
            ReaderCard readerCard2=pageInfo.getList().get(0);
            int num=readerCard2.getNumber();//获取限制书数据
            //获取当前读者已经借了基本
            int number=lendListService.queryBookNum(readerCard2.getId());
            //判断
            if(num-number>=list.size()){
                //可借书
                for(String bid:list){
                    LendList lendList=new LendList();
                    lendList.setReaderId(readerCard2.getId());//读者id
                    lendList.setBookId(Integer.valueOf(bid));//书的id
                    lendList.setLendDate(new Date());
                    lendListService.addLendListSubmit(lendList);
                    //更变书的状态
                    BookInfo info=bookInfoService.queryBookInfoById(Integer.valueOf(bid));
                    //设置书的状态
                    info.setStatus(1);
                    bookInfoService.updateBookSubmit(info);
                }

            }else{
                return R.fail("目前借书数量大于可借数量....");
            }

        }

        return R.ok();
    }


    /**
     * 删除借阅记录
     */
    @ResponseBody
    @RequestMapping("/deleteLendListByIds")
    public R deleteLendListByIds(String ids,String bookIds){
        List list=Arrays.asList(ids.split(","));//借阅记录的id
        List blist=Arrays.asList(bookIds.split(","));//图书信息的id

        int num=lendListService.deleteLendListById(list,blist);
        return R.ok();
    }

    /**
     * 还书功能
     */
    @ResponseBody
    @RequestMapping("/backLendListByIds")
    public R backLendListByIds(String ids,String bookIds){
        List list=Arrays.asList(ids.split(","));//借阅记录的id
        List blist=Arrays.asList(bookIds.split(","));//图书信息的id
        int num=lendListService.updateLendListSubmit(list,blist);
        return R.ok();
    }

    /**
     * 页面跳转 异常还书
     */
    @GetMapping("/excBackBook")
    public String excBackBook(HttpServletRequest request, Model model){
       //获取借阅记录id
        String id=request.getParameter("id");
        String  bId=request.getParameter("bookId");
        model.addAttribute("id",id);
        model.addAttribute("bid",bId);
        return "lend/excBackBook";
    }

    /**
     * 异常还书
     */
    @ResponseBody
    @RequestMapping("/updateLendInfoSubmit")
    public R updateLendInfoSubmit(LendList lendList){
        lendListService.backBook(lendList);
        return R.ok();
    }

    /**
     * 查阅时间线
     */
    @RequestMapping("/queryLookBookList")
    public String queryLookBookList(String flag,Integer id,Model model){
        List<LendList> list=null;
        if(flag.equals("book")){
             list=lendListService.queryLookBookList(null,id);
        }else{
             list=lendListService.queryLookBookList(id,null);
        }
        model.addAttribute("info",list);
        return "lend/lookBookList";
    }


    /**
     * 查阅时间线2
     */
    @RequestMapping("/queryLookBookList2")
    public String queryLookBookList2(HttpServletRequest request ,Model model){
        ReaderCard readerCard= (ReaderCard) request.getSession().getAttribute("user");
        List<LendList>   list=lendListService.queryLookBookList(readerCard.getId(),null);
        model.addAttribute("info",list);
        return "lend/lookBookList";
    }
}
