package org.businessheart

import grails.test.*
import grails.plugins.nimble.core.ProfileBase

class AppProfileTests extends GrailsUnitTestCase {
	
	def appUser
	
	protected void setUp() {
		super.setUp()
		mockDomain(AppProfile)
		mockDomain(AppUser)
		
	  appUser = new AppUser(username: 'joesmi')
	}

	protected void tearDown() {
		super.tearDown()
	}

	void testValidate_Empty() {
		def appProfile = new AppProfile()
		assertFalse appProfile.validate()
		assertTrue appProfile.hasErrors()
		assertEquals 8,appProfile.errors.errorCount
		//appProfile.errors.each {println it}
		assertEquals "blank",appProfile.errors["phone"]
	}

	void testValidate_Good() {
		AppProfile appProfile = new AppProfile(email: 'joe@example.com',phone: '(949) 555-1212', lastName: 'Smith', firstName: 'Joe',  displayGravatar: false, address1: '1234 Main St.', city: 'Anytown', state: 'CA', country: 'USA', zip: '99999',owner: appUser)
		appUser.profile = appProfile
		assertTrue appProfile.validate()
		assertFalse appProfile.hasErrors()
		assertEquals 0,appProfile.errors.errorCount
	}
	
	void testValidate_BadEmail() {
		AppProfile appProfile = new AppProfile(email: 'joeexample.com',phone: '(949) 555-1212', lastName: 'Smith', firstName: 'Joe',  displayGravatar: false, address1: '1234 Main St.', city: 'Anytown', state: 'CA', country: 'USA', zip: '99999',owner: appUser)
		appUser.profile = appProfile
		assertFalse appProfile.validate()
		assertTrue appProfile.hasErrors()
		assertEquals 1,appProfile.errors.errorCount
		//appProfile.errors.each {println it}
		assertEquals "email",appProfile.errors["email"]
	}

	public void testToString() throws Exception {
		AppProfile appProfile = new AppProfile(lastName: 'Smith',firstName: 'Joe',email: 'joeexample.com')
		assertEquals 'Smith, Joe (joeexample.com)',appProfile.toString()
	}
}
