class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
        "/info/$page?/$id?" (controller: "info", action: "show")
        "/info/$page?" (controller: "info", action = "show")
		"500"(view:'/error')
        "404"(controller: "errors", action: "notFound")
        // "403"(controller: "errors", action: "forbidden")  -- no 403's in this app (just login redirect)
	}
}
