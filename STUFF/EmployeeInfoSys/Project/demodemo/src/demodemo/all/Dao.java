package demodemo.all;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://yitrng11dt:3306/employeeinformationsystem";
	private static final String USERNAME = "EmpInfo";
	private static final String PASSWORD = "yash@03";
	Connection connection = null;
	List<String> listSkill = new ArrayList<>();
	List<String> listSkillEfficiency = new ArrayList<>();

	public List<String> fetchSkill() {

		try

		{
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ResultSet resultSet = connection.prepareStatement("SELECT * FROM SKILL").executeQuery();
			while (resultSet.next()) {
				listSkill.add(resultSet.getString(2));
			}
		} catch (Exception e) {

			System.out.println("HELLO");
			
			e.printStackTrace();
		}
		return listSkill;
	}
	
	public List<String> fetchSkillEfficiency(){
		
		try

		{
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ResultSet resultSet = connection.prepareStatement("SELECT * FROM SKILLEFFICIENCY").executeQuery();
			while (resultSet.next()) {
				listSkillEfficiency.add(resultSet.getString("efficiencyType"));
				
			}
		} catch (Exception e) {

			System.out.println("HELLO");
			
			e.printStackTrace();
		}
		return listSkillEfficiency;
	}

}