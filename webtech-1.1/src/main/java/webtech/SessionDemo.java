package webtech;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class SessionDemo
 */
@WebServlet("/SessionDemo")
public class SessionDemo extends HttpServlet {
	int count=0;
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionDemo() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out=response.getOutputStream();
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		//only once and next time, it will retrive
		Object obj=session.getAttribute("counter");
		String encodeURl=response.encodeURL("SessionDemo");
		out.println("<br><a href='" + encodeURl+ "'>Click to refresh session</a></br>");
		
		Cookie cookie=new Cookie("myPassword","1234567");
		response.addCookie(cookie);
		
		Cookie cc[]=request.getCookies();
		for(Cookie ccs:cc) {
			System.out.println(ccs.getName());
		}

		if(obj==null) {
			out.println("<h1> Pehli baar swagat h </h1>");
		session.setAttribute("counter", ++count);
	  }
	else {
		int c = Integer.parseInt(obj.toString());
		out.println("<h1>Wapis aaye h aap welcome dobara" +c+ "times...</h1>");
		session.setAttribute("counter",++c);}
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
