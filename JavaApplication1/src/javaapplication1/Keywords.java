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


/**
 * Java + MongoDB Hello world Example
 * 
 */
public class Keywords {
  public static void main(String[] args) {

	MongoClient mongo = new MongoClient("localhost", 27017);
	
        DB db = mongo.getDB("PaperTree");

        DBCollection keyword = db.getCollection("Keywords");
        Document d=new Document();
        
        d.put("PaperID", null);
        d.put("Keywords", null);
        DBObject ob=new BasicDBObject(d);
        keyword.insert(ob);
        
        
  }
}