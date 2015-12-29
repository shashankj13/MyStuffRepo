package ComponentsJSFDemo.src.com.yash.jsftraining.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
	
	  //1. Collect DB Information
    static String driverClassName="com.mysql.jdbc.Driver";
    static String url="jdbc:mysql://localhost/mydb";
    static String userName="root";
    static String password="root";
    static Connection con;
    /**
     * This method is used to connect the DB, all the exceptions are 
     * handled by the JVM
     */
    public static Connection connectDB()throws Exception{
        Class<?> c=Class.forName(driverClassName);
        c.newInstance();
        System.out.println("c = "+c);
        con=DriverManager.getConnection(url, userName, password);
        return con;        
    }
    
    /**
     * This method is common for all - this will perform 
     * Insertion, Deletion and Updation in tables
     */
    
    public static void update(String sql) throws Exception{
        PreparedStatement pst=con.prepareStatement(sql);
        pst.executeUpdate(); // not selecte statement, insertion, deletion, updation 
    }
    
    /**
     * This method is common for all- and will be returning the ResultSet 
     * object which will be received in ResultSet reference. 
     * 
     */
    public static ResultSet select(String sql){
        try{
        PreparedStatement pst=con.prepareStatement(sql);
        ResultSet rs=pst.executeQuery();
        return rs;
        }
        catch(Exception ex){
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
    
    /**
     * This method is used to disconnect the DB
     * 
     */
    public static void disconnectDB() throws Exception{
        con.close();
    }

}
