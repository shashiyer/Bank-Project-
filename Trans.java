package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Trans
 */
public class Trans extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	{
	try {
		String trac=request.getParameter("acno");
		String tram=request.getParameter("amot");
		Model m=new Model();
		m.setAccno(trac);
		boolean status=m.ckac();
		if(status==true)
		{
				String bla=m.getBalance();
				HttpSession session=request.getSession();
				String sendacc=(String)session.getAttribute("ACCNO");
				m.setAccno(sendacc);
				boolean status1=m.curacc();
				if(status1==true)
				{
					String bla1=m.getBalance();
					int curbal=Integer.parseInt(bla1);
					int trabal=Integer.parseInt(bla);
					int tramt=Integer.parseInt(tram);
					if(curbal>=500)
					{
						if((curbal-tramt)>500)
						{
							curbal=curbal-tramt;
							trabal=trabal+tramt;
							String curbal1=Integer.toString(curbal);
							String trabal1=Integer.toString(trabal);
							 tram=Integer.toString(tramt);
							 m.setAccno(trac);
							 m.setBalance(trabal1);
							 boolean status2=m.uptra();
							 if(status2==false)
							 {
								 response.sendRedirect("/bankproject/trafail.html");
							 }
							 
							 m.setAccno(sendacc);
							 m.setBalance(curbal1);
							 boolean status3=m.upcur(tram,trac);
							 if(status3==true)
							 {
								session.setAttribute("currentbal", curbal1);
								 response.sendRedirect("/bankproject/trasuc.jsp");
							 }
							 else
								 response.sendRedirect("/bankproject/trafail.html");
						}
						else
							 response.sendRedirect("/bankproject/min.html");
					}
					else
						 response.sendRedirect("/bankproject/min.html");
				}
		}
		else 
			response.sendRedirect("/bankproject/nouser.html");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	}

			
					
						
							
								 
							 
							 
							 
						
					
					
				
				
				
				
		

