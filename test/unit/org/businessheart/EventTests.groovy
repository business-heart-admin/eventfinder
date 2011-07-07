package org.businessheart

import grails.test.*

class EventTests extends GrailsUnitTestCase {
	//def trainer
	//def venue
	Trainer trainer = new Trainer(phone: '9946555257',lastName: 'Smith',firstName: 'Joe',email: 'joe@example.com',displayGravatar: false,address1: '1 Greco',address2: '',city: 'Anytown',state: 'CA',country: 'USA',zip: '99999',organization: '',website: '',certifications: '',comments: '',keywords: '')
	Venue venue= new Venue(name: 'Conscires',address1: '1 Greco Aisle',address2: '',city: 'Irvine',state: 'CA',country: 'USA',zip: '',contactName: '',contactPhone: '',capacity: 10,trainerComments: '',studentComments: '')
	
	protected void setUp() {
		super.setUp()
		mockDomain(Event)
		mockDomain(Trainer)
		mockDomain(Venue)
		/*trainer = new Trainer()
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
		venue.studentComments = ''*/
		
	}

	protected void tearDown() {
		super.tearDown()
	}

	void testValidate_Empty() {
		def event = new Event()
		assertFalse event.validate()
		assertTrue event.hasErrors()
		assertEquals 5,event.errors.errorCount
		assertEquals "nullable",event.errors["startTime"]
	}

	
	void testValidate_Good() {
		Event event= new Event(name: 'Intro to Agile',description: 'Agile Practices',trainer: trainer,venue: venue,startTime: new Date("6/28/2011 10:00") ,endTime: new Date("6/28/2011 17:00"),keywords: '',level: 'Advanced',studentComments: '',trainerComments: '')
		assertTrue event.validate()
		assertFalse event.hasErrors()
		assertEquals 0,event.errors.errorCount
		//event.errors.each {println it}
	}
	
	void testValidate_BadLevel() {
		Event event= new Event(name: 'Intro to Agile',description: 'Agile Practices',trainer: trainer,venue: venue,startTime: new Date("6/28/2011 10:00") ,endTime: new Date("6/28/2011 17:00"),keywords: '',level: 'XXX',studentComments: '',trainerComments: '')
		assertFalse event.validate()
		assertTrue event.hasErrors()
		assertEquals 1,event.errors.errorCount
		//event.errors.each {println it}
		assertEquals "inList",event.errors["level"]
	}
	
	public void testToString() throws Exception {
		Event event= new Event(name: 'Intro to Agile',startTime: new Date("6/28/2011 10:00"))
		assertEquals 'Intro to Agile (Tue Jun 28 10:00:00 PDT 2011)',event.toString()
		
	}

	
}
