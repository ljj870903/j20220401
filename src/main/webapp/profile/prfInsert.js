	function chk() {
			if (join.pw.value != join.pwpath.value) {
				alert("암호가 다릅니다,");
				join.pwpath.focus();
				join.pwpath.value="";
				return false;
			}
			return true;
		}
	
		function idchk() {
			if(!join.id.value){
				alert("ID를 입력 하세요.");
				join.id.focus();
				return false;
			}
			window.open("idchk.do?id=" + join.id.value,"",'width=300, height=300');

		}