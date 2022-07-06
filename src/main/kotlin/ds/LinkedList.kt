package ds

import models.LinkNode

class LinkedList<in T>(headData: T? = null) {

    private var head: LinkNode<T>? = null

    init {
        headData?.let {
            this.head = LinkNode(it)
        }
    }

    private fun add(data: T) {
        head?.let {
            var tempNode = it
            while (tempNode.next != null) {
                tempNode = tempNode.next as LinkNode<T>
            }
            tempNode.next = LinkNode(data)
        } ?: run {
            head = LinkNode(data)
        }
    }

    fun add(vararg data: T) {
        data.map {
            add(it)
        }
    }

    fun print() {
        head?.let {
            var tempNode: LinkNode<T>? = it
            while (tempNode != null) {
                print(
                    tempNode.next?.let {
                        " ${tempNode!!.data}--->"
                    } ?: kotlin.run {
                        " ${tempNode!!.data}\n"
                    }
                )
                tempNode = tempNode.next
            }
        }?: kotlin.run {
            println("LinkedList is empty")
        }
    }

    fun reverse() {
        if (head == null) {
            println("LinkedList is empty")
            return
        }
        var prevNode: LinkNode<T>? = null
        var tempNode: LinkNode<T>? = head
        while (tempNode != null) {
            val temp = tempNode.next
            tempNode.next = prevNode
            prevNode = tempNode
            tempNode = temp
        }
        head = prevNode
    }
}