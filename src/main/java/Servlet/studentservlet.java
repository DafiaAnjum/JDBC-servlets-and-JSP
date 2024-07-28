package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dbconnection.studentdb;
import Models.studentmodel;
import Services.studentservice;
@WebServlet("/register")
public class studentservlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String pinno=req.getParameter("PIN");
	String name=req.getParameter("NAME");
	String email=req.getParameter("EMAIL");
	String branch =req.getParameter("BRANCH");
	studentmodel stu=new studentmodel(pinno,name,email,branch);
	studentservice ser =new studentservice(studentdb.conn());
	boolean f=ser.addstudent(stu);
	if(f)
	{
		resp.sendRedirect("welcome.jsp");
	}
	else
	{
		resp.sendRedirect("error.jsp");
	}
}
}
