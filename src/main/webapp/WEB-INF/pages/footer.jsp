<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <footer class="main-footer">
        <div class="pull-right hidden-xs">
          <b>Version</b> 2.0
        </div>
        <strong>Copyright &copy; 2014-2015 <a href="">Almsaeed Studio</a>.</strong> All rights reserved.
      </footer>







    <!-- jQuery 2.1.3 -->
    <script src="<c:url value="/resources/assets/plugins/jQuery/jQuery-2.1.3.min.js"/>"></script>
    <!-- jQuery UI 1.11.2 -->
    <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.min.js" type="text/javascript"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
      $.widget.bridge('uibutton', $.ui.button);
    </script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="<c:url value="/resources/assets/bootstrap/js/bootstrap.min.js"/>" type="text/javascript"></script>   
    <!-- InputMask -->
    <script src="<c:url value="/resources/assets/plugins/input-mask/jquery.inputmask.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/input-mask/jquery.inputmask.date.extensions.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/input-mask/jquery.inputmask.extensions.js"/>" type="text/javascript"></script>
     <!-- DATA TABES SCRIPT -->
    <script src="<c:url value="/resources/assets/plugins/datatables/jquery.dataTables.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/datatables/dataTables.bootstrap.js"/>" type="text/javascript"></script> 
    <!-- Morris.js charts -->
    <!-- <script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script> -->
    <!-- Sparkline -->
    
    <script src="<c:url value="/resources/assets/plugins/sparkline/jquery.sparkline.min.js"/>" type="text/javascript"></script>
    <!-- jvectormap -->
    <script src="<c:url value="/resources/assets/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"/>" type="text/javascript"></script>
    <!-- jQuery Knob Chart -->
    <script src="<c:url value="/resources/assets/plugins/knob/jquery.knob.js"/>" type="text/javascript"></script>
    <!-- Bootstrap WYSIHTML5 -->
    <script src="<c:url value="/resources/assets/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"/>" type="text/javascript"></script>
    <!-- iCheck -->
    <script src="<c:url value="/resources/assets/plugins/iCheck/icheck.min.js"/>" type="text/javascript"></script>
    <!-- Slimscroll -->
    <script src="<c:url value="/resources/assets/plugins/slimScroll/jquery.slimscroll.min.js"/>" type="text/javascript"></script>
    <!-- FastClick -->
    <script src='<c:url value="/resources/assets/plugins/fastclick/fastclick.min.js"/>'></script>
    <!-- AdminLTE App -->
    <script src="<c:url value="/resources/assets/dist/js/app.min.js"/>" type="text/javascript"></script>
    
    <!-- AdminLTE for demo purposes -->
    <%-- <script src="<c:url value="/resources/assets/dist/js/pages/dashboard.js"/>" type="text/javascript"></script> --%>
    <script src="<c:url value="/resources/assets/dist/js/demo.js"/>" type="text/javascript"></script>


    <!-- page script -->
    <script type="text/javascript">
          //SLIMSCROLL FOR CHAT WIDGET
            $('#chat-box').slimScroll({
              height: '493px'
            });
	</script>
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
	
	<script type="text/javascript">
function sup(id)
{
	$('#idClient').attr('href','supprimerClient.htm?idClient='+id);
}

function supDossier(id)
{
	$('#idDossier').attr('href','supprimerDossier.htm?idDossier='+id);
}

function mod(id)
{
	 $( "div" ).remove(".modifierForm");
				$.ajax({
					  url: "ModifClient.htm?idClient="+id,
					  beforeSend: function( xhr ) {
					    xhr.overrideMimeType( "text/plain; charset=x-user-defined" );
					  }
					})
					  .done(function( html ) {
				    $( "#ModAjax" ).append('<div class="modifierForm">'+ html+'</div>' );
				  });				 
}

function modDossier(id)
{
	 $( "div" ).remove(".modifierForm");
				$.ajax({
					  url: "ModifDossier.htm?idDossier="+id,
					  beforeSend: function( xhr ) {
					    xhr.overrideMimeType( "text/plain; charset=x-user-defined" );
					  }
					})
					  .done(function( html ) {
				    $( "#ModAjax" ).append('<div class="modifierForm">'+ html+'</div>' );
				  });
				 
}

function ajouter()
{
	 $( "div" ).remove(".modifierForm");
				$.ajax({
					  url: "AjouterClient.htm",
					  beforeSend: function( xhr ) {
					    xhr.overrideMimeType( "text/plain; charset=x-user-defined" );
					  }
					})
					  .done(function( html ) {
				    $( "#ModAjax" ).append('<div class="modifierForm">'+ html+'</div>' );
				  });				 
}

function ajouterDossier()
{
	 $( "div" ).remove(".modifierForm");
				$.ajax({
					  url: "ajouterDossierFormulaire.htm",
					  beforeSend: function( xhr ) {
					    xhr.overrideMimeType( "text/plain; charset=x-user-defined" );
					  }
					})
					  .done(function( html ) {
				    $( "#ModAjax" ).append('<div class="modifierForm">'+ html+'</div>' );
				  });	 
}

function changerEtatDossier(id)
{
	 $( "div" ).remove(".modifierForm");
				$.ajax({
					  url: "ChangerEtat.htm?idDossier="+id,
					  beforeSend: function( xhr ) {
					    xhr.overrideMimeType( "text/plain; charset=x-user-defined" );
					  }
					})
					  .done(function( html ) {
				    $( "#ModAjax" ).append('<div class="modifierForm">'+ html+'</div>' );
				  });	 
}
function comment(id)
{
				$("div").remove(".commentContent");
				$.ajax({
					  url: "comments.htm?idDossier="+id,
					  beforeSend: function( xhr ) {
					    xhr.overrideMimeType( "text/plain; charset=x-user-defined" );
					  }
					})
					  .done(function( html ) {
				    $( "#comments" ).append('<div class="commentContent">'+ html+'</div>' );
				  });	 
}
function affecter(id)
{
	 $( "div" ).remove(".modifierForm");
				$.ajax({
					  url: "affecter.htm?idDossier="+id,
					  beforeSend: function( xhr ) {
					    xhr.overrideMimeType( "text/plain; charset=x-user-defined" );
					  }
					})
					  .done(function( html ) {
				    $( "#ModAjax" ).append('<div class="modifierForm">'+ html+'</div>' );
				  });
				 
}





</script>

<script type="text/javascript">
function to() {
    document.getElementById( 'to' ).scrollIntoView();    
};

function bottom() {
    document.getElementById( 'bottom' ).scrollIntoView();
    window.setTimeout( function () { to(); }, 2000 );
};

function pageScroll() {
    window.scrollBy(0,50);
    scrolldelay = setTimeout(pageScroll(),500);
};

$(window).bind("load", function() 
{
	//bottom();
	//pageScroll();
	//$('html, body').animate({scrollTop:'350px'},'slow');
	$('body,html').animate({scrollTop: 306}, 3500); 
});
</script>

<script>

  /* jVector Maps
   * ------------
   * Create a world map with markers
   */
   
  $('#world-map-markers').vectorMap({
    map: 'world_mill_en',
    normalizeFunction: 'polynomial',
    hoverOpacity: 0.7,
    hoverColor: false,
    backgroundColor: 'transparent',
    regionStyle: {
      initial: {
        fill: 'rgba(210, 214, 222, 1)',
        "fill-opacity": 1,
        stroke: 'none',
        "stroke-width": 0,
        "stroke-opacity": 1
      },
      hover: {
        "fill-opacity": 0.7,
        cursor: 'pointer'
      },
      selected: {
        fill: 'yellow'
      },
      selectedHover: {
      }
    },
    markerStyle: {
      initial: {
        fill: '#00a65a',
        stroke: '#111'
      }
    },
    markers: [${etatMap}]
  });
</script>


  </body>
</html>            