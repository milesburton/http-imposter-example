package http.imposter.example.fixture

import net.xelnaga.httpimposter.model.ImposterRequest
import com.popcornteam.restclient.header.ContentType
import net.xelnaga.httpimposter.model.HttpHeader

class RealRequest {

    static ImposterRequest withGetJsonRequest() {

        return new ImposterRequest(
                uri: "/http-imposter-example/grails/fake/index.dispatch",
                method: 'GET',
                headers: [
                        new HttpHeader('Accept', ContentType.APPLICATION_JSON)
                ],
                body: ''
        )
    }
}
