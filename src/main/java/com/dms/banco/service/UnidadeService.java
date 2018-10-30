package com.dms.banco.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dms.banco.model.Unidade;
import com.dms.banco.repository.UnidadeRepository;

@Service
public class UnidadeService {

	@Autowired
	private UnidadeRepository unidades;

	@Transactional
	public Unidade atualizar(Unidade unidade) {
		Optional<Unidade> unid = unidades.findById(unidade.getId());
		Unidade u = unid.get();
		System.out.printf("%s - %s - %f - %s\n", u.getId(), u.getDescricao(), u.getConversor(), u.getStatus());
		BeanUtils.copyProperties(unidade, u, "unidade", "conversor", "status", "unidade_ex");
		System.out.printf("%s - %s - %f - %s\n", u.getId(), u.getDescricao(), u.getConversor(), u.getStatus());
		return unidades.saveAndFlush(u);
	}
}
