
import java.net.UnknownHostException;
import java.util.Date;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bson.Document;

public class IDF {
  public static void main(String[] args)throws NullPointerException{

	MongoClient mongo = new MongoClient("localhost", 27017);	
        DB db = mongo.getDB("TFIDF");
      Set<String> collectionNames = db.getCollectionNames();
      String[] input = new String[collectionNames.size()];
      int len=input.length-1;
      Iterator t=collectionNames.iterator();
      int i=0;
      while(t.hasNext())
      {          
          input[i]=(String) t.next();          
          i=i+1;
      }
      DBCollection idf=db.getCollection("IDF");     
      int a=0;
      for(int j=0;j<input.length;j++)
      {
              a=a+1;
          DBCollection temp=db.getCollection(input[j]);
          DBCursor c1=temp.find();
          while(c1.hasNext())
          {
              String tm=(String) c1.next().get("Word");                    
              DBObject ob=new BasicDBObject(new Document("Word",tm));
          DBCursor c2=idf.find(ob);          
          if(c2.count()>0)
          {              
          int freq=0;
          freq=(int)c2.next().get("Frequency");        
          DBObject ob1=new BasicDBObject(new Document("Word",tm));
           freq=freq+1;           
           DBObject ob2=new BasicDBObject(new Document("$set", new Document("Frequency",freq)));
           idf.update(ob1,ob2);
          }
          else
          {              
               Document d=new Document();                
        d.put("Word",tm);
        d.put("Frequency",1);        
        d.put("IDF",null);
        d.put("Mul",null);
        DBObject ob3=new BasicDBObject(d);
        idf.insert(ob3);
          }
                  }
     }
      
      
      
      
      
      
      
      
      
      
      
  }
  
 
}