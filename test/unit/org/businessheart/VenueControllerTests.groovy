package org.businessheart

import grails.test.*

class VenueControllerTests extends ControllerUnitTestCase {
    VenueController venueController
    Venue venue1
    Venue venue2
    Venue venue3

    protected void setUp() {
        super.setUp()

        mockDomain(Venue)
        mockController(VenueController)
        venueController = new VenueController()
        venueController.metaClass.message = { LinkedHashMap args -> return "${args.code}" }

        // We'll create and save three Venues here, so when the List controller calls Venue.list, it will get back a list of these three, and when Show controller calls Venue.get(2) it will get back the second one (Jane)
        venue1 = new Venue(name: 'Venue1', address1: '1 Greco Aisle', address2:'',city: 'Irvine', state: 'CA', country: 'USA', zip: '', contactName: '', contactPhone: '', capacity: 10, trainerComments: '', studentComments: '')
        venue1.save()
        assertEquals 1, venue1.id

        venue2 = new Venue(name: 'Venue2', address1: '2 Greco Aisle', address2:'',city: 'Irvine', state: 'CA', country: 'USA', zip: '', contactName: '', contactPhone: '', capacity: 10, trainerComments: '', studentComments: '')
        venue2.save()
        assertEquals 2, venue2.id

        venue3 = new Venue(name: 'Venue3', address1: '3 Greco Aisle', address2:'',city: 'Irvine', state: 'CA', country: 'USA', zip: '', contactName: '', contactPhone: '', capacity: 10, trainerComments: '', studentComments: '')
        venue3.save()
        assertEquals 3, venue3.id
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testIndex() {
        venueController.index()
        // Nothing to test.  The redirection to list is not actually executed here.
    }
    void testList() {
        def model = venueController.list()
        assertEquals 3, model.venueInstanceTotal
        assertEquals 3, model.venueInstanceList.size()
		def nosuch = Venue.findByName('Venue10')
		assertFalse model.venueInstanceList.contains(nosuch)
		def venue1 = Venue.findByName('Venue1')
		assertTrue model.venueInstanceList.contains(venue1)
    }

    void testCreate_Empty() {
        def model = venueController.create()
        assertEquals Venue.class.name, model.venueInstance.class.name
        assertNull model.venueInstance.id
    }
	void testCreate_PreFilled() {
		venueController.params.putAll([id: '1',name: 'Venue1', address1: '1 Greco Aisle', address2:'',city: 'Irvine', state: 'CA', country: 'USA', zip: '', contactName: '', contactPhone: '', capacity: 10, trainerComments: '', studentComments: ''])
		def model = venueController.create()
		assertEquals Venue.class.name, model.venueInstance.class.name
		assertEquals 1,model.venueInstance.id
		assertEquals 'Venue1',model.venueInstance.name
	}
	
    void testShow() {
        venueController.params.id = 2
        def model = venueController.show()
        assertEquals Venue.class.name, model.venueInstance.class.name
        assertEquals 2, model.venueInstance.id
        assertEquals 'Venue2', model.venueInstance.name
    }

    void testShow_NoSuch() {
        venueController.params.id = 999
        def model = venueController.show()
        assertNull model
        assertEquals 'default.not.found.message',venueController.flash.message
    }

     void testSave_Good() {
		venueController.params.putAll([name: 'Venue4', address1: '4 Greco Aisle', address2:'',city: 'Irvine', state: 'CA', country: 'USA', zip: '', contactName: '', contactPhone: '', capacity: 10, trainerComments: '', studentComments: ''])
		venueController.save()
		def venue1 = Venue.findByName('Venue4')
		assertEquals 4,venue1.id
		
    }
	 void testSave_Invalid() {
		 venueController.params.putAll([name: 'Venue5', city: 'Irvine'])
		 venueController.save()
		 def venue1 = Venue.findByName('Venue5')
		 assertNull venue1
	 }
	 
    void testEdit_Venue1() {
		venueController.params.id = 1
		def model = venueController.edit()
		assertEquals Venue.class.name, model.venueInstance.class.name
		assertEquals 1,model.venueInstance.id
		assertEquals 'Venue1',model.venueInstance.name
    }
	
	void testEdit_Venue2() {
		venueController.params.id = 2
		def model = venueController.edit()
		assertEquals Venue.class.name, model.venueInstance.class.name
		assertEquals 2,model.venueInstance.id
		assertEquals 'Venue2',model.venueInstance.name
	}
	
	void testEdit_noSuch() {
		venueController.params.id = 999
		def model = venueController.edit()
		assertNull model
		assertEquals 'default.not.found.message',venueController.flash.message
	}
	
    void testUpdate_Good() {
		venueController.params.id = 1
		venueController.params.city = 'Irving'
		venueController.update()
		def venue1 = Venue.findByName('Venue1')
		assertEquals 'Irving',venue1.city
		assertEquals 'default.updated.message',venueController.flash.message
	}
	
	void testUpdate_noSuch() {
		venueController.params.id = 999
		def model = venueController.update()
		assertNull model
		assertEquals 'default.not.found.message',venueController.flash.message  
	}
	
    void testDelete_Good() {
		venueController.params.id = 1
		venueController.delete()
		def venue1 = Venue.findByName('Venue1')
		assertNull venue1
		assertEquals 'default.deleted.message',venueController.flash.message
    }
	
	void testDelete_Bad() {
		venueController.params.id = 999
		def model = venueController.delete()
		assertEquals 'default.not.found.message',venueController.flash.message
		assertNull model
	}

}
