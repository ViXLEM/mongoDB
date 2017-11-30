package db2l;

import org.bson.Document;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MainTest {
    @Test
    public void printResponse() throws Exception {
        ArrayList<Document> list = new ArrayList<Document>();
        list.add(new Document("Orange", "Green"));
        list.add(new Document("Black", "Yellow"));
        System.out.println(Main.getString(list.iterator()));
        Assert.assertEquals(Main.getString(list.iterator()), "{ \"Orange\" : \"Green\" }\n" +
                                                                    "{ \"Black\" : \"Yellow\" }\n");
    }

}