$(function(){
	contenedor = $('#contenedorCategorias');	// Cogemos el elemento html donde colocaremos las categorías de cultivo
	var urlCategoriaCultivo = 'http://localhost:8080/categoriaCultivo/'; // Url de donde se van a conseguir las categorías
	// Operación GET para obtener la lista de categorías de cultivo de la aplicación
	$.getJSON(urlCategoriaCultivo,
		function(respuesta){
			contenedor.append($('<div id="listaCategoriasDiv"></div>')); // Colocamos el div que contendrá toda la información de las categorías
			div = $('#listaCategoriasDiv'); // Cogemos el elemento
			div.append($('<h2>').html('Categorías')); // Colocamos de título 'Categorías' en el html
			div.append($('</h2>'));
			div.append($('<ul id="listaCategoriasUl">')); // Creamos la lista no ordenada de categorías
			div.append($('</ul>'));
			lista = $('#listaCategoriasUl'); // Obtenemos el elemento html en la variable lista
			for (categoria in respuesta){ // Categoría obtiene el índice de cada una de las categorías obtenidas en el parámetro respuesta que contiene la lista de cultivos
				elemento = $('<li>').html(respuesta[categoria].nombre); // Creamos un elemento de la lista por cada categoría existente
				lista.append(elemento); // Se coloca al final del html
				lista.append($('</li>'));
				elemento.addClass(respuesta[categoria].nombre);// Colocamos atributo class al ítem de la lista de categorías para poder identificarlo
				var button = document.createElement('button'); // Creamos el botón para cada categoría
				button.type = 'button'; // Indicamos que es de tipo button
				button.id = respuesta[categoria].nombre;
				button.innerText = 'Mostrar'; // Le ponemos título al botón
				elemento.append(button); // Insertamos el botón en el html
				$(button).click(desplegarEspecies); // Asociamos al botón el manejador de eventos
			}
		}
	);
	function desplegarEspecies(){
		if (this.innerText == 'Mostrar'){
			this.innerText = 'Ocultar'; // Cambiamos la funcionalidad del botón
			url = 'http://localhost:8080/categoriaCultivo/'+ encodeURI(this.id); // Conseguimos la url de la categoría de cultivo de la cual necesitamos su lista de especies
			var itemLista = $('li.'+this.id); // Identificar el ítem de la lista de la categoría 
			itemLista.append($('<div id="listaEspeciesDiv' + this.id + '"></div>')); // Añadimos un div que agrupará toda la información de la categoría de cultivo
			div = $('#listaEspeciesDiv' + this.id); // Cogemos el div
			var identificadorCategoria = this.id + 'Especies'; // Creamos el identificador para la lista de especies de la categoría 
			$.getJSON(url,
				function(respuesta){// Realizamos la operación GET y, en segundo plano, se ejecuta la función
					div.append($('<h3>').html('Especies')); // Colocamos el título 'Especies'
					div.append($('</h3>'));
					div.append($('<ul class="' + identificadorCategoria + '">')); // Creamos la lista donde colocaremos las especies
					div.append($('</ul>'));
					lista = $('.'+ identificadorCategoria); // Cogemos la lista de especies
					var especiesCultivo = respuesta.especies; // Obtenemos el array de especies de la respuesta GET
					for (especie = 0; especie < especiesCultivo.length; especie++){ 
						elemento = $('<li>').html(especiesCultivo[especie].nombreVulgar); // Creamos el ítem que contiene una de las especies de la categoría
						lista.append(elemento); 
						lista.append($('</li>'));
						var button = document.createElement('button'); // Se crea el botón asociado a la especie 
						button.type = 'button'; // Se le asigna su tipo
						button.id = especiesCultivo[especie].nombreVulgar; // Se le coloca id, la cual es el nombre vulgar de dicha especie
						button.innerText = 'Mostrar'; // Se introduce de texto 'Mostrar' en el botón por defecto
						elemento.append(button); // Se coloca en el html
						$(button).click(desplegarPlagas); //  Asociamos al botón el manejador de eventos
						elemento.addClass(especiesCultivo[especie].nombreVulgar); // Colocamos atributo class al ítem de la lista de especies para poder identificarlo					
					}
				}
			);			
		}
		else{
			this.innerText = 'Mostrar'; // Cambiamos la funcionalidad del botón
			div = $('#listaEspeciesDiv' + this.id); // Obtenemos el contenido a borrar
			div.remove(); // Se borra del DOM
		}		
	}
	
	function desplegarPlagas(){
		if (this.innerText == 'Mostrar'){
			this.innerText = 'Ocultar'; // Ponemos el botón a 'Ocultar'
			url = 'http://localhost:8080/especies/'+ encodeURI(this.id);//Obtenemos la url para poder hacer el GET de las plagas de la especie
			var itemLista = $('li.'+this.id); // Cogemos el ítem de la especie de la que queremos obtener su lista de plagas
			itemLista.append('<div id="listaPlagasDiv' + this.id + '"></div>'); // Creamos el div que contendrá las plagas
			div = $('#listaPlagasDiv' + this.id); // Cogemos el div
			var identificadorEspecie = this.id + 'Plagas'; // Creamos el identificador para la lista de plagas
			//Procedemos a hacer el GET de la lista de plagas
			$.getJSON(url,
				function(respuesta){
					div.append($('<h4>').html('Plagas')); //Colocamos el título
					div.append($('</h4>'));
					//div.append('<span> '+ respuesta.url+'</span>'); // Colocamos la url de la plaga
					//div.append('<br>'); 
					div.append($('<ul class="' + identificadorEspecie + '">')); // Creamos la lista donde colocaremos las plagas
					div.append($('</ul>'));
					lista = $('.'+ identificadorEspecie); // Cogemos la lista
					var plagasEspecies = respuesta.posiblesPlagas; // Cogemos el array de las plagas de la especie
					for (plaga = 0; plaga < plagasEspecies.length; plaga++){ 
						elemento = $('<li>').html(plagasEspecies[plaga].nombreVulgar); // Creamos el ítem que contiene una de las plagas de la especie
						lista.append(elemento); 
						lista.append($('</li>'));
						var button = document.createElement('button'); // Se crea el botón asociado a la plaga 
						button.type = 'button'; // Se le asigna su tipo
						button.id = plagasEspecies[plaga].nombreVulgar; // Se le coloca id, la cual es el nombre vulgar de dicha plaga
						button.innerText = 'Mostrar'; // Se introduce de texto 'Mostrar' en el botón por defecto
						elemento.append(button); // Se coloca en el html
						//$(button).click(desplegarSustancias); //  Asociamos al botón el manejador de eventos
						elemento.addClass(plagasEspecies[plaga].nombreVulgar); // Colocamos atributo class al ítem de la lista de plagas para poder identificarlo						
					}
				})
		}
		else{
			this.innerText = 'Mostrar'; // Cambia la funcionalidad del botón
			div = $('#listaPlagasDiv' + this.id); // Cogemos el div con la información de la especie
			div.remove(); // Se elimina
		}
	}	
});