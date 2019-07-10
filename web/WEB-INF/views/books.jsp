<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>图书列表</title>
    <link rel="stylesheet" href="${path}/static/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${path}/static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        function del(e) {
            var tr = $(e).parent().parent();
            var id = tr.children(":first").text();
            $.ajax({
                url:"${path}/book/"+id,
                type:"post",
                data:{
                    _method:"delete"
                },
                success:function (res) {
                    if(res.success){
                        //删除tr
                        tr.remove();
                    }else {
                        alert("失败");
                    }
                }
            });
        }
    </script>
</head>
<body class="container">
    <h1>图书列表</h1>
    <a href="${path}/book" class="btn btn-success mb-2">添加</a>
    <table class="table table-striped">
        <tr>
            <th>编号</th>
            <th>书名</th>
            <th>作者</th>
            <th>价格</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${requestScope.books}" var="book">
            <tr>
                <td>${book.bookId}</td>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
                <td>
                    <a class="btn btn-sm btn-primary" href="${path}/book/${book.bookId}">修改</a>
                    <a class="btn btn-sm btn-danger" href="javascript:void (0)" onclick="del(this)">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
