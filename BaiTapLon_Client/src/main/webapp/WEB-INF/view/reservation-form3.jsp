<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thanks</title>
</head>
<style>
    body {
        background-image: url("/background_cam_on.jpg");
        background-repeat: no-repeat;
        background-size: 100% 100%;
    }

    .cam_on {
        margin: 250px 30px 300px 600px;
        font-size: 30px;
        color: #bababa;
        text-align: center;
        background-image: url("/resources/img/cover.png");
    }
</style>

<body>
	<c:url var="editImgUrl" value="/resources/img/background_cam_on.png" />
    <div class="cam_on" >
        <h1>Cảm ơn bạn đã đặt phòng tại</h1>
        <h1>TCD hotel</h1>
    </div>


</body>

</html>