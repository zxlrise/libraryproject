<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="utf-8">
    <title>修改图书</title>
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
    <input type="hidden" name="id"   value="${info.id}">
    <div class="layui-form-item">
        <label class="layui-form-label required">图书名称</label>
        <div class="layui-input-block">
            <input type="text" name="name" lay-verify="required"  value="${info.name}" class="layui-input">
            <tip>填写自己图书名称。</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">图书编号</label>
        <div class="layui-input-block">
            <input type="text" name="isbn" lay-verify="required"value="${info.isbn}"  class="layui-input">
            <tip>填写自己图书名。</tip>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">图书类别</label>
        <div class="layui-input-block">
            <select name="typeId" id="typeId" lay-verify="required">
                <option value="${info.typeId}">请选择</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">图书作者</label>
        <div class="layui-input-block">
            <input type="text" name="author" lay-verify="required" value="${info.author}"   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">图书出版社</label>
        <div class="layui-input-block">
            <input type="text" name="publish" lay-verify="required" value="${info.publish}"   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">图书语言</label>
        <div class="layui-input-block">
            <input type="text" name="language"  value="${info.language}"   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">图书价格</label>
        <div class="layui-input-block">
            <input type="number" name="price"  value="${info.price}"   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">出版日期</label>
        <div class="layui-input-block">
            <input type="text" name="pubDate" id="date"
                   value="<fmt:formatDate value="${info.pubDate}" pattern="yyyy-MMM-dd"/> "
                   lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
            </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">图书介绍</label>
        <div class="layui-input-block">
            <textarea name="introduction" class="layui-textarea" placeholder="请输入介绍信息">${info.introduction}</textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认修改</button>
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
            elem: '#date',
            trigger:'click'
        });

        //动态获取图书类型的数据
        $.get("findAllList",{},function (data) {
            //获取图书类型的值
            var typeId=$('#typeId')[0].value;
            var list=data;
            var select=document.getElementById("typeId");
            if(list!=null|| list.size()>0){
                for(var c in list){
                    var option=document.createElement("option");
                    option.setAttribute("value",list[c].id);
                    option.innerText=list[c].name;
                    select.appendChild(option);
                    //如果类型和循环到的类型iD一致，选中
                    if (list[c].id==typeId){
                        option.setAttribute("selected","selected");
                        layui.form.render('select');
                    }
                }
            }
            form.render('select');
        },"json")

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var datas=data.field;//form单中的数据信息
            //向后台发送数据提交添加
            $.ajax({
                url:"updateBookInfoSubmit",
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
