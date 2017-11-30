import org.bson.Document;

import java.io.IOException;
import java.util.Date;

public class SingleLog {
    String url;
    String ip;
    long date;
    int timeSeconds;

    public SingleLog(String url, String ip, long date, int time) throws IOException {
        this.url = url;
        this.ip = ip;
        this.date = (date == 0)? new Date().getTime(): date;
        timeSeconds = time;
    }

    @Override
    public String toString(){
        return "url:" + url + " | ip:" + ip + " | Date:" + new Date(date) + " | Long:" + timeSeconds;
    }

    public Document toDocument(){
        return new Document("url", url)
                .append("ip", ip)
                .append("date", String.valueOf(date))
                .append("time", timeSeconds);
    }

}
