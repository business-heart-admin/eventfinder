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
		def appUserTrainer = appUser.trainer
		def trainerEvents =[]
		def isStudentOnly = !(SecurityUtils.subject.hasRole('TRAINER') || SecurityUtils.subject.hasRole('EVENT COORDINATOR'))
		if(appUserTrainer)
		{
		trainerEvents = Event.findAllByTrainer(appUserTrainer)
		}
		def studentEvents = []
		return ['isStudentOnly': isStudentOnly,'trainerEvents': trainerEvents,'studentEvents':studentEvents]
	}
}
