<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body style="background-image: url('welcome page.jpg')">
 <div class="container text-center mt-5">
        <h1>Welcome to Our Website</h1>
        <div class="mt-4">
        <form action="Login.jsp">
            <button type="submit"  class="btn btn-primary btn-lg" >Login</button>
            
       </form><br><br>
       <form action="register.jsp">
       <button type="submit" class="btn btn-success btn-lg">Register</button>
       </form>
        </div>
    </div>

</body>
</html>