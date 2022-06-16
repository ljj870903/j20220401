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
	<h3 align="center">- 예약관련 FAQ - </h3><br>
	<div class="accordion accordion-flush" id="accordionFlushExample">
  <div class="accordion-item">
    <h2 class="accordion-header" id="flush-headingOne">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
        반려묘, 반려견을 함께 키우고 있는데 이용이 가능할까요?
      </button>
    </h2>
    <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">네 가능합니다. 
 							<br> 예약하실 때 상세 설명란(요청사항)에 동거하고 있는 반려묘, 반려견 모두 기입해주시면 요청사항별로 담당 펫시터분이 배정됩니다. </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="flush-headingTwo">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
        서비스 가능지역은 어디인가요?
      </button>
    </h2>
    <div id="flush-collapseTwo" class="accordion-collapse collapse" aria-labelledby="flush-headingTwo" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">전국 서비스 지원중입니다. 
 								<br>다만, 지역에 따라 이용자 수의 편차가 있을 수 있어 사용에 수도권을 제외한 곳에서는 불편함이 있을 수 있습니다.
</div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="flush-headingThree">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree">
        펫시터분들은 어떤분들인가요? 믿을 수 있나요?
      </button>
    </h2>
    <div id="flush-collapseThree" class="accordion-collapse collapse" aria-labelledby="flush-headingThree" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">[구해줘 집사!]에서 신원확인을 마치고 서비스교육을 이수한 펫시터님이 고객님 댁으로 방문하게 됩니다.
 								<br> 반려동물 돌봄 경력자, 반려동물 돌봄 전문가 교육 이수자, 관련 자격증 보유자, 관련업종 경력자 등의 조건을 충족한 펫시터님들이 
 								<br> 고객님들께 더욱 만족스러운 경험을 제공할 것입니다. 
</div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="flush-heading4">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse4" aria-expanded="false" aria-controls="flush-collapse4">
       펫시터 방문가능시간은 언제인가요?
      </button>
    </h2>
    <div id="flush-collapse4" class="accordion-collapse collapse" aria-labelledby="flush-heading4" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">펫시터의 방문가능 시간은 협의에 따라 변경가능합니다.

      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="flush-heading5">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse5" aria-expanded="false" aria-controls="flush-collapse5">
        요금결제는 어떻게하나요?
      </button>
    </h2>
    <div id="flush-collapse5" class="accordion-collapse collapse" aria-labelledby="flush-heading5" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">예약확인이 될경우 펫시터분과 연락을 취하셔서 결제해주시면 됩니다. 
  								<br>[구해줘 집사!]는 별도로 결제 시스템을 지원하지 않으니 이점 꼭 확인 부탁드립니다. </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="flush-heading6">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse6" aria-expanded="false" aria-controls="flush-collapse6">
        예약일, 시간을 변경할 수 있나요?
      </button>
    </h2>
    <div id="flush-collapse6" class="accordion-collapse collapse" aria-labelledby="flush-heading6" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">예약 확인전 : 예약을 취소하고 변경된 날짜, 시간으로 다시 예약을 신청합니다.
 							 <br>예약 확인 후 : [구해줘 집사!]의 고객센터에 예약취소를 요청 한 뒤, 다시 예약을 신청합니다. </div>
    </div>
  </div>
   <div class="accordion-item">
    <h2 class="accordion-header" id="flush-heading7">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse7" aria-expanded="false" aria-controls="flush-collapse7">
        예약 취소시 환불 가능한가요?
      </button>
    </h2>
    <div id="flush-collapse7" class="accordion-collapse collapse" aria-labelledby="flush-heading7" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">고객님의 요청으로 취소, 환불하는 경우 요청시점으로 부터 의뢰 진행일까지 남은기간을 기준으로 다음과 같은 취소 수수료 및 환불 정책을 적용합니다.
      							<br>
								<br>* 의뢰 진행 시작일 3일 전까지 취소를 요청하는 경우 결제 금액의 100% 환불
								<br>* 의뢰 진행 시작일 1일 또는 2일 전까지 취소를 요청하는 경우 결제 금액의 50% 환불
								<br>* 의뢰 진행 당일 취소를 요청하는 경우 결제 금액의 20% 환불 됩니다.
</div>
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