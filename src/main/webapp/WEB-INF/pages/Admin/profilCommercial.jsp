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
                  <h3 class="box-title">Liste des Dossier</h3>
                </div><!-- /.box-header -->
                <div class="box-body">


					<table id="example3" class="table table-bordered table-striped">
                    	<thead>
                      		<tr>
                        		<th>Nom de Dossier</th>
                        		<th>Port 1</th>
                        		<th>Port 2</th>
                        		<th>Moyenne transport</th>
                        		<th>date</th>
                        		<th>Incoterm</th>
                        		<th>typetransport</th>
                        		<th>validationclient</th>
								<th>client</th>
								<th>transporteur</th>
								<th>transit</th>
								<th>fintransport</th>
                      		</tr>
                    	</thead>
                    	<tbody>
                    		<c:forEach items="${listeDossier}" var="l">
								<tr>
									<td>${l.numdossier}</td>
									<td>${l.portByIdport.Afficher()}</td>
									<td>${l.portByPorIdport.Afficher()}</td>
									<td>${l.moyennetransport.Afficher()}</td>
									<td>${l.date}</td>
									<td>${l.incoter}</td>
									<td>${l.typetransport}</td>
									<td>${l.validationclient}</td>
									<td>${l.client.toString()}</td>
									<input type="hidden" name="numdossier" value="${l.numdossier}" />
									<td>
										<select name="idTransporteur">
											<c:forEach items="${listeTransporteur}" var="T">
												<option value="${T.toString()}">${T.toString()}</option>
											</c:forEach>
										</select>
									</td>
									<td>
										<select name="idTransit">
											<c:forEach items="${listeTransit}" var="Ti">
												<option value="${Ti.getIdtransit()}">${Ti.getIdtransit()}</option>
											</c:forEach>
										</select>
									</td>
									<td>${l.fintransport}</td>
								</tr>
							</c:forEach>
	                    </tbody>
	                    <tfoot>
	                      	<tr>
	                        	<th>Nom de Dossier</th>
                        		<th>Port 1</th>
                        		<th>Port 2</th>
                        		<th>Moyenne transport</th>
                        		<th>date</th>
                        		<th>Incoterm</th>
                        		<th>typetransport</th>
                        		<th>validationclient</th>
								<th>client</th>
								<th>transporteur</th>
								<th>transit</th>
								<th>fintransport</th>
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