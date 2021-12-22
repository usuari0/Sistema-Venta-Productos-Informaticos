package idat.edu.pe.daa2.jpa.servicio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.Tipo_usuario;
import idat.edu.pe.daa2.jpa.repositorio.Tipo_usuarioRepositorio;

@Service
@Transactional
public class Tipo_usuarioServicio {
	@Autowired
	private Tipo_usuarioRepositorio repositorio;
		
	public Tipo_usuarioServicio() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Tipo_usuario> buscarTodo() {
		return (List<Tipo_usuario>) repositorio.findAll();  
	}
	
	public Tipo_usuario crear(Tipo_usuario tipo_usuario) {
		return repositorio.save(tipo_usuario);
	}
	
	public Tipo_usuario actualizar(Tipo_usuario tipo_usuarioActualizar) {
		Tipo_usuario tipo_usuarioActual = repositorio.findById(tipo_usuarioActualizar.getIdTipo_usuario()).get();
		tipo_usuarioActual.setIdTipo_usuario(tipo_usuarioActualizar.getIdTipo_usuario());
		tipo_usuarioActual.setCargo(tipo_usuarioActualizar.getCargo());
	
		Tipo_usuario tipo_usuarioActualizado = repositorio.save(tipo_usuarioActual);
		return tipo_usuarioActualizado;
	}
	
	public Tipo_usuario buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}
}
