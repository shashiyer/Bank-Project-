package com.candidjava;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

@WebServlet("/delete_usr")

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			int custid = Integer.parseInt(request.getParameter("custid"));
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root", "root");
			Class.forName("com.mysql.jdbc.Driver");
			PreparedStatement ps = con.prepareStatement("delete from cust_register where custid=?");
			ps.setInt(1, custid);
			ps.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
