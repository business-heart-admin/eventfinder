package org.businessheart

import org.springframework.web.servlet.ModelAndView

class InfoController {
    // See conf/UrlMappings.groovy for where params.page is defined and for why every GSP in the info folder is handled by a single "show" action
    def show = {
        String pageName = params.page ?: "about"
        Map model = [:]
        def id = params.id
        if (id) {
            model.id = id
            log.info("/info/${pageName} visited with code: $id")
        }
        return new ModelAndView("/info/${pageName}", model)
    }
}

