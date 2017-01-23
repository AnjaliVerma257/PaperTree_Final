package javaapplication2;
import java.net.UnknownHostException;
import java.util.Date;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bson.Document;

public class Printing {
public static void main(String args[])    
        //71748
{
  MongoClient mongo = new MongoClient("localhost", 27017);
	
        DB db = mongo.getDB("TFIDF");

        DBCollection idf = db.getCollection("IDF");
        DBCursor c=idf.find();
       int i=0;
           while(c.hasNext())
          {
              i=i+1;
        c.next();       
          DBObject k=c.curr();
          
         
       
              
          }
          System.out.println(i);
}
}
