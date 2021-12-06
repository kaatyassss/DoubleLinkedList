class DoublyLinkedList<T> {
    var head: Node<T>? = null
    private var tail: Node<T>? = null

    override fun toString() = head?.toString() ?: "empty list"

    private val isEmpty: Boolean get() {
        return head == null
    }

    fun push(x: T) {
        val node = Node(x)
        if (isEmpty) {
            head = node
            tail = node
            return
        }
        node.next = head
        head!!.prev = node
        head = node
    }

    fun pop(): T? {
        if (isEmpty) {
            return null
        }
        val value = head?.value
        head = head?.next
        if (head == null) {
            tail = null
        } else {
            head!!.prev = null
        }
        return value
    }

    fun addTail(x: T) {
        val node = Node(x)
        if (isEmpty) {
            head = node
            tail = node
            return
        } else {
            val oldTail = tail
            tail = Node(x, null, oldTail)
            oldTail?.next = tail
        }
    }


    fun delTail(): T? {
        if (isEmpty) {
            return null
        }
        val value = tail?.value
        tail = tail?.prev
        tail?.next = null
        return value
    }

    private fun findByIndex(index: Int): Node<T>? {
        var node = head
        var i = 0
        while (node != null && i < index) {
            node = node.next
            i++
        }
        return node
    }

    /*
          Задача. Найти середину связного списка за один проход по св. списку.
     */

    fun findMiddle(): Node<T>? {
        var node = head
        var node2 = head
        while (node != null && node2?.next != null) {
            node = node.next
            node2 = node2.next?.next
        }
        return node
    }

    fun removeAtIndex(index: Int): T? {
        if (index == 0) {
            return pop()
        }
        val a = findByIndex(index - 1)
        val b = a?.next
        val c = b?.next
        a?.next = c
        c?.prev = a
        return b?.value
    }
}