package org.businessheart

import java.util.Date

class Event {

	String name
	String description
	Venue venue
	Trainer trainer
	Date startTime
	Date endTime
	String keywords
	String level
	String trainerComments
	String studentComments
	byte[] attachment
	Date dateCreated
	Date lastUpdated
	
	
	static constraints={
		name(blank:false,minsize:3)
		venue(nullable:false)
		trainer(nullable:false)
		startTime(nullable:false,scale:5)
		endTime(nullable:false,scale:3)
		keywords(blank:true)
		level(blank:true,inList:["Beginner","Intermediate","Advanced"])
		trainerComments(blank:true,maxsize:4000,widget:"textarea")
		studentComments(blank:true,maxsize:4000,widget:"textarea")
		attachment(nullable:true,maxSize:1073741824,display:false)//4 GB
		}
}

