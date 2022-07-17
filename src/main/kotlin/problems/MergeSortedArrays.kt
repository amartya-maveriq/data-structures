package problems

/**
 *  leetcode : easy
 *  https://leetcode.com/problems/merge-sorted-array/
 */

object MergeSortedArrays {

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        // if m = 0, nums1 will have [0]
        if (m == 0) {
            nums2.copyInto(nums1)
            return
        }
        // if n=0, keep nums1 as is
        if (n == 0) {
            return
        }

        var arrIndex1 = m-1 //for nums1

        var arrIndex2 = n-1 //for nums2

        var replacementIndex = m+n-1 //for replacing zeros with nums

        while (replacementIndex >= 0) {
            if (nums1[arrIndex1] >= nums2[arrIndex2]) {
                nums1[replacementIndex] = nums1[arrIndex1]
                nums1[arrIndex1] = Int.MIN_VALUE
                if (arrIndex1 > 0) {
                    arrIndex1--
                }
            } else {
                nums1[replacementIndex] = nums2[arrIndex2]
                nums2[arrIndex2] = 0
                if (arrIndex2 > 0) {
                    arrIndex2--
                } else {
                    break
                }
            }
            replacementIndex--
        }
        println(nums1.joinToString())
    }
}