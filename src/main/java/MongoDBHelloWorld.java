
import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import org.bson.Document;

public class MongoDBHelloWorld {
    public static void main(String[] args) {

            MongoClient client = new MongoClient("localhost", 27017);

            MongoDatabase database = client.getDatabase("hot");

            MongoCollection<Document>  collection = database.getCollection("players");
            Document myDoc = collection.find().first();
            MongoCursor<Document> cursor = collection.find().iterator();
            try {
               while (cursor.hasNext()) {
                   System.out.println(cursor.next().toJson());
                }
            } finally {
                cursor.close();
            }


            //
            // Prints out the document.
            //
            //System.out.println(myDoc.toJson());
            System.out.println(collection.count());

    }
}