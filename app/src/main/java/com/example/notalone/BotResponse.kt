package com.example.notalone

object BotResponse {

    fun getBasicResponses(yourMessage: String): String {

        val random = (0..2).random()
        val message = yourMessage.toLowerCase()

        return when {
            message.contains("спасибо") || message.contains("ок") -> {
                when (random) {
                    0 -> "Был рад помочь"
                    1 -> "Обращайтесь ещё"
                    2 -> "Всегда рад помочь"
                    else -> "error" }
            }
            else -> "АААА"
        }
    }
}