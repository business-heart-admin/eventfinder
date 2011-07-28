package org.businessheart
import grails.plugins.nimble.core.AdminsService;

import org.apache.shiro.SecurityUtils


class HomeController {
	AdminsService adminsService

	def index = {
		if(SecurityUtils.subject.authenticated) {
			if(SecurityUtils.subject.hasRole(AdminsService.ADMIN_ROLE))
			 {	
				redirect(controller: 'administration',action: 'adminstrators')
			}
			else
			{
				redirect(action:dash, params:params)
			}
		}
	}
	def dash = {
		def appUser = AppUser.get(SecurityUtils.subject.principal)
		def trainerEvents = Event.findAllByTrainer(appUser.trainer)
		def studentEvents = []
		return ['trainerEvents': trainerEvents,'studentEvents':studentEvents]
	}
}
