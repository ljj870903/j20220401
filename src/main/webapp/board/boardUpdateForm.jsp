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
				
				
				<div class="col-lg-8 col-md-8 mx-auto">
				
				<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
				<form action="boardUpdatePro.do" method="post" enctype="multipart/form-data">
					<input		type="hidden" name="free_num" value="${board.free_num }">
					<input 		type="hidden" name="pageNum" value="${pageNum }">
					<table class="table table-striped" style="text-align: center;">
						<thead>
							<tr>
								<th colspan="2" style="font-size: 25px; padding: 20px;">자유게시판 글 수정하기</th>
							</tr>
						</thead>
						<tbody>
						
							<tr>
								<td>제목</td>
								<td><input type="text" name="b_title" value="${board.b_title }" class="form-control"></td>
							</tr>
							<tr>
								<td>조회수</td>
								<td>${board.b_view }</td>
							</tr>
							<tr>
								<td>작성일</td>
								<td>${board.b_date }</td>
							</tr>
							<input type="hidden" name="checkDel" id="checkDel" value="1">
							<c:if test="${board.b_photo!=null }">
								<tr class="collapse show" id="collapseEx3">
									<td>사진</td>
									<td>
										<img src="${context }/fileSave/${board.b_photo}" width="90%"><br>
										<button type="button" class="btn btn-secondary" style="display: block; float: right; margin-top: 5px; margin-right: 20px;"
										data-target="#collapseEx3" id="delBtn" onclick="del()">사진 삭제</button>
									</td>
								</tr>
							</c:if>
							
							<tr>
								<c:if test="${board.b_photo!=null }">
									<td>사진 변경</td>
								</c:if>
								<c:if test="${board.b_photo==null }">
									<td>사진 추가</td>
								</c:if>
							<td>
								<div class="input-group">
								  <input type="file" name="b_photo" class="form-control" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload">
								</div>
							</td>
							<tr>
								<td>내용</td>
								<td><textarea class="form-control" rows="5" style="resize: none;" name="b_content">${board.b_content }</textarea></td>
							</tr>
						</tbody>
					</table>
					
					<div style="display: inline-block; float: left;">
						<button type="button" class="btn btn-outline-secondary"  onclick="location.href='freeContent.do?free_num=${board.free_num}&pageNum=${pageNum }&b_category=${board.b_category}'" style="margin-bottom: 10px;">목록</button>
					</div>
					<div style="display: inline-block; float: right;">
						<button type="submit" class="btn btn-outline-secondary" style="margin-bottom: 10px;">수정하기</button>
					</div>
				</form>
				<script type="text/javascript">
						function del() {
							$('#collapseEx3').collapse('hide');
							$('#checkDel').val("0");
						}
				</script>
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