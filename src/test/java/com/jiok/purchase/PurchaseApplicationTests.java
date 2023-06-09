package com.jiok.purchase;

import com.jiok.purchase.domain.Hello;
import com.jiok.purchase.domain.QHello;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
class PurchaseApplicationTests {
	@Test
	public void testMainMethod() {
		String[] args = {}; // main() 메소드에 전달할 인자를 정의합니다.
		PurchaseApplication.main(args); // main() 메소드를 호출합니다.
		// 추가적인 검증 로직을 작성할 수 있습니다.
	}

}

