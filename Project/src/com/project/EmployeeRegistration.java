package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeRegistration
 */
@WebServlet("/EmployeeRegistration")
public class EmployeeRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String dob=request.getParameter("dob");
		String gender=request.getParameter("gender");
		String addr=request.getParameter("addr");
		String mail=request.getParameter("mail");
		String password=request.getParameter("pwd");
		
		
		String mobile_no=request.getParameter("ph");
		
		String qualification=request.getParameter("qua");
		String doj=request.getParameter("doj");
		
		int count=0;
		String role=request.getParameter("desg");
		
		Map errorMsg=new HashMap();
		
		if(name.equals(""))
			errorMsg.put("name", "Name Field can't be empty");
		else if(!(name.matches("[a-zA-Z]+")))
			errorMsg.put("name", "Name Field contains only Characters");
		
		if(dob.equals(""))
			errorMsg.put("dob", "DOB Fields can't be empty");
		
		if(addr.equals(""))
			errorMsg.put("addr","Address Fields can't be empty");
		
		if(mail.equals(""))
			errorMsg.put("mail", "Mail Fields can't be empty");
		else if(!(mail.matches("\\S{5,}@((gmail)|(yahoo))\\.com")))
			errorMsg.put("mail", "Mail Format is incorrect minimum 5 characters");
		
		if(password.equals(""))
			errorMsg.put("password","Password Fields can't be empty");
		else if(!(password.matches("[a-zA-Z0-9]{5,}")))
			errorMsg.put("password","Password should contain atleast 5 characters");
		
		if(mobile_no.equals(""))
			errorMsg.put("mobile", "Mobile No can't be empty");
		else if(!(mobile_no.matches("[987]\\d{9}")))
			errorMsg.put("mobile","Mobile Number should begins with 9 or 8 or 7 and contain 10 characters");
		
		if(doj.equals(""))
			errorMsg.put("doj", "DOJ Fields can't be empty");
		Long phone_no;
		
		if(errorMsg.isEmpty())
		{
			try
			{
			 java.sql.Date date = new java.sql.Date(0000-00-00);
				Class.forName("org.h2.Driver");
				Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/sample__db","sa","");
				PreparedStatement prepareStatement=con.prepareStatement("insert into emp_register(ename,dob,gender,address,mail,password,phno,qua,doj,desgn) values(?,?,?,?,?,?,?,?,?,?)");
				prepareStatement.setString(1,name);
				prepareStatement.setDate(2, date.valueOf(dob));
				//ps.setDate(3,date.valueOf(dob));
				prepareStatement.setString(3,gender);
				prepareStatement.setString(4, addr);
				prepareStatement.setString(5, mail);
							
				phone_no=Long.parseLong(mobile_no);
				prepareStatement.setString(6, password);
				prepareStatement.setLong(7, phone_no);
				prepareStatement.setString(8, qualification);
				prepareStatement.setDate(9, date.valueOf(doj));
				prepareStatement.setString(10, role);
				
				prepareStatement.executeUpdate();
				
				response.sendRedirect("ThankPage.jsp");
			}
			catch(Exception e){}
		}
		else
		{
			request.setAttribute("errobj", errorMsg);
			request.getRequestDispatcher("Register.jsp").forward(request, response);
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
