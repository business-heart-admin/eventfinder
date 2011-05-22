package org.businessheart

class Trainer {
	String name
	String email
	Boolean displayGravatar
	String phone
	String address1
	String address2
	String city
	String state
	String country = "USA"
	String zip
	String organization
	String certifications
	Boolean active = true
	String categories
	String comments
	Date dateCreated
	Date lastUpdated

	static constraints = {
		name(blank:false,unique:true,minSize:3)
		email(blank:false,email:true,unique:true)
		displayGravatar(nullable:false)
		phone(blank:false)
		address1(blank:false)
		address2(blank:true)
		city(blank:false)
		state(blank:false)
		country(blank:false)
		zip(blank:true)
		organization(blank:true)
		certifications(blank:true)
		active()
		categories(blank:true)
		comments(blank:true,maxSize:4000,widget:"textarea")

}
}
