Ext.define('CricketApp.model.Match', {
    extend: 'Ext.data.Model',
    fields: [
        { name: 'id', type: 'int' },
        { name: 'teamA', type: 'string' },
        { name: 'teamB', type: 'string' },
        { name: 'date', type: 'date' },
        { name: 'seriesId', reference: 'Series' }
    ]
});
