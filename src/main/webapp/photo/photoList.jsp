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
		<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
		
		<div class="col-lg-10 col-md-8 mx-auto">
		<h1 class="fw-bolder" id="head1" style="margin-bottom: 60px;">갤러리</h1>
		<c:if test="${mem_num!=null&&grade!=null }">
			<button type="button" class="btn btn-outline-secondary" onclick="location.href='photoWriteForm.do?pageNum=${pageNum}'" style="margin-bottom: 8px; margin-left: 16px;">글쓰기</button>
		</c:if>
		
		  <div class="album py-5 bg-light">
		    <div class="container">
		      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
		
				<c:forEach var="list" items="${list }" >
		
		        <div class="col">
		          <div class="card shadow-sm">
		            <c:if test="${list.b_photo!=null }">
		            	<img src="${context }/fileSave/${list.b_photo}" style="cursor: pointer;" width="100%" height="225" onclick="location.href='photoContent.do?free_num=${list.free_num}&pageNum=${pageNum}'" >
		            </c:if>
		            <c:if test="${list.b_photo==null }">
		            	<svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">사진없음</text></svg>
		            </c:if>
		
		            <div class="card-body">
		              
		              <div style="display: block; float: right;">
		              	<small class="text-muted">작성자 : ${list.id }</small>
		              </div>
		              <br>
		              <h5 class="card-title" style="cursor: pointer; height: 100px; " onclick="location.href='photoContent.do?free_num=${list.free_num}&pageNum=${pageNum}'">${list.b_title }</h5>
		              <div class="d-flex justify-content-between align-items-center">
		                <div class="btn-group">
		                	<c:if test="${mem_num!=null&&grade!=null }">	
			                	<script type="text/javascript">
						      		$(function(){
						      			$('#reco${list.free_num}').click(function(){
						    				if(confirm("이 글을 추천하시겠습니까")){
						    					location.href="recommendPro.do?free_num=${list.free_num}&pageNum=${pageNum}&isListPage=1";
						    				}
						    			});	
						      		});
						      	</script>
					      	</c:if>
							<c:if test="${mem_num==null||grade==null }">	
								<script type="text/javascript">
									$(function(){
										$('#reco${list.free_num}').click(function(){
											alert("추천을 하려면 로그인 해야 합니다");
										});
									});
								</script>
							</c:if>
		                	<div id="reco${list.free_num }" style="border: 1px solid grey; display: flex; width: 70px; height: 45px; border-radius: 6px; justify-content: center; align-items: center; cursor: pointer; ">
								<div style="display: block;">
									<img id="recoImg" alt="" src="${context }/fileSave/thumbs.png" width="20px" style="display: inline; vertical-align: sub; margin-right: 2px;">
									<font size="3" color="blue">${list.b_rc_cnt }</font>
								</div>
							</div>
		                </div>
		                <div style="width: 70px; height: 45px; display: inline-block; text-align: center;"><small class="text-muted">조회수<br>${list.b_view }</small></div>
		                <div style="width: 70px; height: 45px; display: inline-block; text-align: center;"><small class="text-muted">댓글<br>${list.re_count }</small></div>
		                <div style="width: 100px; height: 45px; display: inline-block; text-align: center;"><small class="text-muted">작성일<br>${list.b_date }</small></div>
		              </div>
		            </div>
		          </div>
		        </div>
		      	
		      </c:forEach>
		      </div>
		    
		    
		    </div>
		  </div>
		
		<ul class="pagination" style="justify-content: center;">
	    <c:if test="${startPage > blockSize }">
		    <li class="page-item">
		      <a class="page-link" href="photoList.do?pageNum=${startPage-blockSize }" aria-label="이전">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
	    </c:if>
	    <c:forEach var="i" begin="${startPage }" end="${endPage }">
	    	<c:if test="${currentPage==i }">
	    		<li class="page-item active"><a class="page-link" href="photoList.do?pageNum=${i}">${i }</a></li>	
	    	</c:if>
	    	<c:if test="${currentPage!=i }">
				<li class="page-item"><a class="page-link" href="photoList.do?pageNum=${i}">${i }</a></li>	
	    	</c:if>
		</c:forEach>
		<c:if test="${endPage<pageCnt }">
		    <li class="page-item">
		      <a class="page-link" href="photoList.do?pageNum=${startPage+blockSize }" aria-label="다음">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		</c:if>
	  </ul>
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