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
  </head>

  <body>
    <!-- Page Preloder -->
    <div id="preloder">
      <div class="loader"></div>
    </div>

    <!-- Header Section Begin -->
	<c:import url="include/header.jsp" />
    <!-- Header Section End -->

    <!-- Shop Details Section Begin -->
    <section class="shop-details">
      <div class="product__details__pic">
        <div class="container">
          <div class="row">
            <div class="col-lg-12">
              <div class="product__details__breadcrumb">
                <a href="<c:out value="${context}/Home"/>">Home</a>
                <a href="<c:out value="${context}/Shop"/>">Shop</a>
                <span>Product Details</span>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-lg-3 col-md-3"></div>
            <div class="col-lg-6 col-md-9">
              <div class="tab-content">
                <div class="tab-pane active" id="tabs-1" role="tabpanel">
                  <div class="product__details__pic__item">
                    <img src="<c:out value="${PRODUCT.image}"/>" alt="" />
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="product__details__content">
        <div class="container">
          <div class="row d-flex justify-content-center">
            <div class="col-lg-8">
              <div class="product__details__text">
                <h4><c:out value="${PRODUCT.name}"/></h4>
                <div class="rating">
                  <i class="fa fa-star"></i>
                  <i class="fa fa-star"></i>
                  <i class="fa fa-star"></i>
                  <i class="fa fa-star"></i>
                  <i class="fa fa-star-o"></i>
                  <span> - 5 Reviews</span>
                </div>
                <h3><c:out value="${PRODUCT.price}"/>$</h3>
                <p>
                  Coat with quilted lining and an adjustable hood. Featuring
                  long sleeves with adjustable cuff tabs, adjustable asymmetric
                  hem with elastic side tabs and a front zip fastening with
                  placket.
                </p>

                <div class="product__details__cart__option">
                  <a href="<c:out value="${context}/Shop/Cart?addtocartID=${PRODUCT.id}"/>" class="primary-btn">add to cart</a>
                </div>
                <div class="product__details__last__option">
                  <h5><span>Guaranteed Safe Checkout</span></h5>
                  <img src="shop/img/shop-details/details-payment.png" alt="" />
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-lg-12">
              <div class="product__details__tab">
                <ul class="nav nav-tabs" role="tablist">
                  <li class="nav-item">
                    <a
                      class="nav-link active"
                      data-toggle="tab"
                      href="#tabs-5"
                      role="tab"
                      >Description</a
                    >
                  </li>
                  <li class="nav-item">
                    <a
                      class="nav-link"
                      data-toggle="tab"
                      href="#tabs-6"
                      role="tab"
                      >Customer Previews(5)</a
                    >
                  </li>
                  <li class="nav-item">
                    <a
                      class="nav-link"
                      data-toggle="tab"
                      href="#tabs-7"
                      role="tab"
                      >Additional information</a
                    >
                  </li>
                </ul>
                <div class="tab-content">
                  <div class="tab-pane active" id="tabs-5" role="tabpanel">
                    <div class="product__details__tab__content">
                      <p class="note">
                        Nam tempus turpis at metus scelerisque placerat nulla
                        deumantos solicitud felis. Pellentesque diam dolor,
                        elementum etos lobortis des mollis ut risus. Sedcus
                        faucibus an sullamcorper mattis drostique des commodo
                        pharetras loremos.
                      </p>
                      <div class="product__details__tab__content__item">
                        <h5>Products Infomation</h5>
                        <p>
                          A Pocket PC is a handheld computer, which features
                          many of the same capabilities as a modern PC. These
                          handy little devices allow individuals to retrieve and
                          store e-mail messages, create a contact file,
                          coordinate appointments, surf the internet, exchange
                          text messages and more. Every product that is labeled
                          as a Pocket PC must be accompanied with specific
                          software to operate the unit and must feature a
                          touchscreen and touchpad.
                        </p>
                        <p>
                          As is the case with any new technology product, the
                          cost of a Pocket PC was substantial during it’s early
                          release. For approximately $700.00, consumers could
                          purchase one of top-of-the-line Pocket PCs in 2003.
                          These days, customers are finding that prices have
                          become much more reasonable now that the newness is
                          wearing off. For approximately $350.00, a new Pocket
                          PC can now be purchased.
                        </p>
                      </div>
                      <div class="product__details__tab__content__item">
                        <h5>Material used</h5>
                        <p>
                          Polyester is deemed lower quality due to its none
                          natural quality’s. Made from synthetic materials, not
                          natural like wool. Polyester suits become creased
                          easily and are known for not being breathable.
                          Polyester suits tend to have a shine to them compared
                          to wool and cotton suits, this can make the suit look
                          cheap. The texture of velvet is luxurious and
                          breathable. Velvet is a great choice for dinner party
                          jacket and can be worn all year round.
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="tab-pane" id="tabs-6" role="tabpanel">
                    <div class="product__details__tab__content">
                      <div class="product__details__tab__content__item">
                        <h5>Products Infomation</h5>
                        <p>
                          A Pocket PC is a handheld computer, which features
                          many of the same capabilities as a modern PC. These
                          handy little devices allow individuals to retrieve and
                          store e-mail messages, create a contact file,
                          coordinate appointments, surf the internet, exchange
                          text messages and more. Every product that is labeled
                          as a Pocket PC must be accompanied with specific
                          software to operate the unit and must feature a
                          touchscreen and touchpad.
                        </p>
                        <p>
                          As is the case with any new technology product, the
                          cost of a Pocket PC was substantial during it’s early
                          release. For approximately $700.00, consumers could
                          purchase one of top-of-the-line Pocket PCs in 2003.
                          These days, customers are finding that prices have
                          become much more reasonable now that the newness is
                          wearing off. For approximately $350.00, a new Pocket
                          PC can now be purchased.
                        </p>
                      </div>
                      <div class="product__details__tab__content__item">
                        <h5>Material used</h5>
                        <p>
                          Polyester is deemed lower quality due to its none
                          natural quality’s. Made from synthetic materials, not
                          natural like wool. Polyester suits become creased
                          easily and are known for not being breathable.
                          Polyester suits tend to have a shine to them compared
                          to wool and cotton suits, this can make the suit look
                          cheap. The texture of velvet is luxurious and
                          breathable. Velvet is a great choice for dinner party
                          jacket and can be worn all year round.
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="tab-pane" id="tabs-7" role="tabpanel">
                    <div class="product__details__tab__content">
                      <p class="note">
                        Nam tempus turpis at metus scelerisque placerat nulla
                        deumantos solicitud felis. Pellentesque diam dolor,
                        elementum etos lobortis des mollis ut risus. Sedcus
                        faucibus an sullamcorper mattis drostique des commodo
                        pharetras loremos.
                      </p>
                      <div class="product__details__tab__content__item">
                        <h5>Products Infomation</h5>
                        <p>
                          A Pocket PC is a handheld computer, which features
                          many of the same capabilities as a modern PC. These
                          handy little devices allow individuals to retrieve and
                          store e-mail messages, create a contact file,
                          coordinate appointments, surf the internet, exchange
                          text messages and more. Every product that is labeled
                          as a Pocket PC must be accompanied with specific
                          software to operate the unit and must feature a
                          touchscreen and touchpad.
                        </p>
                        <p>
                          As is the case with any new technology product, the
                          cost of a Pocket PC was substantial during it’s early
                          release. For approximately $700.00, consumers could
                          purchase one of top-of-the-line Pocket PCs in 2003.
                          These days, customers are finding that prices have
                          become much more reasonable now that the newness is
                          wearing off. For approximately $350.00, a new Pocket
                          PC can now be purchased.
                        </p>
                      </div>
                      <div class="product__details__tab__content__item">
                        <h5>Material used</h5>
                        <p>
                          Polyester is deemed lower quality due to its none
                          natural quality’s. Made from synthetic materials, not
                          natural like wool. Polyester suits become creased
                          easily and are known for not being breathable.
                          Polyester suits tend to have a shine to them compared
                          to wool and cotton suits, this can make the suit look
                          cheap. The texture of velvet is luxurious and
                          breathable. Velvet is a great choice for dinner party
                          jacket and can be worn all year round.
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Shop Details Section End -->

    <!-- Footer Section Begin -->
	<c:import url="include/footer.jsp" />
    <!-- Footer Section End -->

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
