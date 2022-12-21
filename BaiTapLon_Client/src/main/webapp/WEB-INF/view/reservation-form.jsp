<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
}

body, html {
	height: 100%;
	font-family: Arial, Helvetica, sans-serif;
	margin: 0px;
	padding: 0px;
}

* {
	box-sizing: border-box;
}

.bg-img {
	/* The image used */
	padding-top: 100px !important;
	min-height: 800px;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	background-image: url("/resources/img/cover.png") !important;
	position: relative;
}

/* Add styles to the form container */
.container {
	position: absolute;
	right: 0;
	margin: 20px;
	max-width: 500px;
	padding: 16px;
	background-color: white;
}

/* Full-width input fields */
.container input[type=text], .container input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	border: none;
	background: #f1f1f1;
}

.container input[type=text]:focus, .container input[type=password]:focus
	{
	background-color: #ddd;
	outline: none;
}

/* Set a style for the submit button */
.btn {
	background-color: #04AA6D;
	color: white;
	padding: 16px 20px;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.btn:hover {
	opacity: 1;
}

/* Header & Footer */
/* Full height image header */
.bgimg-1 {
	background-position: center;
	background-size: cover;
	background-image: url("/resources/img/cover.png");
	min-height: 100%;
}

.w3-bar .w3-button {
	padding: 16px;
}

/* Full-width input fields */
.container input[type=text], .container input[type=password], .container input[type=date],
	.container input[type=number] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
button {
	background-color: #04AA6D;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
	position: relative;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* The Modal (background) */
.modal {
	display: none;
	/* Hidden by default */
	position: fixed;
	/* Stay in place */
	z-index: 1;
	/* Sit on top */
	left: 0;
	top: 0;
	width: 100%;
	/* Full width */
	height: 100%;
	/* Full height */
	overflow: auto;
	/* Enable scroll if needed */
	background-color: rgb(0, 0, 0);
	/* Fallback color */
	background-color: rgba(0, 0, 0, 0.4);
	/* Black w/ opacity */
	padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 80%;
	/* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}

/* Add Zoom Animation */
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

/* Header & Footer end*/
/* Modal */
.modal {
	display: none;
	/* Hidden by default */
	position: fixed;
	/* Stay in place */
	z-index: 1;
	/* Sit on top */
	left: 0;
	top: 0;
	width: 100%;
	/* Full width */
	height: 100%;
	/* Full height */
	overflow: auto;
	/* Enable scroll if needed */
	background-color: rgb(0, 0, 0);
	/* Fallback color */
	background-color: rgba(0, 0, 0, 0.4);
	/* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 15% auto;
	/* 15% from the top and centered */
	padding: 20px;
	border: 1px solid #888;
	width: 80%;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	-webkit-animation-name: animatetop;
	-webkit-animation-duration: 0.4s;
	animation-name: animatetop;
	animation-duration: 0.4s
		/* Could be more or less, depending on screen size */
}

@
-webkit-keyframes animatetop {from { top:-300px;
	opacity: 0
}

to {
	top: 0;
	opacity: 1
}

}
@
keyframes animatetop {from { top:-300px;
	opacity: 0
}

to {
	top: 0;
	opacity: 1
}

}

/* The Close Button */
.closeModal {
	color: #aaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.closeModal:hover, .closeModal:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
}

.modal-header {
	padding: 2px 16px;
	background-color: #5cb85c;
	color: white;
}

.modal-body {
	padding: 2px 16px;
}
/* Xác nhận: Model - End */
</style>
</head>
<body>
	<c:url var="editImgUrl" value="/resources/img/cover.png" />
	<c:url var="urlBack" value="/reservation/showFormForAdd2" />
	<div class="w3-top">
		<div class="w3-bar w3-white w3-card" id="myNavbar">
			<a href="#home" class="w3-bar-item w3-button w3-wide">LOGO</a>
			<!-- Right-sided navbar links -->
			<div class="w3-right w3-hide-small">
				<a href="#about" class="w3-bar-item w3-button">ABOUT</a> <a
					href="#work" class="w3-bar-item w3-button"><i class="fa fa-th"></i>
					WORK</a> <a href="#pricing" class="w3-bar-item w3-button"><i
					class="fa fa-usd"></i> PRICING</a> <a href="#contact"
					class="w3-bar-item w3-button"><i class="fa fa-envelope"></i>
					CONTACT</a> <a href="#team" class="w3-bar-item w3-button"
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
	<h1 style="padding-top: 50px">Bước 1: Vui lòng điền thông tin
		khách hàng</h1>
	<div class="bg-img"
		style="background-image: url(./resources/img/cover.png);">
		<form:form action="showFormForAdd2" class="container"
			modelAttribute="customer">
			<h1>Thông tin khách hàng</h1>
			<label for="tenKH"><b>Họ tên</b></label>
			<form:input type="text" path="tenKH" />
			<form:errors path="tenKH" cssClass="error"></form:errors>
			<label for="cmnd"> <b>Số CMND</b></label>
			<form:input type="text" path="cmnd" />
			<form:errors path="cmnd" cssClass="error"></form:errors>
			<label for="soDienThoai"> <b>Số điện thoại</b></label>
			<form:input type="text" path="soDienThoai" />
			<form:errors path="soDienThoai" cssClass="error"></form:errors>
			<label for="email"> <b>Email</b>
			</label>
			<form:input type="text" path="email" />
			<form:errors path="email" cssClass="error"></form:errors>
			<label for="diaChi"> <b>Địa chỉ</b>
			</label>
			<form:input type="text" path="diaChi" />
			<form:errors path="diaChi" cssClass="error"></form:errors>
			<input type="submit" class="btn" value="Tiếp tục"
				style="font-size: 20px" />
		</form:form>

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
	<!-- Trigger/Open The Modal -->
	<!-- <button id="myBtn">Open Modal</button> -->

	<!-- The Modal -->
	<script type="text/javascript">
		// Get the modal
		var modal = document.getElementById("myModal");

		// Get the button that opens the modal
		var btn = document.getElementById("myBtn");

		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("closeModal")[0];
		// When the user clicks on the button, open the modal
		btn.onclick = function() {
			modal.style.display = "block";
		}

		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
			modal.style.display = "none";
		}

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>

</body>
</html>