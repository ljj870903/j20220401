
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<%
	String context = request.getContextPath();
	System.out.println("context->"+context);
	
%>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="css/section.css?">
	<title>구해줘 집사</title>
</head>
<script type="text/javascript">
	function button_event(){
	
		if (confirm("정말 삭제하시겠습니까?") == true){    //확인
	
			location.href='petDeletePro.do?pet_num=${petinfo.pet_num}';
	
		}else{   //취소
	
		    return;
	
		}
	
	}
</script>

<body class="pet_container">
	<jsp:include page="../css/header.jsp"></jsp:include>
	<div class="container">
	    <div>
<!-- 현재 주석 아래쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->

	<div class="col-lg-8 col-md-8 mx-auto">
	<table class="table table-striped" style="text-align: center;">
		<thead>
			<tr>
				<th colspan="2" style="font-size: 25px; padding: 20px;" >반려동물 상세정보</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td width="40%">사진</td>
				<td><img src="<%=context%>/${filename}" style="width: 400px; height: 400px"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${petinfo.pet_name }</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<c:if test="${petinfo.pet_gender=='M' }">남자</c:if>
					<c:if test="${petinfo.pet_gender=='F' }">여자</c:if>
				</td>
			</tr>
			<tr>
				<td>품종</td>
				<td>${petinfo.pet_type }</td>
			</tr>
			<tr>
				<td>나이</td>
				<td>${petinfo.pet_age }살</td>
			</tr>
			<tr>
				<td>몸무게</td>
				<td>${petinfo.pet_weight }kg</td>
			</tr>
			<tr>
				<td>중성화</td>
				<td>
					<c:if test="${petinfo.pet_neuter=='Y' }">했어요</c:if>
					<c:if test="${petinfo.pet_neuter=='N' }">안했어요</c:if>
				</td>
			</tr>
		</tbody>
	</table>
	
	
	<div style="display: inline-block; float: left;">
		<button type="button" class="btn btn-outline-secondary" onclick="location.href='petList.do'" style="margin-bottom: 10px;">목록</button>
	</div>
	<div style="display: inline-block; float: right;">
		<button type="button" class="btn btn-outline-secondary" onclick="location.href='petUpdateForm.do?pet_num=${petinfo.pet_num}'" style="margin-bottom: 10px;">수정</button>
		<button type="button" class="btn btn-outline-secondary" onclick="button_event();" style="margin-bottom: 10px;">삭제</button>
	</div>
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
		td{
			vertical-align: middle;
		}
	</style>
</body>
</html>
