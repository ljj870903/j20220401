<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="css/section.css?">
<title>구해줘 집사</title>
		<script>
$(function() {
    $("#sit_start").timepicker({
        timeFormat: 'HH:mm p',
        interval: 60,
        defaultTime: '${re.sit_start }',
        startTime: '00:00',
        dynamic: false,
        dropdown: true,
        scrollbar: true        
    });
});
$(function() {
    $("#sit_end").timepicker({
        timeFormat: 'HH:mm p',
        interval: 60,
        defaultTime: '${re.sit_end }',
        startTime: '00:00',
        dynamic: false,
        dropdown: true,
        scrollbar: true        
    });
});
</script>
</head>
<body class="pet_container">
	<jsp:include page="../css/header.jsp"></jsp:include>
	
	<div class="container">
	    <div>
	<!-- 현재 주석 아래쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->
	
		<div class="col-lg-6 col-md-8 mx-auto">
		<form action="resUserUpdate.do?pageNum=${pageNum}&mem_num=${mem_num}&res_num=${re.res_num}" method="post">
			<table class="table table-striped" style="text-align: center;">
				<thead>
					<tr>
						<th colspan="2" style="font-size: 25px; padding: 20px;">예약내용 수정하기</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td width="20%">예약번호</td>
						<td>${re.res_num }</td>
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
						<td>돌봄날짜</td>
						<td><input type="date" name="sit_date" value="${re.sit_date }" class="form-control" min="${sysdate }"></td>
					</tr>
					<tr>
						<td>돌봄시간</td>
						<td>
							<div class="input-group" id="sitTime">
								<input type="text" class="form-control" name="sit_start" id="sit_start">
								<div class="input-group-text">~</div>
								<input type="text" class="form-control" name="sit_end" id="sit_end">
							</div>
						</td>
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
						<td><textarea class="form-control" rows="5" style="resize: none;" name="request">${re.request }</textarea></td>
					</tr>
				</tbody>
			</table>
			
			<div style="display: inline-block; float: left;">
				<button type="button" class="btn btn-outline-secondary" onclick="location.href='resUserList.do?mem_num=${mem_num}&pageNum=${pageNum }'" style="margin-bottom: 10px;">목록</button>
			</div>
			<div style="display: inline-block; float: right;">
				<button type="submit" class="btn btn-outline-secondary" style="margin-bottom: 10px;">수정하기</button>
			</div>
		</form>
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