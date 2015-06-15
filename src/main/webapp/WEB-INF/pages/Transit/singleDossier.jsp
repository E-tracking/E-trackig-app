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
           
            <div class="col-md-5">
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
                    <li class="item">
                      <div class="product-info">
                        Num Dossier<a href="javascript::;" class="product-title"> ${dossier.numdossier}
                        <span class="label label-warning pull-right">${dossier.cotation} DHs</span></a>
                        <span class="product-description">
                          Le client : ${dossier.client.nomclient}
                        </span>
                      </div>
                     </li><!-- /.item -->
                     <li class="item">
                      <div class="product-info">
                        Type de Transport<a href="h" class="product-title"> </a>
                        <span class="product-description">
                          ${dossier.typetransport}
                        </span>
                      </div>
                      </li><!-- /.item -->
                      <li class="item">
                      <div class="product-info">
                        Date de creation<a href="h" class="product-title"> </a>
                        <span class="product-description">
                          ${dossier.date}
                        </span>
                      </div>
                      </li><!-- /.item -->
                      <li class="item">
                      <div class="product-info">
                        Incotern<a href="h" class="product-title"> </a>
                        <span class="product-description">
                          ${dossier.incoter}
                        </span>
                      </div>
                      </li><!-- /.item -->
                      <li class="item">
                      <div class="product-info">
                        Moyennetransport<a href="h" class="product-title"> </a>
                        <span class="product-description">
                          ${dossier.moyennetransport.moyennetransport}
                        </span>
                      </div>
                      </li><!-- /.item -->
                      <li class="item">
                      <div class="product-info">
                        Port de chargement<a href="h" class="product-title"> </a>
                        <span class="product-description">
                          ${dossier.portByIdport.nomport}(${l.portByIdport.pays.paysport})
                        </span>
                      </div>
                      </li><!-- /.item -->
                      <li class="item">
                      <div class="product-info">
                        Port de dechargement<a href="h" class="product-title"> </a>
                        <span class="product-description">
                          ${dossier.portByPorIdport.nomport}(${l.portByPorIdport.pays.paysport})
                        </span>
                      </div>
                      </li><!-- /.item -->
                      <li class="item">
                      <div class="product-info">
                        Etat<a href="h" class="product-title"> </a>
                        <span class="product-description">
                          ${dossier.etat}
                        </span>
                      </div>
                      </li><!-- /.item -->
                      
                      
                    </li><!-- /.item -->
                    
                  </ul>
                </div><!-- /.box-body -->
                <div class="box-footer text-center">
                  <a href="#" class="uppercase" onclick="comment(${dossier.numdossier})">Voir les commentaires</a>
                </div><!-- /.box-footer -->
              </div><!-- /.box -->
              
            </div>
            <div id="comments">
            <div class="commentContent">
            <div class="col-md-7">
            	<div class="box box-success">
                <div class="box-header">
                  <i class="fa fa-comments-o"></i>
                  <h3 class="box-title">Chat</h3>
                  <div class="box-tools pull-right" data-toggle="tooltip" title="Status">
                    <div class="btn-group" data-toggle="btn-toggle" >
                      <button type="button" class="btn btn-default btn-sm active"><i class="fa fa-square text-green"></i></button>
                      <button type="button" class="btn btn-default btn-sm"><i class="fa fa-square text-red"></i></button>
                    </div>
                  </div>
                </div>
                <div class="box-body chat" id="chat-box">
                  <!-- chat item -->
                  <c:forEach var="comment" items="${comments}">
                  <div class="item">
                    <img src="<c:url value="/resources/assets/dist/img/user2-160x160.jpg"/>" alt="user image" class="online"/>
                    
                    <p class="message">
                      <a href="#" class="name">
                        <small class="text-muted pull-right"><i class="fa fa-clock-o"></i> ${comment.date}</small>
                       ${comment.user.nomuser} ${comment.user.prenomuser}
                      </a>
                     ${comment.commentaire}
                    </p>
                    
                  </div><!-- /.item -->
                  </c:forEach>
                </div><!-- /.chat -->
                <div class="box-footer">
                <form class="form-inline" role="form" action="ajouterCommentaire" method="post">
                  <div class="input-group">
                    <input class="form-control" name="idDossier" type="hidden" value="${dossier.numdossier}"/>
                    <input class="form-control" name="comment" placeholder="Type message..."/>
                    <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
                    <div class="input-group-btn">
                      <button class="btn btn-success" type="submit"><i class="fa fa-plus"></i></button>
                    </div>
                  </div>
                 </form>
                </div>
              </div><!-- /.box (chat box) -->
            	
            </div>
            </div>
            
            
            </div>
              	
            
          </div><!-- /.row -->
          <div class="row">
          <div class="col-md-12">
              <!-- MAP & BOX PANE -->
              <div class="box box-success">
                <div class="box-header with-border">
                  <h3 class="box-title">Visitors Report</h3>
                  <div class="box-tools pull-right">
                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                  </div>
                </div><!-- /.box-header -->
                <div class="box-body no-padding">
                  <div class="row">
                    <div class="col-md-12 col-sm-12">
                      <div class="pad">
                        <!-- Map will be created here -->
                        <div id="world-map-markers" style="height: 325px;"></div>
                      </div>
                    </div><!-- /.col -->
                    <!-- <div class="col-md-3 col-sm-4">
                      <div class="pad box-pane-right bg-green" style="min-height: 280px">
                        <div class="description-block margin-bottom">
                          <div class="sparkbar pad" data-color="#fff">90,70,90,70,75,80,70</div>
                          <h5 class="description-header">8390</h5>
                          <span class="description-text">Visits</span>
                        </div>/.description-block
                        <div class="description-block margin-bottom">
                          <div class="sparkbar pad" data-color="#fff">90,50,90,70,61,83,63</div>
                          <h5 class="description-header">30%</h5>
                          <span class="description-text">Referrals</span>
                        </div>/.description-block
                        <div class="description-block">
                          <div class="sparkbar pad" data-color="#fff">90,50,90,70,61,83,63</div>
                          <h5 class="description-header">70%</h5>
                          <span class="description-text">Organic</span>
                        </div>/.description-block
                      </div>
                    </div>/.col -->
                  </div><!-- /.row -->
                </div><!-- /.box-body -->
              </div><!-- /.box -->

            </div><!-- /.col -->
          </div>

		

		 </section><!-- /.content -->
		 



      </div><!-- /.content-wrapper -->
      
      
      
      <!-- *********************************** -->
      <!-- Modal -->
		<div class="modal fade myModal" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
			<form action="updatedossier">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">Modifier le Dossier</h4>
		      </div>
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




<script>

  /* jVector Maps
   * ------------
   * Create a world map with markers
   */
   
  $('#world-map-markers').vectorMap({
    map: 'world_mill_en',
    normalizeFunction: 'polynomial',
    hoverOpacity: 0.7,
    hoverColor: false,
    backgroundColor: 'transparent',
    regionStyle: {
      initial: {
        fill: 'rgba(210, 214, 222, 1)',
        "fill-opacity": 1,
        stroke: 'none',
        "stroke-width": 0,
        "stroke-opacity": 1
      },
      hover: {
        "fill-opacity": 0.7,
        cursor: 'pointer'
      },
      selected: {
        fill: 'yellow'
      },
      selectedHover: {
      }
    },
    markerStyle: {
      initial: {
        fill: '#00a65a',
        stroke: '#111'
      }
    },
    markers: [
    ${etatMap}
    ]
  });
</script>
<%@ include file="footer.jsp" %>