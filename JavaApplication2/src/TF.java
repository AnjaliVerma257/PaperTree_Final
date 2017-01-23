
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;


public class TF
{
    public String[] getKeyword(File f) throws FileNotFoundException, IOException
    {      
        BufferedReader br=new BufferedReader(new FileReader(f));
        ArrayList op = new ArrayList();        
        for (String line; (line = br.readLine()) != null;) {
                     op.add(line);       
        }        
        for(int i=0;i<op.size();i++)
        {
            String test=(String) op.get(i);
            test=test.replaceAll("[\\n]"," ");
            if(test==null)
                op.remove(i);            
        }
        TF i=new TF();
        i.generateTF(op, f);
        return null;
    }
    
    public void generateTF(ArrayList x, File f) throws NullPointerException
    {
        int i=x.size();
       String ip[]=new String[i];
//String s=(String) x.get(0);
for(int h=0;h<x.size();h++)
{
    ip[h]=(String) x.get(h);
}
BigDecimal tf[]=new BigDecimal[i];
for(int h=0;h<i;h++)
{
char k[]=ip[h].toCharArray();
    
        for(int l=0;l<k.length;l++)
        {
           if(k[l]>='a' & k[l]<='z' || k[l]>='A' & k[l]<='Z')
               k[l]=' ';
        }       
        String z=Arrays.toString(k);
       z=z.replace("["," ");         
       z=z.replace("]"," ");        
       z=z.replace(","," ");        
       z=z.trim();        
       z=z.replaceAll(" ", "");    
       z=z.replaceAll("-", ""); 
       z=z.replaceAll("[\\t\\n\\r]"," ");
       z=z.replaceAll("\\s+","");
       
       System.out.println(f.getName());
       if(z!=null)
       {           
        BigDecimal b=new BigDecimal(z);
         b = b.setScale(18, RoundingMode.FLOOR);
        tf[h]=b;
       }
    }
String word[]=new String[i];
for(int h=0;h<i;h++)
{
char k[]=ip[h].toCharArray();
            for(int l=0;l<k.length;l++)
        {
           if(k[l]>='0' & k[l]<='9')
              k[l]=' ';
           else if(k[l]=='.')
               k[l]=' ';
           else
               ;
        }       
        String z=Arrays.toString(k);
       z=z.replace("["," ");         
       z=z.replace("]"," ");        
       z=z.replace(","," ");        
       z=z.trim();        
       z=z.replaceAll(" ", ""); 
       z=z.replaceAll("[\\t\\n\\r]"," ");
       z=z.replaceAll("\\s+","");
       word[h]=z;
    }
String name=f.getName();
name=name.replace(".txt","");
name=name.replaceAll("-","");
name=name.replaceAll("_","");
System.out.println(name);

MongoClient mongo = new MongoClient("localhost", 27017);
	DB db = mongo.getDB("TFIDF");
        DBCollection paper = db.getCollection(name);
        Document d;
        DBObject ob;
     for(int v=0;v<i;v++)   
     {
        d=new Document();     
        String t=word[v];
        String w=String.valueOf(tf[v]);        
        d.put("Word",t);
        d.put("TF",w);
        d.put("Imp",null);
        ob=new BasicDBObject(d);
        paper.insert(ob);
     }
    }
    public static void main(String args[]) throws IOException
    {
   File f=new File("C:\\Users\\Anjali\\Desktop\\Hadoop+Mongo\\20100825-SchPaperRecData\\20100825-SchPaperRecData");       
   File a[]=f.listFiles();
       TF i=new TF();
       for(int p=0;p<a.length;p++)
       {    
        String k[]=i.getKeyword(a[p]);
       }
         } 
}