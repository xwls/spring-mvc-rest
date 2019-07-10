<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书列表</title>
</head>
<body>
    <h1>图书列表</h1>
    <a href="#">添加</a>
    <table>
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
                    <a href="#">修改</a>
                    <a href="#">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
