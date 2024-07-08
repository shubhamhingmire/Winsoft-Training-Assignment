Ext.define('CricketApp.view.match.MatchForm', {
    extend: 'Ext.window.Window',
    xtype: 'matchform',
    title: 'Match Form',
    modal: true,
    layout: 'fit',
    items: [
        {
            xtype: 'form',
            bodyPadding: 10,
            items: [
                { xtype: 'textfield', name: 'teamA', fieldLabel: 'Team A' },
                { xtype: 'textfield', name: 'teamB', fieldLabel: 'Team B' },
                { xtype: 'datefield', name: 'date', fieldLabel: 'Date', format: 'Y-m-d' },
                { xtype: 'numberfield', name: 'seriesId', fieldLabel: 'Series ID' }
            ],
            buttons: [
                {
                    text: 'Save',
                    handler: function(button) {
                        var form = button.up('form').getForm();
                        var record = form.getRecord();
                        if (record) {
                            form.updateRecord();
                        } else {
                            var store = Ext.getStore('MatchStore');
                            store.add(form.getValues());
                        }
                        button.up('window').close();
                    }
                }
            ]
        }
    ]
});
