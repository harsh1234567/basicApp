package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.UserEntity;
public class DaoImpl {
   
	  
	  public static List<UserEntity> getData(Connection connection ){
		  
		  List<UserEntity> ls=new ArrayList<UserEntity>();
		  try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(Query.select);
			    while (resultSet.next()) {
					 UserEntity us=new UserEntity(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),"");
				     ls.add(us);
                }
          	   } catch (SQLException e) {
			    	e.printStackTrace();
			  }
          return ls;
	
		    
		  
		 
		 
	 }
}
