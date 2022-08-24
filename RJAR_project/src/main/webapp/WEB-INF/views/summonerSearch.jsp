<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>

<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<title>summonerSearch</title>
<style type="text/css">
.summoner-search-outter-box {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-right: 100px;
}

.header {
	height: 20%;
	border-color: 
}

.main {
	height: 60%;
	border-color: red;
}

.footer {
	height: 20%
}
</style>
</head>
<body>
<div class= header>
<jsp:include page="header.jsp"></jsp:include>
</div>
	<div class="main">
		<div class="left-main">
			<div class="left-sub-detail"></div>
			<div class="left-playChamp-detail"></div>
		</div>
		<div class="right-main"></div>
	</div>
	<div class="footer"></div>
	<img
		src="http://ddragon.leagueoflegends.com/cdn/12.15.1/img/profileicon/${profileIconId}.png">
	<h1>전적 검색 페이지</h1>
	<h2>검색한 소환사 이름: ${summonerName}</h2>
	<h2>${puuid}</h2>
	<h2>${LV}</h2>
	<h1>자유랭크</h1>
	<h2>${freeTier}</h2>
	<h2>${freeLeaguePoint}</h2>
	<h2>${freeWins}</h2>
	<h2>${freeLosses}</h2>
	<h2>${freeWinRate}%</h2>
	<h1>솔로랭크</h1>
	<h2>${soloTier}</h2>
	<h2>${soloLeaguePoint}</h2>
	<h2>${soloWins}</h2>
	<h2>${soloLosses}</h2>
	<h2>${soloWinRate}</h2>
	<h2>${gameDuration}</h2>
	<h2>${gameEndTimestamp}</h2>
	<h2>${json}</h2>
	
	<div id="main"></div>
	<div id="footer"></div>
<script type="text/javascript">
console.log(Object.keys(${json}))


</script>
</body>
</html>