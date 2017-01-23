package clusterproject;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.bson.Document;

public class ClusterProject {
    public static void main(String[] args) throws IOException {
       String s="C:\\Users\\Anjali\\Desktop\\CLUSTER-INPUT\\FINALCLUSTERS.txt";
       File file=new File(s);
       
       MongoClient mongo=new MongoClient();
       DB db=mongo.getDB("TestRun");
       BufferedWriter bw=null;
       DBCollection test=db.getCollection("Test");
       if (!file.exists()) {
				file.createNewFile();
			}
       

			FileReader fw = new FileReader(file.getAbsoluteFile());
			BufferedReader br = new BufferedReader(fw);
                        int i=0;
                                for (String line; (line = br.readLine()) != null;) {
                                    i=i+1;
                     if(i>4)
                     {
                         String key;
                         line=line.replace("Key: ","");
                         String a=line.substring(0,2);
                         a=a.replace(":","");
                         
                         int x=line.indexOf(".txt");
                         int y=line.lastIndexOf("/");
                         String b=null;
                                       b=line.substring(y+1,x);
                                       
                         
                        
                         String temp="C:\\Users\\Anjali\\Desktop\\TestRuns\\";
                                          
                         File cfile=new File(temp+a+".txt");
                         FileWriter fr = new FileWriter(cfile.getAbsoluteFile(),true);
			 bw= new BufferedWriter(fr);
                         if (!cfile.exists()) {
				cfile.createNewFile();                                
			}
                             System.out.println(b);
                             bw.write(b+"\r\n");
                         
                     bw.close();    
                         }
                     
                     }
        }        
    }
    

