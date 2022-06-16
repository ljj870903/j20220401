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
	
	<br>
	<h3 align="center">- 개인정보 관련 FAQ - </h3><br>
	<div class="accordion accordion-flush" id="accordionFlushExample">
  <div class="accordion-item">
    <h2 class="accordion-header" id="flush-headingOne">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
        아이디랑 비밀번호를 잃어버렸어요. 어떻게 다시 찾죠?
      </button>
    </h2>
    <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">로그인 화면에서 아이디, 비밀번호 찾기 버튼을 누르면 아이디 혹은 비밀번호를 찾을 수 있는 페이지로 이동하게 됩니다. <br>회원가입시 입력하신 이메일 주소가 맞다면 로그인 정보를 수정할 수 있습니다. </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="flush-headingTwo">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
        [구해줘 집사!]를 탈퇴하고 싶어요
      </button>
    </h2>
    <div id="flush-collapseTwo" class="accordion-collapse collapse" aria-labelledby="flush-headingTwo" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">고객센터를 이용해 문의 남겨주시면 가능합니다. <br>단, 탈퇴시 기존의 예약내역,문의사항등은 모두 볼수 없게되오니 신중히 진행해주시길 부탁드립니다.
</div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="flush-headingThree">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree">
        탈퇴했다가 다시 가입하고 싶을땐 어떻게 하죠?
      </button>
    </h2>
    <div id="flush-collapseThree" class="accordion-collapse collapse" aria-labelledby="flush-headingThree" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">탈퇴 후 다시 가입하고 싶으시다면 언제든지 재가입 가능합니다. <br>또한, 이전에 가입했던 아이디, 전화번호로도 가입이 가능합니다.</div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="flush-heading4">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse4" aria-expanded="false" aria-controls="flush-collapse4">
       반려동물 등록 및 수정, 삭제를 어떻게 하나요?
      </button>
    </h2>
    <div id="flush-collapse4" class="accordion-collapse collapse" aria-labelledby="flush-heading4" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">홈페이지 - 마이페이지 내 반려동물 프로필 버튼을 이용하시면 반려동물의 사진, 품종, 몸무게,중성화여부 등 
      						<br> 필수사항을입력 후 등록가능합니다. 더 나은 펫시팅을 위해 선택사항 및 펫시팅시 주의할 점과 참고해야 할 특이사항을 자세히 적어주세요.
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="flush-heading5">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse5" aria-expanded="false" aria-controls="flush-collapse5">
       휴대폰번호나 주소등 개인정보는 어떻게 보호되고 있나요?
      </button>
    </h2>
    <div id="flush-collapse5" class="accordion-collapse collapse" aria-labelledby="flush-heading5" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">홈페이지 - 마이페이지 내 반려동물 프로필 버튼을 이용하시면 반려동물의 사진, 품종, 몸무게,중성화여부 등 
      						<br> 회원가입시 입력하는 개인정보는 개인정보동의서를 통한 개인정보보호법에의해 보호됩니다. 또한 탈퇴 시, 개인정보는 즉시 파기합니다.</div>
    </div>
  </div>
  
</div>
	<div align="center" style="margin-top: 50px;">
		<a class="btn btn-primary" href="cscAply.do" role="button">지원관련 문의</a>
		<a class="btn btn-primary" href="cscProfileInfo.do" role="button">개인정보 문의</a>
		<a class="btn btn-primary" href="cscRes.do" role="button">예약 문의</a>
	</div>

<br>
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