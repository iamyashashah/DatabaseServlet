<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Hello World</title>
<style>
.error {
	color: red;
}

.success {
	color: ${param.color
}
;
}
</style>

</head>
<body>
	<form action="HelloServlet2" method="post">
		<h1>Hello World</h1>
		<p>
			<input type="submit" class="form-control"> <span class="success">${title}</span>
		</p>
		</form>
		<form action="HelloServlet3" method="post">
		<p>
			<input type="submit" class="form-control"> <span class="success"><table border =1 class="table">${title1}</table></span>
		</p>
	</form>
	
</body>
</html>