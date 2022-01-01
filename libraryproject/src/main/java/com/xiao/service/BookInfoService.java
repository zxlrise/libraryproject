package com.xiao.service;

import com.github.pagehelper.PageInfo;
import com.xiao.po.BookInfo;

import java.util.List;

public interface BookInfoService {

    /**
     * 分页查询图书记录信息
     */
    PageInfo<BookInfo> queryBookInfoAll(BookInfo bookInfo, int page, int limit);

    /**
     * 添加
     */
    void addBookSubmit(BookInfo info);

    /**
     * 修改
     */
    void updateBookSubmit(BookInfo info);

    /**
     * 根据id查询记录
     */
    BookInfo queryBookInfoById(Integer id);

    /**
     * 删除功能
     */
    void deleteBookInfoById(List<String> ids);

    /**
     * 根据图书的类型获取图书的数量
     */
    List<BookInfo> getBookCountByType();

}
