<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head></head>
  <body>
   <div class="box-header">
		                  <h3 class="box-title">Ajouter client</h3>
		                </div><!-- /.box-header -->
		                <!-- form start -->
		                  <div class="box-body" >
                <!-- form start -->
                <form role="form" action="addClient" method="post">
                  <div class="box-body">
                  
                  	<input type="hidden" name="idclient"/>
		          	
                    <div class="form-group">
                      <label for="prenomclient">prenomclient</label>
                      <input type="text" class="form-control" name="prenomclient" id="prenomclient" placeholder="" >
                    </div>
                    
                    <div class="form-group">
                      <label for="nomclient">nomclient</label>
                      <input type="text" class="form-control" name="nomclient" placeholder="" />
                    </div>
                    
                    <div class="form-group">
                      <label for="login">login</label>
                      <input type="text" class="form-control" name="login" placeholder="" />
                    </div>
                    
                    <div class="form-group">
                      <label for="pssword">password</label>
                      <input type="password" class="form-control" name="pssword" placeholder="" />
                    </div>
                    
                    <div class="form-group">
                      <label for="adresseclient">adresseclient</label>
                      <input type="text" class="form-control" name="adresseclient" placeholder="" />
                    </div>
                    
                    <div class="form-group">
                      <label for="emailclient">emailclient</label>
                      <input type="email" class="form-control" name="emailclient" placeholder="" />
                    </div>
                    
                    <div class="form-group">
                      <label for="phoneclient">phoneclient</label>
                      <input type="text" class="form-control" name="phoneclient" placeholder="" />
                    </div>
                     <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
                  </div><!-- /.box-body -->

                  <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Ajouter</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                  </div>
                </form>
		     </div><!-- /.box-body -->
                </body></html>
    