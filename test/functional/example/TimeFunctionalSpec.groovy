package example

import geb.spock.GebSpec
import net.xelnaga.httpimposter.remote.HttpImposterRemote
import com.popcornteam.restclient.factory.HttpClientFactory
import org.apache.http.client.HttpClient
import com.popcornteam.restclient.RestClient

import example.fixture.FakeTimeRequest
import example.fixture.FakeTimeResponse
import com.popcornteam.restclient.response.RestResponse
import org.joda.time.DateTime

class TimeFunctionalSpec extends GebSpec {

    String baseUrl = "http://localhost:8080/http-imposter-example"
    HttpImposterRemote imposterRemote

    HttpClientFactory httpClientFactory
    HttpClient httpClient

    RestClient jsonClient

    void setup() {

        httpClientFactory = new HttpClientFactory()
        httpClient = httpClientFactory.makeThreadSafeHttpClient(2)

        imposterRemote = new HttpImposterRemote("${baseUrl}/fake")
        imposterRemote.reset()

        jsonClient = new RestClient(baseUrl, [], httpClient)
    }

    def 'get current time'() {

        given:
            imposterRemote.configure(FakeTimeRequest.asGet(), FakeTimeResponse.withTimeResponse(1336216702))

        when:
            RestResponse response = jsonClient.get("/time")

        then:
            response.bodyAsString == new DateTime(1336216702).toString()
    }
}
