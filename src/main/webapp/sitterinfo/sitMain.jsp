<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="css/section.css?">
	<title>구해줘 집사</title>
</head>
<body class="pet_container">
<jsp:include page="../css/header.jsp"></jsp:include>
	
	<img src="${context }/fileSave/메인사진.jpg" alt="..." width="100%">
	
	<div class="container">
		<div></div>
	    <div>
	<!-- 현재 주석 아래쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->
		<div class="row py-lg-5" style="margin-top: 80px;">
	      <div class="col-lg-6 col-md-8 mx-auto">
	      	
	        <h3 class="fw-bolder">펫시터를 구해줘 집사</h3>
	        <p class="lead text-muted">동물을 사랑하는 당신에게 제안합니다. 자유로운 업무시간!<br>선택적 돌봄 가능! 산책하면서 돈벌수있는 직업이 있다?<br>지금 바로 지원하세요.</p>
	        <p>
	          <a href="sitInsertForm.do" class="btn btn-primary btn-lg" style="margin-top: 60px;">지원할래요</a>
	        </p>
	      </div>
	    </div>
		
	<!-- 현재 주석 위쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->
	    </div>
		<div></div>
	</div>
	<jsp:include page="../css/footer.jsp"></jsp:include>
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
</html>