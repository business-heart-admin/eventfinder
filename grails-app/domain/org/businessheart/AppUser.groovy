
package org.businessheart

import java.util.Date;

class AppUser extends grails.plugins.nimble.core.UserBase {
	
	Trainer trainer;
	
	static constraints = {
		trainer(nullable:true)
	}
	
	String toString(){
		return username;

}
	
	}
