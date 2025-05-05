package br.com.pazimports.repositoryy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.pazimports.model.TipoContato;

@Repository
public interface TipoContatoRepository extends JpaRepository<TipoContato, Integer>{

	@Query("select tContato from TipoContato tContato where tContato.id =: id")
	public TipoContato findOne(@Param("id")Integer id);
}

