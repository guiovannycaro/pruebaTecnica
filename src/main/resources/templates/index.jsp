<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

</head>
<body onload="report();">
	<h1>Hola Mundo Spring</h1>

	<table width="200" border="1">
		<thead>
			<tr>
				<td colspan="7">
					<button class="btn btn-primary add" data-toggle="modal" name="add"
						data-target="#RegistrarClienteModal	" id="Agregar">AGREGAR</button>
				</td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td>Apellido</td>
				<td>email</td>
				<td>ciudad</td>
				<td>pais</td>
				<td>telefono</td>
				<td>Accion</td>
			</tr>
		</thead>
		<tbody id="tbody">
			<td>
				<button data-toggle="modal" data-target="#EditarClienteModal"
					name="edit" class="btn btn-primary btn-xs edit">Editar</button> -
				<button data-toggle="modal" data-target="#EliminarClienteModal"
					id="" name="drop" class="btn btn-primary btn-xs drop">Eliminar</button>
			</td>

		</tbody>


	</table>

	</br>
</body>
<script>
	$(document).ready(function() {
		console.log("Jquery called1");
		function report() {	
			
			$.ajax({	
				type:"GET",
				url:"localhost:8082/pruebaTecnica/Listar",
				success: function(result){
					var tblData="";
					$.each(result.beanList, function() {
						tblData += "<tr><td>" + this.id + "</td>" + 
						"<td>" + this.nombres + "</td>" + 
						"<td>" + this.apellidos + "</td>" + 
						"<td>" + this.email + "</td>" +
						"<td>" + this.ciudad + "</td>" +
						"<td>" + this.pais + "</td>" +
						"<td>" + this.telefono + "</td>" +
						"<td>"+
						"<button onclick='fetchOldRecord(this);' class='btn btn-sm btn-info' data-toggle='modal' data-target='#updateModal'>Update</button>"+
						"<button onclick='deleteUser(this);' class='btn btn-sm btn-danger'>Delete</button>"+
						"</td></tr>" ;
						
					});
					$("#tbody").html(tblData);
				},
				error: function(result){
					alert("Some error occured.");
				}
			})
		}
		const $cuerpoTabla = document.querySelector("#cuerpoTabla");

	});
</script>

</html>