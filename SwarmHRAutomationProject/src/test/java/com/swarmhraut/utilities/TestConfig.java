package com.swarmhraut.utilities;
public class TestConfig{


	
	public static String server="smtp.gmail.com";
	public static String POPserver="pop.gmail.com:995";
	public static String port="465";
	public static String domain="gmail.com";
	public static String from = "swarmhrqa@gmail.com";
	public static String password = "Swarmhr@891";
	public static String authentication="plain";
	public static String[] to ={"dumbala.naveenreddy@gmail.com","swarmhrtestmail@gmail.com","sreekanthgara0001@gmail.com","naveen.dumbala@swarmhr.com","sreekanth@swarmhr.com"};
	public static String subject = "SwarmHR Extent Project Report";
	
	public static String messageBody ="TestMessage";
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
