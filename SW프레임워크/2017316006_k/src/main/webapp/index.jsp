<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>My MVC shopping</title>

</head>
<body>
<ul id="menu">
    <li> My MVC Shopping
        <ul>      
            <li><a href='<c:url value="/shoppingAddForm.do" />'>shoppingAddForm</a></li>
            <li><a href='<c:url value="/shoppingList.do" />'>shoppingList</a></li>
            <li><a href='<c:url value="/shoppingModifyForm.do" />'>shoppingModifyForm</a></li>
            <li><a href='<c:url value="/shoppingView.do" />'>shoppingView</a></li>
        </ul>
    </li>
</ul>
</body>
</html>
