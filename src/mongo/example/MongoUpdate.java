/**
 * @author : Harshit Sharma
 */

package mongo.example;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.Iterator;

public class MongoUpdate
{
	private static final String HOST = "localhost";
	private static final int PORT = 27017;
	private static final String DATABASE_NAME = "foobar";
	private static final String COLLECTION_NAME  = "blog";

	public static void main(String[] args)
	{
		// mongo client
		MongoClient mongoClient = new MongoClient(HOST,PORT);

		//
		MongoDatabase mongoDatabase = mongoClient.getDatabase(DATABASE_NAME);

		//
		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(COLLECTION_NAME);

		//
		UpdateResult updateResult = mongoCollection.updateOne(Filters.eq("name","Harshit"),new Document("$set", new Document("fname", "dumbb")));

		System.out.println(updateResult.getModifiedCount());

		//
		FindIterable<Document> findIterable = mongoCollection.find();

		Iterator<Document> iterator = findIterable.iterator();

		while (iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
}
