package example.fixture

import net.xelnaga.httpimposter.model.ImposterRequest
import com.popcornteam.restclient.header.ContentType
import net.xelnaga.httpimposter.model.HttpHeader

class FakeTimeRequest {

    static ImposterRequest asGet() {

        return new ImposterRequest(
                uri: "/http-imposter-example/fake/TimeService/V1/getTime?appid=test&output=json",
                method: 'GET',
                headers: [],
                body: ''
        )
    }
}
