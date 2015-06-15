<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head></head>
  <body>
   <div class="box-header">
		                  <h3 class="box-title">Modifier client</h3>
		                </div><!-- /.box-header -->
		                <!-- form start -->
		                  <div class="box-body" >
                <!-- form start -->
                <form class="form-inline" role="form" action="updateClient" method="post">
                  <div class="box-body">
                  
                  	<input type="hidden" value="${D.idclient}" name="idclient"/>
		          	
                    <div class="form-group">
                      <label for="prenomclient">prenomclient</label>
                      <input type="text" class="form-control" name="prenomclient" id="prenomclient" placeholder="" value="${D.prenomclient }">
                    </div>
                    
                    <div class="form-group">
                      <label for="nomclient">nomclient</label>
                      <input type="text" class="form-control" name="nomclient" placeholder="" value="${D.nomclient}"/>
                    </div>
                    
                    <div class="form-group">
                      <label for="login">login</label>
                      <input type="text" class="form-control" name="login" placeholder="" value="${D.login }"/>
                    </div>
                    
                    <div class="form-group">
                      <label for="pssword">pssword</label>
                      <input type="text" class="form-control" name="pssword" placeholder="" value="${D.pssword }"/>
                    </div>
                    
                    <div class="form-group">
                      <label for="adresseclient">adresseclient</label>
                      <input type="text" class="form-control" name="adresseclient" placeholder="" value="${D.adresseclient }"/>
                    </div>
                    
                    <div class="form-group">
                      <label for="emailclient">emailclient</label>
                      <input type="text" class="form-control" name="emailclient" placeholder="" value="${D.emailclient }"/>
                    </div>
                    
                    <div class="form-group">
                      <label for="phoneclient">phoneclient</label>
                      <input type="text" class="form-control" name="phoneclient" placeholder="" value="${D.phoneclient }"/>
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
    