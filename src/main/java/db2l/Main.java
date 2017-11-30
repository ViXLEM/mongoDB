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

        System.out.println();
        Set<String> ipByUrl = query.getIpByUrl("www.ukr.net");
        System.out.println(ipByUrl);
        Set<String> urlByIp = query.getUrlByIp("116.98.162.185");
        System.out.println(urlByIp);
        Set<String> urlByTime = query.getUrlByTime("12:00:00 01.11.2017", "12:00:00 10.11.2017");
        System.out.println(urlByTime);
        System.out.println(getString(query.getTopUrlBySumDuration()));
        System.out.println(getString(query.getTopUrlByVisit()));
        System.out.println(getString(query.getTopUrlPerPeriod("12:00:00 01.11.2017", "00:00:00 05.11.2017")));
        System.out.println(getString(query.getTopIpByVisitAndDuration()));

        System.out.println(collection.count());
//        db2l.Convert.csvToDB("./log.csv", collection);
    }

    public static String getString(Iterator<Document> response){
        String ret = "";
        while (response.hasNext()) {
            ret += response.next().toJson() + "\n";
        }
        return ret;
    }






}
