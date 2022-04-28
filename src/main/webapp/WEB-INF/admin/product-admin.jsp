<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Shopping App | Product</title>

  	<!-- link -->
	<c:import url="include/link.jsp" />  
  </head>
  <body class="hold-transition sidebar-mini">
    <div class="wrapper">
      

      <!-- /.navbar -->
      <c:import url="include/nav-bar.jsp" /> 
      <!-- Main Sidebar Container -->
	  <c:import url="include/side-bar.jsp" />
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <div class="container-fluid">
            <div class="row mb-2">
              <div class="col-sm-6">
                <h1>Product</h1>
              </div>
              <div class="col-sm-6">
                <ol class="breadcrumb float-sm-right">
                  <li class="breadcrumb-item"><a href="#">Home</a></li>
                  <li class="breadcrumb-item active">DataTables</li>
                </ol>
              </div>
            </div>
          </div>
          <!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
          <div class="container-fluid">
            <div class="row">
              <div class="col-12">
                <div class="card">
                  <div class="card-header">
                    <h3 class="card-title">
                      <button
                        type="button"
                        class="btn btn-block btn-outline-primary btn-sm"
                      >
                        <a href="<c:out value="${pageContext.request.contextPath}/AddProduct"/>">Add Product</a>
                      </button>
                    </h3>
                  </div>
                  <!-- /.card-header -->
                  <div class="card-body">
                    <table
                      id="example2"
                      class="table table-bordered table-hover"
                    >
                      <thead>
                        <tr>

                          <th>Name</th>
                          <th>Price</th>
                          <th>Image</th>
                          <th>Category</th>
                          <th></th>
                        </tr>
                      </thead>
                      <tbody>
                      <c:forEach var="tempProduct" items="${PRODUCT_LIST}">
                        <tr>

                          <td><c:out value="${tempProduct.name}"/></td>
                          <td><c:out value="${tempProduct.price}"/></td>
                          <td><c:out value="${tempProduct.image}"/></td>
                          <td><c:out value="${tempProduct.category.name}"/></td>
                          <td>
                            
                            <a class="btn btn-block bg-gradient-warning btn-sm" href="<c:out value="${pageContext.request.contextPath}/AddProduct?ID=${tempProduct.id}"/>"><i class="fa-solid fa-pen-to-square"></i></a>
                           
                            <a class="btn btn-block bg-gradient-danger btn-sm" href="<c:out value="${pageContext.request.contextPath}/DeleteProduct?ID=${tempProduct.id}"/>" ><i class="fa-solid fa-trash-can"></i></a>
                          </td>
                        </tr>
                        </c:forEach>
                      </tbody>
                     
                    </table>
                  </div>
                  <!-- /.card-body -->
                </div>
                <!-- /.card -->
              </div>
              <!-- /.col -->
            </div>
            <!-- /.row -->
          </div>
          <!-- /.container-fluid -->
        </section>
        <!-- /.content -->
      </div>
      <!-- /.content-wrapper -->
     <!-- footer -->
     <c:import url="include/footer.jsp" />
  </body>
</html>
