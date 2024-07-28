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
@WebServlet("/update")
public class updateservlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	String branch =req.getParameter("branch");
	String pinno=req.getParameter("pinno");
	studentmodel std=new studentmodel(name,email,branch,pinno);
	studentservice service=new studentservice(studentdb.conn());
	boolean f=service.updatestu(std);
	if(f)
	{
		resp.sendRedirect("welcome.jsp");
	}
	else
	{
		resp.sendRedirect("welcome.jsp");
	}
}
}
