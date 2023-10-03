import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TicTacToeGameTest {
    @Test
    fun `mark X in empty box and index in bounds should return true`() {
        val result = TicTacToeGame().mark(0,0,false)
        assertEquals(true, result)
    }
    @Test
    fun `mark X in empty box and index out of bounds should return false`() {
        val result = TicTacToeGame().mark(100,100,false)
        assertEquals(false, result)
    }
    @Test
    fun `mark O in index that have char should return false`() {
        val game = TicTacToeGame()
        game.mark(0,0,false)
        val result = game.mark(0,0,true)
        assertEquals(false, result)
    }
    @Test
    fun `check end should return false in the start of the game`() {
        val result = TicTacToeGame().checkEnd(false)
        assertEquals(false, result)
    }
    @Test
    fun `check end with 3X in line should return true`() {
        val game = TicTacToeGame()
        game.mark(0,0,false)
        game.mark(0,1,false)
        game.mark(0,2,false)
        val result = game.checkEnd(false)
        assertEquals(true, result)
    }
    @Test
    fun `check end with 3X in diagonal should return true`() {
        val game = TicTacToeGame()
        game.mark(0,0,false)
        game.mark(1,1,false)
        game.mark(2,2,false)
        val result = game.checkEnd(false)
        assertEquals(true, result)
    }

}