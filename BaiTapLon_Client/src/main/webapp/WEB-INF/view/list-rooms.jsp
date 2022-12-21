<%-- 
    Document   : person
    Created on : Mar 13, 2021, 7:43:39 PM
    Author     : TriPham
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%--<%@ page import="com.se.onetomany.sortutil.SortUtils"%> --%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Room</title>
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
	<br>
	<br>
	<br>
	<hr> <hr>
	<h1>Ma Loai: ${categoryId}</h1>
	<h2>List of Category:</h2>
	<c:url var="editImgUrl" value="/resources/img/edit.png" />
	<c:url var="deleteImgUrl" value="/resources/img/delete.png" />
	<c:url var="personUrl" value="/category/list" />
	<c:url var="addCcUrl" value="/room/showFormForAdd?categoryId=${category.maLoai}" />
	<div class="panel panel-primary" style="margin: 50px 10px 10px 10px;">
		<div class="panel-heading"
			style="background-color: black; font-size: 26px;">Phòng</div>
		<div class="panel-body col-md-12"
			style="border: 1px solid; border-radius: 0 0 10px 10px">
			<table class="table" style="font-size: 16px;">
				<thead>
					<tr>
						<th>CC Room</th>
						<th>CC Tình trạng</th>
						<th>CC Mô tả</th>
						<th colspan="3">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty rooms}">
						<c:forEach items="${rooms}" var="room">

							<tr>
								<td><c:out value="${room.maPhong}" /></td>
								<td><c:out value="${room.tinhTrang}" /></td>
								<td><c:out value="${room.moTa}" /></td>

								<c:url var="editCcUrl"
									value="/room/showFormForUpdate?categoryId=${category.maLoai}&roomId=${room.maPhong}" />
								<c:url var="deleteCcUrl"
									value="/room/delete?categoryId=${categoryId}&roomId=${room.maPhong}" />
								<td><a href="${editCcUrl}"><img src="${editImgUrl}" /></a></td>
								<td><a href="${deleteCcUrl}"><img src="${deleteImgUrl}" /></a></td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${empty category.dsPhong}">
						<tr>
							<td>N/A</td>
							<td>N/A</td>
							<c:url var="addCcUrl"
								value="/room/showFormForAdd?categoryId=${categoryId}" />
							<td><a href="${addCcUrl}">+</a></td>
							<td></td>
							<td></td>
						</tr>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
	<div style="font-size: 16px; margin: 20px 0 350px 0;">
		<p>
			<a href="${addCcUrl}">Add Room</a>
		</p>
		<p>
			<a href="${personUrl}">Category List</a>
		</p>
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
