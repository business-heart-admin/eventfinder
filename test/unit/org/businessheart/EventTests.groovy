package org.businessheart

import grails.test.*

class EventTests extends GrailsUnitTestCase {
	def trainer
	def venue
	
	protected void setUp() {
		super.setUp()
		mockDomain(Event)
		mockDomain(Trainer)
		mockDomain(Venue)
		trainer = new Trainer()
		trainer.phone = '9946555257'
		trainer.lastName = 'Smith'
		trainer.firstName = 'Joe'
		trainer.email = 'joe@example.com'
		trainer.displayGravatar = false
		trainer.address1 = '1 Greco'
		trainer.address2 = ''
		trainer.city = 'Anytown'
		trainer.state = 'CA'
		trainer.country = 'USA'
		trainer.zip = '99999'
		trainer.organization = ''
		trainer.website = ''
		trainer.certifications = ''
		trainer.comments = ''
		trainer.keywords = ''
		
		venue = new Venue()
		venue.name = 'Conscires'
		venue.address1 = '1 Greco Aisle'
		venue.address2 = ''
		venue.city = 'Irvine'
		venue.state = 'CA'
		venue.country = 'USA'
		venue.zip = ''
		venue.contactName = ''
		venue.contactPhone = ''
		venue.capacity = 10
		venue.trainerComments = ''
		venue.studentComments = ''
		
	}

	protected void tearDown() {
		super.tearDown()
	}

	void testValidate_Empty() {
		def event = new Event()
		assertFalse event.validate()
		assertTrue event.hasErrors()
		assertEquals 10,event.errors.errorCount
		assertEquals "nullable",event.errors["startTime"]
	}

	void testValidate_Blank() {
		def event = new Event()
		event.name = ''
		event.description = ''
		event.trainer = null
		event.venue = null
		event.startTime = null
		event.endTime = null
		event.keywords = ''
		event.level = ''
		event.attachment = ''
		event.studentComments = ''
		event.trainerComments = ''
		assertFalse event.validate()
		assertTrue event.hasErrors()
		assertEquals 5,event.errors.errorCount
		//event.errors.each {println it}
		assertEquals "blank",event.errors["name"]
	}

	void testValidate_Good() {
		def event = new Event()
		event.name = 'AGILE'
		event.description = 'Agile Practices'
		event.trainer = trainer
		event.venue = venue
		event.startTime = new Date("6/28/2011 10:00") 
		event.endTime = new Date("6/28/2011 17:00")
		event.keywords = ''
		event.level = 'Advanced'
		event.studentComments = ''
		event.trainerComments = ''
		assertTrue event.validate()
		assertFalse event.hasErrors()
		assertEquals 0,event.errors.errorCount
		//event.errors.each {println it}
	}
	
	void testValidate_BadLevel() {
		def event = new Event()
		event.name = 'AGILE'
		event.description = 'Agile Practices'
		event.trainer = trainer
		event.venue = venue
		event.startTime = new Date("6/28/2011 10:00") 
		event.endTime = new Date("6/28/2011 17:00")
		event.keywords = ''
		event.level = 'XXX'
		event.studentComments = ''
		event.trainerComments = ''
		assertFalse event.validate()
		assertTrue event.hasErrors()
		assertEquals 1,event.errors.errorCount
		//event.errors.each {println it}
		assertEquals "inList",event.errors["level"]
	}
	
//	public void testToString() throws Exception {
//		def event = new Trainer()
//		event.lastName = 'Smith'
//		event.firstName = 'Joe'
//		event.email = 'joeexample.com'
//		assertEquals 'Smith, Joe (joeexample.com)',event.toString()
//		
//	}

	
}
