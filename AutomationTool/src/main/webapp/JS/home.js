/**
 * 
 */



function myFunction() {   

   window.location.replace('downloadFile/'+$("#projectName option:selected").text());
  
}

function uploadedFileName() {   

	   $("#fileName").val($("#projectName option:selected").text());
	  
}