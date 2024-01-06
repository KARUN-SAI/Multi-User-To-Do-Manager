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
String uname=session.getAttribute("uname").toString();
    if(session.getAttribute("uname")==null){
    	response.sendRedirect("Login.jsp");
    	
    }
   
    %>
<%@include file="navbar.jsp" %><br></br>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
					<div class="card">
						<div class="card-body">
						<form action ="Addtodo">
						 <input type="hidden" name="uname" value="<%=uname%>">
  <div class="mb-3">
    <label for="exampleInputEmail1" >Todo Name</label>
    <input type="text" class="form-control" name="tname" id="todo name" 
   	placeholder="Enter Name">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" >Todo description</label>
    <input type="text" class="form-control" name="tdes" id="todo description"
    	placeholder="Enter Name">
  </div>
 <div class="mb-3">
      <label for="disabledSelect" class="form-label" >Status</label>
      <select id="disabledSelect" class="form-select" name="tstatus">
       <option selected>--Select--</option>
        <option>complete</option>
        <option>Pending</option>
      </select>
    </div>
  <div class="text-center">
  <button type="submit" class="btn btn-success">Add</button></div>
</form>
						</div>
					</div>
			</div>

		</div>
	</div>	

</body>
</html>