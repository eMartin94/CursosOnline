/**
 * 
 */

// INICIO NAVBAR

$(document).ready(function () {

    // Transition effect for navbar and back-to-top icon
    $(window).scroll(function () {
        // checks if window is scrolled more than 500px, adds/removes solid class
        if ($(this).scrollTop() > 550) {
            $('.navbar').addClass('solid');
            $('.back-to-top').addClass('visible');
        } else {
            $('.navbar').removeClass('solid');
            $('.back-to-top').removeClass('visible');
        }

    });


    // Scrolling effect for Arrow icons
    $("#scrollIcon").click(function (e) {
        e.preventDefault();
        $.scrollTo($("#about"), 1000);
    });
    $("#nav-about").click(function (e) {
        e.preventDefault();
        $.scrollTo($("#about"), 1000);
    });
    $("#nav-portfolio").click(function (e) {
        e.preventDefault();
        $.scrollTo($("#portfolio"), 1000);
    });
    $("#nav-contact").click(function (e) {
        e.preventDefault();
        $.scrollTo($("#contact"), 1000);
    });
    $(".navbar-brand").click(function (e) {
        e.preventDefault();
        $.scrollTo(0, 1000);
    });

});

// FIN NAVBAR

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


