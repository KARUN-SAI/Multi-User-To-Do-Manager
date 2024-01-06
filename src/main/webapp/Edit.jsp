<%@page import="com.Todo.Entity"%>
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
<%response.setHeader("Cache-control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("uname")==null){
	response.sendRedirect("Login.jsp");
} %>
<%@include file="navbar.jsp" %><br></br>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
					<div class="card">
						<div class="card-body">
						
						
						<% if(session.getAttribute("uname")==null){
							response.sendRedirect("Login.jsp");
						}  
						int i=Integer.parseInt(request.getParameter("id"));
						 String uname=request.getParameter("uname");
							LoginDao dao=new LoginDao();
							dao.connect();
							Entity t=dao.UpdateTodo(i,uname);
							
						%>
<form action ="Update?id=<%=t.getId()%>" method="post">
	<input type="Hidden" name="uname" value="<%=uname %>">
  <div class="mb-3">
    <label for="exampleInputEmail1" >Todo Name</label>
    <input type="text" class="form-control" value="<%=t.getTname()%> " name="tname"
   	  placeholder="Enter Name">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" >Todo description</label>
    <input type="text" class="form-control" value="<%=t.getTdes()%>" name="tdes"  
    	placeholder="Enter Name">
  </div>
 <div class="mb-3">
      <label for="inputState" class="form-label">Status</label>
      <select  class="form-select"  name="tstatus"  >
      <% if("Pending".equals(t.getTstatus())){%>
    	  <option value="Pending">Pending</option>
    	  <option value="complete">complete</option>
      
      <%}else{%>
    	   <option value="Pending">pending</option>
        <option value="complete">complete</option>
      <%}
      %>
       
      </select>
    </div>
  <div class="text-center">
  <button type="submit" class="btn btn-success">Update</button></div>
</form>
						</div>
					</div>
			</div>

		</div>
	</div>	

</body>
</html>