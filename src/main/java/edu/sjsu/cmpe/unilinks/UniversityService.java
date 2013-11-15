package edu.sjsu.cmpe.unilinks;

import java.io.File;


import java.util.Scanner;

import org.scribe.builder.*;
import org.scribe.builder.api.*;
import org.scribe.model.*;
import org.scribe.oauth.*;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

import spark.Route;
import spark.Request;
import spark.Response;






//import java.io.FileWriter;
//import java.io.FileWriter;
//import java.io.OutputStreamWriter;
import java.io.StringWriter;
//import java.io.Writer;
import java.util.ArrayList;

import static spark.Spark.*;
import spark.*;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import java.util.List;
import java.util.Map;

import edu.sjsu.cmpe.unilinks.resources.UniversityObject;
import edu.sjsu.cmpe.unilinks.resources.CareerDetails;
import freemarker.template.Configuration;
import freemarker.template.Template;


public class UniversityService
{
	public static void main(String[] args) 
	    {
		
		try{
			
			get(new Route("/careers") {
				Configuration cfg = new Configuration();
		          @Override
		          public Object handle(Request request, Response response){
		        	  
		        	  StringWriter file = null;
		        	  String queryParam = request.queryString();
		        	  String uname;
		        	  try{
		        		  file = new StringWriter();
		            	  cfg.setDirectoryForTemplateLoading(new File("templates"));
		                  // load template
		                  Template template = cfg.getTemplate("tables.ftl");   
		                  	                  
		                  // data-model
		                  Map<String, Object> input = new HashMap<String, Object>(); 		
		                  // create list
		                  List<UniversityObject> universityObject = new ArrayList<UniversityObject>();
		                  List<CareerDetails> careerDetails = new ArrayList<CareerDetails>();
		                  
		                  input.put("Hello","Welcome to CareerData");
		                  template.process(input,file);
		                  if(queryParam == null)
		            	  {        	  
		            	  System.out.println("null");
		            	  }
		            	 else
		            	 {
		            		 System.out.println(queryParam.substring((queryParam.indexOf("=")+1),queryParam.indexOf("&")));
		            		 uname = queryParam.substring((queryParam.indexOf("=")+1),queryParam.indexOf("&"));
		            		 String name = uname.replace('+', ' ');
		            		 if(queryParam.contains("submit"))
		            		 {
		            			          				 
		            				 Mongo mongo = new Mongo("localhost", 27017);
		            				 DB db = mongo.getDB("test");
		            				 DBCollection collection = db.getCollection("test");		            				
		            				 BasicDBObject query = new BasicDBObject("SchoolName",name);
		            				 DBCursor dc = collection.find(query);
		            				// System.out.println("size of careerDetails object:"+dc.length());
		            				 while(dc.hasNext())
		            				 {
		            					 DBObject primary = dc.next();
		            			
		            					 CareerDetails cd =  new CareerDetails();
		            					 cd.setFirstName(primary.get("firstName").toString());
		            					// System.out.println("firstName:"+cd.getFirstName());
		            					 cd.setLastName(primary.get("lastName").toString());
		            					 //System.out.println("lastname:"+cd.getLastName());
		            					 cd.setOrgName(primary.get("OrgName").toString());
		            					 //System.out.println("orgname:"+cd.getOrgName());
		            					 cd.setSchoolName(primary.get("SchoolName").toString());
		            					 //cd.setProfileURL(primary.get("url").toString());
		            					 //System.out.println("SchoolName:"+cd.getSchoolName());
		            					 //add career details object to the list.
		            					 careerDetails.add(cd);		            					 
		            				 }
		            				 
		            				/* BasicDBObject key = new BasicDBObject("OrgName", false );
		            				 BasicDBObject initial= new BasicDBObject("total",0);
		            				 BasicDBObject cond = new BasicDBObject();
		            				 String reduce = "function( curr, result ){result.total++}";
		            				 BasicDBList returnList = (BasicDBList) collection.group(key, cond, initial, reduce);
		            				 for (Object o : returnList) {
                                            System.out.println("Inside the database query");		            					 
		            		                System.out.println(o.toString());
		            		            }*/
		            				 /* List<DBObject> dbo = dc.toArray();
		            				 System.out.println("dbobject size:"+dbo.size());*/
		            				 
		            				 UniversityObject uo = new UniversityObject();
		            				 uo.setSchoolName("San Jose State University");
		            				 uo.setDepartment("Computer Science");
		            				 uo.setLocation("San Jose");
		            				 uo.setContact("One Washington Square,San Jose, CA 95192 408-924-1000");
		            				 uo.setGreScore(94);
		            				 uo.setIeltsScore(6.5);
		            				 uo.setToeflScore(110);	
		            				 uo.setTuitionFees("$7500");
		            				 uo.setFallApplnDate("12August2013");
		            				 uo.setSpringApplnDate("12Jan2013");		            				 		            				 
		            				 universityObject.add(uo);
		            				 
		            				 UniversityObject uoone = new UniversityObject();
		            				 uoone.setSchoolName("Harvard University");
		            				 uoone.setDepartment("Computer Science");
		            				 uoone.setLocation("Cambridge, MA");
		            				 uoone.setContact("Massachusetts Ave, Cambridge, MA 02138");
		            				 uoone.setGreScore(321);
		            				 uoone.setIeltsScore(7.8);
		            				 uoone.setToeflScore(80);	
		            				 uoone.setTuitionFees("$42292");
		            				 uoone.setFallApplnDate("15December2013");
		            				 uoone.setSpringApplnDate("NA");
		            				 
		            				 universityObject.add(uoone);	            				 
		            				 
		            			 }
		            			
		            			 	            			 
		            			 input.put("universityObject",universityObject );
		            			 input.put("careerDetails",careerDetails);
		                         template.process(input, file);
		                         
		                         
		            		 }
		            	 
		                  
		                  
		        	  }catch(Exception e){System.out.print(e.getMessage());}
		        	  
		        	  return file;
		          }
				
			});
			
		}catch(Exception e){System.out.println(e.getMessage());}
           
	    }
	
}


