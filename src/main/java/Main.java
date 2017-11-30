import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.descending;

import org.bson.Document;
import org.json.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase database = client.getDatabase("logDB");
        MongoCollection<Document> collection = database.getCollection("logs");

        MongoQ query = new MongoQ(database, collection);

//        System.out.println();
//        Set<String> ipByUrl = query.getIpByUrl("www.ukr.net");
//        System.out.println(ipByUrl);
//        Set<String> urlByIp = query.getUrlByIp("116.98.162.185");
//        System.out.println(urlByIp);
//        Set<String> urlByTime = query.getUrlByTime("12:00:00 01.01.1970", "12:00:00 01.03.2017");
//        System.out.println(urlByTime);
//        printResponse(query.getTopUrlBySumDuration());
//        printResponse(query.getTopUrlByVisit());
//        printResponse(query.getTopUrlPerPeriod("12:00:00 01.01.2017", "12:00:00 01.06.2017"));
//        printResponse(query.getTopIpByVisitAndDuration());

        System.out.println(collection.count());
//        Convert.csvToDB("./src/main/java/log.csv", collection);
    }

    public static void printResponse(Iterator<Document> response){
        while (response.hasNext()) {
            System.out.println(response.next().toJson());
        }
    }






}
