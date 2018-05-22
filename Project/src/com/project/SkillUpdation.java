package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SkillUpdation
 */
@WebServlet("/SkillUpdation")
public class SkillUpdation extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public SkillUpdation() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int eid=Integer.parseInt(request.getParameter("eid"));
		String skill=request.getParameter("upgrade");
		int batch_handle=Integer.parseInt(request.getParameter("nobatch"));
		int student_handle=Integer.parseInt(request.getParameter("nostu"));
		int student_placed=Integer.parseInt(request.getParameter("nopla"));
		String voucher=request.getParameter("voucher");
		String proposed_desgn=request.getParameter("desgn");
		
		String multi_skill[] = null;
		int flag=0;
		
		Map error=new HashMap();
		
		if(eid==0)
			error.put("eid","Employee Id not be Zero");
		
		if(skill.equals(""))
			error.put("skill", "skill field can't be empty");
		
		if(batch_handle==0)
			error.put("batch_handle","Batch Handle not be Zero");
		
		if(student_handle==0)
			error.put("student_handle","Student Handle not be Zero");
		
		if(student_placed==0)
			error.put("student_placed","Student placed not be Zero");
		
		if(proposed_desgn.equals(""))
			error.put("desgn", "Designation can't be empty");
		if(!(skill.matches("\\S+,.*")))
		{
			flag=1;
			System.out.println("Regex Invoked!!!");
		}
		else
		{
			multi_skill=skill.split(",");
			System.out.println("Regex not Invoked!!!");
			for(int i=0;i<multi_skill.length;i++)
				System.out.println(multi_skill[i]);
		}
		
		
		
		PrintWriter displayObj=response.getWriter();
		
		displayObj.print("Flag : "+flag);
		
		
		try
		{
			Class.forName("org.h2.Driver");
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/sample__db","sa","");
			PreparedStatement skill_tab=null;
			
			 skill_tab=con.prepareStatement("insert into skill(sknown,interexam,eid) values(?,?,?)");
			
			ResultSet reterive=null;
			try
			{
			reterive=con.createStatement().executeQuery("select * from skill_master where eid="+eid);
			}
		
		catch(Exception e)
		{
			//displayObj.print("not  a valid");
			error.put("eid","Not in a database");
		}
			
			PreparedStatement skillmaster_tab;
			
			if(error.isEmpty())
			{
			if(reterive.next())
			{
				skillmaster_tab=con.prepareStatement("update skill_master set eid=?,nobatch=?,nostu=?,nostuplace=?,proposedesg=? where eid=?");
				if(flag==1)
				{
					skill_tab.setString(1,skill);
					skill_tab.setString(2,voucher);
					skill_tab.setInt(3, eid);
					skillmaster_tab.setInt(1, eid);
					skillmaster_tab.setInt(2, batch_handle);
					skillmaster_tab.setInt(3, student_handle);
					skillmaster_tab.setInt(4,student_placed);
					skillmaster_tab.setString(5, proposed_desgn);
					skillmaster_tab.setInt(6,eid);
					skill_tab.executeUpdate();
					skillmaster_tab.executeUpdate();
					
				}
				else
				{
					for(int i=0;i<multi_skill.length;i++)
					{
						skill_tab.setString(1,multi_skill[i]);
						skill_tab.setString(2,voucher);
						skill_tab.setInt(3, eid);
						
						skill_tab.executeUpdate();
						
					}
					skillmaster_tab.setInt(1, eid);
					skillmaster_tab.setInt(2, batch_handle);
					skillmaster_tab.setInt(3, student_handle);
					skillmaster_tab.setInt(4,student_placed);
					skillmaster_tab.setString(5, proposed_desgn);
					skillmaster_tab.setInt(6, eid);
					skillmaster_tab.executeUpdate();
				}
			
			
			}
			else
			{
				skillmaster_tab=con.prepareStatement("insert into skill_master(eid,nobatch,nostu,nostuplace,proposedesg) values(?,?,?,?,?)");
			
			
			if(flag==1)
			{
				skill_tab.setString(1,skill);
				skill_tab.setString(2,voucher);
				skill_tab.setInt(3, eid);
				skillmaster_tab.setInt(1, eid);
				skillmaster_tab.setInt(2, batch_handle);
				skillmaster_tab.setInt(3, student_handle);
				skillmaster_tab.setInt(4,student_placed);
				skillmaster_tab.setString(5, proposed_desgn);
				
				skill_tab.executeUpdate();
				skillmaster_tab.executeUpdate();
				
			}
			else
			{
				for(int i=0;i<multi_skill.length;i++)
				{
					skill_tab.setString(1,multi_skill[i]);
					skill_tab.setString(2,voucher);
					skill_tab.setInt(3, eid);
					
					skill_tab.executeUpdate();
					
				}
				skillmaster_tab.setInt(1, eid);
				skillmaster_tab.setInt(2, batch_handle);
				skillmaster_tab.setInt(3, student_handle);
				skillmaster_tab.setInt(4,student_placed);
				skillmaster_tab.setString(5, proposed_desgn);
				//skillmaster_tab.setInt(6, eid);
				skillmaster_tab.executeUpdate();
			}
			}
			RequestDispatcher rd=request.getRequestDispatcher("viewSkill.jsp");
			rd.forward(request, response);
		//	displayObj.println("Updated....");
	//		request.getRequestDispatcher("viewSkill.jsp").include(request,response);
		}
			else
			{
				request.setAttribute("error", error);
				RequestDispatcher rd=request.getRequestDispatcher("SkillUpdate.jsp");
				rd.forward(request, response);
			}
		}
		catch(Exception e){
			displayObj.println(e);
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
