<%@page import="com.Todo.Entity"%>
<%@page import="java.util.List"%>
<%@page import="com.Dao.LoginDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="css_all.jsp" %>
</head>
<body>
<%
response.setHeader("Cache-control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("uname")==null){
	response.sendRedirect("Login.jsp");
} 
%>
<%@include file="navbar.jsp" %><br></br>
<div class="container">
<table class="table table-bordered border-primary">
  <thead>
    <tr>
    <th class="d-none" scope="col">id</th>
     <th scope="col" > ** </th>
      <th scope="col">Todo Name</th>
      <th scope="col">Todo description</th>
      <th scope="col">Status</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <%
  String uname=session.getAttribute("uname").toString();
  LoginDao l=new LoginDao();
  l.connect();
 /*  List<Entity> t=l.getTodo(); */
 List<Entity> todo=l.getTodo(uname);
 for(Entity t:todo){%>
	 
  <tr>
      <th class="d-none"  scope="row"><%=t.getId()%></th>
      <td> --></td>
      <td><%=t.getTname() %></td>
      <td><%=t.getTdes() %></td>
      <td><%=t.getTstatus() %></td>
      <td class="align-center">
      <a href="Edit.jsp?id=<%=t.getId() %>&uname=<%=uname%>" class= "btn btn-success">Edit</a>
      <a href="Delete?id=<%=t.getId() %>&uname=<%=uname%>" class="btn btn-danger">Delete</a>
    	</td>
      
    </tr>
    <%}%>
   
      
  </tbody>
</table>
</div>
</body>
</html>