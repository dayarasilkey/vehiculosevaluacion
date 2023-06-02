$(document).ready(function(){
    const EstudianteSelect = document.querySelector(".ClienteSelect")
    EstudianteSelect.innerHTML = "<option value='1'>Selecciona un cliente</option>"

    $.ajax({
        url: "http://localhost:8080/ListarEstudiante",
        type: "GET",
        datatype: "JSON",

        success: function(response){
            Object.values(response).forEach(cliente => {
                ClienteSelect.innerHTML += '<option value="' + cliente['IdCliente'] +'">' + cliente['Nombre'] + ' ' + cliente['Direccion'] +'</option>'

            });
        }
    })
});

$(document).ready(function(){
    const LibroSelect = document.querySelector(".LibroSelect")
    LibroSelect.innerHTML = "<option value='1'>Selecciona un libro</option>"

    $.ajax({
        url: "http://localhost:8080/ListarLibro",
        type: "GET",
        datatype: "JSON",

        success: function(response){
            Object.values(response).forEach(libro => {
                LibroSelect.innerHTML += '<option value="' + libro['isbn'] +'">' + libro['titulo'] + ' ' + '</option>'

            });
        }
    })
});

$(document).ready(function() {
    const GuardaPrestamo = $(".GuardaPrestamo");
    const EstudianteSelect = $(".EstudianteSelect");
    const LibroSelect = $(".LibroSelect");

    GuardaPrestamo.click(function(event) {
        event.preventDefault(); // Evita el comportamiento predeterminado del enlace

        const estudianteSeleccionado = EstudianteSelect.val();
        const libroSeleccionado = LibroSelect.val();

        $.ajax({
            url: "http://localhost:8080/agregarPrestamo/" + estudianteSeleccionado + "/" + libroSeleccionado,
            type: "POST",
            dataType: "JSON",
            success: function(response) {
                console.log("Agregado")
                //Object.values(response).forEach(function(element) {
                    //console.log("Elemento:", element);
                    // Realizar acciones adicionales con cada elemento de la respuesta
                //});
                // Código a ejecutar después de recibir una respuesta exitosa
            },
        });
    });
});