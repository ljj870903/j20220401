<%@page import="dao.ProfileDao"%>
<%@page import="java.awt.Window"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="css/section.css?">
<title>아이디 중복확인</title>
<% String id = request.getParameter("id"); %>
<script type="text/javascript">
	function wincl() {
		opener.document.join.id.value="<%=id%>";
		window.close();
	}
</script>

</head>
<body>
	<div class="container">
		<div class="col-lg-6 col-md-8 mx-auto">
		<c:if test="${result == 0 }">
				<div style="margin-top: 50px; text-align: center;">
				<p class="fs-5" style="color: black;">${id } 는 사용할 수 있습니다.</p>
		      <button type="button" onclick="wincl()" class="btn btn-primary" style="display: inline-block; margin-top: 40px;">닫기</button>
		      </div>
		</c:if>
		<c:if test="${result > 0 }">
				<div style="margin-top: 50px; text-align: center;">
					<p class="fs-5" style="color: black;">${id } 는 이미 존재하는 아이디 입니다.</p>
					<form>
					<div class="input-group mb-3">
					  <span class="input-group-text" id="id-addon" style="width: 80px;">아이디</span>
					  <input type="text" class="form-control" id="id-url" aria-describedby="id-addon" name="id" required="required">
					</div>
		    		  <button type="submit" class="btn btn-primary" style="display: inline-block; margin-top: 40px;">확인</button>
					</form>
		      </div>
		</c:if>
	</div>
	</div>
</body>
</html>