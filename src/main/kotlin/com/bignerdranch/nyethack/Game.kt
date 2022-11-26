package com.bignerdranch.nyethack

fun main(args: Array<String>) {

    val player = Player(name="Madrigal")
    player.castFireball(8)

    var currentRoom = TownSquare()
    println(currentRoom.description())
    println(currentRoom.load())

    printPlayerStatus(player)

}

/**
 * プレイヤーのステータスを出力する
 */
private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()}) " + "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}





