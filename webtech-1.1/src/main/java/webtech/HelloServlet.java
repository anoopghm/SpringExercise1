package webtech;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class firstweb
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet doGet Called!");
	//	doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("do post called ...");
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		
		System.out.println("Username: "+uname+"\nPassword: "+upass);
		
		ServletContext application = request.getServletContext();
		application.setAttribute(upass, application);
		if(uname.equals("ramu")) {
			response.sendRedirect("welcome.jsp");
			//RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
		//	rd.forward(request, response);
		}
		else {
//			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
//			rd.forward(request, response);
			response.sendRedirect("register.jsp");
		}
	}
}
