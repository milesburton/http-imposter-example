package http.imposter.example

import grails.test.mixin.*

import spock.lang.Specification
import com.popcornteam.restclient.RestClient
import com.popcornteam.restclient.response.RestResponse
import com.popcornteam.restclient.response.StubRestResponse
import org.joda.time.DateTime
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.commons.DefaultGrailsApplication

@TestFor(YahooTimeService)
class YahooTimeServiceSpec extends Specification {

    RestClient mockRestClient

    def setup(){

        mockRestClient = Mock(RestClient)
        service.yahooRestClient = mockRestClient

        service.grailsApplication = new DefaultGrailsApplication()
        service.grailsApplication.config.yahooApplicationId = "unitTest"
    }

    def 'get current date time'(){

        given:
            long unixTimeStamp = 1336216702

        when:
            DateTime currentDateTime = service.getCurrentDateTime()

        then:
            currentDateTime == new DateTime(unixTimeStamp)

        and:
            (1) * mockRestClient.get("/TimeService/V1/getTime?appid=unitTest&output=json") >> withMockGetTimeResponse(unixTimeStamp)
    }

    private StubRestResponse withMockGetTimeResponse(long unixTimeStamp) {
        return new StubRestResponse(200, [Result: [Timestamp: unixTimeStamp]])
    }


}
