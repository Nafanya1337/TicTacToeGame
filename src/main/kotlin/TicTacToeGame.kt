private interface Game {
    var hasAWinner: Boolean
    val box: Array<Array<Boolean?>>
}

class TicTacToeGame : Game {
    override var hasAWinner = false
        get() = field

    override val box: Array<Array<Boolean?>> = Array(3) { arrayOfNulls(3) }

    fun get(x: Int, y: Int) = box[x][y]

    fun mark(x: Int, y: Int, boolean: Boolean): Boolean {
        if ( x >= 3 || x < 0 || y >= 3 || y < 0 || box[x][y] != null)
            return false
        box[x][y] = boolean
        return true
    }

    fun checkEnd(boolean: Boolean): Boolean {
        if (boxIsFull()) return true
        hasAWinner = checkDiagonal(boolean) || checkLines(boolean)
        return hasAWinner
    }

    private fun boxIsFull(): Boolean {
        for (i in 0..2) {
            for (j in 0..2) {
                if (box[i][j] == null) return false
            }
        }
        return true
    }

    private fun checkLines(boolean: Boolean): Boolean {
        for (i in 0..2) {
            var cols = true
            var rows = true
            for (j in 0..2) {
                cols = cols.and(box[i][j] == boolean)
                rows = rows.and(box[j][i] == boolean)
            }
            if (cols || rows) return true
        }
        return false
    }

    private fun checkDiagonal(boolean: Boolean): Boolean {
        var fromLeft = true
        var fromRight = true
        for (i in 0..2) {
            fromLeft = fromLeft.and(box[i][i] == boolean)
            fromRight = fromRight.and(box[i][i] == boolean)
        }

        if (fromLeft || fromRight) return true

        return false
    }

}
