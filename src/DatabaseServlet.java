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
@WebServlet("/HelloServlet2")
public class DatabaseServlet extends HttpServlet {
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
 
	      String title = "";
	    		Connection con = null;
	    		Statement stmt = null;
	    		ResultSet rs = null;
	    		String sql = "select title and author from bookdata where sku = '18152568'";
	    		try{
	    			Class.forName("oracle.jdbc.driver.OracleDriver");
	    			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
	    			stmt = con.createStatement();
	    			rs = stmt.executeQuery(sql);
	    			while(rs.next()){
	    				title = rs.getString(1);
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
	    	
	    		 request.setAttribute("title", title);
	    	
	    		 
	        request.getRequestDispatcher("/customer.jsp").forward(request, response);
	    }
}
