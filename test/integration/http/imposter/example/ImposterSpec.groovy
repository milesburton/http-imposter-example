package http.imposter.example

import spock.lang.Specification
import net.xelnaga.httpimposter.remote.HttpImposterRemote

class ImposterSpec extends Specification {

    HttpImposterRemote imposterRemote

    void setup() {

        imposterRemote = new HttpImposterRemote("http://localhost/fake")
        imposterRemote.reset()
    }

    def 'test something'() {

    }
}
