Ext.define('CricketApp.view.series.SeriesForm', {
    extend: 'Ext.window.Window',
    xtype: 'seriesform',
    title: 'Series Form',
    modal: true,
    layout: 'fit',
    items: [
        {
            xtype: 'form',
            bodyPadding: 10,
            items: [
                { xtype: 'textfield', name: 'name', fieldLabel: 'Name' },
                { xtype: 'textarea', name: 'description', fieldLabel: 'Description' }
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
                            var store = Ext.getStore('SeriesStore');
                            store.add(form.getValues());
                        }
                        button.up('window').close();
                    }
                }
            ]
        }
    ]
});
