package com.jiok.purchase.web.controller;

import com.jiok.purchase.domain.members.Members;
import com.jiok.purchase.domain.userProduct.GeneralProduct;
import com.jiok.purchase.service.MembersService;
import com.jiok.purchase.service.UserProductService;
import com.jiok.purchase.web.dto.response.ResponseGetUserProductManagement;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserProductManagementControllerTest {
    /** resttemplate */
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;


    /** service */
    @Autowired
    private MembersService membersService;
    @Autowired
    private UserProductService userProductService;


    /** var */
    private Members membersA;
    private GeneralProduct generalProductA;
    private GeneralProduct generalProductB;


    @BeforeEach
    public void before(){
        // before
        membersA = Members.builder()
                .mbrNm("옥자")
                .mbrPhone("01012341234")
                .mbrAddr("서울특별시 동대문구 신설동")
                .mbrDtlAddr("동대문구청 101동 101호")
                .build();

        generalProductA = GeneralProduct.builder()
                .members(membersA)
                .build();

        generalProductB = GeneralProduct.builder()
                .members(membersA)
                .build();

        Members savedMembers = membersService.save(membersA);
        GeneralProduct savedGeneralProductA = userProductService.save(generalProductA);
        GeneralProduct savedGeneralProductB = userProductService.save(generalProductB);
    }

    @Test
    public void userProductManage_test() {
        // given
        String url = "http://localhost:" + port + "/v1/userProduct/management";


        // when
        ResponseEntity<List<ResponseGetUserProductManagement>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        // then
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(Objects.requireNonNull(responseEntity.getBody()).get(0).getMbrPhone()).isEqualTo(membersA.getMbrPhone());

    }
}