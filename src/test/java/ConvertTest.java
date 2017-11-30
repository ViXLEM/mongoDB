import org.junit.Assert;
import org.junit.Test;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ConvertTest {
    @Test
    public void CSVtoSingleLogs() throws Exception {
        ArrayList<SingleLog> singleList = new ArrayList<SingleLog>();
        singleList.add(new SingleLog("www.google.com","132.65.13.255", 1512048338000L,452));
        Assert.assertEquals(Convert.CSVtoSingleLogs("./src/test/java/single.csv"), singleList);
    }

    @Test
    public void singleLogsToJSON() throws Exception {
        String json = Convert.SingleLogsToJSON(Convert.CSVtoSingleLogs("./src/test/java/single.csv"));
        Assert.assertEquals(json, "{\"url\":\"www.google.com\",\"ip\":\"132.65.13.255\",\"date\":1512048338000,\"timeSeconds\":452}, ");
    }

}