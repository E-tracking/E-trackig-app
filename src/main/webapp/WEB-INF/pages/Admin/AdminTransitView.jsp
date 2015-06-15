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
                  <h3 class="box-title">Liste des Transits</h3>
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
                        		<th>Action</th>
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
									<td>
									<c:choose>
										<c:when test="${l.enabled}">
											<span class="label label-danger" data-toggle="modal" data-target="#myModal2">
				                          		<a href="deleteCom?idC=${l.userId}&username=${l.username}" style="color:#fff;"><i class="fa fa-trash-o fa-lg"></i></a>
				                          	</span>
										</c:when>
										<c:otherwise>
											<span class="label label-success" >
				                          		<a href="validerUser?username=${l.username}" style="color:#fff;"><i class="fa fa-check fa-lg" id="modifierb"></i></a>
				                          	</span> 
				                          	&nbsp;
				                          	<span class="label label-danger" data-toggle="modal" data-target="#myModal2">
				                          		<a href="deleteCom?idC=${l.userId}&username=${l.username}" style="color:#fff;"><i class="fa fa-trash-o fa-lg"></i></a>
				                          	</span>
										</c:otherwise>
									</c:choose>
									</td>
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
	                        	<th>Action</th>
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