<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>menu navigation</title>
<link href='resources/css/font.css' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="resources/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/ionicons.min.css">
<link rel="stylesheet" href="resources/css/main.css">
<link rel="stylesheet" href="resources/css/w3.css">
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/highcharts.js"></script>
<script src="resources/js/data.js"></script>
<script src="resources/js/main.js"></script>

<style>
.ad {
	position: absolute;
	width: 300px;
	height: 250px;
	border: 0px 0px #ddd;
	left: 50%;
	transform: translateX(-50%);
	top: 250px;
	z-index: 10;
}

.ad .close {
	position: absolute;
	font-family: 'ionicons';
	width: 20px;
	height: 20px;
	color: #fff;
	background-color: #999;
	font-size: 20px;
	left: -20px;
	top: -1px;
	display: table-cell;
	vertical-align: middle;
	cursor: pointer;
	text-align: center;
}
</style>
<script type="text/javascript">
	$(function() {
		$('.close').click(function() {
			$('.ad').css('display', 'none');
		})
	})
</script>

</head>
<body>
	<div class="header"></div>
	<div class="side-nav">
		<div class="logo">
			<span>MBasS BridgeLabz</span> <br>
		</div>
		<nav>
		<ul>
			<li><a href="#"> <span><i><img alt=""
							src="resources/images/home.png" width="25px" height=25px
							style="margin-top: 20%;"></i></span> <span>Project</span>
			</a></li>
			<li><a href="#"> <span><i><img alt=""
							src="resources/images/account.png" width="25px" height=25px
							style="margin-top: 20%;"></i></span> <span>Auth</span>
			</a></li>
			<li><a href="dashboard"> <span><i><img alt=""
							src="resources/images/database.png" width="25px" height=25px
							style="margin-top: 20%;"></i></span> <span>Database</span>
			</a></li>
		</ul>
		</nav>
		
	</div>
	<div class="main-content">
		<div class="title">REALTIME DATABASE</div>
		<div class="w3-container">
			<ul class="w3-navbar">
				<li><a href="">Select</a></li>
				<li><a href="">Update</a></li>
				<li><a href="">Delete</a></li>
				<li><a href="">Insert JSON Key & Value Format</a></li>
				<li><a href="fileUploadForm">Upload JSON Table Schema File</a></li>
			</ul>
		</div>

		<div class="widget" align="center" style="height:525px">
			<br>

		</div>
	</div>
</body>
</html>