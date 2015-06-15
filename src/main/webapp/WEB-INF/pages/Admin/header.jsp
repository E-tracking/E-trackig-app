<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>AdminLTE 2 | Dashboard</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.2 -->
    <link href="<c:url value="/resources/assets/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />   
    <!-- FontAwesome 4.3.0 -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons 2.0.0 -->
    <link href="http://code.ionicframework.com/ionicons/2.0.0/css/ionicons.min.css" rel="stylesheet" type="text/css" />
     <!-- DATA TABLES -->
    <link href="<c:url value="/resources/assets/plugins/datatables/dataTables.bootstrap.css"/>" rel="stylesheet" type="text/css" />    
    <!-- Theme style -->
    <link href="<c:url value="/resources/assets/dist/css/AdminLTE.min.css"/>" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
    <link href="<c:url value="/resources/assets/dist/css/skins/_all-skins.min.css"/>" rel="stylesheet" type="text/css" />
    <!-- iCheck -->
    <link href="<c:url value="/resources/assets/plugins/iCheck/flat/blue.css"/>" rel="stylesheet" type="text/css" />
    <!-- Morris chart -->
    <link href="<c:url value="/resources/assets/plugins/morris/morris.css"/>" rel="stylesheet" type="text/css" />
    <!-- jvectormap -->
    <link href="<c:url value="/resources/assets/plugins/jvectormap/jquery-jvectormap-1.2.2.css"/>" rel="stylesheet" type="text/css" />
    <!-- Date Picker -->
    <link href="<c:url value="/resources/assets/plugins/datepicker/datepicker3.css"/>" rel="stylesheet" type="text/css" />
    <!-- Daterange picker -->
    <link href="<c:url value="/resources/assets/plugins/daterangepicker/daterangepicker-bs3.css"/>" rel="stylesheet" type="text/css" />
    <!-- bootstrap wysihtml5 - text editor -->
    <link href="<c:url value="/resources/assets/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css"/>" rel="stylesheet" type="text/css" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="skin-blue fixed">
    <div class="wrapper">
      


<!-- *******************************************************HEADER************************************************ -->


      <header class="main-header">
        <!-- Logo -->
        <a href="index2l" class="logo"><b>Admin</b></a>
        <!-- Header Navbar: style can be userAdmin in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button-->
          <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
          </a>
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">


              <!-- User Account: style can be userAdmin in dropdown.less -->
              <li class="dropdown user user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <img src="<c:url value="/resources/assets/dist/img/avatar5.png" />" class="user-image" alt="User Image"/>
                  <span class="hidden-xs">${userAdmin.nomuser} ${userAdmin.prenomuser}</span>
                </a>
                <ul class="dropdown-menu">
                  <!-- User image -->
                  <li class="user-header">
                    <img src="<c:url value="/resources/assets/dist/img/avatar5.png" />" class="img-circle" alt="User Image" />
                    <p>
                      ${userAdmin.prenomuser} ${userAdmin.nomuser} - Admin
                    </p>
                  </li>
                  <!-- Menu Footer-->
                  <li class="user-footer">
                    <div class="pull-left">
                      <a href="#" class="btn btn-default btn-flat">Profile</a>
                    </div>
                    <div class="pull-right">
                     <c:url value="/j_spring_security_logout" var="logoutUrl" />
						<form action="${logoutUrl}" method="post" id="logoutForm">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>
						<script>
							function formSubmit() {
								document.getElementById("logoutForm").submit();
							}
						</script>
				
						<c:if test="${pageContext.request.userPrincipal.name != null}">
						
								<a href="javascript:formSubmit()" class="btn btn-default btn-flat"> Logout</a>
							
						</c:if>
                    </div>
                  </li>
                </ul>
              </li>


            </ul>
          </div>
        </nav>
      </header>


<!-- *******************************************************ASIDE************************************************ -->



      
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be userAdmin in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src="<c:url value="/resources/assets/dist/img/avatar5.png" />" class="img-circle" alt="User Image" />
            </div>
            <div class="pull-left info">
              <p>${userAdmin.prenomuser} ${userAdmin.prenomuser}</p>

              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>
          <!-- search form -->
          <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
              <input type="text" name="q" class="form-control" placeholder="Search..."/>
              <span class="input-group-btn">
                <button type='submit' name='search' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
          </form>
          <!-- /.search form -->
          <!-- sidebar menu: : style can be userAdmin in sidebar.less -->
          <ul class="sidebar-menu">
            <li class="active treeview">
              <a href="#">
                <i class="fa fa-dashboard"></i> <span>Dashboard</span> <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li class="${IsCommercialViewActive}"><a href="AdminCommercialView"><i class="fa fa-circle-o"></i> Liste des Commerciaux</a></li>
                <li class="${IsTransitViewActive}"><a href="AdminTransitView"><i class="fa fa-circle-o"></i>Liste des Transitaires</a></li>
                <li class="${IsTransporteurViewActive}"><a href="AdminTransporterView"><i class="fa fa-circle-o"></i>Liste des Transporteurs</a></li>
              </ul>
            </li>

            
          </ul>
        </section>
        <!-- /.sidebar -->
      </aside>



            
            