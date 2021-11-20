package com.example.notalone.common

object FriendResponse {

    fun getBasicResponses(yourMessage: String): String {

        val message = yourMessage.toLowerCase()

        return when {
            message.contains("i am") || message.contains("my name") || message.contains("i'm")
            -> "I'm Robin\uD83D\uDCAA. Where are you going on the weekend?"
            message.contains("theatre") -> "What a coincidence\uD83D\uDC38. I'm going to a new show on Saturday too \uD83C\uDFDB"
            else -> "I like talking to you \uD83D\uDE03"
        }
    }
}