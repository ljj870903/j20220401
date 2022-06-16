<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/header.css?">
	<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Archivo+Black&family=Nanum+Pen+Script&family=Rubik+Puddles&display=swap" rel="stylesheet">
	<title>구해줘 집사</title>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#MyPage_box').mouseover(function(){
				$('#MyPage').text("마이페이지");
			});
			$('#MyPage_box').mouseout(function(){
				$('#MyPage').text("${id} 님");
			});
		});
	</script>
</head>
<body>
	<nav class="navbar">
		<div></div>
		<div class="navbar_logo">
		    <c:if test="${id == null }">
        		  <a href="main.do">구해줘 집사</a>
        	</c:if>
          	<c:if test="${id != null }">
        		  <a href="loginMain.do?id=${id }&grade=${grade }">구해줘 집사</a>
        	</c:if>
		</div>
		
		<ul class="navbar_menu">
		    <li class="dropdown">
		        <a href="">예약하기</a>
		        <div class="dropdown_content">
		            <a href="resInsertForm.do">돌봄 예약</a>
		            <a href="resList.do">펫시터</a>
		        </div>
		    </li>
		    <li class="dropdown">
		        <a href="">게시판</a>
		        <div class="dropdown_content">
		            <a href="ntcList.do">공지사항</a>
		            <a href="boardList.do?b_category=1">자유게시판</a>
		            <a href="photoList.do">갤러리</a>
		        </div>
		    </li>
		    <li><a href="sitMain.do">지원하기</a></li>
		    <li class="dropdown">
		        <a href="">고객센터</a>
		        <div class="dropdown_content">
		            <a href="cscFAQList.do">FAQ</a>
		            <c:if test="${grade==null||grade=='1'||grade=='2' }">
		            	<a href="cscPList.do">1:1 문의</a>
		            </c:if>
		            <c:if test="${grade=='A' }">
		            	<a href="cscList.do">1:1 문의</a>
		            </c:if>
		        </div>
		    </li>
		</ul>
		
		<ul class="navbar_user">
			<c:choose>
		 	<c:when test="${grade=='1' || grade=='2' }">
		 		<li class="dropdown" id="MyPage_box">
		         	<a id=MyPage>${id } 님</a>
		         	<div class="dropdown_content">
		             	<a href="prfUpdateForm.do">회원수정</a>
		             	<a href="petList.do">PET 정보</a>
		             	<a href="resUserList.do?mem_num=${mem_num }">예약내역</a>
		             	<a href="cscPList.do">문의내역</a>
		         	</div>
		     	</li>
		     	<li><a href="logout.do">로그아웃</a></li>
		 	</c:when>
		 	<c:when test="${grade=='A' }">
		 		<li class="dropdown" id="MyPage_box">
		         	<a id="MyPage">${id } 님</a>
		         	<div class="dropdown_content">
		             	<a href="prfUpdateForm.do">회원수정</a>
		             	<a href="petList.do">PET 정보</a>
		             	<a href="resUserList.do?mem_num=${mem_num }">예약내역</a>
		             	<a href="admMain.do?grade=A">관리자용</a>
		         	</div>
		     	</li>
		     	<li><a href="logout.do">로그아웃</a></li>
		 	</c:when>
			
				<c:otherwise>
					<li><a href="loginForm.do">로그인</a></li>
					<li><a href="prfInsertForm.do">회원가입</a></li>
				</c:otherwise>
				
			</c:choose>
		
		
		</ul>
		<div></div>
	</nav>
</body>
</html>