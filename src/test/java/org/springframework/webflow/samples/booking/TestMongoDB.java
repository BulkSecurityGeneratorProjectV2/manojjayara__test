package org.springframework.webflow.samples.booking;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.webflow.samples.booking.config.MongoDbCOnfig;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class TestMongoDB {
public static void main(String[] args) throws UnknownHostException {
	ApplicationContext ctx = 
            new AnnotationConfigApplicationContext(MongoDbConfigTest.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
/*
	ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
	   MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");*/
	   
	/*MongoClientURI connectionString = new MongoClientURI("mongodb://deepak:deepak@ds055584.mongolab.com:55584/uk_info_db");
	  MongoClient mongoClient = new MongoClient(connectionString);

	  DB db=mongoClient.getDB("uk_info_db");
	  System.out.println(db.getCollectionNames());
	  System.out.println("connected");*/
	
	User user = new User();
	user.setPassword("test");
	user.setName("deepak");

	// save
	mongoOperation.save(user);

	// now user object got the created id.
	System.out.println("1. user : " + user);

	// query to search user
	/*Query searchUserQuery = new Query(Criteria.where("username").is("mkyong"));

	// find the saved user again.
	User savedUser = mongoOperation.findOne(searchUserQuery, User.class);
	System.out.println("2. find - savedUser : " + savedUser);

	// update password
	mongoOperation.updateFirst(searchUserQuery, 
                        Update.update("password", "new password"),User.class);

	// find the updated user object
	User updatedUser = mongoOperation.findOne(searchUserQuery, User.class);

	System.out.println("3. updatedUser : " + updatedUser);

	// delete
	mongoOperation.remove(searchUserQuery, User.class);

	// List, it should be empty now.
	List<User> listUser = mongoOperation.findAll(User.class);
	System.out.println("4. Number of user = " + listUser.size());*/

}
}
