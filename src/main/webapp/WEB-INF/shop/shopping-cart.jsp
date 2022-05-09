<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="zxx">
  <head>
    <meta charset="UTF-8" />
    <meta name="description" content="Male_Fashion Template" />
    <meta name="keywords" content="Male_Fashion, unica, creative, html" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Male-Fashion | Template</title>

    <!-- Google Font -->
    <link
      href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
      rel="stylesheet"
    />

    <!-- Css Styles -->
    <link rel="stylesheet" href="shop/css/bootstrap.min.css" type="text/css" />
    <link rel="stylesheet" href="shop/css/font-awesome.min.css" type="text/css" />
    <link rel="stylesheet" href="shop/css/elegant-icons.css" type="text/css" />
    <link rel="stylesheet" href="shop/css/magnific-popup.css" type="text/css" />
    <link rel="stylesheet" href="shop/css/nice-select.css" type="text/css" />
    <link rel="stylesheet" href="shop/css/owl.carousel.min.css" type="text/css" />
    <link rel="stylesheet" href="shop/css/slicknav.min.css" type="text/css" />
    <link rel="stylesheet" href="shop/css/style.css" type="text/css" />
    <script src="https://kit.fontawesome.com/d219c09b4c.js" crossorigin="anonymous"></script>
    
  </head>

  <body>
    <!-- Page Preloder -->
    <div id="preloder">
      <div class="loader"></div>
    </div>
    <!-- Header Section Begin -->
    <c:import url="include/header.jsp" />
    <!-- Header Section End -->

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-option">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="breadcrumb__text">
              <h4>Shopping Cart</h4>
              <div class="breadcrumb__links">
                <a href="<c:out value="${context}/Home"/>">Home</a>
                <a href="<c:out value="${context}/Shop"/>">Shop</a>
                <span>Shopping Cart</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Shopping Cart Section Begin -->
    <section class="shopping-cart spad">
      <div class="container">
        <div class="row">
          <div class="col-lg-8">
            <div class="shopping__cart__table">
              <table>
                <thead>
                  <tr>
                    <th>Product</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>     
                <c:forEach var="tempBillDetail" items="${BILLDETAIL_LIST}">                         
                  <tr>
                    <td class="product__cart__item">
                      <div class="product__cart__item__pic">
                        <img src="<c:out value="${tempBillDetail.product.image}"/>" alt="" />
                      </div>
                      <div class="product__cart__item__text">
                        <h6><c:out value="${tempBillDetail.product.name}"/></h6>
                        <h5><c:out value="${tempBillDetail.price}"/>$</h5>
                      </div>
                    </td>
                    <td>
                       <div class="row flex-container">              
                        	<div class="flex-item" >
	                        	<form method="post">
	                        		<input type="hidden" value="<c:out value="${tempBillDetail.bill.id}"/>" name="billId">
	                        		<input type="hidden" value="<c:out value="${tempBillDetail.product.id}"/>" name="productId">
	                        		<input type="hidden" value="<c:out value="${tempBillDetail.productQuantity - 1}"/>" name="quantity">
	                        		<button  class="center btn btn-light"  type="submit"><i class="fa-solid fa-angle-left fa-2xs"></i></button>
	                        	</form>
                        	</div>
                        	<div class="flex-item ">
                        		<h5 class="center"><c:out value="${tempBillDetail.productQuantity}"/></h5>
                        	</div>
                        	<div class="flex-item " >
	                        	<form method="post" >
	                        		<input type="hidden" value="<c:out value="${tempBillDetail.bill.id}"/>" name="billId">
	                        		<input type="hidden" value="<c:out value="${tempBillDetail.product.id}"/>" name="productId">
	                        		<input type="hidden" value="<c:out value="${tempBillDetail.productQuantity + 1}"/>" name="quantity">
	                        		<button class="center btn btn-light" type="submit"><i class="fa-solid fa-angle-right fa-2xs"></i></button>
	                        	</form>                        	                                         
                      		</div>
                      </div>
                    </td>
                    <td class="cart__price"><c:out value="${tempBillDetail.price*tempBillDetail.productQuantity}"/>$</td>
                    <td class="cart__close">
                    <a href="<c:out value="${context}/Shoppingcart?removeID=${tempBillDetail.product.id}"/>"><i class="fa fa-close"></i></a>
                    </td>
                  </tr>
                 </c:forEach>     
                </tbody>
              </table>
            </div>
            <div class="row">
              <div class="col-lg-6 col-md-6 col-sm-6">
                <div class="continue__btn">
                  <a href="#">Continue Shopping</a>
                </div>
              </div>            
            </div>
          </div>
          <div class="col-lg-4">
            <div class="cart__total">
              <h6>Cart total</h6>
              <ul>
                <li>Total <span><c:out value="${TOTAL}"/>$</span></li>
              </ul>
              <a href="<c:out value="${context}/Checkout"/>" class="primary-btn">Proceed to checkout</a>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Shopping Cart Section End -->

   <c:import url="include/footer.jsp" />

    <!-- Search Begin -->
    <div class="search-model">
      <div class="h-100 d-flex align-items-center justify-content-center">
        <div class="search-close-switch">+</div>
        <form class="search-model-form">
          <input type="text" id="search-input" placeholder="Search here....." />
        </form>
      </div>
    </div>
    <!-- Search End -->

    <!-- Js Plugins -->
    <script src="shop/js/jquery-3.3.1.min.js"></script>
    <script src="shop/js/bootstrap.min.js"></script>
    <script src="shop/js/jquery.nice-select.min.js"></script>
    <script src="shop/js/jquery.nicescroll.min.js"></script>
    <script src="shop/js/jquery.magnific-popup.min.js"></script>
    <script src="shop/js/jquery.countdown.min.js"></script>
    <script src="shop/js/jquery.slicknav.js"></script>
    <script src="shop/js/mixitup.min.js"></script>
    <script src="shop/js/owl.carousel.min.js"></script>
    <script src="shop/js/main.js"></script>
  </body>
</html>
