import ds.Graph
import models.GraphNode
import problems.MaxAreaOfIsland
import problems.MergeSortedArrays
import problems.OutOfBoundary

class Main {

    /*
    [0,0,0,1,1,1,2,3,3]
3
[-1,0,0,0,0,0]
6
     */
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            MergeSortedArrays.merge(
                intArrayOf(0,0,3,0,0,0,0,0,0),
                3,
                intArrayOf(-1,1,1,1,2,3),
                6
            )
        }
    }
}