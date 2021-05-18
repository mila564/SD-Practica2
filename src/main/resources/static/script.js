$(function(){
	contenedor = $('#contenedorCategorias');	// Cogemos el elemento html donde colocaremos las categorías de cultivo
	var urlCategoriaCultivo = 'http://localhost:8080/categoriaCultivo/'; // Url de donde se van a conseguir las categorías
	// Operación GET para obtener la lista de categorías de cultivo de la aplicación
	$.getJSON(urlCategoriaCultivo,
		function(respuesta){
			contenedor.append($('<div id="listaCategoriasDiv"></div>')); // Colocamos el div que contendrá toda la información de las categorías
			div = $('#listaCategoriasDiv'); // Cogemos el elemento
			div.append($('<h1>').html('Categorías')); // Colocamos de título 'Categorías' en el html
			div.append($('</h1>'));
			div.append($('<ul id="listaCategoriasUl">')); // Creamos la lista no ordenada de categorías
			div.append($('</ul>'));
			lista = $('#listaCategoriasUl'); // Obtenemos el elemento html en la variable lista
			for (categoria in respuesta){ // Categoría obtiene el índice de cada una de las categorías obtenidas en el parámetro respuesta que contiene la lista de cultivos
				elemento = $('<li>').html(respuesta[categoria].nombre); // Creamos un elemento de la lista por cada categoría existente
				lista.append(elemento); // Se coloca al final del html
				lista.append($('</li>'));
				elemento.addClass(respuesta[categoria].nombre.replace(/\s+/g, '_'));// Colocamos atributo class al ítem de la lista de categorías para poder identificarlo
				// El replace nos permite transformar los blancos en barras bajas, ya que una clase no puede tener espacios en blanco
				var button = document.createElement('button'); // Creamos el botón para cada categoría
				button.type = 'button'; // Indicamos que es de tipo button
				$(button).addClass("btn btn-info");
				button.id = respuesta[categoria].nombre.replace(/\s+/g, '_'); // Se identifica al botón
				// El replace nos permite transformar los blancos en barras bajas para no tener problemas con los ids
				button.innerText = 'Mostrar'; // Le ponemos título al botón
				elemento.append(button); // Insertamos el botón en el html
				$(button).click(desplegarEspecies); // Asociamos al botón el manejador de eventos
			}
		}
	);
	function desplegarEspecies(){
		if (this.innerText == 'Mostrar'){
			this.innerText = 'Ocultar'; // Cambiamos la funcionalidad del botón
			url = 'http://localhost:8080/categoriaCultivo/'+ encodeURI(this.id.replaceAll('_', ' ')); // Conseguimos la url de la categoría de cultivo de la cual necesitamos su lista de especies
			// Al haber transformado con reverse los ids, deshacemos el cambio para que se produzca la petición HTTP GET correctamente
			this.id.replace(/\s+/g, '_'); // Deshacemos el cambio 
			var itemLista = $('li.'+this.id); // Identificar el ítem de la lista de la categoría 
			itemLista.append($('<div id="listaEspeciesDiv' + this.id + '"></div>')); // Añadimos un div que agrupará toda la información de la categoría de cultivo
			div = $('#listaEspeciesDiv' + this.id); // Cogemos el div
			var identificadorCategoria = this.id + 'Especies'; // Creamos el identificador para la lista de especies de la categoría 
			// Realizamos el GET de la categoría de cultivo
			$.getJSON(url,
				function(respuesta){// Realizamos la operación GET y, en segundo plano, se ejecuta la función
					div.append($('<h2>').html('Especies')); // Colocamos el título 'Especies'
					div.append($('</h2>'));
					div.append($('<ul class="' + identificadorCategoria + '">')); // Creamos la lista donde colocaremos las especies
					div.append($('</ul>'));
					lista = $('.'+ identificadorCategoria); // Cogemos la lista de especies
					var especiesCultivo = respuesta.especies; // Obtenemos el array de especies de la respuesta GET
					for (especie = 0; especie < especiesCultivo.length; especie++){ 
						elemento = $('<li>'); // Creamos el ítem que contiene una de las especies de la categoría
						elemento.append('<span title="' + especiesCultivo[especie].nombreCientifico + '">' + especiesCultivo[especie].nombreVulgar + '</span>')//.html(especiesCultivo[especie].nombreVulgar);
						lista.append(elemento);
						lista.append($('</li>'));
						var button = document.createElement('button'); // Se crea el botón asociado a la especie 
						button.type = 'button'; // Se le asigna su tipo
						$(button).addClass("btn btn-info");
						button.id = especiesCultivo[especie].nombreVulgar.replace(/\s+/g, '_'); // Se le coloca id, la cual es el nombre vulgar de dicha especie
						// El replace nos permite transformar los blancos en barras bajas para no tener problemas con los ids
						button.innerText = 'Mostrar'; // Se introduce de texto 'Mostrar' en el botón por defecto
						elemento.append(button); // Se coloca en el html
						$(button).click(desplegarPlagas); //  Asociamos al botón el manejador de eventos
						elemento.addClass(especiesCultivo[especie].nombreVulgar.replace(/\s+/g, '_')); // Colocamos atributo class al ítem de la lista de especies para poder identificarlo	
						// El replace nos permite transformar los blancos en barras bajas, ya que una clase no puede tener espacios en blanco
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
			url = 'http://localhost:8080/especies/'+ encodeURI(this.id.replaceAll('_', ' '));//Obtenemos la url para poder hacer el GET de las plagas de la especie
			// Al haber transformado con reverse los ids, deshacemos el cambio para que se produzca la petición HTTP GET correctamente
			this.id.replace(/\s+/g, '_'); // Deshacemos el cambio 
			var itemLista = $('li.'+this.id); // Cogemos el ítem de la especie de la que queremos obtener su lista de plagas
			itemLista.append('<div id="listaPlagasDiv' + this.id + '"></div>'); // Creamos el div que contendrá las plagas
			div = $('#listaPlagasDiv' + this.id); // Cogemos el div
			var identificadorEspecie = this.id + 'Plagas'; // Creamos el identificador para la lista de plagas
			//Procedemos a hacer el GET de la especie
			$.getJSON(url,
				function(respuesta){
					div.append($('<h3>').html('Plagas')); //Colocamos el título
					div.append($('</h3>')); 
					div.append($('<ul class="' + identificadorEspecie + '">')); // Creamos la lista donde colocaremos las plagas
					div.append($('</ul>'));
					lista = $('.'+ identificadorEspecie); // Cogemos la lista
					var plagasEspecies = respuesta.posiblesPlagas; // Cogemos el array de las plagas de la especie
					for (plaga = 0; plaga < plagasEspecies.length; plaga++){ 
						elemento = $('<li>'); // Creamos el ítem que contiene una de las plagas de la especie
						elemento.append('<span title="' + plagasEspecies[plaga].nombreCientifico + '">' + plagasEspecies[plaga].nombreVulgar + '</span>')
						lista.append(elemento); 
						lista.append($('</li>'));
						var button = document.createElement('button'); // Se crea el botón asociado a la plaga 
						button.type = 'button'; // Se le asigna su tipo
						$(button).addClass("btn btn-info");
						button.id = plagasEspecies[plaga].nombreVulgar.replace(/\s+/g, '_'); // Se le coloca id, la cual es el nombre vulgar de dicha plaga
						// El replace nos permite transformar los blancos en barras bajas para no tener problemas con los ids
						button.innerText = 'Mostrar'; // Se introduce de texto 'Mostrar' en el botón por defecto
						elemento.append(button); // Se coloca en el html
						$(button).click(desplegarSustancias); //  Asociamos al botón el manejador de eventos
						elemento.addClass(plagasEspecies[plaga].nombreVulgar.replace(/\s+/g, '_')); // Colocamos atributo class al ítem de la lista de plagas para poder identificarlo
						// El replace nos permite transformar los blancos en barras bajas, ya que una clase no puede tener espacios en blanco
					}
				})
		}
		else{
			this.innerText = 'Mostrar'; // Cambia la funcionalidad del botón
			div = $('#listaPlagasDiv' + this.id); // Cogemos el div con la información de la especie
			div.remove(); // Se elimina
		}
	}
	
	function desplegarSustancias(){
		if (this.innerText == 'Mostrar'){
			this.innerText = 'Ocultar'; // Ocultamos el botón
			var url = 'http://localhost:8080/plagas/' + encodeURI(this.id.replaceAll('_', ' ')); // Obtenemos la url de la plaga
			// Al haber transformado con reverse los ids, deshacemos el cambio para que se produzca la petición HTTP GET correctamente
			this.id.replace(/\s+/g, '_'); // Deshacemos el cambio 
			var itemLista = $('li.'+this.id); // Cogemos el elemento li que contiene la información de una plaga
			itemLista.append('<div id="listaSustanciasDiv' + this.id + '"></div>'); // Creamos el div que contendrá la información de la plaga
			div = $('#listaSustanciasDiv' + this.id); // Obtenemos el div
			var identificadorPlaga = this.id + 'Sustancias'; // Creamos el identificador para la lista de sustancias
			//Procedemos a hacer el GET de la plaga
			$.getJSON(url,
				function(respuesta){
					div.append('<span> '+ respuesta.url +'</span>'); // Colocamos la url de la plaga en el html
					div.append('<br>');
					div.append($('<h4>').html('Sustancias activas')); //Colocamos el título
					div.append($('</h4>')); 
					div.append($('<ul class="' + identificadorPlaga + '">')); // Creamos la lista de sustancias
					div.append($('</ul>'));
					lista = $('.'+ identificadorPlaga); // Obtenemos la lista
					var sustanciasPlaga = respuesta.sustanciasActivas; // Creamos el array que contiene las sustancias activas de la plaga
					for (sustancia = 0; sustancia < sustanciasPlaga.length; sustancia++){
						elemento = $('<li>').html(sustanciasPlaga[sustancia].nombre); // Creamos el ítem dentro de la lista de sustancias con su correspondiente nombre
						lista.append(elemento); //Lo colocamos en el html
						lista.append($('</li>')); // Cerramos la lista
						var button = document.createElement('button'); // Creamos el botón asociado a la sustancia
						button.type = 'button'; // Le colocamos su tipo
						$(button).addClass("btn btn-info");
						button.id = sustanciasPlaga[sustancia].nombre.replace(/\s+/g, '_'); // Colocamos su id (nombre de la sustancia sin espacios en blanco)
						// El replace nos permite transformar los blancos en barras bajas para no tener problemas con los ids
						button.innerText = 'Mostrar'; // Se coloca 'Mostrar' dentro del botón
						elemento.append(button); // Se posiciona en el html
						$(button).click(desplegarProductos); //  Asociamos al botón el manejador de eventos
						elemento.addClass(sustanciasPlaga[sustancia].nombre.replace(/\s+/g, '_')); // Se pone el nombre de la sustancia como valor del atributo clase del elemento de la lista
						// El replace nos permite transformar los blancos en barras bajas, ya que una clase no puede tener espacios en blanco
					} 
				})
		}
		else{
			this.innerText = 'Mostrar'; // Mostramos el botón
			div = $('#listaSustanciasDiv' + this.id); // Obtenemos el contenido a borrar
			div.remove(); // Se borra
		}
	}
	
	function desplegarProductos(){
		if (this.innerText == 'Mostrar'){
			this.innerText = 'Ocultar'; // Ocultamos el botón
			var url = 'http://localhost:8080/sustanciaActiva/' + encodeURI(this.id.replaceAll('_', ' '));// Obtenemos la url de la sustancia
			// Al haber transformado con reverse los ids, deshacemos el cambio para que se produzca la petición HTTP GET correctamente
			this.id.replace(/\s+/g, '_'); // Deshacemos el cambio 
			var itemLista = $('li.'+this.id); // Cogemos el elemento li que contiene la información de una sustancia
			itemLista.append('<div id="listaProductosDiv' + this.id + '"></div>'); // Creamos el div que contendrá la información de la sustancia
			div = $('#listaProductosDiv' + this.id); // Obtenemos el div
			var identificadorSustancia = this.id + 'Productos'; // Creamos el identificador para la lista de productos
			//Procedemos a hacer el GET de la sustancia
			$.getJSON(url,
				function(respuesta){
					div.append($('<h5>').html('Productos')); //Colocamos el título
					div.append($('</h5>'));
					div.append($('<ul class="' + identificadorSustancia + '">')); // Creamos la lista de productos
					div.append($('</ul>'));
					lista = $('.'+ identificadorSustancia); // Obtenemos la lista
					var productosSustancia = respuesta.productos; // Creamos el array que contiene los productos de la sustancia
					for (producto = 0; producto < productosSustancia.length; producto++){
						elemento = $('<li>').html(productosSustancia[producto].nombre); // Creamos el ítem de uno de los productos de la lista de sustancias
						lista.append(elemento); //Lo colocamos en el html
						lista.append($('</li>')); // Cerramos la lista
						var button = document.createElement('button'); // Creamos el botón asociado a la sustancia
						button.type = 'button'; // Le colocamos su tipo
						$(button).addClass("btn btn-info");
						button.id = productosSustancia[producto].nombre.replace(/\s+/g, '_'); // Colocamos su id (nombre del producto sin espacios en blanco)
						// El replace nos permite transformar los blancos en barras bajas para no tener problemas con los ids
						button.innerText = 'Mostrar'; // Se coloca 'Mostrar' dentro del botón
						elemento.append(button); // Se posiciona en el html
						$(button).click(desplegarProductosInfo); //  Asociamos al botón el manejador de eventos
						elemento.addClass(productosSustancia[producto].nombre.replace(/\s+/g, '_')); // Se pone el nombre del producto como valor del atributo clase del elemento de la lista
						// El replace nos permite transformar los blancos en barras bajas, ya que una clase no puede tener espacios en blanco
					} 
				});
		}
		else{
			this.innerText = 'Mostrar'; // Mostramos el botón
			div = $('#listaProductosDiv' + this.id); // Obtenemos el contenido a borrar
			div.remove(); // Se borra
		}
	};
	
	function desplegarProductosInfo(){
		if (this.innerText == 'Mostrar'){
			this.innerText = 'Ocultar'; // Ocultamos el botón	
			var url = 'http://localhost:8080/productos/' + encodeURI(this.id.replaceAll('_', ' '));// Obtenemos la url del producto
			// Al haber transformado con reverse los ids, deshacemos el cambio para que se produzca la petición HTTP GET correctamente
			this.id.replace(/\s+/g, '_'); // Deshacemos el cambio 
			var itemLista = $('li.'+this.id); // Cogemos el elemento li que contiene el producto
			itemLista.append('<div id="listaProductosInfoDiv' + this.id + '"></div>'); // Creamos el div donde se colocará la información del producto
			div = $('#listaProductosInfoDiv' + this.id); // Obtenemos el div
			//Procedemos a hacer el GET del producto
			$.getJSON(url,
				function(respuesta){
					div.append('<span> '+ respuesta.url +'</span>'); // Colocamos la url del producto en el html
					div.append('<br>');					
				})
		}
		else{
			this.innerText = 'Mostrar'; // Mostramos el botón
			div = $('#listaProductosInfoDiv' + this.id); // Obtenemos el contenido a borrar
			div.remove(); // Se borra			
		}
	}	
});