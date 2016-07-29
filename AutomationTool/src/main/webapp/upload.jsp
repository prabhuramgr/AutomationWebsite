<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

<title>Upload File Request Page</title>
<script>
	
</script>
</head>
<body>

	<script src="JS/home.js"></script>

<div class="jumbotron">
<div class = "container">

<%


%>



<h2>Copart Automation</h2>
  <p> Please Choose one of the following environments</p>
	<form method="POST" action="uploadFile" enctype="multipart/form-data">
		
			
			
			<table class="table">
			<thead>
				<tr class="info">
				
					<td>Choose Project</td>
					<td>Choose Environment</td>
					<td>Download Excel</td>
					<td>Upload Modified Excel</td>
					<td>Send Mail To</td>
					<td>Execute</td>
				
				</tr>
				</thead>

				<tr>
					<td><select class="form-control" id="projectName"> 
							<option value="G2Member">G2Member</option>
							<option value="M1Member">M1Member</option>
					</select></td>

					<td><select  class="form-control">
							<option value="Production">Production</option>
							<option value="QA">QA</option>
							<option value="Stage">Stage</option>
					</select></td>
					<td>
						<button type="button" class="btn btn-primary" onclick="myFunction()">Download
							Excel</button>
					</td>
					<td><input class="btn btn-primary" type="file" name="file">
					<input type="hidden" name="name" id="fileName" value="default">
					</td>
					<td><input type="text"  class="form-control" id="email" placeholder="email" name="email">
					</td>
					
					<td><input type="submit" class="btn btn-success" value="Execute" onclick="uploadedFileName()"></td>


				</tr>



			</table>
		
		

	</form>
	
    <iframe width="900 px" height="500 px" src="https://coparto365-my.sharepoint.com/personal/prabhu_ram_copart_com/_layouts/15/WopiFrame.aspx?sourcedoc=%7Bf7156f6f-1a1d-4bb4-9d9a-c9e5740b21ff%7D&action=embedview&wdAllowInteractivity=True&wdbipreview=True&wdDownloadButton=True"></iframe>
	
	</div></div>
	
	
</body>
</html>
