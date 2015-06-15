<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head></head>
  <body>
<div class="col-md-7">
            	<div class="box box-success">
                <div class="box-header">
                  <i class="fa fa-comments-o"></i>
                  <h3 class="box-title">Commentaires</h3>
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
                    <input class="form-control" name="idDossier" type="hidden" value="${idDossier}"/>
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
            <script type="text/javascript">
          //SLIMSCROLL FOR CHAT WIDGET
            $('#chat-box').slimScroll({
              height: '250px'
            });
            </script>
  </body></html>      