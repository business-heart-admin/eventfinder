package org.businessheart

import grails.test.*

/**
 * The following tests merely execute the controller closures directly, and then test what they return.  In other words,
 * we are stopping short of actually invoking the rendering engine, so the pages are not actually rendered. (We use
 * Selenium to test that.)  Instead, these tests tell us if the closures are providing the appropriate information that
 * the rendering engine would need if it were to be invoked.
 */
class TrainerControllerTests extends ControllerUnitTestCase {
    TrainerController trainerController
    Trainer trainer1
    Trainer trainer2
    Trainer trainer3

    protected void setUp() {
        super.setUp()

        mockDomain(Trainer)
        mockController(TrainerController)
        trainerController = new TrainerController()
        trainerController.metaClass.message = { LinkedHashMap args -> return "${args.code}" }

        // We'll create and save three Trainers here, so when the List controller calls Trainer.list, it will get back a list of these three, and when Show controller calls Trainer.get(2) it will get back the second one (Jane)
        trainer1 = new Trainer(email: 'joe@example.com', firstName: 'Joe', lastName: 'Smith', phone: '(949) 555-1212', displayGravatar: false, address1: '1234 Main St.', city: 'Anytown', state: 'CA', country: 'USA', zip: '99999')
        trainer1.save()
        assertEquals 1, trainer1.id

        trainer2 = new Trainer(email: 'jane@example.com', firstName: 'Jane', lastName: 'Smith', phone: '(949) 555-1212', displayGravatar: false, address1: '1234 Main St.', city: 'Anytown', state: 'CA', country: 'USA', zip: '99999')
        trainer2.save()
        assertEquals 2, trainer2.id

        trainer3 = new Trainer(email: 'jeremy@example.com', firstName: 'Jeremy', lastName: 'Smith', phone: '(949) 555-1212', displayGravatar: false, address1: '1234 Main St.', city: 'Anytown', state: 'CA', country: 'USA', zip: '99999')
        trainer3.save()
        assertEquals 3, trainer3.id
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testIndex() {
        trainerController.index()
        // Nothing to test.  The redirection to list is not actually executed here.
    }
    void testList() {
        def model = trainerController.list()
        assertEquals 3, model.trainerInstanceTotal
        assertEquals 3, model.trainerInstanceList.size()
		def nosuch = Trainer.findByEmail('x@example.com')
		assertFalse model.trainerInstanceList.contains(nosuch)
		def jane = Trainer.findByEmail('jane@example.com')
		assertTrue model.trainerInstanceList.contains(jane)
    }

    void testCreate() {
        def model = trainerController.create()
        assertEquals Trainer.class.name, model.trainerInstance.class.name
        assertNull model.trainerInstance.id
    }

    void testShow() {
        trainerController.params.id = 2
        def model = trainerController.show()
        assertEquals Trainer.class.name, model.trainerInstance.class.name
        assertEquals 2, model.trainerInstance.id
        assertEquals 'Jane', model.trainerInstance.firstName
    }

    void testShow_NoSuch() {
        trainerController.params.id = 999
        def model = trainerController.show()
        assertNull model
        assertEquals 'default.not.found.message',trainerController.flash.message
    }

    void testSave() {
        // FIXME need a test here
    }
    void testEdit() {
        // FIXME need a test here
    }
    void testUpdate() {
        // FIXME need a test here
    }
    void testDelete() {
        // FIXME need a test here
    }


}
