/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


/**
 * Java + MongoDB Hello world Example
 * 
 */
public class InsertUser {
  public static void main(String[] args) {

	MongoClient mongo = new MongoClient("localhost", 27017);
	
        DB db = mongo.getDB("PaperTree");

        DBCollection user = db.getCollection("User");
        Document d=new Document();
        d.put("Name", new Document().append("First Name","Akshay").append("Last Name","Chandila"));
        d.put("Email", "akki@gmail.com");
        d.put("Interests", "Computer Science");
        d.put("Password", "shaolinp");
        d.put("Security Question","a?");
        d.put("Security Answer", "b");
        DBObject ob=new BasicDBObject(d);
        user.insert(ob);
        
        DBObject ob1=new BasicDBObject(new Document("Password", "shaolinp"));
        DBObject ob2=new BasicDBObject(new Document("$set", new Document("Security Answer", "Akshay1234")));
        user.update(ob1,ob2);
         String tm="shaolghjmkl;inp";          
              DBObject ob3=new BasicDBObject(new Document("Password",tm));
          DBCursor c2=user.find(ob3);
          System.out.println(c2.count());
  }
          
}