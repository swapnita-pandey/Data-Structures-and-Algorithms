import java.util.Scanner

class Queue {
    var front = 0
    var rear = 0
    var capacity = 0
    lateinit var queue: IntArray

    private fun enqueue(data: Int) {
        if (capacity == rear) {
            println("Queue is full")
            return
        }
        queue[rear] = data
        rear++
        return
    }

    private fun dequeue() {
        if (front == rear) {
            println("Queue is empty")
            return
        }

        for (i in 0 until rear - 1) queue[i] = queue[i + 1]

        // store 0 at rear indicating there's no element
        if (rear < capacity) queue[rear] = 0

        // decrement rear
        rear--
        return
    }

    private fun display() {
        if (front == rear) {
            println("Queue is Empty")
            return
        }
        println("Queue: ")
        var i = front
        while (i < rear) {
            print("${queue[i]} ")
            i++
        }
        println()
        return
    }

    private fun front() {
        if (front == rear) {
            println("Queue is Empty")
            return
        }
        println("Front Element is: ${queue[front]}")
        return
    }

    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        rear = 0
        front = rear
        capacity = 6
        queue = IntArray(capacity)
        println("Enter number of elements to be added: ")
        val n = sc.nextInt()
        println("Enter the element to Enqueue: ")
        // adding element to rear of queue
        for (i in 0 until n) {
            val s = sc.nextInt()
            enqueue(s)
        }
        display()
        dequeue()
        dequeue()
        display()
        front()
        display()
        sc.close()
    }
}
