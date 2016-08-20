<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>menu navigation</title>
		<!-- <link href='css/font.css' rel='stylesheet' type='text/css'> -->
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
		<div class="header">
		</div>
		<div class="side-nav">
			<div class="logo">
				<span>MBaaS BridgeLabz</span>
				<br>
			</div>
			<nav>
				<ul>
					<li>
						<a href="#">
							<span><i><img alt="" src="resources/images/home.png" width="25px" height=25px style="margin-top:20%;"></i></span>
							<span>Project</span>
						</a>
					</li>
					<li>
						<a href="#">
							<span><i><img alt="" src="resources/images/account.png" width="25px" height=25px style="margin-top:20%;"></i></span>
							<span>Auth</span>
						</a>
					</li>
					<li>
						<a href="dashboard">
						<span><i><img alt="" src="resources/images/database.png" width="25px" height=25px style="margin-top:20%;"></i></span>
							<span>Database</span>
						</a>
					</li>
				</ul>
			</nav>
		</div>
		<div class="main-content">
			<div class="title">
				Overview
			</div>
				<div class="widget" align="center" style="height:525px">
					<br>
					<div class="chart" align="center">Welcome to MBaaS BridgeLabz.! Get started here.</div>
					<div class="dashBtn">
					<a class="w3-btn-floating-large w3-teal"><i><img alt="" src="resources/images/androidlogo.png" width="50px" height=50px style="margin-top:20%;"></i></a>
					<div class="text">Android App</div>
					</div>
					<div class="dashBtn">
						<a class="w3-btn-floating-large w3-skyish"><i><img alt="" src="resources/images/ios.png" width="50px" height=50px style="margin-top:20%;"></i></a>
						<div class="text">iOS App</div>
					</div>					
					<div class="dashBtn">
						<a class="w3-btn-floating-large w3-pinksh"><i><img alt="" src="resources/images/download.png" width="50px" height=50px style="margin-top:20%;"></i></a>
						<div class="text">Web App</div>
					</div>				
					</div>
				</div>
	</body>
</html>