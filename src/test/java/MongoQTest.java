import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.lang3.ObjectUtils;
import org.bson.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MongoQTest {
    private MongoDatabase database = null;
    private MongoCollection<Document> collection = null;
    MongoQ query = null;

    @Before
    public void before() {
        MongoClient client = new MongoClient("localhost", 27017);
        this.database = client.getDatabase("logDB");
        this.collection = database.getCollection("logs");

        this.query = new MongoQ(database, collection);
    }

    @Test
    public void getIpByUrl() throws Exception {
//        Set<String> exepted = new HashSet<String>();
//        exepted.add("203.109.18.227");
//        exepted.add("49.45.122.245");
//        exepted.add("120.86.157.41");
//        exepted.add("20.118.36.236");
//        exepted.add("237.17.1.10");
//        Assert.assertEquals(query.getIpByUrl("www.ukr.net"), exepted);
    }

    @Test
    public void getUrlByIp() throws Exception {
//        Set<String> exepted = new HashSet<String>();
//        exepted.add("www.ukr.net");
//        exepted.add("ua.sinoptik.ua");
//        exepted.add("www.instagram.com");
//        exepted.add("www.olx.ua");
//        exepted.add("www.vk.com");
//        Assert.assertEquals(query.getUrlByIp("120.86.157.41"), exepted);
    }
    @Test
    public void getUrlByTime() throws Exception {
//        Set<String> exepted = new HashSet<String>();
//        exepted.add("www.facebook.com");
//        exepted.add("www.privatbank.ua");
//        exepted.add("www.google.com");
//        exepted.add("www.youtube.com");
//        exepted.add("www.vk.com");
//        Assert.assertEquals(query.getUrlByTime("12:00:00 01.11.2017", "00:00:00 3.11.2017"), exepted);
    }

    @Test
    public void getTopUrlBySumDuration() throws Exception {
    }

    @Test
    public void getTopUrlByVisit() throws Exception {
    }

    @Test
    public void getTopUrlPerPeriod() throws Exception {
    }

    @Test
    public void getTopIpByVisitAndDuration() throws Exception {
    }

}