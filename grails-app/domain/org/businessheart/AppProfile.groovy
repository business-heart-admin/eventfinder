
package org.businessheart

import java.util.Date;

class AppProfile extends grails.plugins.nimble.core.ProfileBase {

	String firstName = ''
	String lastName = ''
	String email = ''
	Boolean displayGravatar = true
	String phone = ''
	String address1 = ''
	String address2 = ''
	String city = ''
	String state = ''
	String country = "USA"
	String zip = ''
	Date dateCreated
	Date lastUpdated
	
	static constraints = {
		firstName(blank:false,minSize:3)
		lastName(blank:false,minSize:3)
		email(blank:false,email:true,unique:true)
		displayGravatar(nullable:false)
		phone(blank:true)
		address1(blank:true)
		address2(blank:true)
		city(blank:true)
		state(blank:true)
		country(blank:true)
		zip(blank:true)
	
	}
	String toString(){
		return lastName + ", " + firstName + " (" + email + ")";

}
}
