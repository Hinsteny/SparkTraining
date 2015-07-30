package com.hinsteny.spark.training;

import static spark.Spark.*;

/**
 * TrainAction.java
 * 
 * @author: Hinsteny
 * @date: 2015年7月30日
 * @copyright: 2015 All rights reserved.
 * 
 */
public class HelloWorld {
	
	public static void main(String[] args) {
		
		/*Filters*/
		before((request, response) -> {
		    boolean authenticated = false;
		    // ... check if authenticated
		    if (!authenticated) {
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
