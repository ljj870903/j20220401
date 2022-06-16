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
<!-- 	<style type="text/css">
		.button{
			background-color: #B2EBF4;
			border:  none;
		}
	</style> -->
</head>
<body class="pet_container">
	<jsp:include page="../css/header.jsp"></jsp:include>
	<div class="container">
	
	
	<div class="col-lg-3 col-md-8 mx-auto" style="text-align: center;">
	
	<main class="form-signin">
	  <form action="loginPro.do" method="post" name="join">
	    <img class="mb-4" src="${context }/fileSave/구해줘집사2.png" height="300" style="margin-top: 40px;">
	    <div class="form-floating" style="margin-top: 10px;">
	      <input type="text" class="form-control" id="floatingInput" name="id" required="required">
	      <label for="floatingInput">아이디</label>
	    </div>
	    <div class="form-floating">
	      <input type="password" class="form-control" id="floatingPassword" name="pw" required="required">
	      <label for="floatingPassword">비밀번호</label>
	    </div>
	
	    <button class="w-100 btn btn-lg btn-primary" type="submit" style="margin-top: 30px;">로그인</button>
	    <button class="w-100 btn btn-lg btn-primary" type="button" style="margin-top: 30px;" onclick="location.href='prfInsertForm.do'">회원 가입
	    </button>
	    <div style="margin-bottom: 20px;">
		    <button type="button" class="btn btn-link" style="margin-top: 10px;"
		     onclick="location.href='prfIdSelectFrom.do'">아이디 찾기</button>
		    <button type="button" class="btn btn-link" style="margin-top: 10px;"
		     onclick="location.href='prfPwSelectFrom.do'">비밀번호 찾기</button>
	    </div>
	    
	  </form>
	</main>
		
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
			location.href="loginMain.do?";
		</script>
</c:if>
</html>