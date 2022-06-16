<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>구해줘집사</title></head><body>
<c:if test="${result > 0 }">
	<script type="text/javascript">
		alert("수정이 완료되었습니다");  
		location.href="cscPList.do?pageNum=${pageNum}";
	</script>
</c:if>
<c:if test="${result == 0 }">  
	<script type="text/javascript">
		alert("수정 실패. 다시 시도해 주시기 바랍니다.");  
		location.href="cscUpdateForm.do?pageNum=${pageNum}&cs_num=${cs_num}&startNum=${startNum}";
	</script>
</c:if>
</body>
</html>