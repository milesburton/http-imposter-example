class FakeUrlMappings {

    static mappings = {

        '/fake/reset'           (controller: 'fake', action: [ POST: 'reset' ])
        '/fake/configure'       (controller: 'fake', action: [ POST: 'configure' ])

        '/fake/**'               (controller: 'fake', action: [ GET: 'index' ])
    }
}