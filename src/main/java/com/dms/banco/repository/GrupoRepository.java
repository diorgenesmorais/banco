package com.dms.banco.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dms.banco.model.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Integer> {

	Optional<Grupo> findByDescricaoIgnoreCase(String descricao);

	@Query(value="insert into tb_est_grupo (id_grupo, descricao) values (?1, ?2)", nativeQuery=true)
	Grupo insertGrupo(Integer id, String descricao);
}
