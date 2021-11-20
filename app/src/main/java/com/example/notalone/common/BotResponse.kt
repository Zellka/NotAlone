package com.example.notalone.common

object BotResponse {

    fun getBasicResponses(yourMessage: String): String {

        val random = (0..2).random()
        val message = yourMessage.toLowerCase()

        return when {
            message.contains("fine") || message.contains("good") || message.contains("ok") || message.contains(
                "cool"
            ) -> {
                when (random) {
                    0 -> "Wow. It's good!\uD83D\uDC4F"
                    1 -> "I'm happy for you!\uD83D\uDE4C"
                    2 -> "Well done! tell me ❤"
                    else -> "error"
                }
            }
            message.contains("bad") -> {
                when (random) {
                    0 -> "Tell me \uD83D\uDE3A"
                    1 -> "I am always ready to listen \uD83D\uDE1E"
                    2 -> "Do not lose hope ✊"
                    else -> "error"
                }
            }
            else -> "I always believe in you \uD83D\uDE4F"
        }
    }
}