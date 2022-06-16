<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<script type="text/javascript" src="profile/prfInsert.js"></script>
	<title>구해줘 집사</title>
</head>
<body class="pet_container">
	<jsp:include page="../css/header.jsp"></jsp:include>
	<div class="container">
	
		<div class="row py-lg-5">
			<div class="col-lg-6 col-md-8 mx-auto">
				<h1 class="fw-bolder" id="head1">회원가입</h1>
				<form class="row g-3" action="prfInsertPro.do" onsubmit="return chk()" name="join" method="post">
					
					<label for="userId2" class="form-label" style="margin-bottom: -10px;">아이디</label>
					<div class="input-group mb-3">
					  <input type="text" name="id" class="form-control" placeholder="10글자 이하 알파벳 대소문자 및 숫자 조합" aria-label="Recipient's username"
					   aria-describedby="userId" required="required" maxlength="10">
					  <button class="btn btn-outline-secondary" type="button" id="userId" onclick="return idchk()">중복확인</button>
					</div>
					<div class="col-12" style="margin-top: 0;">
						<label for="passwd" class="form-label">비밀번호</label> <input
							type="password" name="pw" required="required" class="
							form-control" id="passwd" placeholder="10글자 이하 알파벳 대소문자 및 숫자 조합" maxlength="10">
					</div>
					<div class="col-12">
						<label for="passwd2" class="form-label">비밀번호 확인</label> <input
							type="password" name="pwpath" required="required" class="
							form-control" id="passwd2" placeholder="비밀번호 확인" maxlength="10">
					</div>
					<div class="col-md-6">
						<label for="name" class="form-label">이름</label> <input
							type="text" name="name" required="required" class="
							form-control" id="name" maxlength="20">
					</div>
					<div class="col-md-6">
						<label for="gender" class="form-label">성별</label> <select
							id="gender" class="form-select" name="gender">
							<option>선택하세요</option>
							<option value="M">남자</option>
							<option value="W">여자</option>
						</select>
					</div>
					<div class="col-12">
						<label for="mail" class="form-label">이메일</label>
						<div class="input-group" id="mail">
							<input type="text" class="form-control" name="email">
							<div class="input-group-text">@</div>
							<select class="form-select" name="emaillast">
								<option>선택하세요</option>
								<option value="naver.com" >naver.com</option>
								<option value="google.com">google.com</option>
								<option value="daum.net">daum.net</option>
								<option value="hanmail.net">hanmail.net</option>
							</select>
						</div>
					</div>
					<div class="col-12">
						<label for="phone" class="form-label">전화번호</label> <input
							type="tel" name="phone" required="required" class="
							form-control" id="phone" placeholder="'-'없이 입력" pattern="[0-9]{11}">
					</div>
					<div class="col-12">
						<label for="address" class="form-label">거주지역</label> <input
							type="text" name="address" required="required" class="
							form-control" id="address" placeholder="OO시 OO구 OO동">
					</div>
					<div class="col-12">
						<label for="birth" class="form-label">생년월일</label> <input
							type="text" name="birth" required="required" class="
							form-control" id="birth" placeholder="ex)19980514">
					</div>
	
					<button type="submit" class="btn btn-primary btn-lg" style="margin-top: 50px;">회원가입</button>
	
				</form>
			</div>
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
</c:if>
<c:if test="${id != null }">
		<script type="text/javascript">
			alert("이미 로그인 되어 있습니다.")
			/* location.href="loginMain.do?"; */
			history.go(-1);
		</script>
</c:if>
</html>