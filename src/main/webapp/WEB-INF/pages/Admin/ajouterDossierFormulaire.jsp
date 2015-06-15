<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head></head>
  <body>

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
		          	<label for="exampleInputEmail1">Transporteur</label>
		               <select class="form-control" name="transporteurId">
		                  	<c:forEach items="${listeTransporteur}" var="l">
								<option value="${l.idtransporteur}">${l.prenomuser}</option>
					   		</c:forEach>
		               </select>
		          	</div>
		          	<div class="form-group">
		          	<label for="exampleInputEmail1">Commercial</label>
		               <select class="form-control" name="commercialId">
		                  <c:forEach items="${listeCommercial}" var="l">
								<option value="${l.idcommercial}">${l.prenomuser}</option>
					   		</c:forEach>
		               </select>
		          	</div>
		          	<div class="form-group">
		          	<label for="exampleInputEmail1">Transit</label>
		               <select class="form-control" name="transitId">
		                  <c:forEach items="${listeTransit}" var="l">
								<option value="${l.idtransit}">${l.prenomuser}</option>
					   	  </c:forEach>
		               </select>
		          	</div>
		          	<div class="form-group">
		          	<label for="exampleInputEmail1">Moyenne de transport</label>
		               <select class="form-control" name="moyenneTransportId">
		                  <c:forEach items="${listeMoyenneTransport}" var="l">
								<option value="${l.idmoyennetransport}">${l.moyennetransport}</option>
					   	  </c:forEach>
		               </select>
		          	</div>
		          	<div class="form-group">
		          	<label for="typeTransport">Type de transport</label>
		               <select class="form-control" name="typeTransport">
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
                      <label for="cotation">Cotation</label>
                      <input type="number" class="form-control" name="cotation" id="cotation" placeholder="">
                    </div>
                    <div class="form-group">
                      <label for="exampleInputPassword1">Etat</label>
                      <textarea class="form-control" name="etat"  rows="3" placeholder="Enter ..."></textarea>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
                  </div><!-- /.box-body -->

                  <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Ajouter</button>
                  </div>
                </form>
        </body></html>      