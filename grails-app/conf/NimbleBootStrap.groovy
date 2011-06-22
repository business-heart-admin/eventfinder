/*
 *  Nimble, an extensive application base for Grails
 *  Copyright (C) 2010 Bradley Beddoes
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


import grails.plugins.nimble.InstanceGenerator
import grails.plugins.nimble.core.RoleService

import grails.plugins.nimble.core.LevelPermission
import grails.plugins.nimble.core.Role
import grails.plugins.nimble.core.Group
import grails.plugins.nimble.core.AdminsService
import grails.plugins.nimble.core.UserService
import org.businessheart.AppUser
import org.businessheart.AppProfile
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

/*
 * Allows applications using Nimble to undertake process at BootStrap that are related to Nimbe provided objects
 * such as Users, Role, Groups, Permissions etc.
 *
 * Utilizing this BootStrap class ensures that the Nimble environment is populated in the backend data repository correctly
 * before the application attempts to make any extenstions.
 */
class NimbleBootStrap {

	def grailsApplication
	def roleService
	def nimbleService
	def userService
	AdminsService adminsService

	def init = {servletContext ->

		// The following must be executed
		internalBootStap(servletContext)

		// Execute any custom Nimble related BootStrap for your application below

		// Create example User account
		
				
		def passwordText = CH.config.nimble.passwords.mustcontain.uppercase?"!11fdsa3jfaAdsfG8l;J":"secret"
		
		def user = AppUser.findByUsername("user")
		if(!user){
			user = InstanceGenerator.user()
			user.username = "user"
			user.pass = passwordText
			user.passConfirm = passwordText
			user.enabled = true

			def userProfile = InstanceGenerator.profile()
			userProfile.fullName = "Test User"
			userProfile.owner = user
			user.profile = userProfile

			def savedUser = userService.createUser(user)
			if (savedUser.hasErrors()) {
				savedUser.errors.each { log.error(it) }
				throw new RuntimeException("Error creating example user")
			}
		}
		// Create roles for student, trainer and event coordinator
		roleService.createRole("STUDENT", "Can signup for a class", false)
		roleService.createRole("TRAINER", "Can create, and be trainer for, classes", false)
		roleService.createRole("EVENT COORDINATOR", "Can manage classes on behalf of other trainers", false)
		// Create example Administrative account

		def admins = Role.findByName(AdminsService.ADMIN_ROLE)

			def admin = AppUser.findByUsername("admin")
		if(!admin){
			admin = InstanceGenerator.user()
			admin.username = "admin"
		
			admin.pass = passwordText
			admin.passConfirm = passwordText
			admin.enabled = true

			def adminProfile = InstanceGenerator.profile()
			adminProfile.fullName = "Administrator"
			adminProfile.owner = admin
			admin.profile = adminProfile

			def savedAdmin = userService.createUser(admin)
			if (savedAdmin.hasErrors()) {
				savedAdmin.errors.each { log.error(it) }
				throw new RuntimeException("Error creating administrator")
			}

			adminsService.add(admin)
		}
	}

	def destroy = {

	}

	private internalBootStap(def servletContext) {
		nimbleService.init()
	}
}
