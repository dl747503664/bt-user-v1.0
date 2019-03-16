<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#form {
	border: 2px solid red;
}

#tr td{
	border: 1px solid black;
}
td{
	text-align: center;
}
</style>
</head>
<body id="body">

	<table id="table">
		<tr id="tr">
			<td>ID</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${userList}" var="u" varStatus="status">
			<tr id="tr">
				<td>${u.id}</td>
				<td>${u.name}</td>
				<td>${u.age}</td>
				<td><button class="delete" value="${u.id}">删除</button></td>
			</tr>
		</c:forEach>
		<tr id="tr">
			<td><input id="id"></input></td>
			<td><input id="name"></input></td>
			<td><input id="age"></input></td>
			<td><button id="save">修改/新增</button></td>
		</tr>
		<tr id="tr2">
		<td id="id2"></td>
		<td id="name2"></td>
		<td id="age2"></td>
		</tr>
	</table>
		<input id="name1"></input>
		<button id="select">查询</button>
		
</body>
<script src="./js/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#table").on("click", ".delete", doDelete)
		.on("click", "#save",doSaveOrUpdate);
		$("#body").on("click", "#select", doSelect);
	})
	function doDelete() {
		var url = "delete";
		var id = $(this).val();
		var params = {
			"id" : id
		};
		$.post(url, params, function(res) {
			alert(res.message);
			parent.location.reload();
		})
	}
	function doSaveOrUpdate() {
		var id = $("#id").val();
		if (id == '' || id == undefined || id == null) {
			var url = "save";
			var params = {
				"name" : $("#name").val(),
				"age" : $("#age").val()
			};
			if(params.name==''||params.age==''){
				alert("姓名或年龄不能为空");
				return;
			}
			$.post(url, params, function(res) {
				alert(res.message);
				parent.location.reload();
			})
		}else{
			var url = "update";
			var params = {
				"id" : $("#id").val(),	
				"name" : $("#name").val(),
				"age" : $("#age").val()
			};
			if(params.name==''){
				alert("请输入姓名");
				return;
			}else if(params.age==''){
				alert("请输入年龄");
				return;
			}
			$.post(url, params, function(res) {
				alert(res.message);
				parent.location.reload();
			})
		}
	}
	function doSelect(){
		var url = "selectUserByName";
		var params = {
				"name" : $("#name1").val()
		}
		if(params.name==''){
			alert("姓名不能为空");
			return;
		}
		
		$.post(url,params,function(res){
			if(res.state==0){
				alert(res.message);
				return ;				
			}
			var userList = res.data[0];
			$("#id2").html(userList.id);
			$("#name2").html(userList.name);
			$("#age2").html(userList.age);
		})
	}
</script>
</html>