package org.businessheart

import java.util.Date;

class Venue {
	String name
	String address1
	String address2
	String city
	String state
	String country = "USA"
	String zip
	String comments
	Date dateCreated
	Date lastUpdated
	
	
	static constraints={
		name(blank:false,unique:true,minSize:3)
		address1(blank:false)
		address2(blank:true)
		city(blank:false)
		state(blank:false)
		country(blank:false)
		zip(blank:true)
		comments(blank:true,maxSize:4000,widget:"textarea")
	}
	
}
