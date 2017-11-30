import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import db2l.Convert;
import db2l.MongoQ;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;


public class MongoQTest {
    private MongoDatabase database = null;
    private MongoCollection<Document> collection = null;
    private MongoQ query = null;

    @Before
    public void before() {
        MongoClient client = new MongoClient("localhost", 27017);
        this.database = client.getDatabase("logDB");
        this.collection = database.getCollection("logs");

        this.query = new MongoQ(database, collection);
        Bson condition = new Document("$gt", "");
        Bson filter = new Document("url", condition);
        collection.deleteMany(filter);
        Convert.csvToDB("log.csv", collection);
    }

    @Test
    public void getIpByUrl() throws Exception {
        Set<String> exepted = new HashSet<String>();
        exepted.add("203.109.18.227");
        exepted.add("49.45.122.245");
        exepted.add("120.86.157.41");
        exepted.add("20.118.36.236");
        exepted.add("237.17.1.10");
        Assert.assertEquals(query.getIpByUrl("www.ukr.net"), exepted);
    }

    @Test
    public void getUrlByIp() throws Exception {
        Set<String> exepted = new HashSet<String>();
        exepted.add("www.ukr.net");
        exepted.add("ua.sinoptik.ua");
        exepted.add("www.instagram.com");
        exepted.add("www.olx.ua");
        exepted.add("www.vk.com");
        Assert.assertEquals(query.getUrlByIp("120.86.157.41"), exepted);
    }
    @Test
    public void getUrlByTime() throws Exception {
        Set<String> exepted = new HashSet<String>();
        exepted.add("www.facebook.com");
        exepted.add("www.privatbank.ua");
        exepted.add("www.google.com");
        exepted.add("www.youtube.com");
        exepted.add("www.vk.com");
        Assert.assertEquals(query.getUrlByTime("12:00:00 01.11.2017", "00:00:00 3.11.2017"), exepted);
    }

    @Test
    public void getTopUrlBySumDuration() throws Exception {
        ArrayList<Document> topList = toArrayList(query.getTopUrlBySumDuration());
        Assert.assertEquals(topList.get(0).get("_id"), "www.vk.com");
        Assert.assertEquals(topList.get(0).get("value"), 8174.0);
    }

    @Test
    public void getTopUrlByVisit() throws Exception {
        ArrayList<Document> topList = toArrayList(query.getTopUrlByVisit());
        Assert.assertEquals(topList.get(0).get("_id"), "www.vk.com");
        Assert.assertEquals(topList.get(0).get("value"), 15.0);
    }

    @Test
    public void getTopUrlPerPeriod() throws Exception {
        ArrayList<Document> topList = toArrayList(query.getTopUrlPerPeriod("12:00:00 01.11.2017", "00:00:00 05.11.2017"));
        Assert.assertEquals(topList.get(1).get("_id"), "www.aliexpress.com");
        Assert.assertEquals(topList.get(1).get("value"), 3.0);
    }

    @Test
    public void getTopIpByVisitAndDuration() throws Exception {
        ArrayList<Document> topList = toArrayList(query.getTopIpByVisitAndDuration());
        Assert.assertEquals(topList.get(1).get("_id"), "237.17.1.10");
        Assert.assertEquals(topList.get(1).get("value"), new Document("count", 13.0).append("duration", 8048.0));
    }

    private ArrayList<Document> toArrayList(Iterator<Document> documentFindIterable) {
        ArrayList<Document> result = new ArrayList<>();
        for (Iterator<Document> it = documentFindIterable; it.hasNext(); ) {
            Document d = it.next();
            result.add(d);
        }
        return result;
    }

}