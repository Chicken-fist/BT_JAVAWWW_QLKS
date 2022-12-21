<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category</title>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>



<style type="text/css">
/* Card */
.card {
	margin-bottom: 30px;
	border: none;
	border-radius: 5px;
	margin-left: 100px;
	width: 600px;
	box-shadow: 0px 0 30px rgba(1, 41, 112, 0.1);
	font-size: 20px;
	box-shadow: 0px 0 30px rgba(1, 41, 112, 0.1);
}

.card-header, .card-footer {
	border-color: #ebeef4;
	background-color: #fff;
	color: #798eb3;
	padding: 15px;
}

.card-title {
	padding: 20px 0 15px 0;
	font-size: 36px;
	font-weight: 500;
	color: #012970;
	font-family: "Poppins", sans-serif;
}

.card-body {
	padding: 0 20px 20px 20px;
	font-family: "Poppins", sans-serif;
}

.card-img-overlay {
	background-color: rgba(255, 255, 255, 0.6);
}

.text_input {
	width: 100%;
	font-size: 20px;
}

table td {
	padding: 20px
}
</style>
</head>
<body>

	<c:url var="editImgUrl" value="/resources/img/cover.png" />
	<c:url var="datPhong" value="/reservation/showFormForAdd" />
	<c:url var="dsLoaiPhong" value="/category/list" />
	<!-- Navbar (sit on top) -->
	<div class="w3-top" style="font-size: 16px;">
		<div class="w3-bar w3-white w3-card" id="myNavbar"
			style="padding: 10px">
			<a href="#home" class="w3-bar-item w3-button w3-wide">LOGO</a>
			<!-- Right-sided navbar links -->
			<div class="w3-right w3-hide-small">
				<a href="#about" class="w3-bar-item w3-button">ABOUT</a> <a
					href="${dsLoaiPhong }" class="w3-bar-item w3-button"><i
					class="fa fa-th"></i> ROOM</a> <a href="#pricing"
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








	<h1>Record</h1>
	<c:url var="saveUrl" value="/category/saveCategory" />
	<section class="section">
		<div class="row" style="margin: 100px 10px 235px 10px;">
			<div class="col-lg-6">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Thông tin loại phòng</h5>
						<form:form modelAttribute="category" method="POST"
							action="${saveUrl}">
							<form:hidden path="maLoai" value="${category.maLoai}" />
							<%--
This line is very important. Without this line, we'd actually lose context or we actually lose the id of the
original customer. So we need to use this line to actually track the customer just so the back end system 
knows which customer to form the update operation on. 
 --%>
							<table>
								<tr>
									<td><form:label path="tenLoai">Tên Loại:</form:label></td>
									<td><form:input path="tenLoai" type="text"
											class="form-control text_input" /></td>
								</tr>
								<tr>
									<td><form:label path="moTa">Mô tả:</form:label></td>
									<td><form:input path="moTa" type="text"
											class="form-control text_input" /></td>
								</tr>
								<tr>
									<td><form:label path="donGia">Đơn giá:</form:label></td>
									<td><form:input path="donGia" type="number"
											class="form-control text_input" /></td>
								</tr>
								<tr>
									<td><form:label path="dienTich">Diện tích:</form:label></td>
									<td><form:input path="dienTich" type="number"
											class="form-control text_input" /></td>
								</tr>
								<tr>
									<td><form:label path="soGiuongNgu">Số giường ngủ:</form:label></td>
									<td><form:input path="soGiuongNgu" type="number"
											class="form-control text_input" /></td>
								</tr>

							</table>

							<input type="submit" value="Save" class="btn btn-primary"
								style="background-color: #4154f1; border: none; border-radius: 5px; width: 100%; height: 100%; font-size: 36px; color: white" />

						</form:form>
					</div>
				</div>
			</div>
	</section>
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
