package http.imposter.example

import grails.test.mixin.*

import spock.lang.Specification

import org.joda.time.DateTime

@TestFor(TimeController)
class TimeControllerSpec extends Specification {

    YahooTimeService mockTimeService

    def setup(){
        mockTimeService = Mock(YahooTimeService)
        controller.yahooTimeService = mockTimeService
    }

    def 'display time'(){
        given:
            DateTime currentTime = new DateTime()

        when:
            controller.index()

        then:
            (1) * mockTimeService.getCurrentDateTime() >> currentTime

        and:
             response.text == currentTime.toString()
    }

}
