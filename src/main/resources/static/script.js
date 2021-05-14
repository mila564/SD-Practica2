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
				elemento = $('<li>').html(respuesta[categoria].nombre);
				lista.append(elemento);
				lista.append($('</li>'));
				var button = document.createElement('button'); 
				button.type = 'button'; 
				button.innerText = 'Mostrar';
				elemento.append(button);
			}/*
			$('li').each(function(){ 
    			$(this).append(button);
			})*/
		}
	);
});
/*
{Frutales, Hortalizas, Cereales, Oleaginosas}
categoria = {1, 2, 3, 4}
*/