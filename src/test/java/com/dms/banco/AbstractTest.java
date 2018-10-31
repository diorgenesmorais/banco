package com.dms.banco;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Nota: Se for inserido também na classe de teste a seguinte anotação
 * &#64;<code>org.springframework.transaction.annotation.Transactional</code>
 * será feito roolback após os testes.
 * 
 * @see documentation {@link https://docs.spring.io/spring/docs/current/spring-framework-reference/testing.html#testcontext-tx}
 * @author Diorgenes Morais
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BancoApplication.class)
public abstract class AbstractTest {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
}
