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

public class WriteToMalvika {
	public static void main(String[] args) throws IOException {
		
                   MongoClient mongo=new MongoClient();
DB db=mongo.getDB("TFIDF");
                   File ipt=new File("C:\\Users\\Anjali\\Desktop\\Hadoop+Mongo\\20100825-SchPaperRecData\\20100825-SchPaperRecData");
File iptt[]=ipt.listFiles();
String ip[]=new String[iptt.length];

for(int i=0;i<iptt.length;i++)
{
    
    ip[i]=iptt[i].getName();
    
    ip[i]=ip[i].replace(".txt", "");
    ip[i]=ip[i].replace("-","");
    ip[i]=ip[i].replace("_","");
}
            System.out.println(ip[0]);
			
//
String a=new String();
for(int i=0;i<ip.length;i++)
{
    String s="C:\\Users\\Anjali\\Desktop\\Hadoop+Mongo\\Output\\"+ip[i]+".txt";
    File file = new File(s);
    
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			

DBCollection idf=db.getCollection("IDF");
DBCollection table=db.getCollection(ip[i]);
    
DBCursor tcur=table.find();
tcur.addOption(com.mongodb.Bytes.QUERYOPTION_NOTIMEOUT);
while(tcur.hasNext())
{
   
    tcur.next();
    DBObject input=tcur.curr();
    a=input.get("Word").toString();
    
Document d=new Document();
d.put("Word", a);
DBObject ko=new BasicDBObject(d);
DBCursor db1=idf.find(ko);
db1.addOption(com.mongodb.Bytes.QUERYOPTION_NOTIMEOUT);
db1.next();
 DBObject ob2=db1.curr();
Double x= (Double) ob2.get("IDF");
System.out.println(x);
    DBObject n1=new BasicDBObject(new Document("Word",a));
        DBObject n2=new BasicDBObject(new Document("$set", new Document("Imp",x)));
        table.update(n1,n2);

String content = a+" "+x+System.lineSeparator();

			bw.write(content);
}
bw.close();
}
		
	}
}