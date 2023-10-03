fun main() {
    play(TicTacToeGame())
}


fun Boolean?.toMark(): Char = when (this) {
    true -> 'X'
    false -> 'O'
    else -> ' '
}

fun render(game: TicTacToeGame) {
    for (i in 0..2) {
        for (j in 0..2) {
            print("[ ${game.get(i, j).toMark()} ]")
        }
        println()
    }
}

fun play(game: TicTacToeGame) {
    var player = 0
    while (true) {
        render(game)
        do {
            print("Ход игрока №${player % 2 + 1} (${(player % 2 == 0).toMark()})>> ")
            val (x, y) = input()
        } while (!game.mark(x, y, player % 2 == 0))
        if (game.checkEnd(player % 2 == 0)) break
        player = ((player + 1) % 2)
    }
    println(
        when (game.hasAWinner) {
            true -> "Поздравляем игрока №${player % 2 + 1} (${(player % 2 == 0).toMark()}) с победой!"
            else -> "Поздравляем игроков с ничьей!"
        }
    )
    render(game)
}

fun input(): Pair<Int, Int> {
    val input = readLine() ?: error("Can't read the line")
    val pointers = input.split(' ').map { it.toInt() }
    return pointers[0] to pointers[1]
}