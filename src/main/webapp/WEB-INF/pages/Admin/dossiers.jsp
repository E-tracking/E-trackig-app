<%@ include file="header.jsp" %>

<!-- *******************************************************MAIN************************************************ -->


      <!-- Right side column. Contains the navbar and content of the page -->
      <div class="content-wrapper">



         <!-- Main content -->
        <section class="content">
        	<!-- <div class="row">
            <div class="col-xs-12">		
        		   <div class="alert alert-success alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <h4>	<i class="icon fa fa-check"></i> Alert!</h4>
                    Success alert preview. This alert is dismissable.
                  </div>
             </div>
             </div> -->
          <div class="row">
            <div class="col-xs-12">
              
              <div class="row">
            <div class="col-md-12">
              <!-- TABLE: LATEST ORDERS -->
              <div class="box box-info">
                <div class="box-header with-border">
                  <h3 class="box-title">Latest Orders</h3>
                  <div class="box-tools pull-right">
                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                  </div>
                </div><!-- /.box-header -->
                <div class="box-body">
                  <div class="table-responsive">
                    <table class="table no-margin">
                      <thead>
                        <tr>
                          <th>Num Dossier</th>
                          <th>Client</th>
                          <th>IMP/EXP</th>
                          <th>Incoter</th>
                          <th>Moy.trans</th>
                          <th>Port de chargement</th>
                          <th>Port de dechargement</th>
                          <th>Etat actuel</th>
                          <th>Date</th>
                        </tr>
                      </thead>
                      <tbody>
                      <c:forEach items="${listeDossiers}" var="l">
					   		
                        <tr>
                          <td><a href="pages/examples/invoice.html">${l.numdossier}</a></td>
                          <td>${l.client.nomclient}</td>
                          <td>${l.typetransport}</td> 
                          <td>${l.incoter}</td>
                          <td>${l.moyennetransport.moyennetransport}</td>
                          <td>${l.portByIdport.nomport}(${l.portByIdport.pays.paysport})</td>
                          <td>${l.portByPorIdport.nomport}(${l.portByPorIdport.pays.paysport})</td>
                          <td>${l.etat}</td>
                          <td>${l.date}</td>
                          <td>

                          	<span class="label label-success" data-toggle="modal" data-target="#myModal1">
                          		<i class="fa fa-edit fa-lg" id="modifierb" onclick="mod(${l.numdossier})"></i>
                          	</span>
                          	&nbsp;
                          	<span class="label label-danger" data-toggle="modal" data-target="#myModal2">
                          		<i class="fa fa-trash-o fa-lg" onclick="sup(${l.numdossier})"></i>
                          	</span>
                          </td>
                        </tr>
                        
                      </c:forEach> 
                      </tbody>
                    </table>
                  </div><!-- /.table-responsive -->
                </div><!-- /.box-body -->
                <div class="box-footer clearfix">
                  <a class="btn btn-sm btn-info btn-flat pull-left" onclick="ajouter()" data-toggle="modal" data-target="#myModal1">Ajouter Dossierr</a>
                </div><!-- /.box-footer -->
              </div><!-- /.box -->
            </div><!-- /.col -->
          </div><!-- /.row -->
 
              
              
            </div><!-- /.col -->
          </div><!-- /.row -->

<!-- Modal -->
		<div class="modal fade myModal" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
			<form action="updatedossier.htm">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">Modifier le Dossier</h4>
		      </div>
		      <div class="modal-body">
		        <div class="row">
		           <!--  left column -->
		            <div class="col-md-12">
		              <!-- general form elements -->
		              <div class="box box-primary">
		                <div class="box-header">
		                  <h3 class="box-title"></h3>
		                </div><!-- /.box-header -->
		                <!-- form start -->
		                  <div class="box-body" id="ModAjax">
		                  
		                  </div><!-- /.box-body -->
		                  
		                  
		                
		              </div><!-- /.box -->
		             </div><!-- /.col-lg-6 -->
		            </div><!-- /.row -->
		      </div>
			 </form>
		    </div>
		  </div>
		</div>
		
        <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-danger">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
		      </div>
		      <div class="modal-body">
		        Vous voulez vraiment supprimer ce dossier !?
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-outline pull-left" data-dismiss="modal">Non</button>
                <a type="button" class="btn btn-outline" id="idDossier">Oui</a>
		      </div>
		    </div>
		  </div>
	    </div>

		 </section><!-- /.content -->
         <!-- Main content -->
        <section class="content">
          <!-- Small boxes (Stat box) -->
          <div class="row">
            
          </div><!-- /.row (main row) -->

        </section><!-- /.content -->



      </div><!-- /.content-wrapper -->





<%@ include file="footer.jsp" %>