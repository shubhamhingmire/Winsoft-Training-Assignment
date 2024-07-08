Ext.define('CricketApp.view.match.MatchList', {
    extend: 'Ext.grid.Panel',
    xtype: 'matchlist',
    store: 'MatchStore',
    columns: [
        { text: 'ID', dataIndex: 'id', width: 50 },
        { text: 'Team A', dataIndex: 'teamA', flex: 1 },
        { text: 'Team B', dataIndex: 'teamB', flex: 1 },
        { text: 'Date', dataIndex: 'date', xtype: 'datecolumn', format: 'Y-m-d', flex: 1 },
        { text: 'Series ID', dataIndex: 'seriesId', flex: 1 }
    ],
    tbar: [
        {
            text: 'Add Match',
            handler: function() {
                Ext.create('CricketApp.view.match.MatchForm').show();
            }
        }
    ],
    listeners: {
        itemdblclick: function(view, record) {
            var form = Ext.create('CricketApp.view.match.MatchForm');
            form.loadRecord(record);
            form.show();
        }
    }
});
