import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class TestConnection {
	private static String DATABASE_NAME = "ror";
	private static String COLLECTION_NAME = "users";

	public static void main(String[] args) {
		MongoClientURI uri = new MongoClientURI("mongodb://akash:akash@ds249269.mlab.com:49269/ror");
		MongoClient client = new MongoClient(uri);
		User user = new User(574365, "akash");
		Gson gson = new Gson();
		MongoDatabase mongoDatabase = client.getDatabase(DATABASE_NAME);
		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(COLLECTION_NAME);
		String userJSON = gson.toJson(user);
		System.out.println(userJSON);
		Document document = new Document();
		document.append("user1", userJSON);
		mongoCollection.insertOne(document);
		FindIterable<Document> findIterable = mongoCollection.find();
		for (Document document1 : findIterable) {
			System.out.println(document1);
		}
	}
}

class User {
	int id;
	String name;

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
