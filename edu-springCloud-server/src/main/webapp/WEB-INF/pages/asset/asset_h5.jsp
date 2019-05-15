<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    request.setAttribute("webPath", request.getContextPath());
%>
<html>
<head>
	<script type="application/javascript" src="${webPath}/static/js/jquery.min.js"></script>
</head>
<body>
	<form id="myForm" action="${params.requestUrl}" method="post" style="display: none;">
		<input name="sourceName" value="${params.sourceName}" /><br>
		<input name="sign" value="${params.sign}" /><br>
		<input name="data" value='${params.data}' /><br>
	</form>
</body>
<script type="text/javascript">
	window.onload= function(){
	   document.getElementById('myForm').submit();
	}
</script>
</html>