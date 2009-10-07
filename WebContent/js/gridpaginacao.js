Ext.onReady(function(){

   //data store que lê os dados vindos do json - spring
    var store = new Ext.data.Store({
		proxy: new Ext.data.HttpProxy(
			new Ext.data.Connection({
				url:'getContatos.jsonAction'
			})
		),
		reader:new Ext.data.JsonReader({
			totalProperty:'total',
			root:'rows',
			fields: [ 'nome','email' ]
		})
	});


    // cria o grid
    var grid = new Ext.grid.GridPanel({
        store: store,
        columns: [
            {header: "NOME", width: 170, sortable: true, dataIndex: 'nome'},
            {header: "EMAIL", width: 150, sortable: true, dataIndex: 'email'}
        ],
        title: 'Grid com Paginação - Extjs',
        autoHeight:true,
        width:350,
		renderTo: document.body,
		frame:true,
		bbar:new Ext.PagingToolbar({
			pageSize:10,
			store:store,
			displayInfo:true,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			emptyMsg:'sem dados'
		})
    });
    
   //lê os dados passando o 0 de início
    store.load({params:{start:0, limit:50}});

    //div do grid
    grid.render('grid-paginacao');
});