package com.dms.banco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dms.banco.model.Grupo;
import com.dms.banco.repository.GrupoRepository;

@Service
public class GrupoService {

	@Autowired
	private GrupoRepository grupos;

	@Transactional
	public Grupo salvar(Grupo grupo) {
		Optional<Grupo> grupoOptional = grupos.findByDescricaoIgnoreCase(grupo.getDescricao());
		if (grupoOptional.isPresent()) {
			return grupoOptional.get();
		}
		//return grupos.insertGrupo(grupo.getId(), grupo.getDescricao());
		return grupos.save(grupo);
	}
}
