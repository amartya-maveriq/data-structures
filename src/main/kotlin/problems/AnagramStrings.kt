package problems

class AnagramStrings {

    fun isAnagram(s1: String, s2: String): Boolean {
        if (s1.length != s2.length)
            return false
        val map = hashMapOf<Char, Int>()
        s1.forEach {
            map.putIfAbsent(it, 0)
            map[it] = map[it]!! + 1
        }
        s2.forEach {
            if (!map.containsKey(it))
                return false
            map[it] = map[it]!! - 1
        }
        return map.all { it.value == 0 }
    }
}