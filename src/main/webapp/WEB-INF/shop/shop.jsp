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
    <!-- header -->
    <c:import url="include/header.jsp" />
  </head>

  <body>
    <!-- Page Preloder -->
    <div id="preloder">
      <div class="loader"></div>
    </div>
    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-option">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="breadcrumb__text">
              <h4>Shop</h4>
              <div class="breadcrumb__links">
                <a href="<c:out value="${context}/Home"/>">Home</a>
                <span>Shop</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Shop Section Begin -->
    <section class="shop spad">
      <div class="container">
        <div class="row">
          <div class="col-lg-3">
            <div class="shop__sidebar">
              <div class="shop__sidebar__search">
                <form action="#" method="get" id="searchForm" >
                  	
                  <input type="text" placeholder="Search..." name="productSearch" id="search" />
                  <button type="submit">
             									    <!-- complete search -->
                    <span class="icon_search"></span>
                  </button>
                </form>
              </div>
              <div class="shop__sidebar__accordion">
                <div class="accordion" id="accordionExample">
                  <div class="card">
                    <div class="card-heading">
                      <a data-toggle="collapse" data-target="#collapseOne"
                        >Categories</a
                      >
                    </div>
                    <div
                      id="collapseOne"
                      class="collapse show"
                      data-parent="#accordionExample"
                    >
                      <div class="card-body">
                        <div class="shop__sidebar__categories">
                          <ul class="nice-scroll">
                          <c:forEach var="tempCategory" items="${CATEGORY_LIST}">
                            <li><a href="<c:out value="${context}/Shop?categoryID=${tempCategory.id}"/>"><c:out value="${tempCategory.name}"/></a></li>
                          </c:forEach>
                          </ul>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-9">
            <div class="shop__product__option">
              <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                  <div class="shop__product__option__left">
                    <p>Showing 1–12 of 126 results</p>
                  </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                  <div class="shop__product__option__right">
                    <p>Sort by Price:</p>
                    
                    <select name="orderby" onchange="location = this.value;" id="sortType">
                      <option id="sort" value="<c:out value="${context}/Shop?orderby=asc"/>">Low To High</option>
                      <option id="sort" value="<c:out value="${context}/Shop?orderby=desc"/>">High To Low</option>                      
                    </select>
                    
                  </div>
                </div>
              </div>
            </div>
          		<div class="row">
          		<c:forEach var="tempProduct" items="${PRODUCT_LIST}">
	            	
		              <div class="col-lg-4 col-md-6 col-sm-6">
		                <div class="product__item">
		                  <div
		                    class="product__item__pic set-bg"
		                    data-setbg="<c:out value="${tempProduct.image}"/>"
		                  >       
		                  <ul class="product__hover">                           
                                <li><a href="<c:out value="${context}/ProductDetail?productID=${tempProduct.id}"/>"><img src="shop/img/icon/search.png" alt=""></a></li>
                            </ul>           
		                  </div>
		                  <div class="product__item__text">
		                    <h6><c:out value="${tempProduct.name}"/></h6>
		                    <a   href="<c:out value="${context}/Shop/Cart?addtocartID=${tempProduct.id}"/>" class="add-cart" >+ Add To Cart</a>		                
		                    <h5><c:out value="${tempProduct.price}"/>$</h5>                  
		                  </div>
		                </div>	   
		               </div>            
           		 </c:forEach>
           		 </div>
            <div class="row">
              <div class="col-lg-12">
                <div class="product__pagination">               	
	                <c:forEach var="tempPage" items="${PAGE_LIST}">
	                  <a href="<c:out value="${pageURL}?page=${tempPage.pageNumber}"/>"><c:out value="${tempPage.pageNumber}"/></a>
	                 </c:forEach> 
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Shop Section End -->
	<!-- footer -->
   	<c:import url="include/footer.jsp" />
    <!-- Search Begin -->
    <div class="search-model">
      <div class="h-100 d-flex align-items-center justify-content-center">
        <div class="search-close-switch">+</div>
        <form class="search-model-form">
          <input type="text" id="search-input" placeholder="Search here....." />
        </form>
        
        <form style="display:hidden">
        	<input class="hiddenData" type="hidden" name="categoryId" value="<c:out value="${SHOPDTO.categoryId}"/>"/>
        	<input class="hiddenData" type="hidden" name="sortType" value="<c:out value="${SHOPDTO.sortType}"/>"/>
        	<input class="hiddenData" type="hidden" name="page" value="<c:out value="${SHOPDTO.page}"/>"/>
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
  	<script src="shop/js/url.js"></script>
 
  </body>
</html>
