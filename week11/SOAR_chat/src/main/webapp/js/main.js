/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

jQuery(document).ready(function($){
    
var webSocket = new WebSocket('ws://localhost:8080/SOAR_chat/chatendpoint');
var all_messages=[]

    webSocket.onerror = function(event) {
      onError(event);
    };


    webSocket.onmessage = function (event) {
        onMessage(event);
    };

    function onMessage(event) {
      var incoming_message = JSON.parse(event.data);
      updateUI(incoming_message);
    }


    function onError(event) {
      alert("error");
    }
    
    function updateUI(message){
    if (message.name == name){
        var html_msg = '<div class="row msg_container base_sent"> <div class="col-md-10 col-xs-10"><div class="messages msg_sent"><h2>'+message.message+'</h2></div></div><div class="col-md-2 col-xs-2 avatar"><img src="'+contextpath+'/images/'+avatar+'.png" class=" img-responsive " />';
    }
    else{
        var html_msg = '<div class="row msg_container base_receive"> \n\
<div class="col-md-2 col-xs-2 avatar">\n\
<img src="'+contextpath+'/images/'+message.avatar+'.png" class=" img-responsive " />\n\
</div\n\
<div class="col-md-10 col-xs-10"><div class="messages msg_receive"><h2>'+message.message+'</h2></div></div>';
    
    }
        $("#message_box").append(html_msg);
        
           
        
    }
    
    //New message sent!
    $("#btn-chat").click(function(){
        var message = $("#message_input").val();
        message = JSON.stringify({
            name: name,
            message: message,
            avatar: avatar
        });
        webSocket.send(message);
        
        
    });
    
    
    
    
});

