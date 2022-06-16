<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<style>
	IMG {border: none;}
	input[type="number"]::-webkit-outer-spin-button,
	input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}
</style>
<html>
<%
	String context = request.getContextPath();
	System.out.println("context->"+context);
	
%>
<script type="text/javascript">
function readURL(input) {
	
//	alert('input.files[0]->'+input.files[0]);
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			// preview 라는 이미지의 값 세팅
			document.getElementById('preview').src = e.target.result;
		};
		// 실질적으로 파일을 화면에 보여주는 역할
		reader.readAsDataURL(input.files[0]);
	} else {
		document.getElementById('preview').src = "";
	}
}
</script>
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
	
	<div class="col-lg-8 col-md-8 mx-auto">
	<form action="petUpdatePro.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="pet_num" value="${petinfo.pet_num }">
	<table class="table table-striped" style="text-align: center;">
		<thead>
			<tr>
				<th colspan="2" style="font-size: 25px; padding: 20px;">반려동물 정보 수정</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td width="40%">사진</td>
				<td><img id="preview" src="<%=context%>/${filename}" width="80%" style="width: 400px; height: 400px"></td>
			</tr>
			<tr>
				<td>사진 변경</td>
				<td><input class="form-control" type="file" name="pet_photo" 
				required="required" onchange="readURL(this);" accept="image/png, image/jpeg, image/jpg"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input
						type="text" name="pet_name" class="form-control" 
						required="required" value="${petinfo.pet_name }"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<div class="form-check" style="display: inline-block; margin-left: 40px; margin-right: 40px;">
					 <input class="form-check-input" type="radio" name="pet_gender" id="pet_gender"
					 value="M" checked>
				 	 <label class="form-check-label" for="pet_gender">
				   	 남자아이
				 	 </label>
				 	</div>
				 	<div class="form-check" style="display: inline-block; margin-left: 40px; margin-right: 40px;">
				 	 <input class="form-check-input" type="radio" name="pet_gender" id="pet_gender"
					 value="F">
				 	 <label class="form-check-label" for="pet_gender">
				   	 여자아이
				 	 </label>
				 	</div>
				</td>
			</tr>
			<tr>
				<td>품종</td>
				<td><input
						type="text" name="pet_type" class="form-control" 
						required="required" value="${petinfo.pet_type}"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input
						type="number" name="pet_age" class="form-control" 
						required="required" value="${petinfo.pet_age}" placeholder="숫자로 입력해주세요 ex)1,2,3..."></td>
			</tr>
			<tr>
				<td>몸무게</td>
				<td><input
						type="number" name="pet_weight" class="form-control" 
						required="required" value="${petinfo.pet_weight}" placeholder="숫자로 입력해주세요 ex)1,2,3..."></td>
			</tr>
			<tr>
				<td>중성화</td>
				<td>
					<div class="form-check" style="display: inline-block; margin-left: 40px; margin-right: 40px;">
					 <input class="form-check-input" type="radio" name="pet_neuter" id="pet_neuter"
					 value="Y" checked>
				 	 <label class="form-check-label" for="pet_neuter">
				   	 했어요
				 	 </label>
				 	</div>
				 	<div class="form-check" style="display: inline-block; margin-left: 40px; margin-right: 40px;">
				 	 <input class="form-check-input" type="radio" name="pet_neuter" id="pet_neuter"
					 value="N">
				 	 <label class="form-check-label" for="pet_neuter">
				   	 안했어요
				 	 </label>
				 	</div>
				</td>
			</tr>
		</tbody>
	</table>
			
	<div style="display: inline-block; float: left;">
		<button type="button" class="btn btn-outline-secondary" onclick="location.href='petList.do'" style="margin-bottom: 10px;">목록</button>
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
		td{
			vertical-align: middle;
		}
	</style>
</body>
</html>
