package com.example.telebot

import com.example.telebot.service.MyService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import kotlin.coroutines.suspendCoroutine

@SpringBootApplication
class TeleBotApplication

fun main(args: Array<String>) {
    val ctx = runApplication<TeleBotApplication>(*args)
    val myService = ctx.getBean(MyService::class.java)
    run {  myService.performTask()}
    run {  myService.performTask()}
    run {  myService.performTask()}

    ctx.close()
}
