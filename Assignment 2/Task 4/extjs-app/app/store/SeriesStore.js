Ext.define('CricketApp.store.SeriesStore', {
    extend: 'Ext.data.Store',
    model: 'CricketApp.model.Series',
    autoLoad: true,
    proxy: {
        type: 'rest',
        url: '/api/series',
        reader: {
            type: 'json',
            rootProperty: ''
        },
        writer: {
            type: 'json'
        }
    }
});
