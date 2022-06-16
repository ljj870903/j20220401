<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<c:if test="${id != null }">
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="css/section.css?">
	<title>구해줘 집사</title>
</head>
<body class="pet_container">
	<jsp:include page="../css/header.jsp"></jsp:include>
	<div class="container">
	
	<div class="col-lg-5 col-md-8 mx-auto">
		<form action="prfUpdatePro.do" method="post">
			<table class="table" style="text-align: center;">
				<thead>
					<tr>
						<th colspan="2" style="font-size: 25px; padding: 20px;">회원정보 수정하기</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="table-active">아이디</td>
						<td>
							${id }
							<input type="hidden" name="id" value="${id }">
						</td>
					</tr>
					<tr>
						<td class="table-active">비밀번호</td>
						<td><input type="password" name="pw" value="${ntc.n_title }" class="form-control" required="required"></td>
					</tr>
					<tr>
						<td class="table-active">이름</td>
						<td>${profile.name }</td>
					</tr>
					<tr>
						<td class="table-active">성별</td>
						<td>
							<c:if test="${profile.gender == 'M'}">남자</c:if>
							<c:if test="${profile.gender == 'W'}">여자</c:if>
						</td>
					</tr>
					<tr>
						<td class="table-active">이메일</td>
						<td>
							<div class="input-group" id="sitterMail">
								<input type="text" class="form-control" name="email"
									value="${profile.email.split('@')[0]}">
								<div class="input-group-text">@</div>
								<select class="form-select" name="emaillast">
									<option>${profile.email.split('@')[1]}</option>
									<option value="naver.com" >naver.com</option>
									<option value="google.com">google.com</option>
									<option value="daum.net">daum.net</option>
									<option value="hanmail.net">hanmail.net</option>
								</select>
							</div>
						</td>
					</tr>
					<tr>
						<td class="table-active">전화번호</td>
						<td><input type="tel" name="phone" value="${profile.phone}" class="form-control" required="required" placeholder="'-'없이 입력"></td>
					</tr>
					<tr>
						<td class="table-active">주소</td>
						<td><input type="text" name="address" value="${profile.address}" class="form-control" required="required" placeholder="OO시 OO구 OO동"></td>
					</tr>
					<tr>
						<td class="table-active">등급</td>
						<td>
							<c:if test="${grade == 'A'}">관리자</c:if>
							<c:if test="${grade == '1'}">일반회원</c:if>
							<c:if test="${grade == '2'}">펫시터</c:if>
						</td>
					</tr>
					<tr>
						<td class="table-active">생년월일</td>
						<td>${profile.birth }</td>
					</tr>
				</tbody>
			</table>
			
			<div style="display: inline-block; float: left;">
				<button type="button" class="btn btn-outline-secondary" onclick="location.href='main.do'" style="margin-bottom: 10px;">메인으로</button>
			</div>
			<div style="display: inline-block; float: right;">
				<button type="submit" class="btn btn-outline-secondary" style="margin-bottom: 10px;">수정하기</button>
			</div>
		</form>
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
<c:if test="${id == null }">
		<script type="text/javascript">
			alert("로그인이 필요합니다..")
			location.href="loginForm.do?";
		</script>
</c:if>
</html>