
import java.net.UnknownHostException;
import java.util.Date;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bson.Document;

public class NewClass {
  public static void main(String[] args)throws NullPointerException{

	 MongoClient mongo=new MongoClient();
DB db=mongo.getDB("TFIDF");
Set s=db.getCollectionNames();
System.out.println(s.toString());
  }
}