package org.businessheart
import org.apache.shiro.SecurityUtils

class HomeController {

	def index = {
		if(SecurityUtils.subject.authenticated){
			redirect(action:dash, params:params)
		}
	}
	def dash = {
	}
}
