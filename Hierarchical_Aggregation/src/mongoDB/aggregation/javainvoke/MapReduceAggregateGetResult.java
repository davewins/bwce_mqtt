package mongoDB.aggregation.javainvoke;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.tibco.bw.palette.mongodb.runtime.javaobject.MongoDBConnectionAccessor;

public class MapReduceAggregateGetResult {
	public static String invoke(Object is, String collectionName) throws Exception {
		
		final MongoDatabase database = ((MongoDBConnectionAccessor)is).getDatabase();
		
		try {
			MongoCollection<Document> collection  = database.getCollection(collectionName);
			Document object = collection.find(Document.parse("{_id :'Julia'}")).first();
			
			if(object != null){
				return object.toString();
			}else{
				return "No matching document";
			}
		}
		finally {
		}
	}
}
