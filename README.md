http-imposter-example
=====================

Example for the HTTP-Imposter in Grails 2.0.x

The imposter is a simple tool which has been used widely in our team to mock out http requests without using any external dependencies.

This project describes a simple example. A controller requests a timestamp from a Yahoo API. The most common problem when testing remote
webservice interactions is how exactly do you dynamically change the response of a remote service without writing extensive and complicated mock controllers or relying on external web-servers providing content.

 The http imposter revolves around a simple idea that any request/response can be boiled down to an object that contains headers, uri, request verb and body.
 Each request is hashed and in a map. When a configured request (see 'FakeController' and 'TimeFunctionalSpec') is replayed the imposter serves
 the associated response. If you need to modify a response multiple times during a test (@Unroll for example) you can reconfigure the imposter to serve a new response.

 Many thanks to Russell Wilson and the rest of the Popcorn team.
