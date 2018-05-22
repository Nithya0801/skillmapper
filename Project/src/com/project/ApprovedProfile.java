package com.project;

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApprovedProfile
 */
@WebServlet("/ApprovedProfile")
public class ApprovedProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApprovedProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet invoked");
		String value[]=request.getParameterValues("approve");
		for(int i=0;i<value.length;i++)
			System.out.println(value[i]);
		int approved[] = new int[value.length],updated=0;
		for(int i=0;i<value.length;i++)
			approved[i]=Integer.parseInt(value[i]);
		PrintWriter displayMsg=response.getWriter();
		for(int i=0;i<value.length;i++)
		System.out.println(approved[i]);
		try
		{
			Class.forName("org.h2.Driver");
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/sample__db","sa","");
			Statement st=con.createStatement();
			for(int i=0;i<approved.length;i++)
			{
				updated=st.executeUpdate("update skill set approve='A' where sid="+approved[i]);
				System.out.println(updated);
			}
			
			
			if(updated!=0)
			{
				request.getRequestDispatcher("ApproveProfile.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
