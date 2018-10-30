package com.dms.banco.repository;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dms.banco.AbstractTest;
import com.dms.banco.model.Unidade;

public class UnidadeRepositoryTest extends AbstractTest {

	@Autowired
	private UnidadeRepository repository;

	@Test
	public void deveListarAsUnidades() throws Exception {
		List<Unidade> unidades = repository.findAll();

		assertNotNull("Failure - expected not null", unidades);

		unidades.forEach(
				u -> System.out.printf("%s - %s - %f\n", u.getId(), u.getDescricao(), u.getConversor().doubleValue()));
	}

}
