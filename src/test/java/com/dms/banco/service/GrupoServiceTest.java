package com.dms.banco.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dms.banco.AbstractTest;
import com.dms.banco.model.Grupo;

public class GrupoServiceTest extends AbstractTest {

	@Autowired
	private GrupoService service;

	@Test
	public void deveAtualizarGrupo() throws Exception {
		Grupo expected = new Grupo(41, "Membrana forno");

		Optional<Grupo> retornado = Optional.of(service.salvar(expected));

		assertTrue(retornado.isPresent());
		assertThat(retornado, is(Optional.of(expected)));
		System.out.printf("O grupo %s foi atualizado\n", retornado.get().getDescricao());
	}

	public void deveCriarUmGrupoNovo() throws Exception {
		Integer expected = 62;
		Grupo entity = new Grupo(expected, "Software DMS");

		Grupo retornado = service.salvar(entity);

		assertNotNull("Failure - expected not null", retornado);

		assertThat(retornado.getId(), equalTo(expected));
	}
}
