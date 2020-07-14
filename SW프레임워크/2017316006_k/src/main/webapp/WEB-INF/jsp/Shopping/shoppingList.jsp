<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>SHOPPING LIST</title> 
<link href="css/style.css" rel="stylesheet" type="text/css"> 
</head>
<script type="text/javascript"> 
function linkPage(pageNo){ 
	location.href = "shoppingList.do?pageNo="+pageNo; 
}
</script>
<body> 
<form:form commandName="searchCriteria" action="shoppingList.do"> 
<div id="wrap">
	<div class="search">
		이름 <input id="searchName" name="searchName" style="width:120px;" type="text" value=""/> 
		<input type="submit" value="검색"  onclick="this.disabled=true,this.form.submit();" /> 
	</div>
	<table class="tbl_List"> 
		<caption>Board</caption>    
		<colgroup>    
			<col style="width:9%" /> 
			<col style="width:16%" />   
			<col style="width:16%" /> 
			<col style="width:13%" />  
			<col style="width:11%" /> 
	   		<col style="width: ;" />  
		</colgroup>      
		<thead> 
			<tr> 
				<th>번호</th>   
				<th>이름</th> 
			</tr> 
		</thead>
		<tbody> 
			<c:forEach items="${shoppinglist}" var="shoppinginfo"> 
		<tr> 
			<td><a href="shoppingView.do?id=${shoppinginfo.id}">    
				${shoppinginfo.id}</a></td>    
			<td>${shoppinginfo.name}</td>  
		</tr>   
		</c:forEach>   
		</tbody> 
	</table>  
	<div id ="paginaion">
		<ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="linkPage" /> 
	</div>
	<p> 
		<div class="txt-rt mt20"> 
			<input type="button" value="상품추가 " onclick="location.href='shoppingAdd.do'" />  
		</div>     
</div>   
</form:form> 
 </body> 
 </html>
  