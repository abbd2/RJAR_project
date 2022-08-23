<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	
	<div id='box'>
		<div id='main'>
			<aside>
				<div id='champion_list'>
					<jsp:include page="championList.jsp"></jsp:include>
				</div>
			</aside>
		</div>
	</div>
</body>
<script type="text/javascript">
	Aj('champion_Home','#champion_list');
	
	function Aj(url, position) {
		//비동기 통신은 dataType을 json으로 받을 때만,
		$.ajax({
			url: url,
			type: 'get',
			dataType: 'html' //'json'
		}).done((data)=>$(position).html(data))
		  .fail((data)=>console.log(err));
	} //Aj End
</script>
</html>