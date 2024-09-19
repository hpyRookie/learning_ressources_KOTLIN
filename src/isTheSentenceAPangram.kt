val sentence="The quick brown fox jumps over the lazy dog"

fun isTheSentenceAPangram(s: String): Boolean {
    val str=s.replace("\\s+".toRegex(), "") //remove space
    println(str)
    val temporaryList= mutableSetOf<Char>()

    for(letter in str) {
            temporaryList.add(letter.lowercaseChar())// not sensitive to case
        }
    return temporaryList.size==26 // does it contain all the letter of the alphabet
}

fun main(args: Array<String>) {
    println(isTheSentenceAPangram(sentence))
}


