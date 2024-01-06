package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Todo.Entity;




public class LoginDao {
	String url="jdbc:mysql://localhost:3306/jstlldemo";
	String name="root";
	String password="Mysql@2002";
	Connection con=null;
//	Class.forName("com.mysql.jdbc.Driver");
//	Connection con=DriverManager.getConnection(url,name,password);
	  public void connect() throws Exception {
		  Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection(url, name, password);
	    }
	public boolean check(String uname,String upaas) throws Exception {
		
		
		String query="select * from Login where User_name=? and pass=?";
		
		
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, uname);
		st.setString(2, upaas);
		ResultSet rs=st.executeQuery();
		if(rs.next())
		{
			return true;
			
			
		}
		
		return false;
		
		
		
	}
	
	
	 public boolean opentable( String uname) throws SQLException {
		 
	 
	 String sql="select * from "+uname+";";
	 
	 PreparedStatement s=con.prepareStatement(sql);
	 ResultSet rs=s.executeQuery();
	 
	 while(rs.next()){
	
	 
	  
	 } return true;
	 }
	
	/*
	 * public boolean opentable(String uname) throws SQLException { String sql =
	 * "SELECT * FROM " + uname + ";"; try (PreparedStatement s =
	 * con.prepareStatement(sql)) { // No need to set any parameters for a SELECT
	 * query try (ResultSet resultSet = s.executeQuery()) { // Process the result
	 * set if needed while (resultSet.next()) { // Retrieve data from the result set
	 * // Example: String columnValue = resultSet.getString("columnName"); } } }
	 * return true; }
	 */
	
	
	public boolean Add(String fname,String lname,String uname,String pass)throws Exception {

		String query="insert into Login(first_name,last_name,User_name,pass)values(?,?,?,?)";
			
		
		
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1,fname);
		st.setString(2, lname);
		st.setString(3, uname);
		st.setString(4, pass);
		st.executeUpdate();
		return true;
		

			
		}
	
	 
	 public boolean Addtodo(String uname,String tname,String tdes,String tstatus) throws SQLException {
		 String query="insert into "+uname+"(tname,tdes,tstatus)values(?,?,?)";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, tname);
		st.setString(2, tdes);
		st.setString(3,tstatus);
		st.executeUpdate();
		return true;
		
		 
	 }
	 
	 public List<Entity> getTodo(String uname){
		 List<Entity> l=new ArrayList<Entity>();
		 Entity t=null;
		 String sql="select * from "+uname+";";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				t=new Entity();
				t.setId(rs.getInt(1));
				t.setTname(rs.getString(2));
				t.setTdes(rs.getString(3));
				t.setTstatus(rs.getString(4));
				l.add(t);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return l;
		 
	 }
	 
	 public Entity UpdateTodo(int i,String uname)
	 
	 {
		 Entity t=null;
		 
		 String sql="select *from "+uname+" where id=?";
		 
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				t=new Entity();
				t.setId(rs.getInt(1));
				t.setTname(rs.getString(2));
				t.setTdes(rs.getString(3));
				t.setTstatus(rs.getString(4));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
		
		 
	 }
	 public boolean Update(String uname,int i,String tname,String tdes,String tstatus) throws SQLException {
		 String query="UPDATE "+uname+" SET tname = ?, tdes = ?, tstatus=? WHERE id=?;";
			PreparedStatement st=con.prepareStatement(query);
			st.setString(1, tname);
			st.setString(2, tdes);
			st.setString(3,tstatus);
			st.setInt(4, i);
			st.executeUpdate();
			return true;
		 
	 }
	 
	 public boolean Delete(int i,String uname) throws SQLException {
		 String query="Delete FROM "+uname+" WHERE id=?; ";
		 PreparedStatement st=con.prepareStatement(query);
		 st.setInt(1, i);
		st.executeUpdate();
		 
		return true;
		 
	 }
	 
		/*
		 * public boolean CreateTable(String uname) throws SQLException { String
		 * query="CREATE TABLE "+ uname
		 * +"( id  INT NOT NULL AUTO_INCREMENT ,tname varchar(45) ,tdes varchar(45) ,tstatus varchar(45), PRIMARY KEY (`id`));"
		 * ; PreparedStatement st=con.prepareStatement(query); st.setString(1, uname);
		 * st.execute(); return true;
		 * 
		 * }
		 */
	 
	 public boolean CreateTable(String uname) throws SQLException {
		   
		    if (!isValidTableName(uname)) {
		       
		        return false;
		    }

		    String query = "CREATE TABLE " + uname + " (id INT NOT NULL AUTO_INCREMENT, tname varchar(45), tdes varchar(45), tstatus varchar(45), PRIMARY KEY (`id`));";
		    try (PreparedStatement st = con.prepareStatement(query)) {
		        st.execute();
		        return true;
		    }
		}

		private boolean isValidTableName(String tableName) {
		   
		    return tableName.matches("[a-zA-Z_][a-zA-Z0-9_]*");
		}

	
	
		 
	 
	 
	 public void close() throws Exception {
	        if (con != null) {
	            con.close();
	        }
	    }
	
	
		
	}

