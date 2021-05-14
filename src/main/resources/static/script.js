$(function(){
	lista = $('#listaCategorias');	// Cogemos la lista del html 
	var urlCategoriaCultivo = 'http://localhost:8080/categoriaCultivo/'; // Url donde se va a obtener la lista de categorías de cultivo
	$.getJSON(urlCategoriaCultivo,
		function(respuesta){
			lista.append($('<h2>').html('Categorías')); // Título Categorías
			lista.append($('<ul>'));
			for (categoria in respuesta){
				//lista.append($('<li>')respuesta[categoria].nombre);
			}
			lista.append($('</ul>'));
		}
	);
});

//{Frutales, Hortalizas, Cereales, Oleaginosas}
// categoria = {1, 2, 3, 4}