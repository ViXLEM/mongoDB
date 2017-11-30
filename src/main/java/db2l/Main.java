package db2l;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase database = client.getDatabase("logDB");
        MongoCollection<Document> collection = database.getCollection("logs");

        MongoQ query = new MongoQ(database, collection);
        System.out.println(getString(query.getTopIpByVisitAndDuration()));
    }

    public static String getString(Iterator<Document> response){
        String ret = "";
        while (response.hasNext()) {
            ret += response.next().toJson() + "\n";
        }
        return ret;
    }






}
