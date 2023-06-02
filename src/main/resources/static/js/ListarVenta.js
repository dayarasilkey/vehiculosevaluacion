$(document).ready(function(){
    const ListarVenta = $(".ListarVenta");
    ListarVenta.click(function(event) {
        event.preventDefault();
        let tabla = document.querySelector('#tabla')
        tabla.innerHTML = ''
        $.ajax({
            url: "http://localhost:8080/listarClientes",
            type: "GET",
            datatype: "JSON",
            success: function(response){
                console.log(response)
                tabla.innerHTML = '';
                for (i = 0; i <=response.length; i++){
                    tabla.innerHTML += '<tr><td>' + response[i].IdCliente +
                    '</td><td>' + response[i].Nombre +
                     '</td><td>' + response[i].Direccion +
                    '<td><tr>';
                }
            }
        });
    });
});