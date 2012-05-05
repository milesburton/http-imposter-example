import com.popcornteam.restclient.RestClient
import com.popcornteam.restclient.factory.HttpClientFactory

beans = {

    yahooRestClient(
            RestClient,
            application.config.endpoint.yahooServicesBaseUri,
            [],
            new HttpClientFactory().makeThreadSafeHttpClient(64)
    )
}
