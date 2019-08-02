package p1;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Transfil
 */
public class Transfil implements Filter {

    /**
     * Default constructor. 
     */
    public Transfil() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String temp1=request.getParameter("acno");
		String temp2=request.getParameter("cacno");
		
		if(temp1.length()!=0)
		{
		 if(temp1.equals(temp2))
		{
		chain.doFilter(request, response);
		}
		else
			((HttpServletResponse)response).sendRedirect("/bankproject/transerr.html");
		 
		}
		else
			((HttpServletResponse)response).sendRedirect("/bankproject/transerr.html");
	}


	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
