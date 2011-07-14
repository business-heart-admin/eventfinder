package org.businessheart

import grails.test.*

class WidgetsTagLibTests extends TagLibUnitTestCase {
	Trainer trainer1
	Trainer trainer2
	Trainer trainer3
	Trainer trainer4
	
	Trainer trainer
	Venue venue
	Event event1
	Event event2
	Event event3
	
    protected void setUp() {
		def cal = new GregorianCalendar()
		
        super.setUp()
		mockDomain(Trainer)
		mockDomain(Event)
		mockDomain(Venue)
		
		// We'll create and save three Trainers here, so when the List controller calls Trainer.list, it will get back a list of these three, and when Show controller calls Trainer.get(2) it will get back the second one (Jane)
		trainer1 = new Trainer(email: 'joe@example.com', firstName: 'Joe', lastName: 'Smith', phone: '(949) 555-1212', displayGravatar: false, address1: '1234 Main St.', city: 'Anytown', state: 'CA', country: 'USA', zip: '99999')
		trainer1.save()

		trainer2 = new Trainer(email: 'jane@example.com', firstName: 'Jane', lastName: 'Smith', phone: '(949) 555-1212', displayGravatar: false, address1: '1234 Main St.', city: 'Anytown', state: 'CA', country: 'USA', zip: '99999')
		trainer2.save()

		trainer3 = new Trainer(email: 'jeremy@example.com', firstName: 'Jeremy', lastName: 'Smith', phone: '(949) 555-1212', displayGravatar: false, address1: '1234 Main St.', city: 'Anytown', state: 'CA', country: 'USA', zip: '99999')
		trainer3.save()
		
		trainer4 = new Trainer(email: 'john@example.com', firstName: 'John', lastName: 'Smith', phone: '(949) 555-1212', displayGravatar: false, address1: '1234 Main St.', city: 'Anytown', state: 'CA', country: 'USA', zip: '99999')
		trainer4.save()
		
		
		trainer = new Trainer(phone: '9946555257',lastName: 'Smith',firstName: 'Joe',email: 'joe@example.com',displayGravatar: false,address1: '1 Greco',address2: '',city: 'Anytown',state: 'CA',country: 'USA',zip: '99999',organization: '',website: '',certifications: '',comments: '',keywords: '')
		venue= new Venue(name: 'Conscires',address1: '1 Greco Aisle',address2: '',city: 'Irvine',state: 'CA',country: 'USA',zip: '',contactName: '',contactPhone: '',capacity: 10,trainerComments: '',studentComments: '')
		
		// We'll create and save three Events here, so when the List controller calls Event.list, it will get back a list of these three, and when Show controller calls Event.get(2) it will get back the second one (Jane)
		def today = cal.getTime()
		cal.add(Calendar.DAY_OF_MONTH,1)
		def tommorow = cal.getTime()
		cal.add(Calendar.MONTH,1)
		def nextMonth = cal.getTime()
		cal.setTime(today)
		cal.add(Calendar.DAY_OF_MONTH,-1)
		def yesterday = cal.getTime()
		
		event1 = new Event(name: 'EventTommorow',description: 'Agile Practices',trainer: trainer,venue: venue,startTime: tommorow ,endTime: tommorow ,keywords: '',level: 'Advanced',studentComments: '',trainerComments: '')
		event1.save()

		event2 = new Event(name: 'EventNextMonth',description: 'Agile Practices',trainer: trainer,venue: venue,startTime: nextMonth ,endTime: nextMonth ,keywords: '',level: 'Advanced',studentComments: '',trainerComments: '')
		event2.save()
		
		event3 = new Event(name: 'EventYesterday',description: 'Agile Practices',trainer: trainer,venue: venue,startTime: yesterday ,endTime: yesterday ,keywords: '',level: 'Advanced',studentComments: '',trainerComments: '')
		event3.save()
    }

    protected void tearDown() {
        super.tearDown()
    }
/* <ef:widget id="newTrainers" title="New Trainers"/>
 */
   /* void testWidget_newTrainers() {
		def widgetsTagLib = new WidgetsTagLib()
		def actual = widgetsTagLib.widget([id: 'newTrainers', title: 'New Trainers'],'')
		assertEquals("<div id='newTrainers' class='widget'>",actual)
    }*/
	
	void testWidget_upcomingEvents() {
		def widgetsTagLib = new WidgetsTagLib()
		def actual = widgetsTagLib.widget([id: 'upcomingEvents', title: 'Upcoming Events'],'')
		def expected = "<div id='upcomingEvents' class='widget'><div class='titleSection'><h1 class='title'>Upcoming Events</h1></div><ul><li>EventTommorow</li><li>EventNextMonth</li></ul></div>"
		assertEquals(expected,actual.toString()) 
	}
}
