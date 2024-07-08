Ext.define('CricketApp.model.Series', {
    extend: 'Ext.data.Model',
    fields: [
        { name: 'id', type: 'int' },
        { name: 'name', type: 'string' },
        { name: 'description', type: 'string' }
    ],
    hasMany: {
        model: 'CricketApp.model.Match',
        name: 'matches'
    }
});
