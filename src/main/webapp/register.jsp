<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body style="background-image: url('welcome page.jpg')">
<br></br>
	<h2 class ="text-center">User Register Form...</h2><br></br>
<div  class="container" >

	<div class="row">
			<div class="col-md-6 offset-md-3">
					<div class="card">
						<div class="card-body">
	<!-- <div class="col-md-6 col-md-offset-3"> -->
		<div class="alert alert-success center" role="alert">
			<p> ${register} </p>
		</div>
		
		<form action="Register" >
		
		<div class="form-group">
		<label for="uname">First Name:</label><input type="text"
		class="form-control" id="uname" placeholder="First Name"
		name="first Name" required>
		</div>
		
		<div class="form-group">
		<label for="uname">Last Name:</label><input type="text"
		class="form-control" id="uname" placeholder="Last Name"
		name="Last Name" required>
		</div>
		<div class="form-group">
		<label for="uname">User Name:</label><input type="text"
		class="form-control" id="uname" placeholder="User Name"
		name="User Name" required>
		</div>
		
		<div class="form-group">
		<label for="uname">Password:</label><input type="password"
		class="form-control" id="uname" placeholder="Password"
		name="Password" required>
		</div>
		<br>
		
	<div style="text-align:center"><button type=" submit" class ="btn btn-primary"> Register</button></div>
	
		</form>
		<form action="Home.jsp">
		<button type=" submit" class ="btn btn-primary"> Back</button></form>
		</div>
		</div>
		<!-- </div> -->
		</div>
		</div>
</div>

</body>
</html>