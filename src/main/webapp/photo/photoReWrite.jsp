<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table table-striped">
		<c:if test="${list!=null }">
			<thead class="table-secondary">
			<tr>
				<td>작성자</td><td>날짜</td><td>내용</td><td>&nbsp</td>
			</tr>
			</thead>
		</c:if>
		<tbody>
		<c:forEach var="repl" items="${list }">
		<tr>
			<td width="15%">${repl.id }</td>
			<td width="15%">${repl.b_date }</td>
			<td id="td${repl.free_num }" width="50%">${repl.b_content }</td>
			<td width="20%">
				<c:if test="${repl.mem_num==mem_num }">
					<button type="button" class="btn btn-outline-secondary btn-sm" id="bt${repl.free_num }">수정</button>
				</c:if>
				<c:if test="${repl.mem_num==mem_num||grade=='A' }">
					<button type="button" class="btn btn-outline-secondary btn-sm" id="del${repl.free_num }">삭제</button>
				</c:if>
					<script type="text/javascript">
						$(function(){
							$('#bt${repl.free_num}').click(function(){
								var sendData = "free_num="+${repl.free_num};
								$.ajax({
									type:'get',
									url:'ajaxPhotoReUpdate.do',
									dataType:'text',
									data:sendData,
									success:function(data){
										$('#td${repl.free_num}').html(data);
									}
								});
							});
							$('#del${repl.free_num}').click(function(){
								if(confirm("정말로 삭제하시겠습니까?")){
									var sendData = "free_num="+${repl.free_num}+"&ref="+${repl.ref};
									$.ajax({
										type:'get',
										url:'ajaxPhotoReDelete.do',
										dataType:'text',
										data:sendData,
										success:function(data){
											$('#msg').html(data);
										}
									});
								}
							});
						});
					</script>
			</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
</body>
</html>