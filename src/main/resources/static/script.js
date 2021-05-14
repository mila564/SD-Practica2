$(function(){
	contenedor = $('#listaCategorias');	// Cogemos la contenedor del html 
	var urlCategoriaCultivo = 'http://localhost:8080/categoriaCultivo/'; // Url donde se va a obtener la contenedor de categorías de cultivo
	$.getJSON(urlCategoriaCultivo,
		function(respuesta){
			contenedor.append($('<h2>').html('Categorías')); // Título Categorías
			contenedor.append($('</h2>'));
			contenedor.append($('<ul id="listaCategorias">'));
			contenedor.append($('</ul>'));
			lista = $('#listaCategorias');
			for (categoria in respuesta){
				lista.append($('<li>').html(respuesta[categoria].nombre));
				lista.append($('</li>'));
			}
			$('li').each(function(){
				var button = document.createElement('button'); 
				button.type = 'button'; 
				button.innerText = 'Mostrar'; 
    			$(this).append(button);
			})
		}
	);
});
/*
{Frutales, Hortalizas, Cereales, Oleaginosas}
categoria = {1, 2, 3, 4}
*/