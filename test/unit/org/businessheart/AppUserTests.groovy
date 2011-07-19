package org.businessheart

import grails.test.*

class AppUserTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
		mockDomain(AppUser)
    }

    protected void tearDown() {
        super.tearDown()
    }

   public void testToString() throws Exception {
		AppUser appUser = new AppUser(username: 'joesmi')
		assertEquals 'joesmi',appUser.toString()

	}
}
