package org.businessheart

import grails.test.*

class InfoControllerTests extends ControllerUnitTestCase {
    InfoController infoController

    protected void setUp() {
        super.setUp()

        mockController(InfoController)
        infoController = new InfoController()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testShow_About() {
        infoController.params.page = 'about'
        def modelAndView = infoController.show()
        assertEquals '/info/about',modelAndView.viewName
        assertEquals 0,modelAndView.model.size()
    }
    void testShow_Default() {
        def modelAndView = infoController.show()
        assertEquals '/info/about',modelAndView.viewName
        assertEquals 0,modelAndView.model.size()
    }
    void testShow_Terms() {
        infoController.params.page = 'terms'
        def modelAndView = infoController.show()
        assertEquals '/info/terms',modelAndView.viewName
        assertEquals 0,modelAndView.model.size()
    }
    void testShow_Resource() {
        infoController.params.page = 'resource'
        def modelAndView = infoController.show()
        assertEquals '/info/resource',modelAndView.viewName
        assertEquals 0,modelAndView.model.size()
    }
    void testShow_Resource_numbered() {
        infoController.params.page = 'resource'
        infoController.params.id = '1234'
        def modelAndView = infoController.show()
        assertEquals '/info/resource',modelAndView.viewName
        assertEquals 1,modelAndView.model.size()
        assertEquals '1234',modelAndView.model.id
    }
}
