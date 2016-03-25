import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet3")
public class Looping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Preprocess request: we actually don't need to do any business stuff, so just display JSP.
	        request.getRequestDispatcher("/hello.jsp").forward(request, response);
	    }

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Postprocess request: gather and validate submitted data and display the result in the same JSP.

	        // Prepare messages.
	    	
//	    	Map<String, String> title1 = new HashMap<String, String>();
//	        request.setAttribute("title", title1);
 
	      String title1 = "";
	      String author = "";
	    		Connection con = null;
	    		Statement stmt = null;
	    		ResultSet rs = null;
	    		String sql = "select * from bookdata";
	    		try{
	    			Class.forName("oracle.jdbc.driver.OracleDriver");
	    			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
	    			stmt = con.createStatement();
	    			rs = stmt.executeQuery(sql);
	    			while(rs.next()){
	    				title1 += "<tr><td>"+rs.getString(1)+"</td>"+"<td>"+rs.getString(3)+"</td>"+"<td>"+rs.getString(5)+"</td></tr>";
	    				
	    				
	    			}
	    			
	    			
	    			}catch (SQLException e) {
	    				e.printStackTrace();
	    			}catch (ClassNotFoundException e) {
	    				e.printStackTrace();
	    		} finally {
	    			try {
	    				rs.close();
	    				stmt.close();
	    				con.close();
	    			}catch(SQLException e){
	    				e.printStackTrace();
	    			}
	    		}
	    	
	    		 request.setAttribute("title1", title1);
	  
	        request.getRequestDispatcher("/customer.jsp").forward(request, response);
	    }
}
