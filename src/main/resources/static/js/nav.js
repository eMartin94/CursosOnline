/**
 * 
 */

$(document).ready(
	function() {
		tblCursos = $('#ejemplo1')
			.DataTable(
				{
					language: {
						"decimal": "",
						"emptyTable": "Datos no disponibles en la tabla",
						"info": "Mostrando _START_ a _END_ de _TOTAL_ registros",
						"infoEmpty": "Mostrando 0 a 0 de 0 registros",
						"infoFiltered": "(Filtrado de _MAX_ registros totales)",
						"infoPostFix": "",
						"thousands": ",",
						"lengthMenu": "Mostrando _MENU_ registros",
						"loadingRecords": "Cargando...",
						"processing": "Procesando...",
						"search": "Buscar:",
						"zeroRecords": "No se encontraron registros para la búsqueda",
						"paginate": {
							"first": "Primero",
							"last": "Ultimo",
							"next": "Siguiente",
							"previous": "Anterior"
						},
						"aria": {
							"sortAscending": ": Activar para ordenar ascendente",
							"sortDescending": ": Activar para ordenar descendente"
						}
					},
					ordering: false,
					responsive: true,
					columnDefs: [
						{ responsivePriority: 1, targets: 0 },
						{ responsivePriority: 2, targets: -1 }
					],
					//"columnDefs": [ {
			            //"searchable": false,
			            //"orderable": false,
			            //"targets": 0
			        //} ],
        			//"order": [[ 1, 'asc' ]]
					
				});
				tblCursos.on( 'order.dt search.dt', function () {
		        tblCursos.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
		            cell.innerHTML = i+1;
			        } );
			    } ).draw();
		$('[data-toggle="tooltip"]').tooltip();
	});


