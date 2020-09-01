<%-- 
    Document   : chat
    Created on : 21-Nov-2019, 14:15:58
    Author     : alpha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
         <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"/>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/chat.css" />
         <script>
            var name = "${param.name}"
            var avatar = "${param.avatar}"
            var contextpath = "${pageContext.request.contextPath}"
        </script>
        <script src="${pageContext.request.contextPath}/js/main.js"></script>
        
        <title>Conversation</title>
    </head>
    <body>
        <div class="container">
	<div class="row">
                 <div class="col-md-12">
                  <div class="chatbody">
                  <div class="panel panel-primary">
                <div class="panel-heading top-bar">
                    <div class="col-md-8 col-xs-8">
                        <h3 class="panel-title"><span class="glyphicon glyphicon-comment"></span> Chat - ${param.name}</h3>
                    </div>
                </div>
                <div class="panel-body msg_container_base" id="message_box">
                    <h2 align="center">Start the conversation</h2>
                </div>
                <div class="panel-footer">
                    <div class="input-group">
                        <input type="text" class="form-control input-sm chat_input" placeholder="Write your message here..." id="message_input" />
                        <span class="input-group-btn">
                        <button class="btn btn-primary btn-sm" id="btn-chat"><i class="fa fa-send fa-1x" aria-hidden="true"></i></button>
                        </span>
                    </div>
                </div>
    		</div>

                 </div>
             </div>
</div>
        </div>
    </body>
</html>
