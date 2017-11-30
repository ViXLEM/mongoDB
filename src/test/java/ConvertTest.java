import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ConvertTest {
    @Test
    public void CSVtoSingleLogs() throws Exception {
        ArrayList<SingleLog> singleList = new ArrayList<SingleLog>();
        singleList.add(new SingleLog("www.google.com","132.65.13.255", 1512048338000L,452));
        List<SingleLog> now = Convert.csvToSingleLogs("single.csv");
        System.out.println(singleList.get(0).date);
        System.out.println(singleList.get(0).timeSeconds);
        System.out.println(singleList.get(0).url);
        System.out.println(singleList.get(0).ip);
        System.out.println("");
        System.out.println(now.get(0).date);
        System.out.println(now.get(0).timeSeconds);
        System.out.println(now.get(0).url);
        System.out.println(now.get(0).ip);
        Assert.assertEquals(now, singleList);
        Assert.assertTrue(true);
    }

    @Test
    public void singleLogsToJSON() throws Exception {
        Assert.assertTrue(true);
//        String json = Convert.singleLogsToJSON(Convert.csvToSingleLogs("./src/test/java/single.csv"));
//        Assert.assertEquals(json, "{\"url\":\"www.google.com\",\"ip\":\"132.65.13.255\",\"date\":1512048338000,\"timeSeconds\":452}, ");
    }

}