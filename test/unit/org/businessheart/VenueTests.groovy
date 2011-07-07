package org.businessheart

import grails.test.*

class VenueTests extends GrailsUnitTestCase {
	protected void setUp() {
		super.setUp()
		mockDomain(Venue)
	}

	protected void tearDown() {
		super.tearDown()
	}

	void testValidate_Empty() {
		def venue = new Venue()
		assertFalse venue.validate()
		assertTrue venue.hasErrors()
		assertEquals 4,venue.errors.errorCount
		//venue.errors.each {println it}
		assertEquals "blank",venue.errors["state"]
	}

	void testValidate_Good() {
		Venue venue = new Venue(name: 'Conscires', address1: '1 Greco Aisle', address2:'',city: 'Irvine', state: 'CA', country: 'USA', zip: '', contactName: '', contactPhone: '', capacity: 10, trainerComments: '', studentComments: '')
		assertTrue venue.validate()
		assertFalse venue.hasErrors()
		assertEquals 0,venue.errors.errorCount
		//venue.errors.each {println it}
	}
		
	public void testToString() throws Exception {
		Venue venue = new Venue(name: 'Conscires')
		assertEquals 'Conscires',venue.toString()
		
	}

}
