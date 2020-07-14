<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SHOPPING MODIFY FORM</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<form:form commandName="shopping" action="shoppingModify.do">
 <div id="wrap">
 	<table class="tbl_View">
 		<caption>Shopping</caption>
 			<colgroup>
 				<col style="width:30%" /> 
 				<col style="width: ;" /> 
 			</colgroup> 	
 		<tbody> 		
 		<tr> 
 			<th>상품번호</th> 
 			<td><form:input path="id" value="${shoppinginfo.id}" type="text" size="63" maxlength="20" /></td>
 		</tr>
 		<tr>
 			<th>이름</th>
 			<td><form:input path="name" type="text" size="63" maxlength="20" /></td>  
 		</tr>
 		<tr>
 			<th>가격</th>
 			<td><form:input path="price" type="text" size="63" maxlength="20" /></td>
 		</tr> 
 		<tr>
 			<th>색상</th>
 			<td><form:input path="color" type="text" size="63" maxlength="20" /></td>
 		</tr> 
 		<tr>
 			<th>수량</th>
 			<td><form:input path="quantity" type="text" size="63" maxlength="30" /></td>
 		</tr>
 		</tbody>
 		</table>
 		<div class="txt-rt mt20">
 		<input type="button" value="글저장" onclick="form.submit()"/>
 		<input type="button" value="목록" onclick="location.href='shoppingList.do'"/>
 	</div> 
 </div>  
 </form:form>		            		    
</body>
</html>
