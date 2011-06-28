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
		assertEquals 10,venue.errors.errorCount
		//venue.errors.each {println it}
		assertEquals "nullable",venue.errors["contactPhone"]
	}

	void testValidate_Blank() {
		def venue = new Venue()
		venue.name = ''
		venue.address1 = ''
		venue.address2 = ''
		venue.city = ''
		venue.state = ''
		venue.country = ''
		venue.zip = ''
		venue.contactName = ''
		venue.contactPhone = ''
		venue.capacity = 0
		venue.trainerComments = ''
		venue.studentComments = ''
		assertFalse venue.validate()
		assertTrue venue.hasErrors()
		assertEquals 5,venue.errors.errorCount
		//enue.errors.each {println it}
		assertEquals "blank",venue.errors["city"]
	}

	void testValidate_Good() {
		def venue = new Venue()
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
		assertTrue venue.validate()
		assertFalse venue.hasErrors()
		assertEquals 0,venue.errors.errorCount
		//venue.errors.each {println it}
	}
		
	public void testToString() throws Exception {
		def venue = new Venue()
		venue.name = 'Conscires'
		assertEquals 'Conscires',venue.toString()
		
	}

}
