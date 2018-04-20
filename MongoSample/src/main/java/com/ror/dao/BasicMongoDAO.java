package com.ror.dao;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.ror.connection.GetMongoDBConnection;
import com.ror.vo.User;

public class BasicMongoDAO {
	private static String DATABASE_NAME = "ror";
	private static String COLLECTION_NAME = "users";
	private static MongoDatabase mongoDatabase = null;
	private static MongoCollection<Document> mongoCollection = null;
	private static Gson gson = new Gson();

	public static void insertUserObjectIntoDB(String key,User user) {
		mongoDatabase = GetMongoDBConnection.client.getDatabase(DATABASE_NAME);
		mongoCollection = mongoDatabase.getCollection(COLLECTION_NAME);
		String userJSON = gson.toJson(user);
		Document document = new Document();
		document.append(key, userJSON);
		mongoCollection.insertOne(document);
	}

	public static User getUserObject(String key) {
		FindIterable<Document> findIterable = mongoCollection.find();
		User user = null;
		for (Document document1 : findIterable) {
			if (document1.containsKey(key)) {
				user = gson.fromJson((String) document1.get(key), User.class);
			}
		}
		return user;
	}
}
