package com.swarmhraut.utilities;
public class TestConfig{


	 public static String mailServer = "smtp.gmail.com";
	    public static String port = "587";
	    public static String from = "dumbala.naveenreddy@gmail.com";
	    // Paste your app password here WITHOUT spaces
	    public static String password = "cdphwvjvhjoqgyfs";
	    public static String[] to = {
	        "keerthi@swarmhr.com",
	        "manasa@swarmhr.com",
	        "naveen.dumbala@swarmhr.com"
	    };
	    public static String subject = "SwarmHR Automation Project Report";
	    public static String messageBody = "SwarmHR_Automation_Testing_Report";
	public static String attachmentPath="c:\\screenshot\\2017_10_3_14_49_9.jpg";
	public static String attachmentName="error.jpg";
	
	
	
	//SQL DATABASE DETAILS	
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=monitor_eval"; 
	public static String dbUserName="sa"; 
	public static String dbPassword="$ql$!!1"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "selenium";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/acs";
	
	
	
	
	
	
	
	
	
}
