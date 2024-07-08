/*
 * This file launches the application by asking Ext JS to create
 * and launch() the Application class.
 */
Ext.application({
    extend: 'Extjs.app.Application',

    name: 'Extjs.app',

    requires: [
        // This will automatically load all classes in the Extjs.app namespace
        // so that application classes do not need to require each other.
        'Extjs.app.*'
    ],

    // The name of the initial view to create.
    mainView: 'Extjs.app.view.main.Main'
});
