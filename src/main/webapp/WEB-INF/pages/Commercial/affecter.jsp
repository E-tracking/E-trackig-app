<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head></head>
  <body>
   <div class="box-header">
		                  <h3 class="box-title">Affecter un dossier</h3>
		                </div><!-- /.box-header -->
		                <!-- form start -->
		                  <div class="box-body" >
                <!-- form start -->
                <form role="form" action="affecterAction" method="post">
                  <div class="box-body">
                  
                  	<input type="hidden" value="${D.numdossier}" name="idDossier"/>
                  	<!-- radio -->
                    <div class="form-group">
                      <div class="radio">
                        <label>
                          <input type="radio" name="choix" id="optionsRadios1" value="transporteur">
                          affecter un transporteur
                        </label>
                      </div>
                      <div class="radio">
                        <label>
                          <input type="radio" name="choix" id="optionsRadios2" value="transit">
					      affecter un transitaire
                        </label>
                      </div>
                      <div class="radio">
                        <label>
                          <input type="radio" name="choix" id="optionsRadios3" value="deux">
					      affecter les deux
                        </label>
                      </div>
                    </div>	
                    
		          	<div class="form-group" style="display:none;" id="transporteur">
		          	<label for="exampleInputEmail1">Transporteur</label>
		               <select class="form-control" name="transporteurId">
		                  	<c:forEach items="${listeTransporteur}" var="l">
								<option value="${l.userId}">${l.prenomuser}</option>
					   		</c:forEach>
		               </select>
		          	</div>
		          
		          	
		          	<div class="form-group" style="display:none;" id="transit">
		          	<label for="exampleInputEmail1">Transit</label>
		               <select class="form-control" name="transitId">
		                  <c:forEach items="${listeTransit}" var="l">
								<option value="${l.userId}">${l.prenomuser}</option>
					   	  </c:forEach>
		               </select>
		          	</div>
						          	
		          	
                    
                     <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
                    
                  </div><!-- /.box-body -->

                  <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Affecter</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                  </div>
                </form>
		     </div><!-- /.box-body -->
                <script>
                (function() {
				    $("#optionsRadios1").click(function() {
				      $( '#transporteur' ).removeAttr( "style" );
				      $( '#transit' ).attr( "style", "display:none;" );
				
				    });
				    $("#optionsRadios2").click(function() {
				      $( '#transit' ).removeAttr( "style" );
					  $( '#transporteur' ).attr( "style", "display:none;" );
				    });
				    $("#optionsRadios3").click(function() {
				      $( '#transit' ).removeAttr( "style" );
				      $( '#transporteur' ).removeAttr( "style" );
				    });
				  })();
				</script>
                </body></html>
    