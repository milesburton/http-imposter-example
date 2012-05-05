package http.imposter.example

import spock.lang.Specification
import net.xelnaga.httpimposter.remote.HttpImposterRemote
import com.popcornteam.restclient.RestClient
import org.apache.http.client.HttpClient
import com.popcornteam.restclient.factory.HttpClientFactory
import com.popcornteam.restclient.response.RestResponse
import http.imposter.example.fixture.RealRequest
import http.imposter.example.fixture.RealResponse
import com.popcornteam.restclient.header.HttpHeader


class ImposterSpec extends Specification {


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

        jsonClient = new RestClient(baseUrl, [new HttpHeader("Accept","application/json")], httpClient)
    }

    def 'test something'() {

             given:
                 imposterRemote.configure(RealRequest.withGetJsonRequest(), RealResponse.withHelloJsonResponse())

             when:
                RestResponse response = jsonClient.get("/fake/index")

             then:
                response.bodyAsJsonMap.message == "hello"
    }
}
