package com.example.springdocoptionalkotlinparamters

import org.springframework.aop.framework.ProxyFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.support.GenericApplicationContext

@SpringBootApplication
class SpringdocOptionalKotlinParamtersApplication {
    @Bean
    fun controller(applicationContext: GenericApplicationContext): ExampleController {
        return createProxy(ExampleController::class.java)
    }

    private fun <T> createProxy(clazz: Class<T>): T {
        val proxyFactory = ProxyFactory(clazz)
        proxyFactory.targetClass = clazz
        @Suppress("UNCHECKED_CAST")
        return proxyFactory.proxy as T
    }
}

fun main(args: Array<String>) {
    runApplication<SpringdocOptionalKotlinParamtersApplication>(*args)
}
