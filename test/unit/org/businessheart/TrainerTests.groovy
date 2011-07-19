package org.businessheart

import grails.test.*

class TrainerTests extends GrailsUnitTestCase {
	
	def appUser
	
	protected void setUp() {
		super.setUp()
		mockDomain(Trainer)
		mockDomain(AppUser)
		
	  appUser = new AppUser(username: 'joesmi')
	}

	protected void tearDown() {
		super.tearDown()
	}

	void testValidate_Empty() {
		def trainer = new Trainer()
		assertFalse trainer.validate()
		assertTrue trainer.hasErrors()
		assertEquals 1,trainer.errors.errorCount
	}

	void testValidate_Good() {
        Trainer trainer = new Trainer(organization: 'Conscires',website: 'http://example.com', certifications: 'Scrum', owner: appUser)
		appUser.trainer = trainer
		assertTrue trainer.validate()
		assertFalse trainer.hasErrors()
		assertEquals 0,trainer.errors.errorCount
	}

  
	public void testToString() throws Exception {
		Trainer trainer = new Trainer(owner: appUser)
		appUser.trainer = trainer
		assertEquals 'Trainer: joesmi',trainer.toString()

	}

	void testValidate_BadUrl() {
		Trainer trainer = new Trainer(organization: '', website: 'www.conscires.com', certifications: '', comments: '', keywords: '', owner: appUser)
		appUser.trainer = trainer
		assertFalse trainer.validate()
		assertTrue trainer.hasErrors()
		assertEquals 1,trainer.errors.errorCount
		//trainer.errors.each {println it}
		assertEquals "url",trainer.errors["website"]
	}

}

