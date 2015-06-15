<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head></head>
  <body>
  <div class="box-header">
		                  <h3 class="box-title">Changer l'etat</h3>
		                </div><!-- /.box-header -->
		                <!-- form start -->
		                  <div class="box-body" >
                <!-- form start -->
                <form role="form" action="ChangerEtatAction" method="post">
                  <div class="box-body">
                  
                  	<input type="hidden" value="${D.numdossier}" name="idDossier"/>
                 	<input type="hidden" value="${D.client.emailclient}" name="emailclient"/>
                    
                    <div class="form-group">
                      <label for="exampleInputPassword1">Etat</label>
                      <textarea class="form-control" name="etat"  rows="3" placeholder="Enter ..." >${D.etat }</textarea>
                    </div>
                    
                    <div class="form-group">
                      <label for="prenomclient">Coordonnee</label>
                      <input type="text" class="form-control" name="coordonnee" id="coordonnee" placeholder="" ">
                    </div>
                    
                    <div class="form-group">
                      <label for="prenomclient">Position</label>
                      <input type="text" class="form-control" name="position" id="position" placeholder="" ">
                    </div>
                   <div class="checkbox">
                      <label>
                        <input type="checkbox" name="notifier" value="true">Notifier le client
                      </label>
                    </div> 
                   
                     <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
                    
                  </div><!-- /.box-body -->

                  <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Modifier</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                  </div>
                </form>
		     </div><!-- /.box-body -->
                </body></html>
    