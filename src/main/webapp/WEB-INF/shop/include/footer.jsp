<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:set var="context" value="${pageContext.request.contextPath}" />
 <!-- Footer Section Begin -->
    <footer class="footer">
      <div class="container">
        <div class="row">
          <div class="col-lg-3 col-md-6 col-sm-6">
            <div class="footer__about">
              <div class="footer__logo">
                <a href="#"><img src="shop/img/footer-logo.png" alt="" /></a>
              </div>
              <p>
                The customer is at the heart of our unique business model, which
                includes design.
              </p>
            </div>
          </div>
          <div class="col-lg-2 offset-lg-1 col-md-3 col-sm-6">
            <div class="footer__widget">
              <h6>Shopping</h6>
              <ul>
                <li><a href="<c:out value="${context}/Shop"/>">Clothing Store</a></li>
                <li><a href="<c:out value="${context}/Shop"/>">Trending Shoes</a></li>
                <li><a href="<c:out value="${context}/Shop"/>">Accessories</a></li>
              </ul>
            </div>
          </div>
          <div class="col-lg-2 col-md-3 col-sm-6">
            <div class="footer__widget">
              <h6>Shopping</h6>
              <ul>
                <li><a href="<c:out value="${context}/Contact"/>">Contact Us</a></li>

              </ul>
            </div>
          </div>
          <div class="col-lg-3 offset-lg-1 col-md-6 col-sm-6">
            <div class="footer__widget">
              <h6>NewLetter</h6>
              <div class="footer__newslatter">
                <p>
                  Be the first to know about new arrivals, look books, sales &
                  promos!
                </p>                
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-12 text-center">
            <div class="footer__copyright__text">
              <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
              <p>
                Copyright ©
                <script>
                  document.write(new Date().getFullYear());
                </script>
                2020 All rights reserved 
              </p>
              <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            </div>
          </div>
        </div>
      </div>
    </footer>
    <!-- Footer Section End -->
