<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/footer.css?">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Archivo+Black&family=Nanum+Pen+Script&family=Rubik+Puddles&display=swap" rel="stylesheet">
	<title>구해줘 집사</title>
</head>
<body>
	<footer class="footer">
		<div></div>
		<div>
		    <h2>(주)구해줘집사</h2>
		    <h2>대표 : 이재준 하병헌 황재환 김정수 권재인 김인헌 손유진</h2>
		    <h2>주소 : 서울 마포구 신촌로 176 중앙빌딩 5층 (우)04104</h2>
		</div>
		<div></div>
		<div>
		    <ul>
		        <h2>&nbsp고객센터</h2> 
		        <li><a href="cscFAQList.do">자주 묻는 질문(FAQ)</a></li>
		        
		        <c:if test="${grade==null||grade=='1'||grade=='2' }">
	            	<li><a href="cscPList.do">1:1 문의</a></li>
	            </c:if>
	            <c:if test="${grade=='A' }">
	            	 <li><a href="cscList.do">1:1 문의</a></li>
	            </c:if>
		    </ul>
		</div>
		<div></div>
	</footer>
</body>
</html>