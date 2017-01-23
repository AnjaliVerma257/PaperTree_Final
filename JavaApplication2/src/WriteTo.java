import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

public class WriteTo {
	public static void main(String[] args) {
		try {
                   File file = new File("C:\\Users\\Anjali\\Desktop\\Hadoop+Mongo\\Output\\Freq.txt");

			
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
MongoClient mongo=new MongoClient();
DB db=mongo.getDB("TFIDF");
DBCollection idf=db.getCollection("IDF");
DBCursor cur=idf.find();
while(cur.hasNext())
{
    cur.next();
    DBObject k=cur.curr();

			String content =k.get("Frequency")+System.lineSeparator();

			bw.write(content);
			

			System.out.println("Done");
}
bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}