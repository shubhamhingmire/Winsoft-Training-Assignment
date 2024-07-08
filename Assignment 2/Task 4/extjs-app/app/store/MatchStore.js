Ext.define('CricketApp.store.MatchStore', {
    extend: 'Ext.data.Store',
    model: 'CricketApp.model.Match',
    autoLoad: true,
    proxy: {
        type: 'rest',
        url: '/api/matches',
        reader: {
            type: 'json',
            rootProperty: ''
        },
        writer: {
            type: 'json'
        }
    }
});
