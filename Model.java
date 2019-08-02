package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Model {
	private String name;
	private String accno;
	private String balance;
	private String custid;
	private String pass;
	private String email;
	String url="jdbc:oracle:thin:@//localhost:1521/XE";
	String un="system";
	String pw="system";
	Connection con=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	ResultSet res=null;
	ArrayList al=new ArrayList();
	ArrayList al1=new ArrayList();
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public String getAccno() {
		return accno;
	}
	public String getBalance() {
		return balance;
	}
	public String getCustid() {
		return custid;
	}
	public String getPass() {
		return pass;
	}
	public String getEmail() {
		return email;
	}
	Model()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver loaded");
			con=DriverManager.getConnection(url, un, pw);
			System.out.println("got connected");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean login()
	{
		try {
		String s="select * from BANK where CUSTID=? and PASS=?";
		pstmt=con.prepareStatement(s);
		pstmt.setString(1, custid);
		pstmt.setString(2, pass);
		res=pstmt.executeQuery();
		if(res.next()==true)
		{
			accno=res.getString(2);
			name=res.getString(1);
			return true;
		}
		else
			return false;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean cb()
	{
		try {
		String s="select * from BANK where ACCNO=?";
		pstmt=con.prepareStatement(s);
		pstmt.setString(1, accno);
		res=pstmt.executeQuery();
		if(res.next()==true)
		{
			balance=res.getString(3);
			
			return true;
		}
		else
			return false;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean change()
	{
		try {
		String s="update  BANK set PASS=? where ACCNO=?";
		pstmt=con.prepareStatement(s);
		pstmt.setString(1, pass);
		pstmt.setString(2, accno);
		int x=pstmt.executeUpdate();
		if(x!=0)
		{
			System.out.println(x);
			return true;
		}
		else
			return false;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean ckac()
	{
		try {
		String s="select * from BANK where ACCNO=?";
		pstmt=con.prepareStatement(s);
		pstmt.setString(1, accno);
		res=pstmt.executeQuery();
		if(res.next()==true)
		{
			balance=res.getString(3);
			
			return true;
		}
		else
			return false;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean curacc()
	{
		try {
		String s="select * from BANK where ACCNO=?";
		pstmt=con.prepareStatement(s);
		pstmt.setString(1, accno);
		res=pstmt.executeQuery();
		if(res.next()==true)
		{
			balance=res.getString(3);
			
			return true;
		}
		else
			return false;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean uptra()
	{
		try {
		String s="update  BANK set BALANCE=? where ACCNO=?";
		pstmt=con.prepareStatement(s);
		pstmt.setString(1, balance);
		pstmt.setString(2, accno);
		int x=pstmt.executeUpdate();
		if(x!=0)
		{
			return true;
		}
		else
			return false;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean upcur(String tram,String trac)
	{
		try {
		String s="update  BANK set BALANCE=? where ACCNO=?";
		pstmt=con.prepareStatement(s);
		pstmt.setString(1, balance);
		pstmt.setString(2, accno);
		int x=pstmt.executeUpdate();
		String s1="insert into bkst values(?,?,?)";
		pstmt1=con.prepareStatement(s1);
		pstmt1.setString(1, accno);
		pstmt1.setString(2, tram);
		pstmt1.setString(3, trac);
		pstmt1.executeUpdate();
		
		if(x!=0)
		{
			balance=res.getString(3);
			return true;
		}
		else
			return false;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public ArrayList getStmt()
	{
		try {
			String s="select * from bkst where ACCNO=?";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1, accno);
			res=pstmt.executeQuery();
			String temp=null;
			while(res.next()==true)
			{
				temp=res.getString(2);
				al.add(temp);
			}
			return al;
			
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	

}
	public ArrayList getStmt1()
	{
		try {
			String s="select * from bkst where ACCNO=?";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1, accno);
			res=pstmt.executeQuery();
			String temp=null;
			while(res.next()==true)
			{
				temp=res.getString(3);
				al1.add(temp);
			}
			return al1;
			
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al1;
	

}
}
