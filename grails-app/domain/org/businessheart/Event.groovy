package org.businessheart

import java.util.Date
//import java.util.Formatter.DateTime

class Event {

	String name
	String description
	Venue venue
	Trainer trainer
	Date startTime
	Date endTime
	String categories
	String comments
	byte[] attachment
	Date dateCreated
	Date lastUpdated
	
	
	static constraints={
		name(blank:false,unique:true,minsize:3)
		venue(nullable:false)
		trainer(nullable:false)
		startTime(nullable:false,scale:5)
		endTime(nullable:false,scale:3)
		categories(blank:true)
		comments(blank:true,maxsize:4000,widget:"textarea")
		attachment(nullable:true,maxSize:1073741824,display:false)//4 GB
		}
}
