package com.jiok.purchase;

import com.jiok.purchase.domain.Hello;
import com.jiok.purchase.entity.QHello;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class PurchaseApplicationTests {

	@Autowired
	EntityManager em;

	@Test
	@DisplayName("첫 테스트양")
	void contextLoads() {

		Hello hello = new Hello();
		em.persist(hello);

		JPAQueryFactory queryFactory = new JPAQueryFactory(em);
		QHello qHello = QHello.hello;

		Hello result = queryFactory.selectFrom(qHello).fetchOne();

		Assertions.assertThat(result).isEqualTo(hello);
		Assertions.assertThat(result.getId()).isEqualTo(hello.getId());
	}

}
