package org.businessheart
import org.apache.shiro.SecurityUtils

class TrainerController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [trainerInstanceList: Trainer.list(params), trainerInstanceTotal: Trainer.count()]
    }

    def create = {
        def trainerInstance = new Trainer()
        trainerInstance.properties = params
		Long securityUtilsSubjectPrincipal = SecurityUtils.subject.principal
		trainerInstance.owner = AppUser.get(securityUtilsSubjectPrincipal)
        return [trainerInstance: trainerInstance]
    }

    def save = {
        def trainerInstance = new Trainer(params)
		def appUser = trainerInstance.owner
		appUser.trainer = trainerInstance
        if (trainerInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'trainer.label', default: 'Trainer'), trainerInstance.id])}"
            redirect(action: "show", id: trainerInstance.id)
        }
        else {
            render(view: "create", model: [trainerInstance: trainerInstance])
        }
    }

    def show = {
        def trainerInstance = Trainer.get(params.id)
        if (!trainerInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'trainer.label', default: 'Trainer'), params.id])}"
            redirect(action: "list")
        }
        else {
            [trainerInstance: trainerInstance]
        }
    }

    def edit = {
        def trainerInstance = Trainer.get(params.id)
        if (!trainerInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'trainer.label', default: 'Trainer'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [trainerInstance: trainerInstance]
        }
    }

    def update = {
        def trainerInstance = Trainer.get(params.id)
        if (trainerInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (trainerInstance.version > version) {
                    
                    trainerInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'trainer.label', default: 'Trainer')] as Object[], "Another user has updated this Trainer while you were editing")
                    render(view: "edit", model: [trainerInstance: trainerInstance])
                    return
                }
            }
            trainerInstance.properties = params
            if (!trainerInstance.hasErrors() && trainerInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'trainer.label', default: 'Trainer'), trainerInstance.id])}"
                redirect(action: "show", id: trainerInstance.id)
            }
            else {
                render(view: "edit", model: [trainerInstance: trainerInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'trainer.label', default: 'Trainer'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def trainerInstance = Trainer.get(params.id)
        if (trainerInstance) {
            try {
                trainerInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'trainer.label', default: 'Trainer'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'trainer.label', default: 'Trainer'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'trainer.label', default: 'Trainer'), params.id])}"
            redirect(action: "list")
        }
    }
}
