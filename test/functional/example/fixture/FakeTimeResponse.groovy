package example.fixture

import net.xelnaga.httpimposter.model.ImposterResponse
import static org.apache.http.HttpStatus.*
import com.popcornteam.restclient.header.ContentType
import net.xelnaga.httpimposter.model.HttpHeader
import grails.converters.JSON


class FakeTimeResponse {

    static ImposterResponse withTimeResponse(Long unixTime) {

        return new ImposterResponse(
                status: SC_OK.value,
                headers: [],
                body: """{"Result":{"Timestamp":${unixTime}}}"""

        )
    }
}
