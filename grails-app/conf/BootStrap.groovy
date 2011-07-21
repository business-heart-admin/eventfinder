import grails.plugins.nimble.InstanceGenerator

import java.util.Date

import org.businessheart.*
import grails.plugins.nimble.core.LevelPermission
import grails.plugins.nimble.core.Role
import grails.plugins.nimble.core.Group
import grails.plugins.nimble.core.AdminsService
import grails.plugins.nimble.core.UserService
import org.businessheart.AppUser
import org.businessheart.AppProfile
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH


class BootStrap {
	def userService
	def nimbleService

	def init = { servletContext ->
		log.info "-" * 40
		log.info "running bootstrap"
		log.info "-" * 40
		internalBootStap(servletContext)
		sampleData()
	}
	def destroy = {
	}

	def passwordText = CH.config.nimble.passwords.mustcontain.uppercase?"!11fdsa3jfaAdsfG8l;J":"secret"
	private void sampleData(){
		AppUser joe = AppUser.findByUsername("joesmi")
		if(!joe){
			joe = InstanceGenerator.user()
			joe.username = 'joesmi'
			joe.pass = passwordText
			joe.passConfirm = passwordText
			joe.enabled = true

			AppProfile appProfile = InstanceGenerator.profile()
			appProfile.email = 'joe@example.com'
			appProfile.phone = '(949) 555-1212'
			appProfile.lastName = 'Smith'
			appProfile.firstName = 'Joe'
			appProfile.displayGravatar = false
			appProfile.address1 = '1234 Main St.'
			appProfile.city = 'Anytown'
			appProfile.state = 'CA'
			appProfile.country = 'USA'
			appProfile.zip = '99999'
			appProfile.owner = joe

			joe.profile = appProfile

			def savedUser = userService.createUser(joe)
			if (savedUser.hasErrors()) {
				savedUser.errors.each { log.error(it) }
				throw new RuntimeException("Error creating joe")
			}
		}
		AppUser jeremy = AppUser.findByUsername("jersmi")
		if(!jeremy){
			jeremy = InstanceGenerator.user()
			jeremy.username = 'jersmi'
			jeremy.pass = passwordText
			jeremy.passConfirm = passwordText
			jeremy.enabled = true
			
			AppProfile appProfile = InstanceGenerator.profile()
			appProfile.email = 'jeremy@example.com'
			appProfile.phone = '(949) 555-1212'
			appProfile.lastName = 'Smith'
			appProfile.firstName = 'Jeremy'
			appProfile.displayGravatar = false
			appProfile.address1 = '1234 Main St.'
			appProfile.city = 'Anytown'
			appProfile.state = 'CA'
			appProfile.country = 'USA'
			appProfile.zip = '99999'
			appProfile.owner = jeremy
			jeremy.profile = appProfile

			Trainer trainer = new Trainer(organization: 'Conscires',website: 'http://example.com', certifications: 'Scrum', owner: jeremy)
			jeremy.trainer = trainer

			def savedUser = userService.createUser(jeremy)
			if (savedUser.hasErrors()) {
				savedUser.errors.each { log.error(it) }
				throw new RuntimeException("Error creating jeremy")
			}
		}
		log.trace("Enter Sample Venue")
		Venue venue = Venue.findByName("RC Global")
		if(!venue){
			venue = new Venue();
			venue.name = "RC Global"
			venue.address1 = "Greco Aisle"
			venue.address2 = "bbhsabj"
			venue.city = "Irvine"
			venue.state = "California"
			venue.country = "USA"
			venue.zip = "92614"
			venue.contactName = "John"
			venue.contactPhone = "56798809"
			venue.capacity = 1000
			venue.trainerComments = "Test"
			venue.studentComments = "Test"

			try{
				venue.save(failOnError:true)
			}
			catch(grails.validation.ValidationException e){
				//do nothing
			}
		}


		log.trace("Enter Sample Event")
		Event event = new Event();
		event.name = "Agile"
		event.description = "SCRUM Coaching"
		event.venue = venue
		event.trainer = findTrainerByEmail("jeremy@example.com")
		event.startTime = new Date("6/22/2011 5:30")
		event.endTime = new Date("6/23/2011 5:30")
		event.keywords = "Agile"
		event.level = "Beginner"
		event.trainerComments = "Test"
		event.studentComments = "Test"

		try{
			event.save(failOnError:true)
		}
		catch(grails.validation.ValidationException e){
			//do nothing
		}
	}

	Trainer findTrainerByEmail(String email) {
		AppProfile appProfile = AppProfile.findByEmail(email)
		return appProfile.owner.trainer
	}
	
	private internalBootStap(def servletContext) {
		nimbleService.init()
	}
}

