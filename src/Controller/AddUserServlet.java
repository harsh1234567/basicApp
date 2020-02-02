package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoImpl;
import Model.UserEntity;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*connection */
	private Connection connection;
	public void init(ServletConfig config) {
		try {
			ServletContext context = config.getServletContext();
			System.out.println("init()");
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(context.getInitParameter("dbUrl"),
					context.getInitParameter("dbUser"), context.getInitParameter("dbPassword"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

    /**
     * Default constructor. 
     */
    public AddUserServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Hello world")/*.append(request.getContextPath())*/;
        String email=request.getParameter("email");
        String password=request.getParameter("password");

        String firstname=request.getParameter("firstname");
        System.out.println("email:::"+email+"password::"+password+"firstname::"+firstname);
	    request.setAttribute("email", email);
	    request.setAttribute("password", password);
	    request.setAttribute("firstname`", firstname);
		int result=0;
		//CommonFeatures CommonFeatures;
		Statement statement;
		try {
			statement = connection.createStatement();
			result = statement.executeUpdate("insert into user values('" + firstname + "','" + firstname + "','"
					+email.substring(0,10) + "','" + password + "')");
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		String message=result>0?"user created":"not created";
        request.setAttribute("message",message);	
        List<UserEntity> ls=DaoImpl.getData(connection);
        request.setAttribute("list", ls);
        request.getRequestDispatcher("/showUser.jsp").forward(request, response);
 
       

	}

}
