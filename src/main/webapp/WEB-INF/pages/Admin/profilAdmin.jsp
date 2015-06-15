<%@ include file="header.jsp" %>
<!-- *******************************************************MAIN************************************************ -->


      <!-- Right side column. Contains the navbar and content of the page -->
      <div class="content-wrapper">




         <!-- Main content -->
        <section class="content">
          <div class="row">
            <div class="col-xs-12">
              



              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Liste des Commerciaux</h3>
                </div><!-- /.box-header -->
                <div class="box-body">


					<table id="example1" class="table table-bordered table-striped">
                    	<thead>
                      		<tr>
                        		<th>Prenom</th>
                        		<th>Nom</th>
                        		<th>Login</th>
                        		<th>Email</th>
                        		<th>Phone</th>
                      		</tr>
                    	</thead>
                    	<tbody>
                    		<c:forEach items="${listeCommercial}" var="l">
								<tr>
									<td>${l.prenomuser}</td>
									<td>${l.nomuser}</td>
									<td>${l.username}</td>
									<td>${l.emailuser}</td>
									<td>${l.phoneuser}</td>
								</tr>
							</c:forEach>
	                    </tbody>
	                    <tfoot>
	                      	<tr>
	                        	<th>Prenom</th>
	                        	<th>Nom</th>
	                        	<th>Login</th>
	                        	<th>Email</th>
	                        	<th>Phone</th>
	                      	</tr>
	                    </tfoot>
               		</table>
                  
                  
                  
                </div><!-- /.box-body -->
              </div><!-- /.box -->
              
              
              
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Liste des Transitaires</h3>
                </div><!-- /.box-header -->
                <div class="box-body">


					<table id="example3" class="table table-bordered table-striped">
                    	<thead>
                      		<tr>
                        		<th>Prenom</th>
                        		<th>Nom</th>
                        		<th>Login</th>
                        		<th>Email</th>
                        		<th>Phone</th>
                      		</tr>
                    	</thead>
                    	<tbody>
                    		<c:forEach items="${listeTransit}" var="l">
								<tr>
									<td>${l.prenomuser}</td>
									<td>${l.nomuser}</td>
									<td>${l.username}</td>
									<td>${l.emailuser}</td>
									<td>${l.phoneuser}</td>
								</tr>
							</c:forEach>
	                    </tbody>
	                    <tfoot>
	                      	<tr>
	                        	<th>Prenom</th>
	                        	<th>Nom</th>
	                        	<th>Login</th>
	                        	<th>Email</th>
	                        	<th>Phone</th>
	                      	</tr>
	                    </tfoot>
               		</table>
                  
                  
                  
                </div><!-- /.box-body -->
              </div><!-- /.box -->
              
              
              
               <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Liste des Transporteurs</h3>
                </div><!-- /.box-header -->
                <div class="box-body">


					<table id="example4" class="table table-bordered table-striped">
                    	<thead>
                      		<tr>
                        		<th>Prenom</th>
                        		<th>Nom</th>
                        		<th>Login</th>
                        		<th>Email</th>
                        		<th>Phone</th>
                      		</tr>
                    	</thead>
                    	<tbody>
                    		<c:forEach items="${listeTransporteur}" var="l">
								<tr>
									<td>${l.prenomuser}</td>
									<td>${l.nomuser}</td>
									<td>${l.username}</td>
									<td>${l.emailuser}</td>
									<td>${l.phoneuser}</td>
								</tr>
							</c:forEach>
	                    </tbody>
	                    <tfoot>
	                      	<tr>
	                        	<th>Prenom</th>
	                        	<th>Nom</th>
	                        	<th>Login</th>
	                        	<th>Email</th>
	                        	<th>Phone</th>
	                      	</tr>
	                    </tfoot>
               		</table>
                  
                  
                  
                </div><!-- /.box-body -->
              </div><!-- /.box -->
              
              
            </div><!-- /.col -->
          </div><!-- /.row -->
        </section><!-- /.content -->


         <!-- Main content -->
        <section class="content">
          <!-- Small boxes (Stat box) -->
          <div class="row">
            
          </div><!-- /.row (main row) -->

        </section><!-- /.content -->



      </div><!-- /.content-wrapper -->




<%@ include file="footer.jsp" %>