package com.xiao.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiao.dao.BookInfoMapper;
import com.xiao.po.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookInfoService")
public class BookInfoServiceImpl implements BookInfoService{
    @Autowired
    private BookInfoMapper bookinfoDao;

    @Override
    public PageInfo<BookInfo> queryBookInfoAll(BookInfo bookInfo, int page, int limit) {
        //设置当前页以及每页记录数
        PageHelper.startPage(page,limit);
        //获取所有记录信息
        List<BookInfo> list=bookinfoDao.queryBookInfoAll(bookInfo);
        PageInfo<BookInfo> pageInfo=new PageInfo<>(list);
        return pageInfo;

    }

    @Override
    public void addBookSubmit(BookInfo info) {
        bookinfoDao.insert(info);
    }

    @Override
    public void updateBookSubmit(BookInfo info) {
       bookinfoDao.updateByPrimaryKeyWithBLOBs(info);
    }

    @Override
    public BookInfo queryBookInfoById(Integer id) {
        return bookinfoDao.selectByPrimaryKey(id);
    }

    @Override
    public void deleteBookInfoById(List<String> ids) {
        for(String id:ids){
            bookinfoDao.deleteByPrimaryKey(Integer.valueOf(id));
        }
    }

    @Override
    public List<BookInfo> getBookCountByType() {
        return bookinfoDao.getBookCountByType();
    }
}
