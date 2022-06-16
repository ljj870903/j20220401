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
	<!-- 가져온 정보 : profile, mem_num, year, month, day, mail[2] -->
	<!-- 보내는 정보 : mem_num, name, phone, gender, year, month, day, address, mail1, mail2,
	   ps_start, ps_end, ps_smoke, petno, ps_rel_yn, ps_rel_job, ps_rel_period,
	   ps_ex_period, ps_ex_text, ps_agree -->
		<div></div>
	    <div>


	<!-- 현재 주석 아래쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->
	<c:choose>
		<c:when test="${result>0&&rcCount==0 }">
			<script type="text/javascript">
				alert("해당 게시물을 추천하였습니다. 첫번째 추천!");
				location.href="freeContent.do?free_num=${free_num}&pageNum=${pageNum}";
			</script>
		</c:when>
		<c:when test="${result>0&&rcCount==1 }">
			<script type="text/javascript">
				alert("해당 게시물을 추천하였습니다. 두번째 추천!");
				location.href="freeContent.do?free_num=${free_num}&pageNum=${pageNum}";
			</script>
		</c:when>
		<c:when test="${result>0&&rcCount==2 }">
			<script type="text/javascript">
				alert("해당 게시물을 추천하였습니다. 세번째 추천!");
				location.href="freeContent.do?free_num=${free_num}&pageNum=${pageNum}";
			</script>
		</c:when>
		<c:when test="${result==0||rcCount>=3 }">
			<script type="text/javascript">
				alert("더 이상 추천할 수 없습니다. 게시물 당 3번의 추천만 가능합니다");
				location.href="freeContent.do?free_num=${free_num}&pageNum=${pageNum}";
			</script>
		</c:when>
	</c:choose>




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