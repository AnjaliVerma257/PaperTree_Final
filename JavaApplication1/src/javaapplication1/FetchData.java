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

public class FetchData {
    
    public static void main(String args[])
    {
MongoClient mongo=new MongoClient();
DB db = mongo.getDB("PaperTree");
DBCollection user = db.getCollection("User");
DBCollection paper = db.getCollection("Paper");
DBCursor u=user.find();
System.out.println("USER ID");
while(u.hasNext()) {
                System.out.println(u.next().get("_id"));
            }
DBCursor p=paper.find();


System.out.println("     ");
System.out.println("     ");
System.out.println("     ");
System.out.println("     ");
System.out.println("     ");
System.out.println("     ");




while(p.hasNext()) {
                System.out.println(p.next().get("_id"));
            }


    }
    
}
