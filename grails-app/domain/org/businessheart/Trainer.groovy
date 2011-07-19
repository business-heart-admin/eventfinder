package org.businessheart

class Trainer {
	
	String organization = ''
	String website = ''
	String certifications = ''
	Boolean active = true
	String keywords = ''
	String comments = ''
	Date dateCreated
	Date lastUpdated

	static belongsTo = [appUser: AppUser]
	
	
	static constraints = {
		organization(blank:true)
		website(url:true,blank:true)
		certifications(blank:true)
		active()
		keywords(blank:true)
		comments(blank:true,maxSize:4000,widget:"textarea")

	}
	
	String toString(){
		return "Trainer: " + appUser.toString();

}

}
