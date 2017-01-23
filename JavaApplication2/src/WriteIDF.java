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

public class WriteIDF {
public static void main(String args[])    
{
  MongoClient mongo = new MongoClient();
	
        DB db = mongo.getDB("TFIDF");

        DBCollection idf = db.getCollection("IDF");
        DBCursor c=idf.find();
           c.addOption(com.mongodb.Bytes.QUERYOPTION_NOTIMEOUT);
          Set<String> collectionNames = db.getCollectionNames();
      
      int i=0;
      int len=collectionNames.size();
      System.out.println(len);
           while(c.next()!=null)
          {
              i=i+1;
        //c.next();       
          Double freq=0.0;
          
          DBObject k=c.curr();
          int h=(int) k.get("Frequency");
          
        Double bd=(Math.log(2212/h));
          
         
       //System.out.println(k.get("Word")+"  "+bd);
              
              
         DBObject ob1=new BasicDBObject(new Document("Word",k.get("Word")));
        DBObject ob2=new BasicDBObject(new Document("$set", new Document("IDF",bd)));
        idf.update(ob1,ob2);
              System.out.println(i);   
          }
           
          
}
}
