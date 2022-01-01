package com.xiao.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiao.dao.ReaderCardMapper;
import com.xiao.po.ReaderCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("readerService")
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    private ReaderCardMapper readerDao;

    @Override
    public PageInfo<ReaderCard> queryReaderAll(ReaderCard readerCard, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<ReaderCard> list=readerDao.queryReaderListAll(readerCard);
        PageInfo<ReaderCard> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void addReaderInfoSubmit(ReaderCard readerCard) {
        readerDao.insertSelective(readerCard);
    }

    @Override
    public ReaderCard queryReaderById(Integer id) {
        return readerDao.selectByPrimaryKey(id);
    }

    @Override
    public void updateReaderInfoSubmit(ReaderCard readerCard) {
           readerDao.updateByPrimaryKey(readerCard);
    }

    @Override
    public void deleteReaderByIds(List<String> ids) {
            for(String id:ids){
                readerDao.deleteByPrimaryKey(Integer.valueOf(id));
            }
    }

    @Override
    public ReaderCard queryUserInfoByNameAndPassword(String username, String password) {
        return readerDao.queryUserInfoByNameAndPassword(username,password);
    }
}
