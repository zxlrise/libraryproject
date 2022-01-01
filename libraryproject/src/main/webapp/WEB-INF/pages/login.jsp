<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书馆管理系统-登陆</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <script type="text/javascript" src="<%=basePath%>/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="<%=basePath%>/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>/css/public.css" media="all">

    <style>
        html, body {width: 100%;height: 100%;overflow: hidden}
        body {background: url("${basePath}images/bg.png");}
        body:after {content:'';background-repeat:no-repeat;background-size:cover;-webkit-filter:blur(3px);-moz-filter:blur(3px);-o-filter:blur(3px);-ms-filter:blur(3px);filter:blur(3px);position:absolute;top:0;left:0;right:0;bottom:0;z-index:-1;}
        .layui-container {width: 100%;height: 100%;overflow: hidden}
        .admin-login-background {width:450px;height:360px;position:absolute;left:65%;top:45%;margin-left:-180px;margin-top:-100px;}
        .logo-title {text-align:center;letter-spacing:2px;padding:14px 0;}
        .logo-title h1 {color:#1E9FFF;font-size:25px;font-weight:bold;}
        .login-form {background-color:#fff;border:1px solid #fff;border-radius:3px;padding:14px 20px;box-shadow:0 0 8px #eeeeee;}
        .login-form .layui-form-item {position:relative;}
        .login-form .layui-form-item label {position:absolute;left:1px;top:1px;width:38px;line-height:36px;text-align:center;color:#d2d2d2;}
        .login-form .layui-form-item input {padding-left:36px;}
        .captcha-img img {height:34px;border:1px solid #e6e6e6;height:36px;width:100%;}
    </style>
</head>
<body>

<div class="layui-container">
    <div class="admin-login-background">
        <div class="layui-form login-form">
            <form class="layui-form"  action="<%=basePath%>loginIn" method="post">
                <div class="layui-form-item logo-title">
                    <h1>图书馆管理系统</h1>
                    <div style="color: red;text-align: center;">${msg}</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-username"></label>
                    <input type="text" name="username" lay-verify="required" placeholder="用户名" autocomplete="off" class="layui-input" >
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-password"></label>
                    <input type="password" name="password" lay-verify="required" placeholder="密码" autocomplete="off" class="layui-input" >
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-username"></label>
                    <select name="type" lay-verify="required">
                        <option value="">请选择用户类型</option>
                        <option value="1">管理员</option>
                        <option value="2">读者</option>
                    </select>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-inline">
                        <input type="text" name="captcha" style="width: 200px;" lay-verify="required" placeholder="验证码" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-input-inline">
                        <div class="field">
                            <a href="javascript:void(0)" onclick="getCode()"><img id="code" ></a>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn layui-btn layui-btn-normal layui-btn-fluid" lay-submit="" lay-filter="login">登录</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="<%=basePath%>/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script type="text/javascript">
    getCode();
    /**
     * 获取验证码
     */
    function getCode(){
        document.getElementById("code").src=timestamp("verifyCode");
    }

    /**
     * 实现刷新更滑验证码
     */
    function timestamp(url){
        var gettime=new Date().getTime();
        if(url.indexOf("?")>-1){
            url=url+"&timestamp="+gettime;
        }else{
            url=url+"?timestamp="+gettime;
        }
        return url;
    }


    layui.use(['form'], function () {
        var form = layui.form,
            layer = layui.layer;
        form.on('submit(login)', function (data) {
            data = data.field;
            if (data.username == '') {
                layer.msg('用户名不能为空');
                return false;
            }
            if (data.password == '') {
                layer.msg('密码不能为空');
                return false;
            }
            if (data.captcha == '') {
                layer.msg('验证码不能为空');
                return false;
            }
            if (data.type == '') {
                layer.msg('类型不能为空');
                return false;
            }
        });
    });
</script>
</body>
</html>