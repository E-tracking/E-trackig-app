<%@ include file="header.jsp" %>

<!-- *******************************************************MAIN************************************************ -->


      <!-- Right side column. Contains the navbar and content of the page -->
      <div class="content-wrapper">





        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Dashboard
            <small>Control panel</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Dashboard</li>
          </ol>
        </section>


         <!-- Main content -->
        <section class="content">
        	
          <div class="row">
            <div class="col-xs-12">
              
              <div class="row">
            <div class="col-md-12">
              <!-- TABLE: LATEST ORDERS -->
              <div class="box box-info">
                <div class="box-header with-border">
                  <h3 class="box-title">Listes des Clients</h3>
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
                          <th>Id Client</th>
                          <th>Nom</th>
                          <th>Prenom</th>
                          <th>Login</th>
                          <th>Mot de Passe</th>
                          <th>Phone</th>
                          <th>Email</th>
                          <th>Adresse</th>
                        </tr>
                      </thead>
                      <tbody>
                      <c:forEach items="${listeClients}" var="l">
					   		
                        <tr>
                          <td>${l.idclient}</td>
                          <td>${l.nomclient}</td>
                          <td>${l.prenomclient}</td>
                          <td>${l.login}</td>
                          <td>${l.pssword}</td>
                          <td>${l.phoneclient}</td>
                          <td>${l.emailclient}</td>
                          <td>${l.adresseclient}</td>
                          <td>

                          	<span class="label label-success" data-toggle="modal" data-target="#myModal1">
                          		<i class="fa fa-edit fa-lg" id="modifierb" onclick="mod(${l.idclient})"></i>
                          	</span>
                          	&nbsp;
                          	<span class="label label-danger" data-toggle="modal" data-target="#myModal2">
                          		<i class="fa fa-trash-o fa-lg" onclick="sup(${l.idclient})"></i>
                          	</span>
                          </td>
                        </tr>
                        
                      </c:forEach> 
                      </tbody>
                    </table>
                  </div><!-- /.table-responsive -->
                </div><!-- /.box-body -->
                <div class="box-footer clearfix">
                  <a class="btn btn-sm btn-info btn-flat pull-left" onclick="ajouter()" data-toggle="modal" data-target="#myModal1">Ajouter Client</a>
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
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
		        <button type="button" class="btn btn-primary" id="DossierModifier">Enregistrer les changements</button>
		        <a type="button" class="btn btn-outline" id="DossierModifier2">Oui</a>
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
                <a type="button" class="btn btn-outline" id="idClient">Oui</a>
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