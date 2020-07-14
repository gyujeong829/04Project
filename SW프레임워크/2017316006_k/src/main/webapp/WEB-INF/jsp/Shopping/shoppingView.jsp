<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SHOPPING VIEW</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<script>
	function init(code){ 
		 var form  = document.hmsForm;
		 selectBox(form.dept, code);
	}
	
	 function selectBox(sel, val){
		 var selOptions = sel.options;
		 var size = selOptions.length;
		 for(var i = 0; i<size; i++){
			 if(selOptions[i].value == val){ 
				 selOptions[i].selected = true;
				 break; 			 
		 }
	 }
</script>

<form name="hmsForm"> 
<div id="wrap">
	<table class="tbl_View">
		<caption>Shopping</caption>
		<colgroup> 
			<col style="width:30%" />    
			<col style="width: ;" />
		</colgroup>
		<tbody>
			<tr>
				<th>번호</th>
				<td>${shoppinginfo.id}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${shoppinginfo.name}</td>
			</tr>
			<tr>
				<th>가격</th>
				<td>${shoppinginfo.price}</td>
			</tr> 
			<tr>
				<th>색상</th>
				<td>${shoppinginfo.color}</td>
			</tr> 
			<tr>
				<th>수량</th>
				<td>${shoppinginfo.quantity}</td>
			</tr>
		</tbody>
		</table>
		<div class="txt-rt mt20">
		<input type="button" value="목록" onclick="location.href='shoppingList.do'"/>
		<input type="button" value="수정"  onclick="location.href='shoppingModify.do?id=${shoppinginfo.id}'"/>
		<input type="button" value="삭제"  onclick="location.href='shoppingRemove.do?id=${shoppinginfo.id}'"/>
		</div>     
	</div>
	</form>		         
</body>
</html>