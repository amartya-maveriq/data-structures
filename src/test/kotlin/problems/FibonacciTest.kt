package problems

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class FibonacciTest {

    @DisplayName("test iterative fibonacci")
    @Test
    fun `test iterative fibonacci`() {
        assertTrue(Fibonacci.fibIterative(5) == 5L)
        org.junit.jupiter.api.assertThrows<Exception> {
            Fibonacci.fibIterative(-5)
        }
        assertTrue(Fibonacci.fibIterative(0) == 0L)
        assertTrue(Fibonacci.fibIterative(1) == 1L)
        assertTrue(Fibonacci.fibIterative(2) == 1L)
        assertTrue(Fibonacci.fibIterative(7) == 13L)
    }

    @DisplayName("test recursive fibonacci")
    @Test
    fun `test recursive fibonacci`() {
        assertTrue(Fibonacci.fibRecursive(5) == 5)
        org.junit.jupiter.api.assertThrows<Exception> {
            Fibonacci.fibRecursive(-5)
        }
        assertTrue(Fibonacci.fibRecursive(0) == 0)
        assertTrue(Fibonacci.fibRecursive(1) == 1)
        assertTrue(Fibonacci.fibRecursive(2) == 1)
        assertTrue(Fibonacci.fibRecursive(7) == 13)
    }

    @DisplayName("test memoized fibonacci")
    @Test
    fun `test memoized fibonacci`() {
        assertTrue(Fibonacci.fibMemoized(5) == 5)
        org.junit.jupiter.api.assertThrows<Exception> {
            Fibonacci.fibMemoized(-5)
        }
        assertTrue(Fibonacci.fibMemoized(0) == 0)
        assertTrue(Fibonacci.fibMemoized(1) == 1)
        assertTrue(Fibonacci.fibMemoized(2) == 1)
        assertTrue(Fibonacci.fibMemoized(7) == 13)
        assertTrue(Fibonacci.fibMemoized(30) == 832040)
    }
}