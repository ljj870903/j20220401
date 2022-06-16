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
	<h3 align="center">- 펫시터 지원관련 FAQ - </h3><br>
	<div class="accordion accordion-flush" id="accordionFlushExample">
  <div class="accordion-item">
    <h2 class="accordion-header" id="flush-headingOne">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
        근무환경이 어떻게 되나요?
      </button>
    </h2>
    <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">업무시간 : 자유로운 휴무일 관리로 여가생활을 즐기며 원하는 날에만 일할수 있어요.
  							  <br>근무장소 : 회원가입시 작성한 주소지 기준 가까운곳의 펫시팅 요청을 자동으로 추천해드립니다. 
                			  <br>원하시는 장소를 선택하셔서 근무해주시면 됩니다.</div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="flush-headingTwo">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
        펫시터 활동 수익은 얼마인가요?
      </button>
    </h2>
    <div id="flush-collapseTwo" class="accordion-collapse collapse" aria-labelledby="flush-headingTwo" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">펫시터 여러분이 근무하신 만큼 받아가실수 있습니다.
							  <br>저희 서비스는 중개수수료를 받지 않기 때문에, 펫시터 여러분은 100%수익을 받아가실수 있습니다.
							  <br>또한  저희 [구해줘 집사!]는 별도의 활동비용(가입비, 월회비)를 받지않습니다. 금액 부담없이 [구해줘 집사!]에서 활동해보세요.</div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="flush-headingThree">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree">
       근무환경에 애로사항이 있을경우 어떡하나요?
      </button>
    </h2>
    <div id="flush-collapseThree" class="accordion-collapse collapse" aria-labelledby="flush-headingThree" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">부서 담당자가 항시 대기하여 펫시팅 교육 및 위험 상황 발생 시 언제든 상담 도와드리고 있습니다.</div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="flush-heading4">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse4" aria-expanded="false" aria-controls="flush-collapse4">
       펫시터는 어떤 순서대로 일하게 되나요?
      </button>
    </h2>
    <div id="flush-collapse4" class="accordion-collapse collapse" aria-labelledby="flush-heading4" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">1. 예약 수락 : 홈페이지를 통해 간편하게 가능한 날짜의 예약을 수락합니다
							 <br> 2. 돌봄 : 배정받은 반려동물과 즐거운시간을 보내며 업무해주시면 됩니다
							 <br> 3. 정산 : 예약자분과 연락하셔서 정산받으시면 됩니다. </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="flush-heading5">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse5" aria-expanded="false" aria-controls="flush-collapse5">
       펫시터 지원자격이나 우대사항이 있을까요?
      </button>
    </h2>
    <div id="flush-collapse5" class="accordion-collapse collapse" aria-labelledby="flush-heading5" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">반려동물을 3년이상 키워보신분, 위탁 또는 방문 펫시터 경험자, 반려동물 관련 자격증 소지자, 반려동물 관련 학과 전공자 분들을 우대하고 있습니다만, 
							  <br>외에도 다양하게 지원받고 있으니 부담 없이 남녀노소 모두 지원가능합니다.</div>		
    </div>
  </div>
    <div class="accordion-item">
    <h2 class="accordion-header" id="flush-heading6">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse6" aria-expanded="false" aria-controls="flush-collapse6">
       교육은 어떻게 진행되나요?
      </button>
    </h2>
    <div id="flush-collapse6" class="accordion-collapse collapse" aria-labelledby="flush-heading6" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">교육담당자의 지도하에 진행되며, 펫시팅이론, 홈페이지 사용법, 서비스교육과 같이 펫시터 활동에 필요한 교육으로 진행 됩니다. 
							  <br>모든 교육은 온라인으로 진행되며, 지원자님이 가능하신 시간대에 언제든지 들을 수 있으니 부담없이 지원 부탁드립니다.</div>
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