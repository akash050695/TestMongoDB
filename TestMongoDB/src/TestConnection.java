import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class TestConnection {
	public static void main(String[] args) {
		MongoClientURI uri = new MongoClientURI("mongodb://akash:akash@ds249269.mlab.com:49269/ror");
		MongoClient client = new MongoClient(uri);
		MongoDatabase mongoDatabase = client.getDatabase("ror");
		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("users");
		User user = new User(574365, "akash");
		Gson gson = new Gson();
		String userJSON = gson.toJson(user);
		Document document = new Document();
		mongoCollection.insertOne(document.parse(userJSON));
		FindIterable<Document> findIterable = mongoCollection.find();
		for (Document document1 : findIterable) {
			User user1 = gson.fromJson(document1.toJson(), User.class);
			System.out.println(user1);
		}
	}
}

class User extends Document {
	int id;
	String name;

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
