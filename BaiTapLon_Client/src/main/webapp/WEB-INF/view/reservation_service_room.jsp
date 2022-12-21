<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container" style="margin: 15px 0px 0px 0px;">
		<div class="row">
			<div class="col-md-5">
				<table class="table table-hover table-bordered">
					<thead>
						<tr>
							<th>STT</th>
							<th>Image</th>
							<th>Title</th>
							<th>Number</th>
							<th>Price</th>
							<th>Total Price</th>
						</tr>
					</thead>
					<tbody id="cardList">

					</tbody>
				</table>
			</div>
			<div class="col-md-7">
				<div class="row" id="product_items"></div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
       $(document).ready(function(){ var dataList = [{
            'thumbnail': 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVsE20sijJHnIZl14WDHGhV6QNrXPiRZPw-A&usqp=CAU',
            'title': 'Boba Pop',
            'price': '10000'
        }, {
            'thumbnail': 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLW5NJrKKGLiA8s-7oXFAeCsX1z6UXZMEzqQ&usqp=CAU',
            'title': 'Tra Hong',
            'price': '20000'
        }, {
            'thumbnail': 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpt4wqQP0wVcap8QW4v67GYOIRDqmSKyWsnQ&usqp=CAU',
            'title': 'Tra sua O Long',
            'price': '30000'
        }, {
            'thumbnail': 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ2nrSYMAtDmp7Mequ9xeOqDgOpxhI_YYlp9w&usqp=CAU',
            'title': 'Tra sua Khong Ten',
            'price': '40000'
        }, {
            'thumbnail': 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7YPYNJP-nSOs4_TWANIdW-U6q5VjSTPJFtQ&usqp=CAU',
            'title': 'Chuck Chuck',
            'price': '50000'
        }, {
            'thumbnail': 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVsE20sijJHnIZl14WDHGhV6QNrXPiRZPw-A&usqp=CAU',
            'title': 'Boba Pop',
            'price': '60000'
        }, {
            'thumbnail': 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRwbR1YL8GtMXF9BohMvK5oj04WXOPmAcZQjQ&usqp=CAU',
            'title': 'ABC XYZ',
            'price': '80000'
        }, {
            'thumbnail': 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROYtLhP10E7w1p-hGhYZYt-kiGevXloqF9OA&usqp=CAU',
            'title': 'LALA MEoMEo',
            'price': '90000'
        }]

        var cardItems = []

        $(function () {
            loadData()
        })

        function loadData() {
            for (var i = 0; i < dataList.length; i++) {
                $('#product_items').append(`
                <div class="col-md-3" onclick=clickItem(${i}) style="cursor:pointer">
                    <img src="${dataList[i].thumbnail}" alt="hinhanh" width="100%">
                        <p style="text-align: center;">$.dataList[i].title</p>
                        <p style="text-align: center;">"${dataList[i].price}"</p>
                </div>`)
            }
        }

        function clickItem(index) {
            console.log(index); 
            if (cardItems[index] == undefined) {
                cardItems[index] = {
                    'thumbnail': dataList[index].thumbnail,
                    'title': dataList[index].title,
                    'price': dataList[index].price,
                    'number': 1
                }
            } else {
                cardItems[index].number++
            }
            $('#cardList').empty()
            var count = 0;
            for (let i = 0; i < cardItems.length; i++) {
                product = cardItems[i];
                if(product === undefined) continue;
                $('#cardList').append(`
                        <tr>
                            <td>count++</td>
                            <td><img src="${product.thumbnail}" alt="anh" width="60px"></td>
                            <td>${product.title}</td>
                            <td>${product.number}</td>
                            <td>${product.price}</td>
                            <td>${product.price * product.number}</td>
                        </tr>`)
            }

        }});
    </script>

</body>
</html>