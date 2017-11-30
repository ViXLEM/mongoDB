package db2l;

import java.io.IOException;
import java.util.Date;

public class SingleLog {
    private String url;
    private String ip;
    private long date;
    private int timeSeconds;

    public SingleLog(String url, String ip, long date, int time) throws IOException {
        this.url = url;
        this.ip = ip;
        this.date = (date == 0)? new Date().getTime(): date;
        timeSeconds = time;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        final SingleLog other = (SingleLog) obj;
        if ((this.url == null) ? (other.url != null) : !this.url.equals(other.url)) {
            return false;
        }
        if ((this.ip == null) ? (other.ip != null) : !this.ip.equals(other.ip)) {
            return false;
        }
        if (this.timeSeconds != other.timeSeconds) {
            return false;
        }
        if (this.date != other.date) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = (int) ((this.timeSeconds + this.date)/1000);
        return hash;
    }

}
