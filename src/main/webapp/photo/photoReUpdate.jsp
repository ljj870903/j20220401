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
	<input type="hidden" name="free_num" value="${board.free_num }" id="freenum">
	<div class="input-group input-group-sm mb-3">
		<input type="text" name="b_content" value="${board.b_content }" class="form-control" id="updateC">
		<button class="btn btn-outline-secondary" type="button" id="confirm">확인</button>
	</div>
	<script type="text/javascript">
		$(function(){
			$('#confirm').click(function(){
				var content = $('#updateC').val();
				var free_num = $('#freenum').val();
				var sendData = 'free_num='+free_num+'&b_content='+content;
				$.ajax({
					type:'get',
					url:'ajaxPhotoReUpdatePro.do',
					dataType:'text',
					data:sendData,
					success:function(data){
						$('#td${board.free_num}').html(data);
					}
				});
			});
		});
	</script>
</body>
</html>