package com.ror.test;

import com.ror.connection.GetMongoDBConnection;
import com.ror.dao.BasicMongoDAO;
import com.ror.vo.User;

public class TestMongoProject {

	public static void main(String[] args) {
		GetMongoDBConnection getMongoDBConnection = new GetMongoDBConnection();
		getMongoDBConnection.getConnection();
		BasicMongoDAO basicMongoDAO = new BasicMongoDAO();
		User user = new User(574365, "akash");
		String key = "user1";
		basicMongoDAO.insertUserObjectIntoDB(key, user);
		System.out.println(basicMongoDAO.getUserObject(key));
	}

}
