package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Balance
 */
public class Balance extends HttpServlet
{
	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		try {
		HttpSession session=request.getSession();
		String accno=(String) session.getAttribute("ACCNO");
		Model m=new Model();
		m.setAccno(accno);
		boolean x=m.cb();
		if(x==true)
		{
			String bal=m.getBalance();
			session.setAttribute("BAL", bal);
			response.sendRedirect("/bankproject/bal.jsp");
		}
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


}
