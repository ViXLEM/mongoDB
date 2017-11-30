import db2l.Convert;
import db2l.SingleLog;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class ConvertTest {
    @Test
    public void csvToSingleLogs() throws Exception {
        ArrayList<SingleLog> singleList = new ArrayList<SingleLog>();
        singleList.add(new SingleLog("www.google.com","132.65.13.255", 1512055538000L,452));
        Assert.assertEquals(Convert.csvToSingleLogs("single.csv"), singleList);
    }

    @Test
    public void singleLogsToJSON() throws Exception {
        Assert.assertTrue(true);
        String json = Convert.singleLogsToJSON(Convert.csvToSingleLogs("./src/test/java/single.csv"));
        Assert.assertEquals(json, "{\"url\":\"www.google.com\",\"ip\":\"132.65.13.255\",\"date\":1512055538000,\"timeSeconds\":452}, ");
    }

}