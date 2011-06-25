package org.businessheart

import grails.test.*

class TrainerTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testValidate_Empty() {
		def trainer = new Trainer()
		assertFalse trainer.validate()
		assertTrue trainer.hasErrors()
		assertEquals 4,trainer.errors.errorCount
    }
}
