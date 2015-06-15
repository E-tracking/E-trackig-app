<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head></head>
  <body>
 			<div class="box-header">
		          <h3 class="box-title">Ajouter un dossier</h3>
		                </div><!-- /.box-header -->
		                <!-- form start -->
		                  <div class="box-body" >
                <form role="form" action="ajouterDossier" method="post">
                  <div class="box-body">
		          	<div class="form-group">
		          	<label for="exampleInputEmail1">Client</label>
		               <select class="form-control" name="clientId">
		                  <c:forEach items="${listeClient}" var="l">
								<option value="${l.idclient}">${l.nomclient}</option>
					   		</c:forEach>
		               </select>
		          	</div>
		          	<div class="form-group">
		          	<label for="exampleInputEmail1">Moyen de transport</label>
		               <select class="form-control" name="moyenneTransportId">
		                  <c:forEach items="${listeMoyenneTransport}" var="l">
								<option value="${l.idmoyennetransport}">${l.moyennetransport}</option>
					   	  </c:forEach>
		               </select>
		          	</div>
		          	<div class="form-group">
		          	<label for="typeTransport">Type de transport</label>
		               <select class="form-control" name="typeTransport">
		                  <option value="IMP">IMP</option>
		                  <option value="EXP">EXP</option>
		               </select>
		          	</div>
                    <div class="form-group">
		          	<label for="exampleInputEmail1">Port de depart</label>
		               <select class="form-control" name="portDepartId">
		                  <c:forEach items="${listePort}" var="l">
								<option value="${l.idport}">${l.nomport}</option>
					   	  </c:forEach>
		               </select>
		          	</div>
                    <div class="form-group">
		          	<label for="exampleInputEmail1">Port d'arrivée</label>
		               <select class="form-control" name="portArriveeId">
		                  <c:forEach items="${listePort}" var="l">
								<option value="${l.idport}">${l.nomport}</option>
					   	  </c:forEach>
		               </select>
		          	</div>
                    <div class="form-group">
		          	<label for="exampleInputEmail1">Incoterm</label>
		               <select class="form-control" name="incoterm">
								<option value="FOB">FOB</option>
								<option value="EXW">EXW</option>
								<option value="FCA">FCA</option>
								<option value="CFR">CFR</option>
								<option value="CIF">CIF</option>
								<option value="DDU">DDU</option>
								<option value="DDP">DDP</option>
		               </select>
		          	</div>
                    <div class="form-group">
		          	<label for="delaiTransit">Delai Transit</label>
		               <input type="number" class="form-control" name="delaiTransit" id="delaiTransit" placeholder="" required="required">
		          	</div>
                    <div class="form-group">
		          	<label for="delaiTransit">Date</label>
		               <input type="date" class="form-control" name="date" required="required" />
		          	</div>
                    <div class="form-group">
                      <label for="cotation">Cotation</label>
                      <input type="number" class="form-control" name="cotation" id="cotation" placeholder="" value="0" required="required">
                    </div>
                    <div class="form-group">
                      <label for="exampleInputPassword1">Etat</label>
                      <textarea class="form-control" name="etat"  rows="3" placeholder="Enter ..."  required="required"></textarea>
                    </div>
                  </div><!-- /.box-body -->
                  <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

                  <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Ajouter</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                  </div>
                </form>
		     </div><!-- /.box-body -->
        </body></html>      