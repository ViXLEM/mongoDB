import db2l.SingleLog;
import org.junit.Assert;
import org.junit.Test;

public class SingleLogTest {
    @Test
    public void equalsT() throws Exception {
        SingleLog log = new SingleLog("www.google.com","132.65.13.255", 1512048338000L,452);
        SingleLog log1 = new SingleLog("www.vk.com","132.65.13.255", 1512048338000L,452);
        SingleLog log2 = new SingleLog("www.google.com","132.66.13.255", 1512048338000L,452);
        SingleLog log3 = new SingleLog("www.google.com","132.65.13.255", 1512048339000L,452);
        SingleLog log4 = new SingleLog("www.google.com","132.65.13.255", 1512048338000L,453);

        Assert.assertFalse(log.equals(log1));
        Assert.assertFalse(log.equals(log2));
        Assert.assertFalse(log.equals(log3));
        Assert.assertFalse(log.equals(log4));
        Assert.assertTrue(log.equals(log));
    }

    @Test
    public void hashCodeT() throws Exception {
        SingleLog log = new SingleLog("www.google.com","132.65.13.255", 1512048338000L,452);
        Assert.assertEquals(log.hashCode(),1512048338L);
    }

}