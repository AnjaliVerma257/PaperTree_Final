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
public class Reads {
  public static void main(String[] args) {

	MongoClient mongo = new MongoClient("localhost", 27017);
	
        DB db = mongo.getDB("PaperTree");
        /*USRER ID




"5653bd45b8b0e031f0bf4ef3"
"5653bd54b8b0e037481f39b0"
"5653bd5fb8b0e02f18168825"
"5653bd7ab8b0e022c4e712e7"
"5653bd8bb8b0e0189c8f1299"
"5653bd9ab8b0e030ac4e4384"
"5653bdb7b8b0e0251c4c7b69"
"5653bdd7b8b0e01b5c1eb5ff"
"5653bde5b8b0e016d856499a"
'5653bdf1b8b0e00b14cb96fb"
*/
        
        
/*
        PaperID



565072dbb8b0e00654ebef3f
565072e6b8b0e012000de500
565072f4b8b0e0091c153ace
5650734bb8b0e01030a034ed
56507353b8b0e0120499838a
56507361b8b0e000d8e09c33
56507391b8b0e01b28773da6
5650739eb8b0e01dac6a3cf8
565073afb8b0e01790a58430
565073cdb8b0e022e4a8017d
56507b58b8b0e0200ceccc01
56507cc1b8b0e01f60bd1f6f

        */        
        DBCollection reads = db.getCollection("Readings");
        Document d=new Document();
        
        
        d.put("UserID", "5653bd36b8b0e02914a818a2");
        d.put("PaperID","565072ceb8b0e0235c75d1f2");
        d.put("Rating",);
        d.put("TimeStamp",null);
        
        
        d.put("UserID", "5653bd36b8b0e02914a818a2");
        d.put("PaperID","565072ceb8b0e0235c75d1f2");
        d.put("Rating",);
        d.put("TimeStamp",null);
        DBObject ob=new BasicDBObject(d);
        reads.insert(ob);
        
        
  }
}