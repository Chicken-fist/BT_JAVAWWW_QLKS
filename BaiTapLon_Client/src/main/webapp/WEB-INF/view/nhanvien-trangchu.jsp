<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<link
	href="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
body {
	margin-top: 20px;
	background: #f1f2f7;
}

/*panel*/
.panel {
	border: none;
	box-shadow: none;
}

.panel-heading {
	border-color: #eff2f7;
	font-size: 16px;
	font-weight: 300;
}

.panel-title {
	color: #2A3542;
	font-size: 14px;
	font-weight: 400;
	margin-bottom: 0;
	margin-top: 0;
	font-family: 'Open Sans', sans-serif;
}

.panel-body {
	padding: 0px 0px 0px 0px !important;
}

/*product list*/
.prod-cat li a {
	border-bottom: 1px dashed #d9d9d9;
}

.prod-cat li a {
	color: #3b3b3b;
}

.prod-cat li ul {
	margin-left: 30px;
}

.prod-cat li ul li a {
	border-bottom: none;
}

.prod-cat li ul li a:hover, .prod-cat li ul li a:focus, .prod-cat li ul li.active a,
	.prod-cat li a:hover, .prod-cat li a:focus, .prod-cat li a.active {
	background: none;
	color: #ff7261;
}

.pro-lab {
	margin-right: 20px;
	font-weight: normal;
}

.pro-sort {
	padding-right: 20px;
	float: left;
}

.pro-page-list {
	margin: 5px 0 0 0;
}

.product-list img {
	width: 100%;
	border-radius: 4px 4px 0 0;
	-webkit-border-radius: 4px 4px 0 0;
}

.product-list .pro-img-box {
	position: relative;
}

.adtocart {
	background: #fc5959;
	width: 30px;
	height: 30px;
	border-radius: 50%;
	-webkit-border-radius: 50%;
	color: #fff;
	display: inline-block;
	text-align: center;
	border: 3px solid #fff;
	left: 31%;
	bottom: 16px;
	position: absolute;
}

.adtocart i {
	color: #fff;
	font-size: 25px;
	line-height: 42px;
}

.pro-title {
	color: #5A5A5A;
	display: inline-block;
	margin-top: 5px;
	font-size: 16px;
}

.product-list .price {
	color: #fc5959;
	font-size: 15px;
	margin-bottom: 5px;
}

.pro-img-details {
	margin-left: -15px;
}

.pro-img-details img {
	width: 100%;
}

.pro-d-title {
	font-size: 16px;
	margin-top: 0;
}

.product_meta {
	border-top: 1px solid #eee;
	border-bottom: 1px solid #eee;
	padding: 10px 0;
	margin: 15px 0;
}

.product_meta span {
	display: block;
	margin-bottom: 10px;
}

.product_meta a, .pro-price {
	color: #fc5959;
}

.pro-price, .amount-old {
	font-size: 18px;
	padding: 0 10px;
}

.amount-old {
	text-decoration: line-through;
}

.quantity {
	width: 120px;
}

.pro-img-list {
	margin: 10px 0 0 -15px;
	width: 100%;
	display: inline-block;
}

.pro-img-list a {
	float: left;
	margin-right: 10px;
	margin-bottom: 10px;
}

.pro-d-head {
	font-size: 18px;
	font-weight: 300;
}
</style>
</head>
<body>

	<c:url var="editImgUrl" value="/resources/img/cover.png" />
	<c:url var="datPhong" value="/reservation/showFormForAdd" />
	<c:url var="dsLoaiPhong" value="/category/list" />
	<c:url var="dsDichVu" value="/service/list" />
	<c:url var="nhanVienTrangChu" value="/nhanvien" />
	<!-- Navbar (sit on top) -->
	<div class="w3-top">
		<div class="w3-bar w3-white w3-card" id="myNavbar">
			<c:url var="imgLogo" value="/resources/img/logo.jpg" />
			<a href="#home" class="w3-bar-item w3-button w3-wide"><img
				src="${imgLogo}" alt="" width="50px" height="50px" /></a>
			<!-- Right-sided navbar links -->
			<div class="w3-right w3-hide-small">
				<a href="${nhanVienTrangChu}" class="w3-bar-item w3-button">ABOUT</a>
				<a href="${dsLoaiPhong}" class="w3-bar-item w3-button"><i
					class="fa fa-th"></i> ROOM</a> <a href="${dsDichVu}"
					class="w3-bar-item w3-button"><i class="fa fa-usd"></i> PRICING</a>
				<a href="#contact" class="w3-bar-item w3-button"><i
					class="fa fa-envelope"></i> CONTACT</a> <a href="#team"
					class="w3-bar-item w3-button"
					onclick="document.getElementById('id01').style.display='block'"
					style="width: auto;"><i class="fa fa-user"></i> ĐĂNG NHẬP</a>
			</div>
			<!-- Hide right-floated links on small screens and replace them with a menu icon -->

			<a href="javascript:void(0)"
				class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium"
				onclick="w3_open()"> <i class="fa fa-bars"></i>
			</a>
		</div>
	</div>

	<!-- Sidebar on small screens when clicking the menu icon -->
	<nav
		class="w3-sidebar w3-bar-block w3-black w3-card w3-animate-left w3-hide-medium w3-hide-large"
		style="display: none" id="mySidebar">
		<a href="javascript:void(0)" onclick="w3_close()"
			class="w3-bar-item w3-button w3-large w3-padding-16">Close ×</a> <a
			href="#about" onclick="w3_close()" class="w3-bar-item w3-button">ABOUT</a>
		<a href="#work" onclick="w3_close()" class="w3-bar-item w3-button">WORK</a>
		<a href="#pricing" onclick="w3_close()" class="w3-bar-item w3-button">PRICING</a>
		<a href="#contact" onclick="w3_close()" class="w3-bar-item w3-button">CONTACT</a>
	</nav>






	<div class="container bootdey" style="margin-top: 100px">
		<div class="col-md-3">
			<section class="panel">
				<div class="panel-body">
					<input type="date" placeholder="Keyword Search"
						class="form-control" />
				</div>
			</section>
			<c:url var="phieuDatUrl" value="/reservation/phieudat" />
			<c:url var="nhanVienUrl" value="/showNhanVien" />
			<section class="panel">
				<header class="panel-heading">
					<a href="${phieuDatUrl}">Phiếu đặt phòng</a>
				</header>
				<security:authorize access="hasRole('MANAGER')">
					<header class="panel-heading">
						<a href="${nhanVienUrl}">Nhân viên</a>
					</header>
				</security:authorize>
			</section>
		</div>

		<div class="col-md-9">
			<div class="row product-list">
				<c:forEach var="temp" items="${rooms}">
					<c:url var="imgTinhTrang" value="/resources/img/phong_trong.jpg" />

					<c:if test="${temp.tinhTrang == 2}">
						<c:url var="imgTinhTrang"
							value="/resources/img/phong_da_duoc_dat.jpg" />
					</c:if>
					<c:if test="${temp.tinhTrang == 3}">
						<c:url var="imgTinhTrang"
							value="/resources/img/phong_dang_quet_don.jpg" />
					</c:if>
					<c:url var="thongTinPhong"
						value="/reservation/showReservationFull?roomId=${temp.maPhong}" />
					<div class="col-md-3">
						<section class="panel">
							<div class="pro-img-box">
								<a href="${thongTinPhong}"> <img src="${imgTinhTrang}"
									alt="" width="20px" height="100dp" />
								</a>
							</div>
							<div class="panel-body text-center">
								<h4>
									<a href="#" class="pro-title"> ${temp.loaiPhong.tenLoai} </a>
								</h4>
								<p class="price">${temp.moTa}</p>
							</div>
						</section>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>

<footer class="w3-center w3-black w3-padding-64">
	<a href="#home" class="w3-button w3-light-grey"><i
		class="fa fa-arrow-up w3-margin-right"></i>To the top</a>
	<div class="w3-xlarge w3-section">
		<i class="fa fa-facebook-official w3-hover-opacity"></i> <i
			class="fa fa-instagram w3-hover-opacity"></i> <i
			class="fa fa-snapchat w3-hover-opacity"></i> <i
			class="fa fa-pinterest-p w3-hover-opacity"></i> <i
			class="fa fa-twitter w3-hover-opacity"></i> <i
			class="fa fa-linkedin w3-hover-opacity"></i>
	</div>
	<p>
		Powered by <a href="https://www.w3schools.com/w3css/default.asp"
			title="W3.CSS" target="_blank" class="w3-hover-text-green">w3.css</a>
	</p>
</footer>
</html>