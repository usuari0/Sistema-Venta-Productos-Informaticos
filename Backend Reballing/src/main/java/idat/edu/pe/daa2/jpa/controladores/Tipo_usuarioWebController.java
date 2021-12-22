package idat.edu.pe.daa2.jpa.controladores;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import idat.edu.pe.daa2.jpa.modelo.Categoria;
import idat.edu.pe.daa2.jpa.modelo.Tipo_usuario;
import idat.edu.pe.daa2.jpa.repositorio.CategoriaRepositorio;
import idat.edu.pe.daa2.jpa.repositorio.Tipo_usuarioRepositorio;
import idat.edu.pe.daa2.jpa.servicio.Tipo_usuarioServicio;

@RestController
@RequestMapping("/tipo_usuario")
public class Tipo_usuarioWebController {
	@Autowired
	private Tipo_usuarioRepositorio tipo_usuarioRepositorio;

	@GetMapping("/listarTodo")
	public List<Tipo_usuario> listarTipo_usuario() {
		List<Tipo_usuario> listaTipo_usuario = new ArrayList<>();
		Iterator<Tipo_usuario> it = tipo_usuarioRepositorio.findAll().iterator();
		while (it.hasNext()) {
			listaTipo_usuario.add(it.next());
		}
		return listaTipo_usuario;
	}
	
	@GetMapping("/obtener/{id}")
	public Tipo_usuario obtenerTipo_usuario(@PathVariable(value="id") Integer idTipo_usuario) {
		return tipo_usuarioRepositorio.findById(idTipo_usuario).get();
	}
	
	@PostMapping("/nuevo")
	public Tipo_usuario nuevoTipo_usuario(@Valid @RequestBody Tipo_usuario tipo_usuario) {	
		return tipo_usuarioRepositorio.save(tipo_usuario);
	}
	
	@PutMapping(value = "/actualizar/{id}")
	public Tipo_usuario actualizarTipo_usuario(@PathVariable(value="id") Integer idTipo_usuario,@Valid @RequestBody Tipo_usuario tipo_usuario) {
		Tipo_usuario tip = tipo_usuarioRepositorio.findById(idTipo_usuario).get();
		 tip.setCargo(tipo_usuario.getCargo());
		 return tipo_usuarioRepositorio.save(tip);
	}
	
	@DeleteMapping(value = "/eliminar/{id}")
	public void eliminarTipo_usuario(@PathVariable(name = "id") int idTipo_usuario) {
		tipo_usuarioRepositorio.deleteById(idTipo_usuario);     
	}
}
