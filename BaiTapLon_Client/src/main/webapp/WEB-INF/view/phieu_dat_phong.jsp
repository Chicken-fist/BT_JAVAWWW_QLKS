<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Document</title>
<style>
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Raleway", sans-serif
}

body, html {
	height: 100%;
	line-height: 1.8;
}

/* Full height image header */
.bgimg-1 {
	background-position: center;
	background-size: cover;
	background-image: url("/Demo_QLKS/cover.jpg");
	min-height: 100%;
}

.w3-bar .w3-button {
	padding: 16px;
}

button:hover {
	opacity: 0.8;
}

/* Thân Website */
.container {
	width: 100%;
}

/* Set height of the grid so .sidenav can be 100% (adjust if needed) */
.row.content {
	height: 1000px
}

/* Set gray background color and 100% height */
.sidenav {
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

ul li.active a {
	background-color: black !important;
	color: white !important;
}

/* THân Website - hết */
.animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

@
-webkit-keyframes animatezoom {from { -webkit-transform:scale(0)
	
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes animatezoom {from { transform:scale(0)
	
}

to {
	transform: scale(1)
}

}
/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		var menuHome = document.getElementById("menuHome");
		var menuDaTiepNhan = document.getElementById("menuDaTiepNhan");
		var menuDaThanhToan = document.getElementById("menuDaThanhToan");
		var menuHoaDon = document.getElementById("menuHoaDon");
		/* var menuDaHuy = document.getElementById("menuDaHuy"); */
		$('.table_chua_xac_nhan').show()
		$('.table_da_xac_nhan').hide()
		$('.table_da_thanh_toan').hide()
		$('.table_hoa_don').hide()
		menuHome.classList.add("active");
		menuDaThanhToan.classList.remove("active");
		/* menuDaHuy.classList.remove("active"); */
		menuDaTiepNhan.classList.remove("active");
		menuHoaDon.classList.remove("active");
		$('#menuHome').click(function() {
			$('.table_chua_xac_nhan').show()
			$('.table_da_xac_nhan').hide()
			$('.table_da_thanh_toan').hide()
			$('.table_hoa_don').hide()
			menuHome.classList.add("active");
			menuDaThanhToan.classList.remove("active");
			/* menuDaHuy.classList.remove("active"); */
			menuDaTiepNhan.classList.remove("active");
			menuHoaDon.classList.remove("active");
		})
		$('#menuDaTiepNhan').click(function() {
			$('.table_chua_xac_nhan').hide()
			$('.table_da_xac_nhan').show()
			$('.table_da_thanh_toan').hide()
			$('.table_hoa_don').hide()
			menuHome.classList.remove("active");
			menuDaThanhToan.classList.remove("active");
			/* menuDaHuy.classList.remove("active"); */
			menuDaTiepNhan.classList.add("active");
			menuHoaDon.classList.remove("active");
		})
		$('#menuDaThanhToan').click(function() {
			$('.table_chua_xac_nhan').hide()
			$('.table_da_xac_nhan').hide()
			$('.table_da_thanh_toan').show()
			$('.table_hoa_don').hide()
			/* 	$('.form_form').show() */
			menuHome.classList.remove("active");

			/* menuDaHuy.classList.remove("active"); */
			menuDaTiepNhan.classList.remove("active");
			menuDaThanhToan.classList.add("active");
			menuHoaDon.classList.remove("active");
		})
		$('#menuHoaDon').click(function() {
			$('.table_chua_xac_nhan').hide()
			$('.table_da_xac_nhan').hide()
			$('.table_da_thanh_toan').hide()
			$('.table_hoa_don').show()
			menuHome.classList.remove("active");
			menuDaThanhToan.classList.remove("active");
			/* menuDaHuy.classList.remove("active"); */
			menuDaTiepNhan.classList.remove("active");
			menuHoaDon.classList.add("active");
		})
		/* $('#menuDaHuy').click(function() {
			$('.table_table').hide()
			$('.form_form').hide()
			menuHome.classList.remove("active");
			menuDaThanhToan.classList.remove("active");
			menuDaTiepNhan.classList.remove("active");
			menuDaHuy.classList.add("active");
		}) */
	})
</script>

<body>
	<!-- Navbar (sit on top) -->
	<c:url var="logoutUrl"
		value="${pageContext.request.contextPath}/logout" />
	<div class="w3-top">
		<div class="w3-bar w3-white w3-card" id="myNavbar">
			<a href="#home" class="w3-bar-item w3-button w3-wide">LOGO</a>
			<!-- Right-sided navbar links -->
			<div class="w3-right w3-hide-small">
				<a href="#about" class="w3-bar-item w3-button"> KHÁCH HÀNG</a> <a
					href="../Demo_QLKS/NhanVien_Phong.html"
					class="w3-bar-item w3-button"><i class="fa fa-th"></i> PHÒNG</a> <a
					href="#pricing" class="w3-bar-item w3-button"><i
					class="fa fa-usd"></i> HÓA ĐƠN</a> <a href="#contact"
					class="w3-bar-item w3-button"><i class="fa fa-envelope"></i>
					PHIẾU ĐẶT PHÒNG</a> <a href="#team"
					class="w3-bar-item w3-button dropdown-toggle"
					data-toggle="dropdown"> <i class="fa fa-user"></i> Nhân Viên
				</a>
				<ul class="dropdown-menu" style="margin-left:1526px;">
					<li><a href="#">Thông tin cơ bản</a></li>
					<li><a href="#">Đổi mật khẩu</a></li>
					<li><form:form
							action="${pageContext.request.contextPath}/logout" method="POST">
							<input type="submit" value="Logout"
								style="font-family: inherit; font-size: inherit; line-height: inherit; border: none; background-color: white; padding-left: 21px;" />
						</form:form></li>
				</ul>
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
	<br>
	<br>
	<div style="height: 30px;"></div>
	<div class="container">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<h4>QUẢN LÝ PHIẾU ĐẶT PHÒNG</h4>
				<ul class="nav nav-pills nav-stacked">
					<li class="active" id="menuHome"><a href="#section1">Đang
							xử lý</a></li>
					<li id="menuDaTiepNhan"><a href="#section2">Đã tiếp nhận</a></li>
					<li id="menuDaThanhToan"><a href="#section3">Đã thanh toán</a></li>
					<li id="menuHoaDon"><a href="#section4">Hóa đơn</a></li>
					<!-- 	<li id="menuDaHuy"><a href="#section3">Đã hủy</a></li> -->
			</div>
			<c:url var="xacNhanImgUrl" value="/resources/img/xacNhan.jpg" />
			<c:url var="deleteImgUrl" value="/resources/img/delete.png" />


			<div class="col-sm-10">
				<div class="container-fluid table_chua_xac_nhan">
					<div class="panel panel-primary">
						<div class="panel-heading" style="background-color: black;">Danh
							sách phiếu đặt đang chờ xác nhận</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>Mã phiếu</th>
										<th>Ngày nhận phòng</th>
										<th>Ngày trả phòng</th>
										<th>Người lớn</th>
										<th>Trẻ em</th>
										<th>Tình trạng</th>
										<th colspan="2">Xác nhận / Hủy</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${reservations}" var="reservation">

										<c:url var="xacNhanUrl" value="/reservation/updateReservation">
											<c:param name="reservationId"
												value="${reservation.maPhieuDatPhong}" />
										</c:url>
										<!-- construct an "delete" link with customer id -->
										<c:url var="deleteUrl" value="/reservation/delete">
											<c:param name="reservationId"
												value="${reservation.maPhieuDatPhong}" />
										</c:url>
										<c:if test="${reservation.tinhTrangPhieuDat == 1}">

											<tr>
												<td><c:out value="${reservation.maPhieuDatPhong}" /></td>
												<td><c:out value="${reservation.ngayNhanPhong}" /></td>
												<td><c:out value="${reservation.ngayTraPhong}" /></td>
												<td><c:out value="${reservation.soNguoiLon}" /></td>
												<td><c:out value="${reservation.soTreEm}" /></td>
												<td><c:out value="${reservation.tinhTrangPhieuDat}" /></td>
												<td><a href="${xacNhanUrl}"><img
														src="${xacNhanImgUrl}" /> </a></td>
												<td><a href="${deleteUrl}"><img
														src="${deleteImgUrl}" /></a></td>
											</tr>
										</c:if>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>


				<c:url var="thanhToanImgUrl" value="/resources/img/eye.png" />
				<div class="container-fluid table_da_xac_nhan">
					<div class="panel panel-primary">
						<div class="panel-heading" style="background-color: black;">Danh
							sách phiếu đặt đã xác nhận</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>Mã phiếu</th>
										<th>Ngày nhận phòng</th>
										<th>Ngày trả phòng</th>
										<th>Người lớn</th>
										<th>Trẻ em</th>
										<th>Tình trạng</th>
										<th>Thanh toán</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${reservations}" var="reservation">
										<c:if test="${reservation.tinhTrangPhieuDat == 2}">
											<tr>
												<td><c:out value="${reservation.maPhieuDatPhong}" /></td>
												<td><c:out value="${reservation.ngayNhanPhong}" /></td>
												<td><c:out value="${reservation.ngayTraPhong}" /></td>
												<td><c:out value="${reservation.soNguoiLon}" /></td>
												<td><c:out value="${reservation.soTreEm}" /></td>
												<td><c:out value="${reservation.tinhTrangPhieuDat}" /></td>
												<td><a href="${thanhToanUrl}"><img
														src="${thanhToanImgUrl}" /></a></td>
											</tr>
										</c:if>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="container-fluid table_da_thanh_toan">
					<div class="panel panel-primary">
						<div class="panel-heading" style="background-color: black;">Danh
							sách phiếu đặt đã thanh toán</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>Mã phiếu</th>
										<th>Ngày nhận phòng</th>
										<th>Ngày trả phòng</th>
										<th>Người lớn</th>
										<th>Trẻ em</th>
										<th>Tình trạng</th>
										<!-- <th colspan="2">Xác nhận / Hủy</th> -->

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${reservations}" var="reservation">
										<c:if test="${reservation.tinhTrangPhieuDat == 3}">
											<tr>
												<td><c:out value="${reservation.maPhieuDatPhong}" /></td>
												<td><c:out value="${reservation.ngayNhanPhong}" /></td>
												<td><c:out value="${reservation.ngayTraPhong}" /></td>
												<td><c:out value="${reservation.soNguoiLon}" /></td>
												<td><c:out value="${reservation.soTreEm}" /></td>
												<td><c:out value="${reservation.tinhTrangPhieuDat}" /></td>
												<%-- <td><a href="${editUrl}"><img src="${editImgUrl}" />
												</a></td> --%>
												<%-- <td><a href="${deleteUrl}"><img
														src="${deleteImgUrl}" /></a></td> --%>
											</tr>
										</c:if>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="container-fluid table_hoa_don">
					<div class="panel panel-primary">
						<div class="panel-heading" style="background-color: black;">Danh
							sách hóa đơn</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>Mã hóa đơn</th>
										<th>Mã phiếu đặt</th>
										<th>Ngày lập</th>
										<th>Số người lớn thực tế</th>
										<th>Phụ thu</th>
										<th>Tiền phòng</th>
										<th>Tiền dịch vụ</th>
										<th>Tổng tiền</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${bills}" var="bill">
										<tr>
											<td><c:out value="${bill.maHD}" /></td>
											<td><c:out value="${bill.maPhieuDatPhong}" /></td>
											<td><c:out value="${bill.ngayNhanPhong}" /></td>
											<td><c:out value="${bill.ngayLap}" /></td>
											<td><c:out value="${bill.soNguoiLonThucTe}" /></td>
											<td><c:out value="${bill.phuThu}" /></td>
											<td><c:out value="${bill.tienPhong}" /></td>
											<td><c:out value="${bill.tienDV}" /></td>
											<%-- <td><a href="${thanhToanUrl}"><img
													src="${thanhToanImgUrl}" /></a></td> --%>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<%-- <div class="container-fluid form_form">
					<div class="panel panel-primary">
						<div class="panel-heading" style="background-color: black;">Add
							User</div>
						<div class="panel-body">
							<form action="#add_user" method="get" class="form">
								<input type="text" name="fullname" id="txtName" class="c_name"
									placeholder="Enter your name..." size="50"> <br> <br>
								<input type="text" name="address" id=""
									placeholder="Enter your address..." size="50"> <br>
								<br> <input type="number" name="age" id=""
									placeholder="Enter your age..." size="20"> <br> <br>
								<input type="email" name="email" id=""
									placeholder="Enter your email..." size="50"> <br>
								<br> <input type="number" name="phonenumber" id=""
									placeholder="Enter your phone number..." size="50"> <br>
								<br>
								<center>
									<button type="button" id="btnAdd">Add User</button>
									<button type="button" id="btnSort" style="margin-left: 20px;">Sort</button>
									<button type="reset" id="btnReset" style="margin-left: 20px;">Reset</button>
								</center>
							</form>
						</div>
					</div>
				</div> --%>
			</div>
		</div>
	</div>

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

	</div>

</body>

</html>