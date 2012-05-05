package http.imposter.example.fixture

import net.xelnaga.httpimposter.model.ImposterResponse
import static org.apache.http.HttpStatus.*
import com.popcornteam.restclient.header.ContentType
import net.xelnaga.httpimposter.model.HttpHeader
import grails.converters.JSON


class RealResponse {

    static ImposterResponse withHelloJsonResponse() {

        return new ImposterResponse(
                status: SC_OK.value,
                headers: [
                        new HttpHeader('Content-Type', ContentType.APPLICATION_JSON),
                ],
                body: "{'message':'hello'}"
        )
    }
}
