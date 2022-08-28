/**
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. 
The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, 
she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, 
she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.


Input: piles = [3,6,7,11], h = 8
Output: 4

Input: piles = [30,11,23,4,20], h = 5
Output: 30
 */

object Koko {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        // Koko can eat max bananas -> max of piles
        val maxPile = maxPiles(piles)
        if (h == piles.size) {
            return maxPile
        }

        // so, koko can have minimum 1 banana and maximum maxPile banana
        // we can do binary search within a range 1..maxPile
        var i = 1
        var j = maxPile
        var mid: Int = 0
        while (i <= j) {
            mid = (i+j)/2
            val hours = calculateMaxHoursTaken(piles, bananasPerHour = mid)
            when {
                hours > h -> i = mid + 1 // should increase speed
                hours < h -> j = mid - 1 // can decrease speed
                else -> return mid
            }
        }
        return mid
    }

    fun calculateMaxHoursTaken(piles: IntArray, bananasPerHour: Int): Int {
        var hours = 0
        for (pile in piles) {
            hours += Math.ceil(pile.toDouble()/bananasPerHour).toInt()
        }
        return hours
    }

    fun maxPiles(piles: IntArray): Int {
        var m = Int.MIN_VALUE
        for (i in piles.indices) {
            m = maxOf(piles[i], m)
        }
        return m
    }
}