package org.businessheart

import grails.test.*

/**
 * The following tests merely execute the controller closures directly, and then test what they return.  In other words,
 * we are stopping short of actually invoking the rendering engine, so the pages are not actually rendered. (We use
 * Selenium to test that.)  Instead, these tests tell us if the closures are providing the appropriate information that
 * the rendering engine would need if it were to be invoked.
 */
class EventControllerTests extends ControllerUnitTestCase {
	EventController eventController
	Event event1
	Event event2
	Event event3
	
	def trainer
	def venue
	
	

	protected void setUp() {
		super.setUp()

		mockDomain(Event)
		mockController(EventController)
		eventController = new EventController()
		eventController.metaClass.message = { LinkedHashMap args -> return "${args.code}" }

		trainer = new Trainer(organization: '',website: '',certifications: '',comments: '',keywords: '')
		venue= new Venue(name: 'Conscires',address1: '1 Greco Aisle',address2: '',city: 'Irvine',state: 'CA',country: 'USA',zip: '',contactName: '',contactPhone: '',capacity: 10,trainerComments: '',studentComments: '')
		
		// We'll create and save three Events here, so when the List controller calls Event.list, it will get back a list of these three, and when Show controller calls Event.get(2) it will get back the second one (Jane)
		event1 = new Event(name: 'Event1',description: 'Agile Practices',trainer: trainer,venue: venue,startTime: new Date("6/28/2011 10:00") ,endTime: new Date("6/28/2011 17:00"),keywords: '',level: 'Advanced',studentComments: '',trainerComments: '')
		event1.save()
		assertEquals 1, event1.id

		event2 = new Event(name: 'Event2',description: 'Agile Practices',trainer: trainer,venue: venue,startTime: new Date("6/28/2011 10:00") ,endTime: new Date("6/28/2011 17:00"),keywords: '',level: 'Advanced',studentComments: '',trainerComments: '')
		event2.save()
		assertEquals 2, event2.id

		event3 = new Event(name: 'Event3',description: 'Agile Practices',trainer: trainer,venue: venue,startTime: new Date("6/28/2011 10:00") ,endTime: new Date("6/28/2011 17:00"),keywords: '',level: 'Advanced',studentComments: '',trainerComments: '')
		event3.save()
		assertEquals 3, event3.id
	}

	protected void tearDown() {
		super.tearDown()
	}

	void testIndex() {
		eventController.index()
		// Nothing to test.  The redirection to list is not actually executed here.
	}
	void testList() {
		def model = eventController.list()
		assertEquals 3, model.eventInstanceTotal
		assertEquals 3, model.eventInstanceList.size()
		def nosuch = Event.findByName('EventX')
		assertFalse model.eventInstanceList.contains(nosuch)
		def event1 = Event.findByName('Event1')
		assertTrue model.eventInstanceList.contains(event1)
	}

	void testCreate_Empty() {
		def model = eventController.create()
		assertEquals Event.class.name, model.eventInstance.class.name
		assertNull model.eventInstance.id
	}
	void testCreate_PreFilled() {
		eventController.params.putAll([id: 1,name: 'Event1',description: 'Agile Practices',trainer: trainer,venue: venue,startTime: new Date("6/28/2011 10:00") ,endTime: new Date("6/28/2011 17:00"),keywords: '',level: 'Advanced',studentComments: '',trainerComments: ''])
		def model = eventController.create()
		assertEquals Event.class.name, model.eventInstance.class.name
		assertEquals 1,model.eventInstance.id
		assertEquals 'Event1',model.eventInstance.name
	}
	
	void testShow() {
		eventController.params.id = 2
		def model = eventController.show()
		assertEquals Event.class.name, model.eventInstance.class.name
		assertEquals 2, model.eventInstance.id
		assertEquals 'Event2', model.eventInstance.name
	}

	void testShow_NoSuch() {
		eventController.params.id = 999
		def model = eventController.show()
		assertNull model
		assertEquals 'default.not.found.message',eventController.flash.message
	}

	 void testSave_Good() {
		eventController.params.putAll([name: 'Event4',description: 'Agile Practices',trainer: trainer,venue: venue,startTime: new Date("6/28/2011 10:00") ,endTime: new Date("6/28/2011 17:00"),keywords: '',level: 'Advanced',studentComments: '',trainerComments: ''])
		eventController.save()
		def event4 = Event.findByName('Event4')
		assertEquals 4,event4.id
		
	}
	 void testSave_Invalid() {
		 eventController.params.putAll([name: 'Event4', description: 'Intro'])
		 eventController.save()
		 def event4 = Event.findByName('Event4')
		 assertNull event4
	 }
	 
	void testEdit_Event1() {
		eventController.params.id = 1
		def model = eventController.edit()
		assertEquals Event.class.name, model.eventInstance.class.name
		assertEquals 1,model.eventInstance.id
		assertEquals 'Event1',model.eventInstance.name
	}
	
	void testEdit_Event2() {
		eventController.params.id = 2
		def model = eventController.edit()
		assertEquals Event.class.name, model.eventInstance.class.name
		assertEquals 2,model.eventInstance.id
		assertEquals 'Event2',model.eventInstance.name
	}
	
	void testEdit_noSuch() {
		eventController.params.id = 999
		def model = eventController.edit()
		assertNull model
		assertEquals 'default.not.found.message',eventController.flash.message
	}
	
	void testUpdate_Good() {
		eventController.params.id = 1
		eventController.params.name = 'EventNew'
		eventController.update()
		def eventNew = Event.findByName('EventNew')
		assertEquals 'EventNew',eventNew.name
		assertEquals 'default.updated.message',eventController.flash.message
	}
	
	void testUpdate_noSuch() {
		eventController.params.id = 999
		def model = eventController.update()
		assertNull model
		assertEquals 'default.not.found.message',eventController.flash.message
	}
	
	void testDelete_Good() {
		eventController.params.id = 1
		eventController.delete()
		def event1 = Event.findByName('Event1')
		assertNull event1
		assertEquals 'default.deleted.message',eventController.flash.message
	}
	
	void testDelete_Bad() {
		eventController.params.id = 999
		def model = eventController.delete()
		assertEquals 'default.not.found.message',eventController.flash.message
		assertNull model
	}

}
