function NuevoAjax(){
var xmlhttp=false;
try{
	xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
}catch(e){
	try{
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
 	}catch(E){
		xmlhttp = false;
	}
}

if(!xmlhttp && typeof XMLHttpRequest!='undefined'){
	xmlhttp = new XMLHttpRequest();
}
return xmlhttp;
}
function Cargar(url){
var contenido, preloader;
contenido = document.getElementById('contenido');
preloader = document.getElementById('preloader');
ajax=NuevoAjax();
ajax.open("GET", url,true);
ajax.onreadystatechange=function(){
	if(ajax.readyState==1){
		preloader.innerHTML = "<b><font size='2'>Cargando...</font></b>";
		preloader.style.background = "url('loading.gif') no-repeat";
	}else if(ajax.readyState==4){
		if(ajax.status==200){
			contenido.innerHTML = ajax.responseText;
			preloader.innerHTML = "<b><font size='1'>Página Cargada  - AJAX</font></b>";
			preloader.style.background = "url('loaded.gif') no-repeat";
		}else if(ajax.status==404){
			preloader.innerHTML = "ERROR - Al cargar la página";
		}else{
			preloader.innerHTML = "Error:" .ajax.status;
		}
	}
}
ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
ajax.send(null);
}
<!-- mandar datos de formularios -->

function FAjax (url,capa,valores,metodo)
{
  
   contenido = document.getElementById('contenido');
   preloader = document.getElementById('preloader');
   ajax=NuevoAjax();

/*Creamos y ejecutamos la instancia si el metodo elegido es POST*/
 if(metodo.toUpperCase()=='POST'){
    
    ajax.open ('POST', url, true);
    ajax.onreadystatechange = function() {
         if (ajax.readyState==1) {
                 preloader.innerHTML = "<b><font size='2'>Cargando...</font></b>";
				 preloader.style.background = "url('loading.gif') no-repeat";
         }
         else if (ajax.readyState==4){
            if(ajax.status==200)
            {
                 contenido.innerHTML = ajax.responseText;
				preloader.innerHTML = "<b><font size='1'>Página Cargada  - AJAX</font></b>";
				preloader.style.background = "url('loaded.gif') no-repeat";
            }
            else if(ajax.status==404)
                 {

                      contenido.innerHTML = "La direccion existe";
					  preloader.innerHTML = "ERROR - Al cargar la página";
                 }
             else
                 {
                      contenido.innerHTML = "Error: ".ajax.status;
					  preloader.innerHTML = "Error:" .ajax.status;
                 }
        }
    }
    ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
    ajax.send(valores);
    return;
	}
	if (metodo.toUpperCase()=='GET'){

         ajax.open ('GET', url, true);
         ajax.onreadystatechange = function() {
         if (ajax.readyState==1) {
               preloader.innerHTML="<img src='imagenes/loader.gif'>";
         }
         else if (ajax.readyState==4){
                   if(ajax.status==200){
                        contenido.innerHTML=ajax.responseText; 
						preloader.innerHTML = "<b><font size='1'>Página Cargada  - AJAX</font></b>";
				 		preloader.style.background = "url('loaded.gif') no-repeat";
                   }
                   else if(ajax.status==404)
                                             {

                            contenido.innerHTML = "La direccion no existe";
                                             }
                                             else
                                             {
                            contenido.innerHTML = "Error: ".ajax.status;
                                             }
                                    }
                  }
         ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
         ajax.send(null);
         return
}
}

