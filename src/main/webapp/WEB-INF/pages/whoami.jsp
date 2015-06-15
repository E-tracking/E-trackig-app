<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="UTF-8">
    <title>AdminLTE 2 | Log in</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.2 -->
    <link href="<c:url value="/resources/assets/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="<c:url value="/resources/assets/dist/css/AdminLTE.min.css"/>" rel="stylesheet" type="text/css" />
    <!-- iCheck -->
    <link href="<c:url value="/resources/assets/plugins/iCheck/square/blue.css"/>" rel="stylesheet" type="text/css" />

    <!-- HTML5 Shim and Respond.js"/> IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js"/> doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"/>"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js"/>/1.3.0/respond.min.js"/>"></script>
    <![endif]-->
  </head>


  <body class="login-page">

    <div class="login-box">
      <div class="login-logo">
        <a href="index.jsp"><b>Bienvenue</b></a>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
        <p class="login-box-msg">Choisissez votre rôle</p>
        
       
        
        <form action="<c:url value='votreRole' />" method="post">
          
          <div class="form-group has-feedback">
          
            <select name="role" class="form-control" >
                    <option value="Commercial">Commercial</option>
                    <option value="Transporteur">Transporteur</option>
                    <option value="Transit">Transit</option>
                    <option value="Admin">Admin</option>
            </select>
              
          </div>
          
          <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
          
          <div class="row">
            <div class="col-xs-8">    
              <div class="checkbox icheck">

              </div>                        
            </div><!-- /.col -->
            <div class="col-xs-4">
              <button type="submit" class="btn btn-primary btn-block btn-flat" name="action">Valider</button>
            </div><!-- /.col -->
          </div>
        </form>

       

       

      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->


    <!-- jQuery 2.1.3 -->
    <script src="<c:url value="/resources/assets/plugins/jQuery/jQuery-2.1.3.min.js"/>"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="<c:url value="/resources/assets/bootstrap/js/bootstrap.min.js"/>" type="text/javascript"></script>
    <!-- iCheck -->
    <script src="<c:url value="/resources/assets/plugins/iCheck/icheck.min.js"/>" type="text/javascript"></script>
    <script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
    </script>


  </body>
</html>