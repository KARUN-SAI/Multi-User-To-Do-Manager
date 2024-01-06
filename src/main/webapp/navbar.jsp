<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="css_all.jsp" %>
</head>

<body  style="background-image: url('image.jpg')">


<nav class="navbar navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="TodoHome.jsp">MY TODO</a>
    <a class="navbar-brand"aria-current="page" href="Addtodo.jsp">Add Todo</a> 
    <form class="d-flex" action="Login.jsp">
     
      <button class="btn btn-outline-success" type="submit">Logout</button>
    </form>
  </div>
</nav>
</body>
</html>