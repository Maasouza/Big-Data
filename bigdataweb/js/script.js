	var mandarRequest = function(type){
		var data = {
			"pais":document.getElementById("pais").value,
			"lati":document.getElementById("lat1").value,
			"longi":document.getElementById("long1").value,
			"latf":document.getElementById("lat2").value,
			"longf":document.getElementById("long2").value,
			"data1":document.getElementById("dataI").value,
			"data2":document.getElementById("dataF").value
		}
	    var objPedidoAJAX = new XMLHttpRequest();
	    objPedidoAJAX.open("POST", "http://localhost:3000/"+type);
	    objPedidoAJAX.setRequestHeader("Content-Type","application/json;charset=UTF-8");
	    // Prepara recebimento da resposta: tipo da resposta JSON!
	    objPedidoAJAX.responseType = 'json';
	    objPedidoAJAX.onreadystatechange =
	        function() {
	            if(objPedidoAJAX.readyState===4 && objPedidoAJAX.status===200){
	                alert(objPedidoAJAX.response.alert);
	            }
	        };
	    // Envio do pedido
	    
	    objPedidoAJAX.send(JSON.stringify(data));

	};
