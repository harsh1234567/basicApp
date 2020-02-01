package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		
		response.getWriter().append("Hello world")/*.append(request.getContextPath())*/;
        String email=request.getParameter("email");
        String password=request.getParameter("password");

        String firstname=request.getParameter("firstname");
        System.out.println("email:::"+email+"password::"+password+"firstname::"+firstname);
	    request.setAttribute("email", email);
	    request.setAttribute("password", password);
	    request.setAttribute("firstname", firstname);
	    
        request.getRequestDispatcher("/showUser.jsp").forward(request, response);

  
         //    System.out.println("hello world");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
