import java.net.UnknownHostException;
import java.util.Date;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bson.Document;

public class InputClusters {
public static void main(String args[]) throws FileNotFoundException, IOException    
{
  MongoClient mongo = new MongoClient("localhost", 27017);

        DB db = mongo.getDB("TFIDF");

       DBCollection idf = db.getCollection("Clusters");
      File f=new File("C:\\Users\\Anjali\\Desktop\\Input");       
   File a[]=f.listFiles();
   BufferedReader br;
StringBuilder sb[] = new  StringBuilder[a.length];	    
    for(int i=0;i<a.length;i++)
    {
    br=new BufferedReader(new FileReader(a[i].getAbsolutePath()));
    Document d=new Document();
    d.put("Cluster Name",a[i].getName());
    sb[i]=new StringBuilder();
          for (String line; (line = br.readLine()) != null;) 
          {
sb[i].append(","+line);
        }   
          sb[i].deleteCharAt(0);
    d.put("PaperID",sb[i]);
    DBObject dbo=new BasicDBObject(d);
    idf.insert(dbo);
         }
    
    
}
        
          }
          

