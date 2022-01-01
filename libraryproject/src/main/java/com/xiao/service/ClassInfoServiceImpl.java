package com.xiao.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiao.dao.ClassInfoDao;
import com.xiao.po.ClassInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("classService")
public class ClassInfoServiceImpl implements ClassInfoService{

    @Autowired
    private ClassInfoDao classDao;
    @Override
    public PageInfo<ClassInfo> queryClassInfoAll(String name,int page,int limit) {
        //传入参数，每页条数 当前页
        PageHelper.startPage(page,limit);
        List<ClassInfo> list=classDao.queryClassInfoAll(name);
        //通过包装获取分页需要的其他值信息
        PageInfo<ClassInfo> pageInfo=new PageInfo<>(list);
        return pageInfo;

    }

    @Override
    public void addTypeSubmit(ClassInfo info) {
        classDao.addTypeSubmit(info);
    }

    @Override
    public ClassInfo queryClassInfoById(Integer id) {
        return classDao.queryClassInfoById(id);
    }

    @Override
    public void updateTypeSubmit(ClassInfo info) {
         classDao.updateTypeSubmit(info);
    }

    @Override
    public void deleteTypeByIds(List<String> id) {
        List<Integer> list=new ArrayList<>();
        for(String cid:id){
           int id2= Integer.valueOf(cid);
           list.add(id2);
        }
        classDao.deleteTypeByIds(list);
    }


}
