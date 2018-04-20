package com.ror.connection;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class GetMongoDBConnection {
	public static MongoClient client = null;

	public static void getConnection() {
		MongoClientURI uri = new MongoClientURI("mongodb://akash:akash@ds249269.mlab.com:49269/ror");
		client = new MongoClient(uri);
	}
}
