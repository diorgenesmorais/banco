package com.dms.banco.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Assume;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dms.banco.AbstractTest;
import com.dms.banco.config.DbConfig;
import com.dms.banco.model.Grupo;

public class GrupoRepositoryTest extends AbstractTest {

	@Autowired
	private GrupoRepository repository;

	@Test
	public void deveObterOPrimeiraCategoria() throws Exception {
		Optional<Grupo> expected = Optional.of(new Grupo(1, "Capacitor"));
		Integer id = 1;

		Optional<Grupo> grupo = repository.findById(id);

		assertThat(grupo, equalTo(expected));
	}

	@Test
	public void deveListarOsGrupos() throws Exception {
		Assume.assumeTrue(DbConfig.getUrl().contains("192.168.0.119"));
		int expected = 60;

		List<Grupo> grupos = repository.findAll();

		assertNotNull("Failure - expected not null", grupos);
		assertThat(grupos.size(), equalTo(expected));
	}

	@Test
	public void deveListarOsGruposNaLoja() throws Exception {
		Assume.assumeTrue(DbConfig.getUrl().contains("192.168.0.105"));
		int expected = 61;

		List<Grupo> grupos = repository.findAll();

		assertNotNull("Failure - expected not null", grupos);
		assertThat(grupos.size(), equalTo(expected));
	}

	@Test
	public void deveListarTodosOsGrupos() throws Exception {
		List<Grupo> grupos = repository.findAll();

		assertNotNull("Failure - expected not null", grupos);

		grupos.forEach(g -> System.out.printf("%d - %s\n", g.getId(), g.getDescricao()));
	}

	@Test
	public void deveRetornarUmGrupoEspecifico() throws Exception {
		String expected = "Varicap";

		Optional<Grupo> grupo = repository.findByDescricaoIgnoreCase(expected);

		assertNotNull("Failure - expected not null", grupo);

		System.out.printf("%d - %s\n", grupo.get().getId(), grupo.get().getDescricao());

		assertThat(grupo.get().getDescricao(), equalTo(expected));
	}
}
