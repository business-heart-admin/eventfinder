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
		Trainer trainer = new Trainer();
		trainer.firstName = "Joe"
		trainer.lastName = "Smith"
		trainer.email = "joe.smith@example.com"
		trainer.displayGravatar = true
		trainer.phone = "9999999"
		trainer.address1 = "235"
		trainer.address2 = "Example"
		trainer.city = "Irvine"
		trainer.state = "CA"
		trainer.country = "USA"
		trainer.zip = "999"
		trainer.organization = "Conscires"
		trainer.website = "http://www.example.com"
		trainer.certifications = "CSM"
		trainer.active = true
		trainer.keywords = "Scrum"
		trainer.comments = "NA"

		try{
			trainer.save(failOnError:true)
		}
		catch(Exception e){
			//do nothing
		}
		
		log.trace("Enter Sample Venue")
		Venue venue = new Venue();
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
		catch(Exception e){
			//do nothing
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
		catch(Exception e){
			//do nothing
		}
	
	}

}
