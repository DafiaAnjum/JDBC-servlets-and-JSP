package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import Models.studentmodel;

public class studentservice {
private Connection conn;

public studentservice(Connection conn) {
	super();
	this.conn = conn;
}

public boolean addstudent(studentmodel st)
{
boolean f= false;
try {
	String sql= "insert into student (pinno,name,email,branch) values(?,?,?,?)";
	PreparedStatement pmst = conn.prepareStatement(sql);
	pmst.setString(1, st.getPinno());
	pmst.setString(2, st.getName());
	pmst.setString(3, st.getEmail());
	pmst.setString(4, st.getBranch());
	int i=pmst.executeUpdate();
	if(i>0)
	{
		f=true;
	}
} catch (Exception e) {
	e.printStackTrace();
	
}
return f;
}
//fetching of data
public List<studentmodel> fetchall(){
	List<studentmodel> std=new ArrayList<studentmodel>();
	studentmodel s= null;
	try {
		String sql="select * from student";
		PreparedStatement pmst= conn.prepareStatement(sql);
		ResultSet rs= pmst.executeQuery();
		while(rs.next())
		{
			s=new studentmodel();
			s.setPinno(rs.getString(2));
			s.setName(rs.getString(3));
			s.setEmail(rs.getString(4));
			s.setBranch(rs.getString(5));
			std.add(s);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return std;
}
public boolean deletestudent(String pinno)
{
	boolean f=false;
	try {
		String sql="delete from student where pinno=?";
		PreparedStatement pmst=conn.prepareStatement(sql);
		pmst.setString(1, pinno);
		int i=pmst.executeUpdate();
		if(i==1)
		{
			f=true;
		}
	
	} catch (Exception e) {
		e.printStackTrace();
	}
	return f;
}
public boolean updatestu(studentmodel sm)
{
	boolean f=false;
	try {
		String sql="update student set name=?,email=?,branch=? where pinno=?";
		PreparedStatement pmst=conn.prepareStatement(sql);
		pmst.setString(1, sm.getName());
		pmst.setString(2, sm.getEmail());
		pmst.setString(3, sm.getBranch());
		pmst.setString(4, sm.getPinno());
		int i=pmst.executeUpdate();
		if(i==1)
		{
			f=true;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return f;
}
public studentmodel getbystu(String pinno)
{
	studentmodel s=null;
	try {
		String sql="select * from student where pinno=?";
		PreparedStatement pmst=conn.prepareStatement(sql);
		pmst.setString(1,pinno);
		ResultSet rs= pmst.executeQuery();
		while(rs.next()) {
			s=new studentmodel();
			s.setPinno(rs.getString(1));
			s.setName(rs.getString(2));
			s.setEmail(rs.getString(3));
			s.setBranch(rs.getString(4));
			
		}
	} catch (Exception e) {
	e.printStackTrace();
	}
	return s;
}
}
