package http.imposter.example

import com.popcornteam.restclient.RestClient
import org.joda.time.DateTime
import org.codehaus.groovy.grails.commons.GrailsApplication
import com.popcornteam.restclient.response.RestResponse

class YahooTimeService {

    RestClient yahooRestClient

    GrailsApplication grailsApplication

    DateTime getCurrentDateTime() {

        String uri = "/TimeService/V1/getTime?appid=${grailsApplication.config.yahooApplicationId}&output=json";
        RestResponse response = yahooRestClient.get(uri)
        return new DateTime(response.bodyAsJsonMap.Result.Timestamp as Long)
    }
}
