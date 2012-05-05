package http.imposter.example

import grails.converters.JSON

class RealController {

    def index() {

        def map = ["message":"hello"]
        render map as JSON
    }
}
