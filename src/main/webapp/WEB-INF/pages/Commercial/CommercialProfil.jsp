<%@ include file="header.jsp" %>

<!-- *******************************************************MAIN************************************************ -->


      <!-- Right side column. Contains the navbar and content of the page -->
      <div class="content-wrapper">



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
			<form action="updatedossier">
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
		        <h4 class="modal-title" id="myModalLabel">Suppression d'un client</h4>
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
		
		<div class="row">
            <section class="col-lg-7 connectedSortable ui-sortable">		
				<div class="box box-info">
                <div class="box-header ui-sortable-handle" style="cursor: move;">
                  <i class="fa fa-envelope"></i>
                  <h3 class="box-title">Quick Email</h3>
                  <!-- tools box -->
                  <div class="pull-right box-tools">
                    <button class="btn btn-info btn-sm" data-widget="remove" data-toggle="tooltip" title="" data-original-title="Remove"><i class="fa fa-times"></i></button>
                  </div><!-- /. tools -->
                </div>
                <div class="box-body">
                  <form action="envoyerEmail" method="post">
                    <div class="form-group">
                      <input type="email" class="form-control" name="emailto" placeholder="Email to:">
                    </div>
                    <div class="form-group">
                      <input type="text" class="form-control" name="subject" placeholder="Subject">
                    </div>
                    <div class="form-group">
                    
                    	<textarea name="message" class="textarea" style="width: 100%; height: 125px; font-size: 14px; line-height: 18px; border: 1px solid rgb(221, 221, 221); padding: 10px;" placeholder="Message"></textarea>
                   
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
                    <div class="box-footer clearfix">
	                  <button type="submit" class="pull-right btn btn-default" id="sendEmail">Send <i class="fa fa-arrow-circle-right"></i></button>
	                </div>
                  </form>
                </div>
                
              </div>
             </section>
         	<section class="col-lg-5 connectedSortable ui-sortable">

              <!-- Calendar -->
              <div class="box box-solid bg-green-gradient">
                <div class="box-header ui-sortable-handle" style="cursor: move;">
                  <i class="fa fa-calendar"></i>
                  <h3 class="box-title">Calendar</h3>
                  <!-- tools box -->
                  <div class="pull-right box-tools">
                    <!-- button with a dropdown -->
                    <div class="btn-group">
                      <button class="btn btn-success btn-sm dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bars"></i></button>
                      <ul class="dropdown-menu pull-right" role="menu">
                        <li><a href="#">Add new event</a></li>
                        <li><a href="#">Clear events</a></li>
                        <li class="divider"></li>
                        <li><a href="#">View calendar</a></li>
                      </ul>
                    </div>
                    <button class="btn btn-success btn-sm" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    <button class="btn btn-success btn-sm" data-widget="remove"><i class="fa fa-times"></i></button>
                  </div><!-- /. tools -->
                </div><!-- /.box-header -->
                <div class="box-body no-padding">
                  <!--The calendar -->
                  <div id="calendar" style="width: 100%"><div class="datepicker datepicker-inline"><div class="datepicker-days" style="display: block;"><table class="table table-condensed"><thead><tr><th class="prev" style="visibility: visible;">«</th><th colspan="5" class="datepicker-switch">May 2015</th><th class="next" style="visibility: visible;">»</th></tr><tr><th class="dow">Su</th><th class="dow">Mo</th><th class="dow">Tu</th><th class="dow">We</th><th class="dow">Th</th><th class="dow">Fr</th><th class="dow">Sa</th></tr></thead><tbody><tr><td class="old day">26</td><td class="old day">27</td><td class="old day">28</td><td class="old day">29</td><td class="old day">30</td><td class="day">1</td><td class="day">2</td></tr><tr><td class="day">3</td><td class="day">4</td><td class="day">5</td><td class="day">6</td><td class="day">7</td><td class="day">8</td><td class="day">9</td></tr><tr><td class="day">10</td><td class="day">11</td><td class="day">12</td><td class="day">13</td><td class="day">14</td><td class="day">15</td><td class="day">16</td></tr><tr><td class="day">17</td><td class="day">18</td><td class="day">19</td><td class="day">20</td><td class="day">21</td><td class="day">22</td><td class="day">23</td></tr><tr><td class="day">24</td><td class="day">25</td><td class="day">26</td><td class="day">27</td><td class="day">28</td><td class="day">29</td><td class="day">30</td></tr><tr><td class="day">31</td><td class="new day">1</td><td class="new day">2</td><td class="new day">3</td><td class="new day">4</td><td class="new day">5</td><td class="new day">6</td></tr></tbody><tfoot><tr><th colspan="7" class="today" style="display: none;">Today</th></tr><tr><th colspan="7" class="clear" style="display: none;">Clear</th></tr></tfoot></table></div><div class="datepicker-months" style="display: none;"><table class="table table-condensed"><thead><tr><th class="prev" style="visibility: visible;">«</th><th colspan="5" class="datepicker-switch">2015</th><th class="next" style="visibility: visible;">»</th></tr></thead><tbody><tr><td colspan="7"><span class="month">Jan</span><span class="month">Feb</span><span class="month">Mar</span><span class="month">Apr</span><span class="month">May</span><span class="month">Jun</span><span class="month">Jul</span><span class="month">Aug</span><span class="month">Sep</span><span class="month">Oct</span><span class="month">Nov</span><span class="month">Dec</span></td></tr></tbody><tfoot><tr><th colspan="7" class="today" style="display: none;">Today</th></tr><tr><th colspan="7" class="clear" style="display: none;">Clear</th></tr></tfoot></table></div><div class="datepicker-years" style="display: none;"><table class="table table-condensed"><thead><tr><th class="prev" style="visibility: visible;">«</th><th colspan="5" class="datepicker-switch">2010-2019</th><th class="next" style="visibility: visible;">»</th></tr></thead><tbody><tr><td colspan="7"><span class="year old">2009</span><span class="year">2010</span><span class="year">2011</span><span class="year">2012</span><span class="year">2013</span><span class="year">2014</span><span class="year">2015</span><span class="year">2016</span><span class="year">2017</span><span class="year">2018</span><span class="year">2019</span><span class="year new">2020</span></td></tr></tbody><tfoot><tr><th colspan="7" class="today" style="display: none;">Today</th></tr><tr><th colspan="7" class="clear" style="display: none;">Clear</th></tr></tfoot></table></div></div></div>
                </div><!-- /.box-body -->
                
              </div><!-- /.box -->

            </section>
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