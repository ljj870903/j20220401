<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<c:if test="${id == null }">
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="css/section.css?">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Archivo+Black&family=Nanum+Pen+Script&family=Rubik+Puddles&display=swap" rel="stylesheet">
	<title>구해줘 집사</title>
</head>
<body class="pet_container">
	<jsp:include page="css/header.jsp"></jsp:include>
	<img src="${context }/fileSave/메인3.jpg" alt="..." width="100%">
	<div class="container">
	
	<div class="row py-lg-5" style="margin-top: 80px;">
      <div class="col-lg-6 col-md-8 mx-auto">
      	
        <h3 class="fw-bolder">구해줘 집사?</h3>
        <p class="lead text-muted">전문 펫시터가 진행하는 방문 펫시팅 서비스<br>환경 정리는 기본! 산책부터 반려동물 맞춤 놀이도 진행<br>구해줘 집사에서 찾으세요</p>
      </div>
    </div>
	
	
	
	</div>
	<jsp:include page="css/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<style>
	.navbar a:hover{
		color: white;
	}
	.footer a:hover{
		color: white;
	}
</style>
</body>
</c:if>
<c:if test="${id != null }">
		<script type="text/javascript">
			location.href="loginMain.do?";
		</script>
</c:if>
</html>