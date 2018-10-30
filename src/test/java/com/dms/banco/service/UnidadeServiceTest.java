package com.dms.banco.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dms.banco.AbstractTest;
import com.dms.banco.model.Unidade;

public class UnidadeServiceTest extends AbstractTest {

	@Autowired
	private UnidadeService service;

	@Test
	public void deveModificarUnidade() throws Exception {
		Unidade unidade = new Unidade();
		unidade.setId("PCT");
		unidade.setDescricao("Pacote fechado2");

		Unidade unidadeSalva = service.atualizar(unidade);

		assertNotNull("Failure - expected not null", unidadeSalva);
		assertThat(unidadeSalva.getDescricao(), equalTo(unidade.getDescricao()));
	}
}
