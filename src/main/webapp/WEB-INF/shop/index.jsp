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

    <!-- Hero Section Begin -->
    <section class="hero">
      <div class="hero__slider owl-carousel">
        <div class="hero__items set-bg" data-setbg="shop/img/hero/hero-1.jpg">
          <div class="container">
            <div class="row">
              <div class="col-xl-5 col-lg-7 col-md-8">
                <div class="hero__text">
                  <h6>Summer Collection</h6>
                  <h2>Fall - Winter Collections 2030</h2>
                  <p>
                    A specialist label creating luxury essentials. Ethically
                    crafted with an unwavering commitment to exceptional
                    quality.
                  </p>
                  <a href="<c:out value="${context}/Shop"/>" class="primary-btn"
                    >Shop now <span class="arrow_right"></span
                  ></a>

                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="hero__items set-bg" data-setbg="shop/img/hero/hero-2.jpg">
          <div class="container">
            <div class="row">
              <div class="col-xl-5 col-lg-7 col-md-8">
                <div class="hero__text">
                  <h6>Summer Collection</h6>
                  <h2>Fall - Winter Collections 2030</h2>
                  <p>
                    A specialist label creating luxury essentials. Ethically
                    crafted with an unwavering commitment to exceptional
                    quality.
                  </p>
                  <a href="<c:out value="${context}/Shop"/>" class="primary-btn"
                    >Shop now <span class="arrow_right"></span
                  ></a>
                  <div class="hero__social">
                    <a href="#"><i class="fa fa-facebook"></i></a>
                    <a href="#"><i class="fa fa-twitter"></i></a>
                    <a href="#"><i class="fa fa-pinterest"></i></a>
                    <a href="#"><i class="fa fa-instagram"></i></a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Hero Section End -->

    <!-- Banner Section Begin -->
    <section class="banner spad">
      <div class="container">
        <div class="row">
          <div class="col-lg-7 offset-lg-4">
            <div class="banner__item">
              <div class="banner__item__pic">
                <img src="shop/img/banner/banner-1.jpg" alt="" />
              </div>
              <div class="banner__item__text">
                <h2>Clothing Collections 2030</h2>
                <a href="<c:out value="${context}/Shop"/>">Shop now</a>
              </div>
            </div>
          </div>
          <div class="col-lg-5">
            <div class="banner__item banner__item--middle">
              <div class="banner__item__pic">
                <img src="shop/img/banner/banner-2.jpg" alt="" />
              </div>
              <div class="banner__item__text">
                <h2>Accessories</h2>
                <a href="<c:out value="${context}/Shop"/>">Shop now</a>
              </div>
            </div>
          </div>
          <div class="col-lg-7">
            <div class="banner__item banner__item--last">
              <div class="banner__item__pic">
                <img src="shop/img/banner/banner-3.jpg" alt="" />
              </div>
              <div class="banner__item__text">
                <h2>Shoes Spring 2030</h2>
                <a href="<c:out value="${context}/Shop"/>">Shop now</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Banner Section End -->

    <!-- Product Section Begin -->

    <!-- Categories Section Begin -->
    <section class="categories spad">
      <div class="container">
        <div class="row">
          <div class="col-lg-3">
            <div class="categories__text">
              <h2>
                Clothings Hot <br />
                <span>Shoe Collection</span> <br />
                Accessories
              </h2>
            </div>
          </div>
          <div class="col-lg-4">
            <div class="categories__hot__deal">
              <img src="shop/img/product-sale.png" alt="" />
              <div class="hot__deal__sticker">
                <span>Sale Of</span>
                <h5>$29.99</h5>
              </div>
            </div>
          </div>
          <div class="col-lg-4 offset-lg-1">
            <div class="categories__deal__countdown">
              <span>Deal Of The Week</span>
              <h2>Multi-pocket Chest Bag Black</h2>
              <div class="categories__deal__countdown__timer" id="countdown">
                <div class="cd-item">
                  <span>3</span>
                  <p>Days</p>
                </div>
                <div class="cd-item">
                  <span>1</span>
                  <p>Hours</p>
                </div>
                <div class="cd-item">
                  <span>50</span>
                  <p>Minutes</p>
                </div>
                <div class="cd-item">
                  <span>18</span>
                  <p>Seconds</p>
                </div>
              </div>
              <a href="<c:out value="${context}/Shop"/>" class="primary-btn">Shop now</a>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Categories Section End -->

    <!-- Instagram Section Begin -->
    <section class="instagram spad">
      <div class="container">
        <div class="row">
          <div class="col-lg-8">
            <div class="instagram__pic">
              <div
                class="instagram__pic__item set-bg"
                data-setbg="shop/img/instagram/instagram-1.jpg"
              ></div>
              <div
                class="instagram__pic__item set-bg"
                data-setbg="shop/img/instagram/instagram-2.jpg"
              ></div>
              <div
                class="instagram__pic__item set-bg"
                data-setbg="shop/img/instagram/instagram-3.jpg"
              ></div>
              <div
                class="instagram__pic__item set-bg"
                data-setbg="shop/img/instagram/instagram-4.jpg"
              ></div>
              <div
                class="instagram__pic__item set-bg"
                data-setbg="shop/img/instagram/instagram-5.jpg"
              ></div>
              <div
                class="instagram__pic__item set-bg"
                data-setbg="shop/img/instagram/instagram-6.jpg"
              ></div>
            </div>
          </div>
          <div class="col-lg-4">
            <div class="instagram__text">
              <h2>Instagram</h2>
              <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
                eiusmod tempor incididunt ut labore et dolore magna aliqua.
              </p>
              <h3>#Male_Fashion</h3>
            </div>
          </div>
        </div>
      </div>
    </section>
    <br>
    <br>
    <!-- Instagram Section End -->
    <!-- Footer Section Begin -->
  	<c:import url="include/footer.jsp" />
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
