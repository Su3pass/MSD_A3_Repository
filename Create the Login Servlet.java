java
复制代码
	import javax.servlet.*;  

	import javax.servlet.http.*;  

	import javax.sql.*;  

	import java.io.*;  

	import java.sql.*;  

	  

	public class LoginServlet extends HttpServlet {  

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  

	        String username = request.getParameter("username");  

	        String password = request.getParameter("password");  

	  

	        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "")) {  

	            Statement stmt = conn.createStatement();  

	            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";  

	            PreparedStatement pstmt = conn.prepareStatement(sql);  

	            pstmt.setString(1, username);  

	            pstmt.setString(2, password);  

	            ResultSet rs = pstmt.executeQuery();  

	  

	            if (rs.next()) {  

	                HttpSession session = request.getSession();  

	                session.setAttribute("username", username);  

	                response.sendRedirect("welcome.jsp");  

	            } else {  

	                response.sendRedirect("login.jsp?error=true");  

	            }  

	        } catch (SQLException e) {  

	            e.printStackTrace();  

	            response.getWriter().println("Error logging in user: " + e.getMessage());  

	        }  

	    }  

	}