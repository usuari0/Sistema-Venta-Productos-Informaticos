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
import idat.edu.pe.daa2.jpa.repositorio.CategoriaRepositorio;
import idat.edu.pe.daa2.jpa.servicio.CategoriaServicio;

@RestController
@RequestMapping("/categoria")
public class CategoriaWebController {
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;

	@GetMapping("/listarTodo")
	public List<Categoria> listarCategoria() {
		List<Categoria> listaCategoria = new ArrayList<>();
		Iterator<Categoria> it = categoriaRepositorio.findAll().iterator();
		while (it.hasNext()) {
			listaCategoria.add(it.next());
		}
		return listaCategoria;
	}
	
	@GetMapping("/obtener/{id}")
	public Categoria obtenerCategoria(@PathVariable(value="id") Integer idCategoria) {
		return categoriaRepositorio.findById(idCategoria).get();
	}
	
	@PostMapping("/nuevo")
	public Categoria nuevoCategoria(@Valid @RequestBody Categoria categoria) {	
		return categoriaRepositorio.save(categoria);
	}
	
	@PutMapping(value = "/actualizar/{id}")
	public Categoria actualizarCategoria(@PathVariable(value="id") Integer idCategoria,@Valid @RequestBody Categoria categoria) {
		 Categoria cat = categoriaRepositorio.findById(idCategoria).get();
		 cat.setNombre(categoria.getNombre());
		 return categoriaRepositorio.save(cat);
	}
	
	@DeleteMapping(value = "/eliminar/{id}")
	public void eliminarCategoria(@PathVariable(name = "id") int idCategoria) {
	    categoriaRepositorio.deleteById(idCategoria);     
	}
}
