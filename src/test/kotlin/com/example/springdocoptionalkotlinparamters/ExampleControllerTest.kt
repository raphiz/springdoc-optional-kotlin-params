package com.example.springdocoptionalkotlinparamters

import io.swagger.v3.oas.models.OpenAPI
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ExampleControllerTest(
    @LocalServerPort val port: Int,
    @Autowired val restTemplate: TestRestTemplate
) {
    @Test
    fun `kotlin parameter should be optional`() {
        val result = restTemplate.getForObject(
            "http://localhost:$port/v3/api-docs",
            OpenAPI::class.java
        )
        assert(result.paths["/"]!!.get.parameters.single().required == false)
    }
}