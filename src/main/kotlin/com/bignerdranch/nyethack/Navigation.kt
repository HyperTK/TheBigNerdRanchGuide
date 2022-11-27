package com.bignerdranch.nyethack

class Navigation {
    enum class Direction(private val coordinate: Coordinate) {
        NORTH(Coordinate(0, -1)),
        EAST(Coordinate(1, 0)),
        SOUTH(Coordinate(0, 1)),
        WEST(Coordinate(-1, 0));

        /**
         * プレイヤーの位置を変更する
         * @param playerCoordinate 変更前のプレイヤーの座標
         */
        fun updateCoordinate(playerCoordinate: Coordinate) =
            coordinate + playerCoordinate
    }
    data class Coordinate(val x: Int, val y: Int) {
        val isInBounds = x >= 0 && y >= 0

        operator fun plus(other: Coordinate) = Coordinate(x + other.x, y + other.y)
    }
}