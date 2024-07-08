Ext.define('CricketApp.view.series.SeriesList', {
    extend: 'Ext.grid.Panel',
    xtype: 'serieslist',
    store: 'SeriesStore',
    columns: [
        { text: 'ID', dataIndex: 'id', width: 50 },
        { text: 'Name', dataIndex: 'name', flex: 1 },
        { text: 'Description', dataIndex: 'description', flex: 2 }
    ],
    tbar: [
        {
            text: 'Add Series',
            handler: function() {
                Ext.create('CricketApp.view.series.SeriesForm').show();
            }
        }
    ],
    listeners: {
        itemdblclick: function(view, record) {
            var form = Ext.create('CricketApp.view.series.SeriesForm');
            form.loadRecord(record);
            form.show();
        }
    }
});
