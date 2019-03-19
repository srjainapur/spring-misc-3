package com.java.mongo;

import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;

public class MongoDBTest {
	public static void main(String[] args) {
		// Creating a Mongo client 
	      MongoClient mongo = new MongoClient( "127.0.0.1" , 27017 ); 
	   
	      // Creating Credentials 
	      MongoCredential credential; 
	      credential = MongoCredential.createCredential("sampleUser", "myDb", "password".toCharArray());
	      System.out.println("Connected to the database successfully");  
	      
	      // Accessing the database 
	      MongoDatabase database = mongo.getDatabase("myDb"); 
	      System.out.println("Credentials ::"+ credential);  
	      
	      MongoCollection<Document> collection = database.getCollection("Employeeee");
	      System.out.println("listCollections " + collection);
	      
	      Document row = new Document();
	      row.append("id", 100);
	      row.append("name", "Satish");
	      
	      collection.insertOne(row);
	      System.out.println("One row inserted successfully");
	}
}
