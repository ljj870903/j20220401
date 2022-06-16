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

        <div class="container">
            <div>
<!-- 현재 주석 아래쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->
	<h2 align="center">자주묻는 질문 FAQ </h2>
	<h3 align="center">아래 버튼을 눌러 문의 유형을 선택해주세요</h3>
		<br>
		<div align="center" style="margin-top: 50px;">
		<a class="btn btn-primary" href="cscAply.do" role="button">지원관련 문의</a>
		<a class="btn btn-primary" href="cscProfileInfo.do" role="button">개인정보 문의</a>
		<a class="btn btn-primary" href="cscRes.do" role="button">예약 문의</a>
		</div>
		
<!-- 현재 주석 위쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->
	 </div>
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