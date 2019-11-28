<%-- 
    Document   : createUser
    Created on : 21-Nov-2019, 14:10:56
    Author     : alpha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        <title>Join the conversation</title><link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css" /><link type="text/css" rel="stylesheet" href="/soar_week10/faces/javax.faces.resource/css/cssLayout.css" />
        
    </head>
    <body>
        <header>
                <nav class="navbar navbar-dark bg-dark">
                    <a class="navbar-brand" href="#">Our super chat</a>
                </nav>
            </header>
        <br />
        
        
        <div class="container-fluid">
            <h1>Join the conversation</h1>
            
            <div class="row">
                <div class="col-md-6">
        <form method="post" action="chatServlet">

                    <label for="username">Username</label>
                    <div class="input-group mb-2">
                      <div class="input-group-prepend">
                        <div class="input-group-text">@</div>
                      </div><input id="username" type="text" name="name" class="form-control" />
                    </div>
                    <br />
                    <label for="avatar">Avatar</label>
                    
                    <select class="form-control selectpicker" id="avatar" name="avatar">
                        
                        <option value="bart">Bart</option>
                        <option value="homer">Homer</option>
                        <option value="lisa">Lisa</option>
                        <option value="maggie">Maggie</option>
                        <option value="marge">Marge</option>
                        <option value="burns">Mr Burns</option>
                        
                    </select>
                    <br />
                
                    <div class="col-auto"><input id="submit" type="submit" name="submit" value="Start the conversation" class="btn btn-primary" />
                    </div>
</form>
                </div>
                <div class="col-md-3"></div>
                <div class="col-md-3"></div>
                
            </div>
        </div>
        
            
    <footer class="page-footer font-small blue pt-4">
        <div class="footer-copyright text-center py-3">
            Homemade chat using Java websockets
      </div>

    </footer>
    </body>
</html>
