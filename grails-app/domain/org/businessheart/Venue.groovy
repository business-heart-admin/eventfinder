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
	String contactName
	String contactPhone
	Integer capacity
	String trainerComments
	String studentComments
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
		contactName(blank:false,unique:true,minSize:3)
		contactPhone(blank:true)
		capacity(nullable:true)
		trainerComments(blank:true,maxSize:4000,widget:"textarea")
		studentComments(blank:true,maxSize:4000,widget:"textarea")
	}
	
}
