<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

<head>
<title>Lập hóa đơn</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="./style.css" rel="stylesheet" />
<meta charset="utf-8">
<!-- <link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"> -->
<!-- <script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<style>
* {
	box-sizing: border-box;
}

#header {
	height: 100px;
	width: 100%;
}

body {
	font-family: "Raleway", sans-serif;
	background-image: url("./resources/img/background_ks3.png");
	background-repeat: no-repeat;
	background-size: 100% 800px;
}

#left_sidebar {
	float: left;
	width: 1000px;
	height: 700px;
	padding: 10px 10px 10px 10px;
}

#right_sidebar {
	float: right;
	width: 450px;
	height: 700px;
	margin-right: 20px;
	padding: 10px 10px 10px 10px;
}

.khach_hang {
	border-radius: 30px 30px 30px 30px;
	background: url("./resources/img/background_khach_hang.png");
	background-repeat: no-repeat;
	background-size: 1050px 400px;
	margin: 10px 0 10px 20px;
	padding: 20px;
	height: 200px;
}

.khach_hang p {
	font-size: 18px;
	color: #B8860B;
}

.khach_hang h1 {
	font-size: 30px;
	color: #191970;
}

.dich_vu {
	/* height: 250px; */
	border-radius: 30px 30px 30px 30px;
	background: url("./resources/img/background_phieu_dat.png");
	background-repeat: no-repeat;
	background-size: 1050px 600px;
	margin: 10px 0 20px 20px;
	padding: 20px;
	font-size: 18px;
}

.phieu_dat {
	font-size: 18px;
	border-radius: 30px 30px 30px 30px;
	height: 330px;
	background: url("./resources/img/background_phieu_dat.png");
	background-size: 800px 600px;
	background-repeat: no-repeat;
	margin: 10px 20px 10px 0;
	padding: 20px;
}

.lap_hoa_don {
	/* width: 700px; */
	border-radius: 30px 30px 30px 30px;
	height: 200px;
	background-size: 800px 200px;
	background-repeat: no-repeat;
	margin: 10px 20px 10px 0;
	padding: 20px;
}

.lap_hoa_don button {
	font-size: 20px;
	color: white;
	width: 300px;
	height: 60px;
	background-color: #B8860B;
	/* border: #B8860B solid 5px; */
	border-radius: 10px;
	margin: 20px 0 0 30px;
}

#product_items {
	max-height: 180px;
	overflow: scroll;
}

.list-items {
	max-height: 200px;
	overflow: scroll;
}

.items_dich_vu {
	background-color: #d3dce3;
}
</style>


<body>
	<div id="main_wrapper">
		<div id="main_content col-md-12">
			<div id="left_sidebar">
				<div class="col-md-12 khach_hang">
					<h1>Khach hang</h1>
					<br> <br>
					<form:form method="GET" action="#" modelAttribute="customer">
						<div class="col-md-6" style="float: left">
							<p style="text-align: left;">Mã khách hàng: ${customer.maKH}</p>
							<p style="text-align: left;">Tên khách hàng:
								${customer.tenKH}</p>
							<p style="text-align: left;">CMND: ${customer.cmnd}</p>
						</div>
						<div class="col-md-6" style="float: left;">
							<p>Số điện thoại: ${customer.soDienThoai}</p>
							<p>Email: ${customer.email}</p>
							<p>Địa chỉ: ${customer.diaChi}</p>
						</div>
					</form:form>
				</div>
				<h1>Dich Vu</h1>
				<div class="col-md-12 dich_vu">
					<table>
						<tr>
							<th>Mã dịch vụ</th>
							<th>Tên dịch vụ</th>
							<th>Đơn giá</th>
							<th>Tinh trang</th>
							<th></th>
						</tr>
						<!-- loop over and print our customers -->
						<c:forEach var="temp" items="${services}">
							<!-- construct an "update" link with customer id -->
							<c:url var="updateLink" value="/reservation/addChiTietDV">
								<c:param name="maDV" value="${temp.maDV}" />
								<c:param name="maPhieu" value="${maPhieu}" />
								<c:param name="roomId" value="${roomId}" />

							</c:url>
							<!-- construct an "delete" link with customer id -->
							<c:url var="deleteLink" value="/reservation/addChiTietDV">
								<c:param name="maDV" value="${temp.maDV}" />
							</c:url>

							<tr>
								<td>${temp.maDV}</td>
								<td>${temp.tenDV}</td>
								<td>${temp.donGia}</td>
								<td>${temp.tinhTrang}</td>
								<td>
									<!-- display the update link --> <a href="${updateLink}">Thêm</a>
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Xóa</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<p>Số lượng</p>
				<c:url var="a" value="/reservation/addChiTietDV" />
				<form:form method="GET" action="${a }" modelAttribute="ctdv">
					
				<form:input path="soLanSuDung" />
				<form:input type="text" path="dichVu.maDV"/>
					<input type="hidden" name="maPhieu" value="${maPhieu}" />
					<input type="hidden" name="roomId" value="${roomId}" />
					<input type="submit" value="SoLuong">
				</form:form>

				<h1>Thanh Toan</h1>
				<div class="col-md-12 dich_vu">
					<table>
						<tr>
							<th>Mã dịch vụ</th>
							<th>Tên dịch vụ</th>
							<th>Đơn giá</th>
							<th>Tinh trang</th>
							<th></th>
						</tr>
						<!-- loop over and print our customers -->
						<c:forEach var="temp" items="${servicedetails}">
							<!-- construct an "update" link with customer id -->
							<tr>
								<td>${temp.dichVu.maDV}</td>
								<td>${temp.dichVu.tenDV}</td>
								<td>${temp.dichVu.donGia}</td>
								<td>${temp.thanhTien}</td>
								<td>
									<!-- display the update link --> <a href="${updateLink}">Thêm</a>
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Xóa</a>
								</td>
							</tr>
						</c:forEach>

					</table>

				</div>
			</div>
			<div id="right_sidebar">
				<div class="phieu_dat col-md-12">
					<c:url var="link" value="/reservation/addChiTietDV2" />
					<form:form action="${link}" method="GET"
						modelAttribute="reservation">
						<h1>Phiếu đặt phòng</h1>
						<p>Mã phiếu: ${reservation.maPhieuDatPhong}</p>
						<input type="hidden" name="maPhieu"
							value="${reservation.maPhieuDatPhong}">
						<p>Ngày nhận: ${reservation.ngayNhanPhong}</p>
						<p>Ngày trả: ${reservation.ngayTraPhong}</p>
						<p>
							Tình trạng phiếu:
							<c:if test="${reservation.tinhTrangPhieuDat == 1}">
								<c:out value="Chưa Xác Nhận" />
							</c:if>
							<c:if test="${reservation.tinhTrangPhieuDat == 2}">
								<c:out value="Đã Xác Nhận" />
							</c:if>
							<c:if test="${reservation.tinhTrangPhieuDat == 3}">
								<c:out value="Đã Thanh Toán" />
							</c:if>
						</p>
						<p>Người lớn: ${reservation.soNguoiLon }</p>
						<p>Trẻ em: ${reservation.soTreEm }</p>
						<input type="submit" value="Gui" />
					</form:form>
				</div>

				<div class="lap_hoa_don col-md-12">
					<button>
						<b>Lập hóa đơn</b>
					</button>
				</div>
			</div>
			<div style="clear: both"></div>
		</div>
	</div>
	</style>
</body>



</html>