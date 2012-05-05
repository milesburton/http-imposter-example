class UrlMappings {

	static mappings = {

        "/time"                         (controller:'time', action: 'index')

		"/"                             (view:"/index")
		"500"                           (view:'/error')
	}
}
