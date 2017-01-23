package javaapplication1;
import java.net.UnknownHostException;
import java.util.Date;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.util.List;
import org.bson.Document;

public class Readings {
  public static void main(String[] args) {

	MongoClient mongo = new MongoClient("localhost", 27017);
	
        DB db = mongo.getDB("PaperTree");

        DBCollection paper = db.getCollection("Readings");
        Document d=new Document();
        
        d.put("Title", "Bandeya Ho");
        
        DBObject ob=new BasicDBObject(d);
        paper.insert(ob);
        
        
  }
}