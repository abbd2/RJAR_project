<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style type="text/css">
.tierVersion {
	margin-left: 70px;
}

.selectOption {
	width: 150px;
	height: 50px;
	margin: 5px;
}

.ui-autocomplete {
	overflow-y: scroll;
	overflow-x: hidden;
}

table.position {
	border: solid 1px lightgray;
	width: 440px;
	margin-left: 70px;
	margin-bottom: 10px;
	/* border-collapse: separate; */
	border-radius: 8px;
}

td:nth-child(-n) {
	border-left: solid 1px lightgray;
}

td:nth-child(-n+5) {
	border-right: solid 1px lightgray;
}

.chamImg {
	border: none;
	width: 100px;
	float: left;
	overflow: auto;
	margin-left: 10px;
}

.i_cham {
	border-radius: 8px;
}

small {
	overflow: hidden;
	white-space: nowrap;
	width: 46px;
	text-overflow: ellipsis;
	height: 16px;
	font-size: 12px;
	line-height: 1.33;
	margin: 2px 0 8px
}

#searchInput {
	width: 300px;
	height: 30px;
	margin-bottom: 10px;
	margin-left: 20px;
	border-radius: 5px;
	border: solid 1px lightgray;
}

#searchInput:focus {
	outline: solid 2px #B3CDFF;
}
</style>


</head>
<body>

	<form action="">
		<div class="tierVersion">
			<select id="tierSelect" class="selectOption">
				<option value="bronze">+Bronze</option>
				<option value="silver">+Silver</option>
				<option value="gold">+Gold</option>
				<option value="platinum">+Platinum</option>
				<option value="diamond">+Diamond</option>
			</select>
			<!-- 		</select> <select id="versionSelect" class="selectOption"> -->
			<!-- 			<option value="12.14.456.5556">12.14</option> -->
			<!-- 			<option value="12.13.456.5556">12.13</option> -->
			<!-- 		</select> -->
		</div>
	</form>
	<div>
		<input id="searchInput" type="text" placeholder="챔피언 검색(가렌, 그라가스...)">
	</div>
	<table class="position">
		<tr>
			<td class="a_img" id="all"><a class="all"
				href="javascript:Aj('./champion_list','#champion_list')"> <img
					name="All"
					src="https://raw.communitydragon.org/latest/plugins/rcp-fe-lol-clash/global/default/assets/images/position-selector/positions/icon-position-fill.png"
					width="40px;" height="40px;">
			</a></td>
			<td class="a_img" id="top"><a class='aTop'
				href="javascript:Aj('./Top','#champion_list')"> <img name='Top'
					src="https://raw.communitydragon.org/latest/plugins/rcp-fe-lol-clash/global/default/assets/images/position-selector/positions/icon-position-top.png"
					width="40px;" height="40px;">
			</a></td>
			<td class="a_img" id="jungle"><a
				href="javascript:Aj('./Jungle','#champion_list')"> <img
					name='Jungle'
					src="https://raw.communitydragon.org/latest/plugins/rcp-fe-lol-clash/global/default/assets/images/position-selector/positions/icon-position-jungle.png"
					width="40px;" height="40px;">
			</a></td>
			<td class="a_img" id="mid"><a
				href="javascript:Aj('./Middle','#champion_list')"> <img
					name='Middle'
					src="https://raw.communitydragon.org/latest/plugins/rcp-fe-lol-clash/global/default/assets/images/position-selector/positions/icon-position-middle.png"
					width="40px;" height="40px;">
			</a></td>
			<td class="a_img" id="bot"><a
				href="javascript:Aj('./Bot','#champion_list')"> <img name='Bot'
					src="https://raw.communitydragon.org/latest/plugins/rcp-fe-lol-clash/global/default/assets/images/position-selector/positions/icon-position-bottom.png"
					width="40px;" height="40px;">
			</a></td>
			<td class="a_img" id="supporter"><a
				href="javascript:Aj('./Supporter','#champion_list')"> <img
					name='Supporter'
					src="https://raw.communitydragon.org/latest/plugins/rcp-fe-lol-clash/global/default/assets/images/position-selector/positions/icon-position-utility.png"
					width="40px;" height="40px;">
			</a></td>
			<td class="a_img" id="free"><a
				href="javascript:Aj('free','#champion_list')"> <img name='free'
					src="https://raw.communitydragon.org/latest/plugins/rcp-fe-lol-clash/global/default/assets/images/position-selector/positions/icon-position-utility.png"
					width="40px;" height="40px;">
			</a></td>
		</tr>
	</table>
	${chamList}

	<script type="text/javascript">
		$('.chamImg').click(
				function() {
					let data_eName = $(this).attr("data-eName");
					let data_lane = $(this).attr("data-lane");
					let data_code = $(this).attr("data-code");
					let $form = $("<form></form>");
					$form.attr("action", "champInfo");
					$("<input>").attr("name", "img").val(
							$(this).attr("data-eName")).appendTo($form);
					$("<input>").attr("name", "lane").val(
							$(this).attr("data-lane")).appendTo($form);
					$("<input>").attr("name", "code").val(
							$(this).attr("data-code")).appendTo($form);

					$form.appendTo("body");
					$form.submit();
				});
	</script>
</body>
</html>