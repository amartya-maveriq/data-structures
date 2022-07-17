package problems

/**

Leetcode : medium
https://leetcode.com/problems/maximum-value-after-insertion/

Delivery Hero - Screening question

You are given a number as an input which can be signed
The output of your function should be maximum possible number by
injecting 5 anywhere in the number.

For example:

input = 673
o/p = 6753

ip = 723
o/p = 7523

input = -673
o/p = -5673

input = 0
o/p = 50
 */
object MaxValueAfterInsert {
    fun maxValue(n: String, x: Int): String {
        // create a bool val which stores whether the num is negative
        val isNeg = n[0] == '-'

        // create a stringbuilder val with capacity of n.len + 1
        val sb = StringBuilder(n.length + 1)

        // create a bool var which checks if x is inserted
        var inserted = false

        // iterate over `n`
        for (ch in n) {
            // if '-' sign is encountered insert it and continue
            if (ch == '-') {
                sb.append(ch)
                continue
            }
            // if num is neg && char at i's num value is greater than x
            // then insert x as char and insert char at i
            if (isNeg) {
                if (Character.getNumericValue(ch) > x && !inserted) {
                    sb.append(x)
                    inserted = true
                }
            }

            // else if num is pos && char at i's num val is less than x
            // then insert x as char and insert char at i
            else {
                if (Character.getNumericValue(ch) < x && !inserted) {
                    sb.append(x)
                    inserted = true
                }
            }
            // insert the char at i
            sb.append(ch)
        }
        if (!inserted) {
            sb.append(x)
        }
        // return sb as string
        return sb.toString()
    }
}