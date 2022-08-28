package problems

object EncodeDecode {

    private const val block = "<*#>"

    fun encode(strings: List<String>): String {
        return strings.joinToString(block)
    }

    fun decode(string: String): List<String> {
        return string.split(block)
    }
}