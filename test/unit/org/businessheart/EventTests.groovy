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
		trainer = new Trainer(phone: '9946555257',lastName: 'Smith',firstName: 'Joe',email: 'joe@example.com',displayGravatar: false,address1: '1 Greco',address2: '',city: 'Anytown',state: 'CA',country: 'USA',zip: '99999',organization: '',website: '',certifications: '',comments: '',keywords: '')
		venue= new Venue(name: 'Conscires',address1: '1 Greco Aisle',address2: '',city: 'Irvine',state: 'CA',country: 'USA',zip: '',contactName: '',contactPhone: '',capacity: 10,trainerComments: '',studentComments: '')
			
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
