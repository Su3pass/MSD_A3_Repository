java
	import javax.servlet.*;  

	import javax.servlet.http.*;  

	import javax.sql.*;  

	import java.io.*;  

	import java.sql.*;  

	  

	public class RegisterServlet extends HttpServlet {  

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  

	        String username = request.getParameter("username");  

	        String password = request.getParameter("password");  

	  

	        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "")) {  

	            Statement stmt = conn.createStatement();  

	            String sql = "CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(50) UNIQUE, password VARCHAR(50))";  

	            stmt.execute(sql);  

	  

	            sql = "INSERT INTO users (username, password) VALUES (?, ?)";  

	            PreparedStatement pstmt = conn.prepareStatement(sql);  

	            pstmt.setString(1, username);  

	            pstmt.setString(2, password);  

	            pstmt.executeUpdate();  

	  

	            response.sendRedirect("login.jsp");  

	        } catch (SQLException e) {  

	            e.printStackTrace();  

	            response.getWriter().println("Error registering user: " + e.getMessage());  

	        }  

	    }  

	}