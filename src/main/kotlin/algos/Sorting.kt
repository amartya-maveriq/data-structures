package algos

object Sorting {

    // 100,000 random numbers took 17226 milliseconds
    fun bubbleSort(arr: IntArray) {
        for (i in arr.indices) {
            for (j in 0 until arr.lastIndex - i) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] += arr[j + 1]
                    arr[j + 1] = arr[j] - arr[j + 1]
                    arr[j] -= arr[j + 1]
                }
            }
        }
    }

    // 100,000 random numbers took 34 milliseconds
    fun quickSort(arr: IntArray) {
        quickSort(arr, 0, arr.lastIndex)
    }

    private fun quickSort(arr: IntArray, left: Int, right: Int) {
        if (left >= right) {
            return
        }
        val pivot = arr[(left + right) / 2]
        val partition = partition(arr, left, right, pivot)
        quickSort(arr, left, partition - 1)
        quickSort(arr, partition, right)
    }

    private fun partition(arr: IntArray, left: Int, right: Int, pivot: Int): Int {
        var l = left
        var r = right
        while (l <= r) {
            if (arr[l] < pivot) {
                l++
                continue
            }
            if (arr[r] > pivot) {
                r--
                continue
            }
            swap(arr, l, r)
            l++
            r--
        }
        return l
    }

    private fun swap(arr: IntArray, left: Int, right: Int) {
        val temp = arr[left]
        arr[left] = arr[right]
        arr[right] = temp
    }

    fun getRandomIntArray(num: Int): IntArray {
        return IntArray(num) {
            (1..num).random()
        }
    }

    fun validate(arr: IntArray) {
        for (i in 0 until arr.lastIndex) {
            if (arr[i] > arr[i+1]) {
                println("arr is NOT SORTED!")
                return
            }
        }
        println("arr is SORTED!")
    }
}