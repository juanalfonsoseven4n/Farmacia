function jsmostrar(id){
	if(document.getElementById(id).style.display=='none'){
		document.getElementById(id).style.display=''
		document.getElementById('boton'+id).src='images/tabmsub4.gif'
	}else{
		document.getElementById(id).style.display='none'
		document.getElementById('boton'+id).src='images/plus.gif'
	}
}

   function search(valor){
     document.forms[0].action = valor
     document.forms[0].submit();
   }
   
   function saveComboMultiple(fbox1,forma,action){
    var fbox = document.getElementsByName(fbox1)[0];
 	for(var i=0; i<fbox.options.length;i++){
 	  fbox.options[i].selected = true;
 	}
 	forma.action = action;
 	forma.submit();
 }
 
  sortitems = 1;  // Automatically sort items within lists? (1 or 0)

	function move(fbox1,tbox1) {
	 	var fbox = document.getElementsByName(fbox1)[0];
	 	var tbox = document.getElementsByName(tbox1)[0];
		for(var i=0; i<fbox.options.length; i++) {
			if(fbox.options[i].selected && fbox.options[i].value != "") {
				var no = new Option();
				no.value = fbox.options[i].value;
				no.text = fbox.options[i].text;
				tbox.options[tbox.options.length] = no;
				fbox.options[i].value = "";
				fbox.options[i].text = "";
	   		}
		}
		BumpUp(fbox);
		if (sortitems) SortD(tbox);
	}
	
	function BumpUp(box)  {
		for(var i=0; i<box.options.length; i++) {
			if(box.options[i].value == "")  {
				for(var j=i; j<box.options.length-1; j++)  {
					box.options[j].value = box.options[j+1].value;
					box.options[j].text = box.options[j+1].text;
				}
				var ln = i;
				break;
	   		}
		}
		if(ln < box.options.length)  {
			box.options.length -= 1;
			BumpUp(box);
	   }
	}
	
	function SortD(box)  {
		var temp_opts = new Array();
		var temp = new Object();
		for(var i=0; i<box.options.length; i++)  {
			temp_opts[i] = box.options[i];
		}
		for(var x=0; x<temp_opts.length-1; x++)  {
			for(var y=(x+1); y<temp_opts.length; y++)  {
				if(temp_opts[x].text > temp_opts[y].text)  {
					temp = temp_opts[x].text;
					temp_opts[x].text = temp_opts[y].text;
					temp_opts[y].text = temp;
	      		}
	   		}
		}
		for(var i=0; i<box.options.length; i++)  {
			box.options[i].value = temp_opts[i].value;
			box.options[i].text = temp_opts[i].text;
	   }	
	}  
	
	function seleccionarTodos(nombre, propiedad, input){
		var checAll=input
		var num = document.getElementById("cantidad").value;
		
		if(!isNaN(num)){
			num = parseFloat(num);
		}
		
		if(num > 0){
			var i = 0;
			while(i < num){
				
				eval("document.getElementsByName('"+nombre+"["+i+"]."+propiedad+"')[0].checked = checAll.checked");
				i++;
			}
		}
	}
	
	function limpiarNombre(forma){
		document.getElementsByName('nombre')[0].value=''
		forma.submit();
	}