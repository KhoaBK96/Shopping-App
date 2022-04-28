<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>AdminLTE 3 | General Form Elements</title>

    <!-- Google Font: Source Sans Pro -->
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback"
    />
    <!-- Font Awesome -->
    <link
      rel="stylesheet"
      href="admin/plugins/fontawesome-free/css/all.min.css"
    />
    <!-- Theme style -->
    <link rel="stylesheet" href="admin/css/adminlte.min.css" />
  </head>
  <body class="hold-transition sidebar-mini">
    <div class="wrapper">
      <!-- Main Sidebar Container -->
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
                <h1>Add & Update Bill</h1>
              </div>
              <div class="col-sm-6">
                <ol class="breadcrumb float-sm-right">
                  <li class="breadcrumb-item"><a href="<c:out value="${pageContext.request.contextPath}/BillList"/>">Home</a></li>
                  <li class="breadcrumb-item active">General Form</li>
                </ol>U
              </div>
            </div>
          </div>
          <!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
          <div class="container-fluid">
            <div class="row">
              <!-- left column -->
              <div class="col-md-6">
                <!-- general form elements -->
                <div class="card card-primary">
                  <div class="card-header">
                    <h3 class="card-title">Quick Example</h3>
                  </div>
                  <!-- /.card-header -->
                  <!-- form start -->
                  <form method="post">
                    <div class="card-body">
                      <input type="hidden" value="<c:out value="${UPDATE_BILL.id}"/>" name="id">
                       <div class="form-group">
						  <label>User</label>
						  <select class="form-control" name="userId">
						  	<c:forEach var="tempUser" items="${USER_LIST}">
						    	<option value="<c:out value="${tempUser.id}"/>" <c:if test = "${UPDATE_BILL.user.id == tempUser.id}">selected</c:if> ><c:out value="${tempUser.name}"/></option>
						    </c:forEach>
						  </select>
					  </div>  
                      <div class="form-group">
                        <label for="date">Date</label>
                        <input
                          type="date"
                          class="form-control"
                          id="exampleInputEmail1"
                          name="date"
                          value="<c:out value="${UPDATE_BILL.date}"/>"
                        />
                      </div>
                    </div>
                    <!-- /.card-body -->

                    <div class="card-footer">
                      <button type="submit" class="btn btn-primary">
                        Submit
                      </button>
                    </div>
                  </form>
                </div>
                <!-- /.card -->

              <!--/.col (right) -->
            </div>
            <!-- /.row -->
          </div>
          <!-- /.container-fluid -->
        </section>
        <!-- /.content -->
      </div>
      <!-- /.content-wrapper -->
      <footer class="main-footer">
        <div class="float-right d-none d-sm-block"><b>Version</b> 3.2.0</div>
        <strong
          >Copyright &copy; 2014-2021
          <a href="https://adminlte.io">AdminLTE.io</a>.</strong
        >
        All rights reserved.
      </footer>

      <!-- Control Sidebar -->
      <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
      </aside>
      <!-- /.control-sidebar -->
    </div>
    <!-- ./wrapper -->

    <!-- jQuery -->
    <script src="admin/plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap 4 -->
    <script src="admin/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- bs-custom-file-input -->
    <script src="admin/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
    <!-- AdminLTE App -->
    <script src="admin/js/adminlte.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="admin/js/demo.js"></script>
    <!-- Page specific script -->
    <script>
      $(function () {
        bsCustomFileInput.init();
      });
    </script>
  </body>
</html>
