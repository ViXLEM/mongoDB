package db2l;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.opencsv.CSVReader;
import org.bson.Document;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Convert {

    public static List<SingleLog> csvToSingleLogs(String path){
        ArrayList<SingleLog> logs = new ArrayList<SingleLog>();
        try {
            CSVReader reader = new CSVReader(new FileReader(path));
            String[] line;
            while ((line = reader.readNext()) != null) {
                Long timeUnix = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy").parse(line[2]).getTime();
                SingleLog log = new SingleLog(line[0], line[1], timeUnix, Integer.parseInt(line[3]));
                logs.add(log);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return logs;
    }

    public static String singleLogsToJSON(List<SingleLog> logs){
        Gson gson = new Gson();
        String logsString = "";
        for (SingleLog log:logs ){
            String logString = gson.toJson(log);
            logsString += logString + ", ";
        }
        return logsString;
    }

    public static void csvToDB(String path, MongoCollection<Document> collection){
        List<SingleLog> singleLogList = csvToSingleLogs(path);
        String jsonStrings = singleLogsToJSON(singleLogList);
        ArrayList<String> jsonStringList = new ArrayList<String>(Arrays.asList(jsonStrings.split("}, ")));
        for(String jsonStr:jsonStringList){
            Document doc = Document.parse(jsonStr+"}");
            collection.insertOne(doc);
        }
    }
}
