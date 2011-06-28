package org.businessheart

import grails.test.*

class TrainerTests extends GrailsUnitTestCase {
	protected void setUp() {
		super.setUp()
		mockDomain(Trainer)
	}

	protected void tearDown() {
		super.tearDown()
	}

	void testValidate_Empty() {
		def trainer = new Trainer()
		assertFalse trainer.validate()
		assertTrue trainer.hasErrors()
		assertEquals 15,trainer.errors.errorCount
		assertEquals "nullable",trainer.errors["phone"]
	}

	void testValidate_Blank() {
		def trainer = new Trainer()
		trainer.phone = ''
		trainer.lastName = ''
		trainer.firstName = ''
		trainer.email = ''
		trainer.displayGravatar = false
		trainer.address1 = ''
		trainer.address2 = ''
		trainer.city = ''
		trainer.state = ''
		trainer.country = ''
		trainer.zip = ''
		trainer.organization = ''
		trainer.website = ''
		trainer.certifications = ''
		trainer.comments = ''
		trainer.keywords = ''
		assertFalse trainer.validate()
		assertTrue trainer.hasErrors()
		assertEquals 7,trainer.errors.errorCount
		//trainer.errors.each {println it}
		assertEquals "blank",trainer.errors["phone"]
	}

	void testValidate_Good() {
		def trainer = new Trainer()
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
		assertTrue trainer.validate()
		assertFalse trainer.hasErrors()
		assertEquals 0,trainer.errors.errorCount
		//trainer.errors.each {println it}
	}
	void testValidate_BadEmail() {
		def trainer = new Trainer()
		trainer.phone = '9946555257'
		trainer.lastName = 'Smith'
		trainer.firstName = 'Joe'
		trainer.email = 'joeexample.com'
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
		assertFalse trainer.validate()
		assertTrue trainer.hasErrors()
		assertEquals 1,trainer.errors.errorCount
		//trainer.errors.each {println it}
		assertEquals "email",trainer.errors["email"]
	}
	
	public void testToString() throws Exception {
		def trainer = new Trainer()
		trainer.lastName = 'Smith'
		trainer.firstName = 'Joe'
		trainer.email = 'joeexample.com'
		assertEquals 'Smith, Joe (joeexample.com)',trainer.toString()
		
	}

	void testValidate_BadUrl() {
		def trainer = new Trainer()
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
		trainer.website = 'www.conscires.com'
		trainer.certifications = ''
		trainer.comments = ''
		trainer.keywords = ''
		assertFalse trainer.validate()
		assertTrue trainer.hasErrors()
		assertEquals 1,trainer.errors.errorCount
		//trainer.errors.each {println it}
		assertEquals "url",trainer.errors["website"]
	}
	
}
