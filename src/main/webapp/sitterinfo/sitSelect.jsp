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
		<div></div>
	    <div>
	<!-- 현재 주석 아래쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->
	
	<h1 class="fw-bolder" id="head1" style="margin-bottom: 60px;">펫시터 지원 신청서</h1>
	
	<div class="col-lg-8 col-md-8 mx-auto">
	<table class="table" style="text-align: center;">
		<thead>
		</thead>
		<tbody>
			<tr>
				<td class="table-active" width="15%">이름</td>
				<td  width="35%">${profile.name }</td>
				<td class="table-active" width="15%">연락처</td>
				<td width="35%">${profile.phone }</td>
			</tr>
			<tr>
				<td class="table-active">성별</td>
				<td>
					<c:if test="${profile.gender=='M' }">남자</c:if>
					<c:if test="${profile.gender=='W' }">여자</c:if>
				</td>
				<td class="table-active">생년월일</td>
				<td>${year }년 ${month }월 ${day }일</td>
			</tr>
			<tr>
				<td class="table-active">주소</td>
				<td>${profile.address }</td>
				<td class="table-active">E-mail</td>
				<td>${profile.email }</td>
			</tr>
			<tr>
				<td class="table-active">반려동물 수</td>
				<td>${profile.petno }&nbsp마리</td>
				<td class="table-active">흡연여부</td>
				<td>
					<c:if test="${sitter.ps_smoke=='N' }">아니오</c:if>
					<c:if test="${sitter.ps_smoke=='Y' }">네</c:if>
				</td>
			</tr>
			</tbody>
		</table>
			
		<table class="table" style="text-align: center;">
			<thead>
			<tr>
				<td colspan="4" class="table-active-color">펫시터 활동 경험</td>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td class="table-active" width="15%">시작일</td>
				<td width="35%">
					<c:if test="${sitter.ps_start==null }">없음</c:if>
					<c:if test="${sitter.ps_start!=null }">${sitter.ps_start }</c:if>
				</td>
				<td class="table-active" width="15%">종료일</td>
				<td width="35%">
					<c:if test="${sitter.ps_end==null }">없음</c:if>
					<c:if test="${sitter.ps_end!=null }">${sitter.ps_end }</c:if>
				</td>
			</tr>
			</tbody>
		</table>
			
		<table class="table" style="text-align: center;">
			<thead>
			<tr>
				<td colspan="4" class="table-active-color">관련 업종 종사 경험</td>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td class="table-active" width="15%">종사 유무</td>
				<td width="35%">
					<c:if test="${sitter.ps_rel_yn=='Y' }">있다</c:if>
					<c:if test="${sitter.ps_rel_yn=='N' }">없다</c:if>
				</td>
				<td class="table-active" width="15%">업종</td>
				<td width="35%">
					<c:if test="${sitter.ps_rel_job!=null }">
						${sitter.ps_rel_job }
					</c:if>
					<c:if test="${sitter.ps_rel_job==null }">
						해당없음
					</c:if>
				</td>
			</tr>
			<tr>
				<td class="table-active">종사 기간</td>
				<td colspan="3">
					<c:if test="${sitter.ps_rel_period!=null }">
						${sitter.ps_rel_period }
					</c:if>
					<c:if test="${sitter.ps_rel_period==null }">
						해당없음
					</c:if>
				</td>
			</tr>
			</tbody>
		</table>
			
		<table class="table" style="text-align: center;">
			<thead>
			<tr>
				<td colspan="4" class="table-active-color">반려동물 키웠던 경험</td>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td class="table-active" width="180">키운 기간</td>
				<td colspan="3">
					<c:if test="${sitter.ps_ex_period!=null }">
						${sitter.ps_ex_period }
					</c:if>
					<c:if test="${sitter.ps_ex_period==null }">
						없음
					</c:if>
				</td>
			</tr>
			<tr>
				<td class="table-active">키웠던 과정 서술</td>
				<td colspan="3" height="180">
					<c:if test="${sitter.ps_ex_text!=null }">
						${sitter.ps_ex_text }
					</c:if>
					<c:if test="${sitter.ps_ex_text==null }">
						해당 없음
					</c:if>
				</td>
			</tr>
			</tbody>
		</table>
			
		<table class="table" style="text-align: center;">
			<thead>
			<tr>
				<td colspan="4" class="table-active-color">지원서에 대한 사실 동의 여부</td>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td class="table-active" width="15%">사실 동의</td>
				<td colspan="3" width="85%">
					<c:if test="${sitter.ps_agree=='Y'  }">
						네
					</c:if>
					<c:if test="${sitter.ps_agree=='N' }">
						아니오
					</c:if>
				</td>
			</tr>
			
			
		</tbody>
	</table>
	
	
	<div style="display: inline-block; float: left; margin-top: 70px;">
		<button type="button" class="btn btn-outline-secondary" onclick="location.href='sitList.do?pageNum=${pageNum}'" style="margin-bottom: 10px;">목록</button>
	</div>
	<div style="display: inline-block; float: right; margin-top: 70px;">
		<c:if test="${profile.grade==1 }">		
			<button type="button" class="btn btn-outline-secondary" onclick="location.href='sitUpdate.do?pageNum=${pageNum}&mem_num1=${sitter.mem_num }'" style="margin-bottom: 10px;">승인</button>
			<button type="button" class="btn btn-outline-secondary" onclick="location.href='sitDelete.do?pageNum=${pageNum}&mem_num1=${sitter.mem_num }'" style="margin-bottom: 10px;">거절</button>
		</c:if>
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