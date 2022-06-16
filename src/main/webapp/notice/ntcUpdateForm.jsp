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
            <div>
<!-- 현재 주석 아래쪽으로 작업해주세요-------------------------------------------------------------------------------------------------------- -->
				
				<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
				<div class="col-lg-8 col-md-8 mx-auto">
				<form action="ntcUpdatePro.do?pageNum=${pageNum }&n_num=${n_num}&startNum=${startNum}" method="post" enctype="multipart/form-data">
					<table class="table table-striped" style="text-align: center;">
						<thead>
							<tr>
								<th colspan="2" style="font-size: 25px; padding: 20px;">공지사항 글 수정하기</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td width="20%">글번호</td>
								<td>${startNum }</td>
							</tr>
							<tr>
								<td>제목</td>
								<td><input type="text" name="n_title" value="${ntc.n_title }" class="form-control"></td>
							</tr>
							<tr>
								<td>조회수</td>
								<td>${ntc.n_view }</td>
							</tr>
							<tr>
								<td>작성일</td>
								<td>${ntc.n_date }</td>
							</tr>
							<input type="hidden" name="checkDel" id="checkDel" value="1">
							<c:if test="${ntc.n_photo!=null }">
								<tr class="collapse show" id="collapseEx3">
									<td>사진</td>
									<td>
										<img src="${context }/fileSave/${ntc.n_photo}" width="90%">
										<button type="button" class="btn btn-secondary" style="display: block; float: right;"
										data-target="#collapseEx3" id="delBtn" onclick="del()">사진 삭제</button>
									</td>
								</tr>
							</c:if>
							
							<tr>
								<c:if test="${ntc.n_photo!=null }">
									<td>사진 변경</td>
								</c:if>
								<c:if test="${ntc.n_photo==null }">
									<td>사진 추가</td>
								</c:if>
							<td>
								<div class="input-group">
								  <input type="file" name="n_photo" class="form-control" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload">
								  <button class="btn btn-outline-secondary" type="reset" id="inputGroupFileAddon04">취소</button>
								</div>
							</td>
							<tr>
								<td>내용</td>
								<td><textarea class="form-control" rows="5" style="resize: none;" name="n_content">${ntc.n_content }</textarea></td>
							</tr>
						</tbody>
					</table>
					
					<div style="display: inline-block; float: left;">
						<button type="button" class="btn btn-outline-secondary" onclick="location.href='ntcList.do?pageNum=${pageNum}'" style="margin-bottom: 10px;">목록</button>
					</div>
					<div style="display: inline-block; float: right;">
						<button type="submit" class="btn btn-outline-secondary" style="margin-bottom: 10px;">수정하기</button>
					</div>
				</form>
				</div>
				<script type="text/javascript">
						function del() {
							$('#collapseEx3').collapse('hide');
							$('#checkDel').val("0");
						}
				</script>

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