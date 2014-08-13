//using jquery.form.js
function uploadJqueryForm(){
    $('#result').html('');
 
   $("#form1").ajaxForm({
    success:function(data) { 
          $('#result').html(data);
     },
     dataType:"text"
   }).submit();
}

//using FormData() object
function uploadFormData(){
    $('#result').html('');
 
  var oMyForm = new FormData();
  oMyForm.append("file", file2.files[0]);
 
  $.ajax({	  
    url: 'http://localhost:8080/iouned/rest/controller/upload',
    data: oMyForm,
    dataType: 'text',
    processData: false,
    contentType: false,
    type: 'POST',
    success: function(data){
      $('#result').html(data);
    }
  });
}