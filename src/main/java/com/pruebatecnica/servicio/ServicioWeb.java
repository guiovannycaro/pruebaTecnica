package com.pruebatecnica.servicio;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pruebatecnica.controller.TransaccionController;
import com.pruebatecnica.model.Usuarios;

@RestController
@RequestMapping("/pruebaTecnica")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ServicioWeb {
	TransaccionController operacion = new TransaccionController();

	@RequestMapping("/app")
    String hellow(
    		@RequestParam(value = "nombres") String nombres
    		) 
    {
        return "Hello World! guiovanny" + nombres;
    }
	
	@RequestMapping(value = "/Listar" , method = RequestMethod.GET)
	public List<Usuarios> EnviarInformacion() {
		return operacion.consultaListaUsuarios();
	}

	@RequestMapping(value = "/consultarPorId" , method = RequestMethod.GET)
	public List<Usuarios> consultarPorId(@RequestParam(value = "id") String id) {
		return operacion.consultaUsuariosPorId(id);
	}

	@RequestMapping(value = "/insertarUsuario" , method = RequestMethod.GET)
	public String insertarUsuario(
			@RequestParam(value = "nombres") String nombres, @RequestParam(value = "apellidos") String apellidos,
			@RequestParam(value = "email") String email, @RequestParam(value = "ciudad") String ciudad,
			@RequestParam(value = "pais") String pais,@RequestParam(value = "telefono") String telefono

	) {
		return operacion.insertarUsuarios(nombres,apellidos,email,ciudad,pais,telefono);
	}
	
	@RequestMapping(value = "/editarUsuario" , method = RequestMethod.GET)
	public String editarUsuario(
			@RequestParam(value = "id") String id,
			@RequestParam(value = "nombres") String nombres, 
			@RequestParam(value = "apellidos") String apellidos,
			@RequestParam(value = "email") String email, 
			@RequestParam(value = "ciudad") String ciudad,
			@RequestParam(value = "pais") String pais

	) {
		return operacion.editarUsuarios(id,nombres,apellidos,email,ciudad,pais);
	}
	
	 
}
