import org.junit.jupiter.api.Assertions.*

class TicTacToeGameTest {

    fun `mark X in empty box and index in bounds should return true`() {
        val result = TicTacToeGame()
        assertEquals(true, result)
    }

    fun `mark X in empty box and index out of bounds should return false`() {
        val result = TicTacToeGame()
        assertEquals(false, result)
    }

    fun `mark X in index that have char should return false`() {
        val result = TicTacToeGame()
        assertEquals(false, result)
    }

    fun `check end should return false in the start of the game`() {
        val result = TicTacToeGame()
        assertEquals(false, result)
    }

    fun `check end with 3X in line should return true`() {
        val result = TicTacToeGame()
        assertEquals(true, result)
    }

    fun `check end with 3X in diagonal should return true`() {
        val result = TicTacToeGame()
        assertEquals(true, result)
    }

}