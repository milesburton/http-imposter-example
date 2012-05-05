package http.imposter.example

class TimeController {

    YahooTimeService yahooTimeService

    def index() {

        render yahooTimeService.currentDateTime.toString()
    }
}
