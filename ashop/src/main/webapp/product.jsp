<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.myjavac.averchenkov.ashop.entity.Product" %>
<html>
    <head>
        <title>expjee</title>
    </head>
    <body>
        <b>PRODUCT PAGE</b>
        <br/>id: ${product.id}
        <br/>id: <%=((Product)request.getAttribute("product")).getId()%>
        <br/>id: ${product.name}
        <br/><a href="/index.jsp">main page</a>
    </body>
</html>
