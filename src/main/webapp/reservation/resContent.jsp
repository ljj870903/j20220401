<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%
String context = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
		
		function check(){
			var ins = confirm("예약을 하시겠습니까?");
			if(ins){
				alert("해당 예약건에 담당 펫시터로 등록하였습니다");
				location.href='resApproval.do?res_num=${re.res_num }';
			}else{
				alert("담당 펫시터 등록이 취소되었습니다");
				history.back();
			}
		}
		/* 
		var ins;
		ins=confim("예약을 하시겠습니까?");
		if(ins){
			document.write("예약을 하셨습니다")
		}else{
			document.write("예약을 취소하셨습니다")
		} */
	
	
	</script>
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
			
			
		<div class="col-lg-6 col-md-8 mx-auto">
			<table class="table table-striped" style="text-align: center;">
				<thead>
					<tr>
						<th colspan="2" style="font-size: 25px; padding: 20px;">예약현황 상세내역</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td width="20%">예약번호</td>
						<td>${res_num }</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>${re.name }</td>
					</tr>
					<tr>
						<td>작성일자</td>
						<td>${re.res_date }</td>
					</tr>
					<tr>
						<td>펫 수</td>
						<td>${re.count }</td>
					</tr>
					<tr>
						<td>돌봄날짜</td>
						<td>${re.sit_date }</td>
					</tr>
					<tr>
						<td>돌봄시간</td>
						<td>${re.sit_start }:00~${re.sit_end }:00</td>
					</tr>
					<tr>
						<td>지역</td>
						<td>${re.address }</td>
					</tr>
					<tr>
						<td>진행상태</td>
						<td>${re.res_st }</td>
					</tr>
					<tr>
						<td>상세요청사항</td>
						<td style="height: 200px;">${re.request }</td>
					</tr>
					<c:if test="${re.res_st =='펫시터예약완료' }">
						<tr>
							<td>펫시터 이름</td>
							<td>${prf.name }</td>
						</tr>
						<tr>
							<td>펫시터 전화번호</td>
							<td>${prf.phone }</td>
						</tr>
					</c:if>
				</tbody>
			</table>
			
			<c:if test="${mem_num==re.mem_num }">
				<div style="display: inline-block; float: left;">
					<button type="button" class="btn btn-outline-secondary" onclick="location.href='resUserList.do?mem_num=${mem_num}&pageNum=${pageNum }'" style="margin-bottom: 10px;">목록</button>
				</div>
				<div style="display: inline-block; float: right;">
					<c:if test="${re.res_st !='펫시터예약완료' }">
					<button type="button" class="btn btn-outline-secondary" onclick="location.href='resUpdate.do?mem_num=${mem_num}&res_num=${res_num }&pageNum=${pageNum }'" style="margin-bottom: 10px;">수정</button>
					<button type="button" class="btn btn-outline-secondary" onclick="chk()" style="margin-bottom: 10px;">삭제</button>
					</c:if>
					<script type="text/javascript">
						function chk(){
							let check = confirm("정말로 삭제하시겠습니까?");
							if(check==true){
								location.href="resDelete.do?mem_num=${mem_num}&res_num=${res_num }&pageNum=${pageNum }";
							}
						}
					</script>
				</div>
			</c:if>
			<c:if test="${grade=='2'&& mem_num!=re.mem_num }">
				<c:if test="${re.res_st =='펫시터예약완료' }">
					<div style="display: inline-block; float: left;">
						<button type="button" class="btn btn-outline-secondary" onclick="location.href='resUserList.do?pageNum=${pageNum}&mem_num=${mem_num }'" style="margin-bottom: 10px;">목록</button>
					</div>
				</c:if>
				<c:if test="${re.res_st =='예약요청' }">
					<div style="display: inline-block; float: left;">
						<button type="button" class="btn btn-outline-secondary" onclick="location.href='resList.do?pageNum=${pageNum}'" style="margin-bottom: 10px;">목록</button>
					</div>
				</c:if>
				<c:if test="${re.res_st =='예약요청' }">
					<div style="display: inline-block; float: right;">
						<button type="button" class="btn btn-outline-secondary" onclick="check()" style="margin-bottom: 10px;">예약하기</button>
					</div>
				</c:if>
			</c:if>
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