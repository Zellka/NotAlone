package com.example.notalone.common

object Test {

    private val answers = listOf<String>(
        "Do you like hiking \uD83D\uDEB5 \uD83D\uDCAA? Do you like spending a weekend in the mountains \uD83C\uDFD4 and feeling the beauty of nature \uD83C\uDF0D?",
        "Do you like swimming \uD83C\uDFCA\u200D♂️? Do you go to the pool on weekends \uD83C\uDFCA\u200D♀️\uD83C\uDFCA\u200D♀️?",
        "I like to go to the theater \uD83C\uDFDB. And you\uD83E\uDDCD?",
        "Do you attend concerts \uD83C\uDF03?",
        "Do you like organizing events \uD83D\uDD7A? Spending time with people\uD83D\uDC68\u200D\uD83D\uDC68\u200D\uD83D\uDC67\u200D\uD83D\uDC67?",
        "Do you run a business\uD83E\uDDD1\u200D\uD83D\uDCBC?",
        "How do you feel about \uD83D\uDC15 animals? Do you like them\uD83D\uDC31?",
        "Do you want to learn languages \uD83D\uDC68\u200D\uD83C\uDF93? And understand your favorite films in the original \uD83D\uDE4B?",
        "My friends and I go to the volunteer center \uD83D\uDC75. Do you like helping people\uD83D\uDC68\u200D\uD83E\uDDB3?"
    )

    fun getTestAnswer(yourMessage: String, pos: Int): String {
        if (pos < 9) {
            if (yourMessage == "Yes" || yourMessage == "No") {
                return answers[pos]
            }
        }
        return "Ok"
    }
}