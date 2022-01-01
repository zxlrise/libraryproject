<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="utf-8">
    <title>添加读者信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>css/public.css" media="all">
    <style>
        body {
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<div class="layui-form layuimini-form">
    <div class="layui-form-item">
        <label class="layui-form-label required">卡号</label>
        <div class="layui-input-block">
            <input type="text" name="cardnumber" lay-verify="required" lay-reqtext="卡号名称不能为空" placeholder="请输入卡号名称" value="" class="layui-input">
            <tip>填写自己卡号，建议使用身份证号码。</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="username" lay-verify="required" lay-reqtext="用户名不能为空" placeholder="请输入用户名" value="" class="layui-input">
            <tip>填写昵称。</tip>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label ">真实姓名</label>
        <div class="layui-input-block">
            <input type="text" name="name"  lay-reqtext="真实姓名不能为空" placeholder="请输入真实姓名" value="" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label ">性别</label>
        <div class="layui-input-block">
            <input type="radio" name="sex" value="男" title="男" checked="checked"/>
            <input type="radio" name="sex" value="女" title="女" />
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label ">出生日期</label>
        <div class="layui-input-block">
            <input type="text" name="birthday" id="date1" autocomplete="off"  class="layui-input" placeholder="yyyy-MM-dd">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label ">联系方式</label>
        <div class="layui-input-block">
            <input type="tel" name="tel"   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label ">邮箱地址</label>
        <div class="layui-input-block">
            <input type="email" name="email"   class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label required">借书数量</label>
        <div class="layui-input-block">
            <input type="number" name="number"   class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
        </div>
    </div>
</div>
<script src="<%=basePath%>lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form','laydate'], function () {
        var form = layui.form,
            layer = layui.layer,
            laydate=layui.laydate,
            $ = layui.$;

        //日期
        laydate.render({
            elem: '#date1',
            trigger:'click'
        });



        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var datas=data.field;//form单中的数据信息
            //向后台发送数据提交添加
            $.ajax({
                url:"addReaderSubmit",
                type:"POST",
                // data:datas,
                contentType:'application/json',
                data:JSON.stringify(datas),
                success:function(result){
                    if(result.code==0){//如果成功
                        layer.msg('添加成功',{
                            icon:6,
                            time:500
                        },function(){
                            parent.window.location.reload();
                            var iframeIndex = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(iframeIndex);
                        })
                    }else{
                         layer.msg("添加失败了");
                    }
                }
            })
            return false;
        });




    });
</script>
</body>
</html>
