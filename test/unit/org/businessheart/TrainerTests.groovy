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
		assertEquals 7,trainer.errors.errorCount
		assertEquals "blank",trainer.errors["phone"]
	}

	void testValidate_Good() {
        Trainer trainer = new Trainer(email: 'joe@example.com',phone: '(949) 555-1212', lastName: 'Smith', firstName: 'Joe',  displayGravatar: false, address1: '1234 Main St.', city: 'Anytown', state: 'CA', country: 'USA', zip: '99999')
		assertTrue trainer.validate()
		assertFalse trainer.hasErrors()
		assertEquals 0,trainer.errors.errorCount
		//trainer.errors.each {println it}
	}

    void testValidate_BadEmail() {
        Trainer trainer = new Trainer(email: 'joeexample.com',phone: '(949) 555-1212', lastName: 'Smith', firstName: 'Joe',  displayGravatar: false, address1: '1234 Main St.', city: 'Anytown', state: 'CA', country: 'USA', zip: '99999')
		assertFalse trainer.validate()
		assertTrue trainer.hasErrors()
		assertEquals 1,trainer.errors.errorCount
		//trainer.errors.each {println it}
		assertEquals "email",trainer.errors["email"]
	}

	public void testToString() throws Exception {
		Trainer trainer = new Trainer(lastName: 'Smith',firstName: 'Joe',email: 'joeexample.com')
		assertEquals 'Smith, Joe (joeexample.com)',trainer.toString()

	}

	void testValidate_BadUrl() {
		Trainer trainer = new Trainer(phone: '(949) 555-1212',lastName: 'Smith',firstName: 'Joe',email: 'joe@example.com', displayGravatar: false, address1: '1 Greco', address2: '', city:'Anytown', state: 'CA', country: 'USA', zip: '99999', organization: '', website: 'www.conscires.com', certifications: '', comments: '', keywords: '')
		assertFalse trainer.validate()
		assertTrue trainer.hasErrors()
		assertEquals 1,trainer.errors.errorCount
		//trainer.errors.each {println it}
		assertEquals "url",trainer.errors["website"]
	}

}

