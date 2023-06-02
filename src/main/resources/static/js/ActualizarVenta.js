$(document).ready(function(){
    const EstudianteSelect = document.querySelector(".EstudianteSelect")
    EstudianteSelect.innerHTML = "<option value='1'>Selecciona un estudiante</option>"

    $.ajax({
        url: "http://localhost:8080/ListarEstudiante",
        type: "GET",
        datatype: "JSON",

        success: function(response){
            Object.values(response).forEach(estudiante => {
                EstudianteSelect.innerHTML += '<option value="' + estudiante['documento'] +'">' + estudiante['nombre'] + ' ' + estudiante['apellido'] +'</option>'

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
    const ActualizarPrestamo = $(".ActualizarPrestamo");
    const EstudianteSelect = $(".EstudianteSelect");
    const LibroSelect = $(".LibroSelect");

    ActualizarPrestamo.click(function(event) {
        event.preventDefault(); // Evita el comportamiento predeterminado del enlace

        const estudianteSeleccionado = EstudianteSelect.val();
        const libroSeleccionado = LibroSelect.val();

        $.ajax({
            url: "http://localhost:8080/actualizarPrestamo/" + estudianteSeleccionado + "/" + libroSeleccionado,
            type: "PUT",
            dataType: "JSON",
            success: function(response) {
                console.log("Actualizado")
                //Object.values(response).forEach(function(element) {
                    //console.log("Elemento:", element);
                    // Realizar acciones adicionales con cada elemento de la respuesta
                //});
                // Código a ejecutar después de recibir una respuesta exitosa
            },
        });
    });
});