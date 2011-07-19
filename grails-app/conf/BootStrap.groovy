import java.util.Date;
import org.businessheart.*


class BootStrap {

	def init = {
		servletContext ->
		log.info "-" * 40
		log.info "running bootstrap"
		log.info "-" * 40
		sampleData()
	}
	def destroy = {
	}


	private void sampleData(){
		AppUser joe = AppUser.findByUsername("joesmi")
		if(!joe){
			joe = new AppUser(username: 'joesmi')
			AppProfile appProfile = new AppProfile(email: 'joe@example.com',phone: '(949) 555-1212', lastName: 'Smith', firstName: 'Joe',  displayGravatar: false, address1: '1234 Main St.', city: 'Anytown', state: 'CA', country: 'USA', zip: '99999',owner: joe)
			joe.profile = appProfile
			try{
				joe.save(failOnError:true)
				//appProfile.save(failOnError:true)
			}
			catch(grails.validation.ValidationException e){
				//do nothing
			}
			
		}
		AppUser jeremy = AppUser.findByUsername("jersmi")
		if(!jeremy){
			jeremy = new AppUser(username: 'jersmi')
			AppProfile appProfile = new AppProfile(email: 'jeremy@example.com',phone: '(949) 555-1212', lastName: 'Smith', firstName: 'Jeremy',  displayGravatar: false, address1: '1234 Main St.', city: 'Anytown', state: 'CA', country: 'USA', zip: '99999',owner: jeremy)
			jeremy.profile = appProfile
			Trainer trainer = new Trainer(organization: 'Conscires',website: 'http://example.com', certifications: 'Scrum', owner: jeremy)
			joe.trainer = trainer
			try{
				jeremy.save(failOnError:true)
				//appProfile.save(failOnError:true)
				//trainer.save(failOnError:true)
			}
			catch(grails.validation.ValidationException e){
				//do nothing
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
event.trainer = trainer
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
}
