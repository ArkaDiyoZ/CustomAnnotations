package com.example.telebot.service

import com.example.telebot.anntotations.TgProfiling
import org.springframework.stereotype.Service

@Service
class MyService {
    @TgProfiling
    fun performTask() {
        println("Кто запустил эту аннтоацию ?")
    }
}