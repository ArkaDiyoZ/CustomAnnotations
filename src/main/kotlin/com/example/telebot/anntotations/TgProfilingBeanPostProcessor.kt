package com.example.telebot.anntotations

import org.springframework.beans.BeansException
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.stereotype.Component
import kotlin.system.measureNanoTime

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class TgProfiling

@Component
class TgProfilingBeanPostProcessor : BeanPostProcessor {
    @Throws(BeansException::class)
    override fun postProcessBeforeInitialization(bean: Any, beanName: String): Any? {
        val methods = bean.javaClass.methods
        for (method in methods) {
            if (method.isAnnotationPresent(TgProfiling::class.java)) {
                val methodName = method.name
                val className = bean.javaClass.simpleName
                val executionTime = measureNanoTime {
                    method.invoke(bean)
                }
                println("Метод $methodName класса $className запустил аннотацию @TgProfiling. Время выполнения: $executionTime мс")
            }
        }
        return bean
    }

    @Throws(BeansException::class)
    override fun postProcessAfterInitialization(bean: Any, beanName: String): Any? {
        return bean
    }
}