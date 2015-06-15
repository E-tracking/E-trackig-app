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
                          <td><a href="SingleDossier?idDossier=${l.numdossier}">${l.numdossier}</a></td>
                          <td>${l.client.nomclient}</td>
                          <td>${l.typetransport}</td>
                          <td>${l.incoter}</td>
                          <td>${l.moyennetransport.moyennetransport}</td>
                          <td>${l.portByIdport.nomport}(${l.portByIdport.pays.paysport})</td>
                          <td>${l.portByPorIdport.nomport}(${l.portByPorIdport.pays.paysport})</td>
                          <td>${l.etat}</td>
                          <td>${l.date}</td>
                          <td>
							<span class="label label-success" data-toggle="modal" data-target="#myModal1" >
                          		<i data-toggle="tooltip" data-placement="top" title="Modifier" class="fa fa-edit fa-lg" id="modifierb" onclick="modDossier(${l.numdossier})"></i>
                          	</span>
                          	&nbsp;
                          	<span class="label label-success" >
                          		<a href="valider?idDossier=${l.numdossier}" style="color:#fff;"><i data-toggle="tooltip" data-placement="top" title="Valider" class="fa fa-check fa-lg" id="modifierb" onclick="valider(${l.numdossier})"></i> </a>
                          	</span> 
                          	&nbsp;
                          	<span class="label label-danger" data-toggle="modal" data-target="#myModal2">
                          		<i data-toggle="tooltip" data-placement="top" title="Supprimer" class="fa fa-trash-o fa-lg" onclick="supDossier(${l.numdossier})"></i>
                          	</span>
                          	&nbsp;
                          	<span class="label label-info" data-toggle="modal" data-target="#myModal1">
                          		<i data-toggle="tooltip" data-placement="top" title="Affecter" class="fa fa-paperclip" onclick="affecter(${l.numdossier})"></i>
                          	</span>
                          </td>
                        </tr>
                        
                      </c:forEach> 
                      </tbody>
                    </table>
                  </div><!-- /.table-responsive -->
                </div><!-- /.box-body -->
                <div class="box-footer clearfix">
                  <a class="btn btn-sm btn-info btn-flat pull-left" onclick="ajouterDossier()" data-toggle="modal" data-target="#myModal1">Ajouter Dossierr</a>
                </div><!-- /.box-footer -->
              </div><!-- /.box -->
            </div><!-- /.col -->
          </div><!-- /.row -->
 
              
              
            </div><!-- /.col -->
            <div class="col-md-6">
              <!-- PRODUCT LIST -->
              <div class="box box-primary">
                <div class="box-header with-border">
                  <h3 class="box-title">Les dossiers recents</h3>
                  <div class="box-tools pull-right">
                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                  </div>
                </div><!-- /.box-header -->
                <div class="box-body">
                  <ul class="products-list product-list-in-box">
                  <c:forEach items="${dossierReccents}" var="l">
                    <li class="item">
                      
                      <div class="product-info">
                        Num Dossier<a href="javascript::;" class="product-title"> ${l.numdossier}<span class="label label-warning pull-right">${l.cotation} DHs</span></a>
                        <span class="product-description">
                          Le client : ${l.client.nomclient}
                        </span>
                      </div>
                    </li><!-- /.item -->
                    </c:forEach>
                    
                  </ul>
                </div><!-- /.box-body -->
                <div class="box-footer text-center">
                  <a href="javascript::;" class="uppercase">View All Products</a>
                </div><!-- /.box-footer -->
              </div><!-- /.box -->
            </div>
            <div class="col-md-6">
            	<div class="box box-success">
                <div class="box-header">
                  <h3 class="box-title">Les Ports</h3>
                  <div class="box-tools pull-right" data-toggle="tooltip" title="Status">
                    <div class="btn-group" data-toggle="btn-toggle" >
                      <button type="button" class="btn btn-default btn-sm active"><i class="fa fa-square text-green"></i></button>
                      <button type="button" class="btn btn-default btn-sm"><i class="fa fa-square text-red"></i></button>
                    </div>
                  </div>
                </div>
                <div class="box-body chat" id="chat-box">
                  <!-- chat item -->
                  <c:forEach var="port" items="${ports}">
                  <div class="item">
                    <p>
                    ${port.nomport}
                    </p>
                      <%-- <a href="#" class="name">
                        <small class="text-muted pull-right"><i class="fa fa-clock-o"></i> ${comment.date}</small>
                       ${comment.user.nomuser} ${comment.user.prenomuser}
                      </a> --%>
                     
                    
                  </div><!-- /.item -->
                  </c:forEach>
                  <c:forEach var="port" items="${ports}">
                  <div class="item">
                    <p>
                    ${port.nomport}
                    </p>
                      <%-- <a href="#" class="name">
                        <small class="text-muted pull-right"><i class="fa fa-clock-o"></i> ${comment.date}</small>
                       ${comment.user.nomuser} ${comment.user.prenomuser}
                      </a> --%>
                     
                    
                  </div><!-- /.item -->
                  </c:forEach>
                  <c:forEach var="port" items="${ports}">
                  <div class="item">
                    <p>
                    ${port.nomport}
                    </p>
                      <%-- <a href="#" class="name">
                        <small class="text-muted pull-right"><i class="fa fa-clock-o"></i> ${comment.date}</small>
                       ${comment.user.nomuser} ${comment.user.prenomuser}
                      </a> --%>
                     
                    
                  </div><!-- /.item -->
                  </c:forEach>
                  <c:forEach var="port" items="${ports}">
                  <div class="item">
                    <p>
                    ${port.nomport}
                    </p>
                      <%-- <a href="#" class="name">
                        <small class="text-muted pull-right"><i class="fa fa-clock-o"></i> ${comment.date}</small>
                       ${comment.user.nomuser} ${comment.user.prenomuser}
                      </a> --%>
                     
                    
                  </div><!-- /.item -->
                  </c:forEach>
                </div><!-- /.chat -->
                <div class="box-footer">
                <form class="form-inline" role="form" action="ajouterPort" method="post">
                  <div class="input-group">
                  <div class="form-group">
		               <select class="form-control" name="portPays">
		                  <c:forEach items="${pays}" var="l">
								<option value="${l.idpays}">${l.paysport}</option>
					   	  </c:forEach>
		               </select>
		          	</div>
                    <input class="form-control" name="portName" placeholder="Entrer le port"/>
                    <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
                    <div class="input-group-btn">
                      <button class="btn btn-success" type="submit" style="margin-top: 34px;"><i class="fa fa-plus"></i></button>
                    </div>
                  </div>
                 </form>
                </div>
              </div><!-- /.box (chat box) -->
            	
            </div>
          </div><!-- /.row -->

		

		 </section><!-- /.content -->
		 



      </div><!-- /.content-wrapper -->
		<div class="modal fade myModal" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-body">
		        <div class="row">
		           <!--  left column -->
		            <div class="col-md-12">
		              <!-- general form elements -->
		              <div class="box box-primary" id="ModAjax">
		                  
		              </div><!-- /.box -->
		             </div><!-- /.col-lg-6 -->
		            </div><!-- /.row -->
		      </div>
		    </div>
		  </div>
		</div>
		<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-danger">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">Suppresion d'un dossier</h4>
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



<%@ include file="footer.jsp" %>