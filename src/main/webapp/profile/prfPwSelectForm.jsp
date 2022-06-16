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
	<title>구해줘 집사</title>
</head>
<body class="pet_container">
	<jsp:include page="../css/header.jsp"></jsp:include>
	<div class="container">
	
	
	<div class="col-lg-4 col-md-8 mx-auto" style="text-align: center;">
		<h1 class="fw-bolder" id="head1">비밀번호 찾기</h1>
		
		<main class="form-signin">
		  
		  
		  <div class="accordion" id="accordionExample">
		  <div class="accordion-item">
		    <h2 class="accordion-header" id="headingOne">
		      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
		        아이디 및 전화번호로 찾기
		      </button>
		    </h2>
		    <div id="collapseOne" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
		      <div class="accordion-body">
				 <form action="prfPwSelectPro.do" method="post" name="phone">
				    <div class="input-group mb-3">
					  <span class="input-group-text" id="id-addon" style="width: 80px;">아이디</span>
					  <input type="text" class="form-control" id="id-url" aria-describedby="id-addon" name="id" required="required">
					</div>
					<div class="input-group mb-3">
					  <span class="input-group-text" id="name-addon3" style="width: 80px;">이름</span>
					  <input type="text" class="form-control" id="name-url3" aria-describedby="name-addon3" name="name" required="required">
					</div>
					<div class="input-group mb-3">
					  <span class="input-group-text" id="phone-addon4" style="width: 80px;">전화번호</span>
					  <input type="tel" class="form-control" id="phone-ur4" aria-describedby="phone-addon4" name="phone" pattern="[0-9]{11}" required="required">
					</div>
					<button class="w-100 btn btn-lg btn-primary" type="submit" style="margin-top: 30px;">비밀번호 찾기</button>
				</form>		 
		      </div>
		    </div>
		  </div>
		  <div class="accordion-item">
		    <h2 class="accordion-header" id="headingTwo">
		      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
		        아이디 및 E-mail로 찾기
		      </button>
		    </h2>
		    <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
		      <div class="accordion-body">
		     	 <form action="prfPwSelectPro.do" method="post" name="email">
				    <div class="input-group mb-3">
					  <span class="input-group-text" id="id-addon5" style="width: 80px;">아이디</span>
					  <input type="text" class="form-control" id="id-url5" aria-describedby="id-addon5" name="id" required="required">
					</div>
					<div class="input-group mb-3">
					  <span class="input-group-text" id="name-addon5" style="width: 80px;">이름</span>
					  <input type="text" class="form-control" id="name-url5" aria-describedby="name-addon5" name="name" required="required">
					</div>
					<div class="input-group mb-3">
					  <span class="input-group-text" id="email-addon6" style="width: 80px;">E-mail</span>
					  <input type="text" class="form-control" id="email-ur6" aria-describedby="email-addon6" name="email" required="required">
					  <span class="input-group-text">@</span>
					  <select class="form-select" name="emaillast">
						<option>선택하세요</option>
						<option value="naver.com" >naver.com</option>
						<option value="google.com">google.com</option>
						<option value="daum.net">daum.net</option>
						<option value="hanmail.net">hanmail.net</option>
					</select>
					</div>
					<button class="w-100 btn btn-lg btn-primary" type="submit" style="margin-top: 30px;">비밀번호 찾기</button>
				</form>		
		      </div>
		    </div>
		  </div>
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