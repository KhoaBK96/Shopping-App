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

    <!-- Offcanvas Menu Begin -->
   
    <!-- Offcanvas Menu End -->

    <!-- Header Section Begin -->
	<c:import url="include/header.jsp" />
    <!-- Header Section End -->

    <!-- Map Begin -->
    <div class="map">
      <iframe
        src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d111551.9926412813!2d-90.27317134641879!3d38.606612219170856!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x54eab584e432360b%3A0x1c3bb99243deb742!2sUnited%20States!5e0!3m2!1sen!2sbd!4v1597926938024!5m2!1sen!2sbd"
        height="500"
        style="border: 0"
        allowfullscreen=""
        aria-hidden="false"
        tabindex="0"
      ></iframe>
    </div>
    <!-- Map End -->

    <!-- Contact Section Begin -->
    <section class="contact spad">
      <div class="container">
        <div class="row">
          <div class="col-lg-6 col-md-6">
            <div class="contact__text">
              <div class="section-title">
                <span>Information</span>
                <h2>Contact Us</h2>
                <p>
                  As you might expect of a company that began as a high-end
                  interiors contractor, we pay strict attention.
                </p>
              </div>
              <ul>
                <li>
                  <h4>America</h4>
                  <p>
                    195 E Parker Square Dr, Parker, CO 801 <br />+43
                    982-314-0958
                  </p>
                </li>
                <li>
                  <h4>France</h4>
                  <p>
                    109 Avenue Léon, 63 Clermont-Ferrand <br />+12 345-423-9893
                  </p>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Contact Section End -->

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
