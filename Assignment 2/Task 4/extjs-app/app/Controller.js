Ext.define('CricketApp.controller.MainController', {
    extend: 'Ext.app.Controller',
    init: function() {
        this.control({
            'serieslist': {
                itemdblclick: this.editSeries
            },
            'seriesform button[action=save]': {
                click: this.updateSeries
            },
            'matchlist': {
                itemdblclick: this.editMatch
            },
            'matchform button[action=save]': {
                click: this.updateMatch
            }
        });
    },
    editSeries: function(grid, record) {
        var view = Ext.widget('seriesform');
        view.down('form').loadRecord(record);
    },
    updateSeries: function(button) {
        var win = button.up('window'),
            form = win.down('form'),
            record = form.getRecord(),
            values = form.getValues();

        if (values.id) {
            record.set(values);
        } else {
            record = Ext.create('CricketApp.model.Series');
            record.set(values);
            Ext.getStore('SeriesStore').add(record);
        }
        win.close();
        Ext.getStore('SeriesStore').sync();
    },
    editMatch: function(grid, record) {
        var view = Ext.widget('matchform');
        view.down('form').loadRecord(record);
    },
    updateMatch: function(button) {
        var win = button.up('window'),
            form = win.down('form'),
            record = form.getRecord(),
            values = form.getValues();

        if (values.id) {
            record.set(values);
        } else {
            record = Ext.create('CricketApp.model.Match');
            record.set(values);
            Ext.getStore('MatchStore').add(record);
        }
        win.close();
        Ext.getStore('MatchStore').sync();
    }
});
