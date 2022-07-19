package problems

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class AnagramStringsTest {

    private var anagramStrings: AnagramStrings? = null

    @BeforeEach
    fun init() {
        if (anagramStrings == null) {
            anagramStrings = AnagramStrings()
        }
    }

    @DisplayName("test blank strings")
    @Test
    fun isAnagram_blanks() {
        val s1 = ""
        val s2 = ""
        assertTrue(anagramStrings!!.isAnagram(s1, s2))
    }

    @DisplayName("test unequal strings")
    @Test
    fun isAnagram_unequals() {
        val s1 = "abc"
        val s2 = "abcd"
        assertFalse(anagramStrings!!.isAnagram(s1, s2))
    }

    @DisplayName("test equal strings")
    @Test
    fun isAnagram_equals() {
        val s1 = "abcd"
        val s2 = "abcd"
        assertTrue(anagramStrings!!.isAnagram(s1, s2))
    }

    @DisplayName("test equal but jumbled strings")
    @Test
    fun isAnagram_equals_but_jumbled() {
        val s1 = "adcb"
        val s2 = "abcd"
        assertTrue(anagramStrings!!.isAnagram(s1, s2))
    }
}