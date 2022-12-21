<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Service</title>
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


	<c:url var="editImgUrl" value="/resources/img/edit.png" />
	<c:url var="deleteImgUrl" value="/resources/img/delete.png" />
	<c:url var="viewImgUrl" value="/resources/img/eye.png" />
	<c:url var="addUrl" value="/service/showFormForAdd" />
	<c:url var="viewUrl" value="/room/list" />
	<c:url var="Url" value="/person/search" />
	<div style="font-size: 16px; margin: 100px 10px 10px 10px">
		<form:form action="${Url}" method="GET">
            Search Service: <input type="text" name="theSearchName" />
		</form:form>
	</div>

	<div class="panel panel-primary" style="margin: 10px">
		<div class="panel-heading"
			style="background-color: black; font-size: 26px;">Dịch vụ</div>
		<div class="panel-body col-md-12"
			style="border: 1px solid; border-radius: 0 0 10px 10px">
			<table class="table" style="font-size: 16px;">
				<thead>
					<tr>
						<th>Mã Dịch Vụ</th>
						<th><a href="${sortLinkFirstName}">Tên Dịch Vụ</a></th>
						<th><a href="${sortLinkMoney}">Đơn giá</a></th>
						<th><a href="${sortLinkMoney}">Tình trang</a></th>
						<th colspan="2"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${services}" var="service">
						<c:url var="editUrl" value="/service/showFormForUpdate">
							<c:param name="serviceId" value="${service.maDV}" />
						</c:url>
						<!-- construct an "delete" link with customer id -->
						<c:url var="deleteUrl" value="/service/delete">
							<c:param name="serviceId" value="${service.maDV}" />
						</c:url>
						<tr>
							<td><c:out value="${service.maDV}" /></td>
							<td><c:out value="${service.tenDV}" /></td>
							<td><c:out value="${service.donGia}" /></td>
							<td><c:out value="${service.tinhTrang}" /></td>

							<td><a href="${editUrl}"><img src="${editImgUrl}" /> </a></td>
							<td><a href="${deleteUrl}"><img src="${deleteImgUrl}" /></a></td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<c:if test="${empty services}">
            No records found. 
        </c:if>
	<div style="font-size: 16px; margin: 20px 0 350px 0">
		<p>
			<a href="${addUrl}">Create new record</a>
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
