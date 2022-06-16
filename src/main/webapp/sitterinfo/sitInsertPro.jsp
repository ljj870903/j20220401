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
<body class="container">
	<jsp:include page="../css/header.jsp"></jsp:include>

       <div class="container">
       <!-- 가져온 정보 : mem_num, result -->
	<!-- 보내는 정보 : mem_num -->
<!-- 현재 주석 아래쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->
           <!-- p 태그 전부 지우고 진행해주세요 -->
           <c:if test="${result>0 }">
   		<script type="text/javascript">
   			alert("펫시터 지원 신청이 정상적으로 이루어 졌습니다");
   			location.href="main.do";
   		</script>
    	</c:if>
    	<c:if test="${result==0 }">
    		<script type="text/javascript">
    			alert("펫시터 지원 신청이 실패 했습니다. 다시 신청해주세요");
    			location.href="sitInsertForm.do";
    		</script>
    	</c:if>
        
        </div>
<!-- 현재 주석 위쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->
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