package http.imposter.example

import net.xelnaga.httpimposter.filter.HttpHeaderFilter
import net.xelnaga.httpimposter.HttpImposter
import net.xelnaga.httpimposter.filter.HeaderNameExclusionFilter

class FakeController {

    private static final HttpHeaderFilter FILTER = new HeaderNameExclusionFilter([ 'Host', 'User-Agent', 'Connection', 'Content-Length' ])
    private static final HttpImposter IMPOSTER = new HttpImposter(filter:  FILTER)

    def index() {
        IMPOSTER.respond(request, response)
    }

    def reset() {

        IMPOSTER.reset()
        render ''
    }

    def configure() {

        IMPOSTER.configure(request)
        render ''
    }
}
