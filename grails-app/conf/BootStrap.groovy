import java.util.Date;
import org.businessheart.*
class BootStrap {

	def init = {
		servletContext ->
		log.info "-" * 40
		log.info "running bootstrap"
		log.info "-" * 40
		sampleTrainers()
	}
	def destroy = {
	}
	private void sampleTrainers(){
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
	}
}


