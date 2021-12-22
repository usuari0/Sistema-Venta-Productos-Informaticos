package idat.edu.pe.daa2.jpa.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.Categoria;

public interface CategoriaRepositorio extends CrudRepository<Categoria, Integer> {
	@Query(value = "SELECT c FROM Categoria c WHERE c.Nombre = ?1")
	public List<Categoria> buscarCategoriaPorNombre(String categoria);
	
	
	@Query(value = "SELECT c FROM Categoria c WHERE c.Nombre like CONCAT(?1, '%')")
	public List<Categoria> buscarCategoriaLikeNombre(String categoria);
}
