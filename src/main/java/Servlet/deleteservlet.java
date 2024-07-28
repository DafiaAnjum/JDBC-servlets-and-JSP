package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dbconnection.studentdb;
import Services.studentservice;
@WebServlet("/delete")
public class deleteservlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String pinno=req.getParameter("pinno");
	studentservice service=new studentservice(studentdb.conn());
	boolean f=service.deletestudent(pinno);
	if(f)
	{
		System.out.println("Deletion successful for pinno: "+pinno);
		resp.sendRedirect("welcome.jsp");
	}
	else
	{
		System.out.println("Deletion failed for pinno: "+pinno);
		resp.sendRedirect("welcome.jsp");
	}
}
}
