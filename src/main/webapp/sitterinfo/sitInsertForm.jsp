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
			<c:if test="${grade=='0' }">
				<script type="text/javascript">
					alert("펫시터에 지원하려면 로그인을 해주세요");
					location.href = "main.do";
				</script>
			</c:if>
			<c:if test="${grade=='1'&&si!=null }">
				<script type="text/javascript">
					alert("이미 펫시터에 지원하셨습니다");
					location.href = "main.do";
				</script>
			</c:if>
			<c:if test="${grade=='2' }">
				<script type="text/javascript">
					alert("이미 펫시터에 등록이 되었습니다");
					location.href = "main.do";
				</script>
			</c:if>
			<c:if test="${grade=='A' }">
				<script type="text/javascript">
					alert("관리자 등급으로 로그인되어있습니다.");
					location.href = "main.do";
				</script>
			</c:if>



			<div class="row py-lg-5">
				<div class="col-lg-6 col-md-8 mx-auto">
					<h1 class="fw-bolder" id="head1">펫시터 지원 신청서</h1>
					<form class="row g-3" action="sitInsertPro.do">
						<div class="col-md-5">
							<label for="sitterName" class="form-label">이름</label> <input
								type="text" name="name" value="${profile.name }" class="
								form-control" id="sitterName">
						</div>
						<div class="col-md-5">
							<label for="sitterPhone" class="form-label">연락처</label> <input
								type="tel" name="phone" value="${profile.phone }" class="
								form-control" id="sitterPhone">
						</div>
						<div class="col-md-2">
							<label for="sitterGender" class="form-label">성별</label> <select
								id="sitterGender" class="form-select" name="gender">
								<c:if test="${profile.gender=='M' }">
									<option value="M" selected="selected">남자</option>
									<option value="W">여자</option>
								</c:if>
								<c:if test="${profile.gender=='W' }">
									<option value="M">남자</option>
									<option value="W" selected="selected">여자</option>
								</c:if>
							</select>
						</div>
						<div class="col-md-4">
							<label for="sitterYear" class="form-label">생년월일</label>
							<div class="input-group" id="sitterYear">
								<input type="number" class="form-control" name="year"
									value="${year }" min="1900" max="2050">
								<div class="input-group-text">년</div>
							</div>
						</div>
						<div class="col-md-4">
							<label for="sitterMonth" class="form-label">&nbsp</label>
							<div class="input-group" id="sitterMonth">
								<input type="number" class="form-control" name="month"
									value="${month }" min="1" max="12">
								<div class="input-group-text">월</div>
							</div>
						</div>
						<div class="col-md-4">
							<label for="sitterDate" class="form-label">&nbsp</label>
							<div class="input-group" id="sitterDate">
								<input type="number" class="form-control" name="day"
									value="${day }" min="1" max="31">
								<div class="input-group-text">일</div>
							</div>
						</div>
						<div class="col-12">
							<label for="sitterAddress" class="form-label">주소</label> <input
								type="text" name="address" value="${profile.address }" class="
								form-control" id="sitterAddress">
						</div>
						<div class="col-12">
							<label for="sitterMail" class="form-label">이메일</label>
							<div class="input-group" id="sitterMail">
								<input type="text" class="form-control" name="mail1"
									value="${mail[0] }">
								<div class="input-group-text">@</div>
								<input type="text" class="form-control" name="mail2"
									value="${mail[1] }">
							</div>
						</div>

						<div class="col-md-6">
							<label for="sitterSmoke" class="form-label">흡연을 하시나요?</label> <select
								id="sitterSmoke" class="form-select" name="ps_smoke">
								<option value="Y">네</option>
								<option value="N">아니오</option>
							</select>
						</div>
						<div class="col-md-6">
							<label for="sitterPet" class="form-label">반려동물 수</label> <input
								type="number" class="form-control" id="sitterPet" name="petno"
								value="${profile.petno }">
						</div>


						<hr class="my-4">
						<h4 class="mb-3">펫시터 활동 경험</h4>

						<script type="text/javascript"
							src="http://code.jquery.com/jquery-latest.min.js"></script>


						<div class="my-3">
							<div class="form-check">
								<input id="sitterExY" type="radio" name="petExCheck"
									class="form-check-input" required="" 
									data-target="#collapseEx"
									onchange="$('#collapseEx').collapse('show')"> <label
									class="form-check-label" for="sitterExY">네</label>
							</div>
							<div class="form-check">
								<input id="sitterExN" type="radio" name="petExCheck"
									class="form-check-input" required="" 
									data-target="#collapseEx"
									onchange="$('#collapseEx').collapse('hide')" checked> <label
									class="form-check-label" for="sitterExN">아니오</label>
							</div>
						</div>

						<div class="collapse" id="collapseEx">
							<div class="input-group" id="sitterExStart">
								<div class="input-group-text">시작일</div>
								<input type="text" class="form-control"
									placeholder="0000-00-00(년-월-일)" name="ps_start">
								<div class="input-group-text">종료일</div>
								<input type="text" class="form-control"
									placeholder="0000-00-00(년-월-일)" name="ps_end">
							</div>
						</div>



						<hr class="my-4">
						<h4 class="mb-3">관련 업종 종사 경험</h4>
						<div class="my-3">
							<div class="form-check">
								<input id="relExY" type="radio" data-target="#collapseEx2" onchange="$('#collapseEx2').collapse('show')"
									class="form-check-input" required="" name="ps_rel_yn" value="Y">
								<label class="form-check-label" for="relExY">네</label>
							</div>
							<div class="form-check">
								<input id="relExN" type="radio" data-target="#collapseEx2" onchange="$('#collapseEx2').collapse('hide')"
									class="form-check-input" required="" name="ps_rel_yn" value="N" checked>
								<label class="form-check-label" for="relExN">아니오</label>
							</div>
						</div>
						
						<div class="collapse" id="collapseEx2">
							<div class="col-12">
								<label for="relJob" class="form-label">업종을 적어주세요</label> <input
									type="text" class="form-control" id="relJob" name="ps_rel_job"
									placeholder="ex) 동물병원 간호사">
							</div><br>
							<div class="col-12">
								<label for="relPeriod" class="form-label">종사 기간</label> <input
									type="text" class="form-control" id="relPeriod" name="ps_rel_period"
									placeholder="ex) 2년, 6개월">
							</div>
						</div>

						<hr class="my-4">
						<h4 class="mb-3">반려동물 키웠던 경험</h4>
						<div class="my-3">
							<div class="form-check">
								<input id="petEx1" type="radio" data-target="#collapseEx3" onchange="$('#collapseEx3').collapse('hide')"
									class="form-check-input" required="" name="ps_ex_period"
									value="없음" checked> <label class="form-check-label"
									for="petEx1">없음</label>
							</div>
							<div class="form-check">
								<input id="petEx2" type="radio" data-target="#collapseEx3" onchange="$('#collapseEx3').collapse('show')"
									class="form-check-input" required="" name="ps_ex_period"
									value="1년 미만"> <label class="form-check-label"
									for="petEx2">1년 미만</label>
							</div>
							<div class="form-check">
								<input id="petEx3" type="radio" data-target="#collapseEx3" onchange="$('#collapseEx3').collapse('show')"
									class="form-check-input" required="" name="ps_ex_period"
									value="1년~3년"> <label class="form-check-label"
									for="petEx3">1년 이상~3년 미만</label>
							</div>
							<div class="form-check">
								<input id="petEx4" type="radio" data-target="#collapseEx3" onchange="$('#collapseEx3').collapse('show')"
									class="form-check-input" required="" name="ps_ex_period"
									value="3년 이상"> <label class="form-check-label"
									for="petEx4">3년 이상</label>
							</div>
						</div>
						<div class="collapse" id="collapseEx3">
							<label for="petExText" class="form-label">키웠던 과정에 대해 간략하게
								말씀해주세요</label>
							<textarea class="form-control" id="petExText" rows="5"
								style="resize: none;" name="ps_ex_text"></textarea>
						</div>

						<hr class="my-4">
						<h4 class="mb-3">위의 지원서에 대한 정보가 사실임에 동의합니다</h4>
						<div class="my-3">
							<div class="form-check">
								<input id="relExY" type="radio"
									class="form-check-input" required="" name="ps_agree" value="Y">
								<label class="form-check-label" for="relExY">네</label>
							</div>
							<div class="form-check">
								<input id="relExN" type="radio"
									class="form-check-input" required="" name="ps_agree" value="N">
								<label class="form-check-label" for="relExN">아니오</label>
							</div>
						</div>

						<button type="submit" class="btn btn-primary btn-lg">지원하기</button>

					</form>
				</div>
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