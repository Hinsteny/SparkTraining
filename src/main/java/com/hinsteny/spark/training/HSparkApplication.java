package com.hinsteny.spark.training;

import static spark.Spark.after;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.halt;
import spark.servlet.SparkApplication;


/**
 * SparkApplication.java
 * 
 * @author: Hinsteny
 * @date: 2015年7月30日
 * @copyright: 2015 All rights reserved.
 * 
 */
public class HSparkApplication implements SparkApplication  {

	/* (non-Javadoc)
	 * @see spark.servlet.SparkApplication#init()
	 */
	@Override
	public void init() {
		/*Filters*/
		before((request, response) -> {
		    boolean authenticated = false;
		    // ... check if authenticated
		    if (authenticated) {
		        halt(401, "You are not welcome here");
		    }
		});
		
        get("/hello", (request, response) -> "Hello World");
        
        /*Filters*/
        after((request, response) -> {
            response.header("foo", "set by after filter");
        });
	}

}
