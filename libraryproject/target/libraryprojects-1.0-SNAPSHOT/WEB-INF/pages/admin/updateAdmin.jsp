<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page isELIgnored="false" %>

<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <meta charset="utf-8">
    <title>修改密码</title>
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
    <input type="hidden" name="id"  value="${id}">
    <div class="layui-form-item">
        <label class="layui-form-label required">原密码</label>
        <div class="layui-input-block">
            <input type="password" name="oldPwd" lay-verify="required" placeholder="请输入原密码" class="layui-input">
            <tip>请输入原密码。</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">请输入新密码</label>
        <div class="layui-input-block">
            <input type="password" name="newPwd" lay-verify="required" placeholder="请输入新密码" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">请再次输入新密码</label>
        <div class="layui-input-block">
            <input type="password" name="newPwd2" lay-verify="required" placeholder="请再次输入新密码" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">修改密码</button>
        </div>
    </div>
</div>
<script src="<%=basePath%>lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form'], function () {
        var form = layui.form,
            layer = layui.layer,
            $ = layui.$;

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var datas=data.field;//form单中的数据信息
            if(datas.newPwd!=datas.newPwd2){
                layer.msg("两次输入的新密码不一样...请重新输入")
            }else{
            //向后台发送数据提交添加
            $.ajax({
                url:"updatePwdSubmit",
                type:"POST",
                 data: {
                    id:datas.id,
                     oldPwd:datas.oldPwd,
                     newPwd:datas.newPwd
                 },
                success:function(result){
                    if(result.code==0){//如果成功
                        layer.msg(result.msg,{
                            icon:6,
                            time:500
                        },function(){
                            parent.window.location.reload();
                            var iframeIndex = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(iframeIndex);
                        })
                    }else{
                         layer.msg(result.msg);
                    }
                }
            })
            }
            return false;

        });

    });
</script>
</body>
</html>
