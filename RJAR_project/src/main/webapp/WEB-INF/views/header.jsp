<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
	
<style type="text/css">
.summoner-search-outter-box {
	display: flex;
	justify-content: center;
	align-items: center;
	margin-right: 100px;
}
.main-text-center{
    width:500px;
    height:300px;
    position:absolute;
    left:50%;
    top:50%;
    margin-left:-150px;
    margin-top:-100px;
}
#summoner-search-box{
    margin-left:-150px;
    width: 500px;
}
.w-btn {
    position: relative;
    border: none;
    display: inline-block;
    padding: 15px 30px;
    border-radius: 15px;
    font-family: "paybooc-Light", sans-serif;
    font-size: 16px;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    text-decoration: none;
    font-weight: 700;
    transition: 0.25s;
}

.w-btn-outline {
    position: relative;
    padding: 15px 30px;
    border-radius: 15px;
    font-family: "paybooc-Light", sans-serif;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    text-decoration: none;
    font-weight: 600;
    transition: 0.25s;
}
.w-btn-green {
    background-color: #77af9c;
    color: #d7fff1;
}

.w-btn-green-outline {
    border: 3px solid #77af9c;
    color: darkgray;
}

.w-btn-green-outline:hover {
    background-color: #77af9c;
    color: #d7fff1;
}
.w-btn:hover {
    letter-spacing: 1.5px;
    transform: scale(1.2);
    cursor: pointer;
}

.w-btn-outline:hover {
    letter-spacing: 1.5px;
    transform: scale(1.2);
    cursor: pointer;
}

.w-btn:active {
    transform: scale(1.2);
}

.w-btn-outline:active {
    transform: scale(1.2);
}
#summoner-search-btn:focus { 
    outline:none;
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
						<li class="nav-item"><a class="nav-link" href="./championDetail">챔피언분석</a></li>
						<li class="nav-item"><a class="nav-link" href="./laboratory">연구소</a></li>
						<li class="nav-item"><a class="nav-link" href="./multiSearch">멀티서치</a></li>
						<li class="nav-item"><a class="nav-link" href="./community">커뮤니티</a></li>
						<li class="nav-item"><a class="nav-link" href="./lck">LCK분석</a></li>
						
					</ul>
				</div>
				<div class="summoner-search-outter-box"
					style="text-align: center; vertical-align: middle;">
					<div class="summoner-search-box" style="display:block; margin-right: 3px;">
						<input class="form-control me-sm-2" type="text" placeholder="소환사명을 입력하세요">
					</div>
					<div class="summoner-search-button">
						<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>					
					</div>
				</div>
				<div class="login-box">
				   <button id="login-btn" type="button" class="btn btn-success">로그인</button>
				</div>
			</div>
		</nav>
	</div>
</body>
</html>