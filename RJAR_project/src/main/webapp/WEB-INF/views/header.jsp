<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.summoner-search-outter-box {
	text-align: center;
	vertical-align: middle;
}
.summoner-search-box{
display: block
}
</style>
</head>
<body>
	<div id="header">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="./home">RJAR</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarColor02"
					aria-controls="navbarColor02" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarColor02">
					<ul class="navbar-nav me-auto">
						<li class="nav-item"><a class="nav-link"
							href="./championDetail">챔피언분석</a></li>
						<li class="nav-item"><a class="nav-link" href="./laboratory">연구소</a></li>
						<li class="nav-item"><a class="nav-link" href="./multiSearch">멀티서치</a></li>
						<li class="nav-item"><a class="nav-link" href="./community">커뮤니티</a></li>
						<li class="nav-item"><a class="nav-link" href="./lck">LCK분석</a></li>

					</ul>
				</div>
				<form action="summonerSearch" method="get">
					<div class="summoner-search-outter-box">
						<div class="summoner-search-box">
							<input type="text" class="form-control me-sm-2" placeholder="소환사명을 입력하세요" name="summonerName">
						</div>
						<div class="summoner-search-button">
							<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
						</div>
					</div>
				</form>
				<div class="login-box">
					<button id="login-btn" type="button" class="btn btn-success">로그인</button>
				</div>
			</div>
		</nav>
	</div>
</body>
</html>