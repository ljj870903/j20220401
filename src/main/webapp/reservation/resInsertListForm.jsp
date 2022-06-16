<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../error.jsp"%>
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
			
			
			<div class="col-lg-6 col-md-8 mx-auto">
				<table class="table" style="text-align: center;">
					<thead>
						<tr>
							<th colspan="2" style="font-size: 25px; padding: 20px;">예약 상세 내역</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td width="20%" class="table-active">예약 번호</td>
							<td>${res_num }</td>
						</tr>
						<tr>
							<td class="table-active">작성자</td>
							<td>${re.name }</td>
						</tr>
						<tr>
							<td class="table-active">작성일자</td>
							<td>${re.res_date }</td>
						</tr>
						<tr>
							<td class="table-active">돌봄날짜</td>
							<td>${re.sit_date }</td>
						</tr>
						<tr>
							<td class="table-active">돌봄시간</td>
							<td>${re.sit_start }:00~${re.sit_end }:00</td>
						</tr>
						<tr>
							<td class="table-active">지역</td>
							<td>${re.address }</td>
						</tr>
						<tr>
							<td class="table-active">진행상태</td>
							<td>${re.res_st }</td>
						</tr>
						<tr>
							<td class="table-active">상세 요청사항</td>
							<td style="height: 200px;">${re.request }</td>
						</tr>
					</tbody>
				</table>
				
				
				<div style="display: inline-block; float: left;">
					<button type="button" class="btn btn-outline-secondary" onclick="location.href='resUserList.do?mem_num=${mem_num}'" style="margin-bottom: 10px;">확인</button>
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
	</style>
</body>
</html>