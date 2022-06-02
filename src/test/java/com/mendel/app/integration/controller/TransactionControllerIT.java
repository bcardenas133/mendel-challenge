package com.mendel.app.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mendel.app.mock.Mocks;
import com.mendel.app.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.TestPropertySourceUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@AutoConfigureMockMvc
@ContextConfiguration(initializers = TransactionControllerIT.Initializer.class)
public class TransactionControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TransactionRepository transactionRepository;

    @Container
    public static GenericContainer mongoDbContainer = new GenericContainer("mongo:4.0");

    @BeforeEach
    public void cleanDb() {
        transactionRepository.deleteAll();
    }

    @DisplayName("Save transaction for a successful scenario.")
    @Test
    public void saveTransactionOkTest() throws Exception {

        mockMvc.perform(put("http://localhost:8080/api/v1/transactions/10")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(Mocks.getSaveTransactionBody())))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.status").value("ok"));

        assertEquals(1, transactionRepository.findAll().size());
        assertEquals("10", transactionRepository.findAll().get(0).getTransactionId());
    }

    @DisplayName("Get transactionsId by type for a successful scenario.")
    @Test
    public void getTransactionsIdByTypeOkTest() throws Exception {
        transactionRepository.saveAll(Mocks.getTransactionsMocks());
        mockMvc.perform(get("http://localhost:8080/api/v1/transactions/types/cars")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string("[15,16]"));
    }

    @DisplayName("Get sum for related transactions by parentId and transactionId.")
    @Test
    public void getSumOkTest() throws Exception {
        transactionRepository.saveAll(Mocks.getMockForGetSumEndpointTesting());
        mockMvc.perform(get("http://localhost:8080/api/v1/transactions/sum/10")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"sum\":300}"));
    }

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {

            TestPropertySourceUtils.addInlinedPropertiesToEnvironment(configurableApplicationContext,
                    format("spring.data.mongodb.uri=mongodb://%s:%s",mongoDbContainer.getContainerIpAddress(), mongoDbContainer.getMappedPort(27017)));
        }
    }
}
