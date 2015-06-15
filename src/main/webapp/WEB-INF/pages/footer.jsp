



    <!-- jQuery 2.1.3 -->
    <script src="<c:url value="/resources/assets/plugins/jQuery/jQuery-2.1.3.min.js" />"></script>
    <!-- jQuery UI 1.11.2 -->
    <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.min.js" type="text/javascript"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
      $.widget.bridge('uibutton', $.ui.button);
    </script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="<c:url value="/resources/assets/bootstrap/js/bootstrap.min.js" />" type="text/javascript"></script>   
     <!-- DATA TABES SCRIPT -->
    <script src="<c:url value="/resources/assets/plugins/datatables/jquery.dataTables.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/datatables/dataTables.bootstrap.js" />" type="text/javascript"></script> 
    <!-- Morris" /> charts -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <!-- Sparkline -->
    <script src="<c:url value="/resources/assets/plugins/sparkline/jquery.sparkline.min.js" />" type="text/javascript"></script>
    <!-- jvectormap -->
    <script src="<c:url value="/resources/assets/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/jvectormap/jquery-jvectormap-world-mill-en.js" />" type="text/javascript"></script>
    <!-- jQuery Knob Chart -->
    <script src="<c:url value="/resources/assets/plugins/knob/jquery.knob.js" />" type="text/javascript"></script>
    <!-- daterangepicker -->
    <script src="<c:url value="/resources/assets/plugins/daterangepicker/daterangepicker.js" />" type="text/javascript"></script>
    <!-- datepicker -->
    <script src="<c:url value="/resources/assets/plugins/datepicker/bootstrap-datepicker.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/input-mask/jquery.inputmask.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/input-mask/jquery.inputmask.date.extensions.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/input-mask/jquery.inputmask.extensions.js" />" type="text/javascript"></script>
    <!-- Bootstrap WYSIHTML5 -->
    <script src="<c:url value="/resources/assets/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" />" type="text/javascript"></script>
    <!-- iCheck -->
    <script src="<c:url value="/resources/assets/plugins/iCheck/icheck.min.js" />" type="text/javascript"></script>
    <!-- Slimscroll -->
    <script src="<c:url value="/resources/assets/plugins/slimScroll/jquery.slimscroll.min.js" />" type="text/javascript"></script>
    <!-- FastClick -->
    <script src='<c:url value="/resources/assets/plugins/fastclick/fastclick.min.js" />'></script>
    <!-- AdminLTE App -->
    <script src="<c:url value="/resources/assets/dist/js/app.min.js" />" type="text/javascript"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="<c:url value="/resources/assets/dist/js/demo.js" />" type="text/javascript"></script>

    <!-- page script -->
    <script type="text/javascript">
      $(function () 
      {
        $("#example1").dataTable();
        $("#example3").dataTable();
        $("#example4").dataTable();
        $('#example2').dataTable({
          "bPaginate": true,
          "bLengthChange": false,
          "bFilter": false,
          "bSort": true,
          "bInfo": true,
          "bAutoWidth": false
        });
      });
    </script>



  </body>
</html>            