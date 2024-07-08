Ext.define('CricketApp.view.Main', {
    extend: 'Ext.container.Viewport',
    layout: 'fit',
    items: [
        {
            xtype: 'tabpanel',
            items: [
                {
                    title: 'Series',
                    xtype: 'serieslist'
                },
                {
                    title: 'Matches',
                    xtype: 'matchlist'
                }
            ]
        }
    ]
});
