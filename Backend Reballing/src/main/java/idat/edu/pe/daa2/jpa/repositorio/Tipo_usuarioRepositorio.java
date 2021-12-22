package idat.edu.pe.daa2.jpa.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.Categoria;
import idat.edu.pe.daa2.jpa.modelo.Tipo_usuario;

public interface Tipo_usuarioRepositorio extends CrudRepository<Tipo_usuario, Integer> {
	@Query(value = "SELECT t FROM Tipo_usuario t WHERE t.Cargo = ?1")
	public List<Tipo_usuario> buscarTipo_usuarioPorCargo(String tipo_usuario);
	
	
	@Query(value = "SELECT t FROM Tipo_usuario t WHERE t.Cargo like CONCAT(?1, '%')")
	public List<Tipo_usuario> buscarTipo_usuarioLikeCargo(String tipo_usuario);
}
