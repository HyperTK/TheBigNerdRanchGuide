package com.bignerdranch.nyethack

import java.lang.Exception
import java.lang.IllegalStateException

fun main(args: Array<String>) {
    Game.play()
}


object Game {
    private val player = Player(name="Madrigal")
    private var currentRoom: Room = TownSquare()

    private var worldMap = listOf(
        listOf(currentRoom, Room("Tavern"), Room("Back Room")),
        listOf(Room("Long Corridor"), Room("Generic Room"))
    )

    init {
        println("Welcome, adventure.")
        player.castFireball(8)
    }

    /**
     * ゲームループ
     */
    fun play() {
        while (true) {
            println(currentRoom.description())
            println(currentRoom.load())
            // Player Status
            printPlayerStatus(player)

            print("> Enter your command: ")
            println(GameInput(readLine()).processCommand())
        }
    }

    /**
     * プレイヤーのステータスを出力する
     */
    private fun printPlayerStatus(player: Player) {
        println("(Aura: ${player.auraColor()}) " + "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }

    /**
     * プレイヤーを移動する
     * @param directionInput 移動方向
     */
    private fun move(directionInput: String) =
        try {
            val direction = Navigation.Direction.valueOf(directionInput.uppercase())
            val newPosition = direction.updateCoordinate(player.currentPosition)
            check(newPosition.isInBounds) {"$direction is out of bounds."}

            val newRoom = worldMap[newPosition.y][newPosition.x]
            player.currentPosition = newPosition
            currentRoom = newRoom
            "OK, you move $direction to the ${newRoom.name}.\n${newRoom.load()}"

        }catch (e: Exception) {
            println(e)
            "Invalid direction: $directionInput"
        }


    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, { "" })

        fun processCommand() = when (command.lowercase()) {
            "move" -> move(argument)
            else -> commandNotFound()
        }
        private fun commandNotFound() =
            "I'm not quite sure what you're trying to do!"
    }
}





