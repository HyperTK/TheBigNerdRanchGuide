package com.bignerdranch.nyethack

class Player(
    _name: String,
    var healthPoints: Int,
    val isBlessed: Boolean,
    private val isImmortal: Boolean
) {
    var name = _name
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }

    /**
     * オーラの色を決定する
     * @return オーラの色
     */
    fun auraColor(): String = if (isBlessed && healthPoints > 50 || isImmortal) {
        "GREEN"
    } else {
        "NONE"
    }

    /**
     * @return 残り体力の状態
     */
    fun formatHealthStatus(): String = when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }

        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }

    /**
     * ファイアボールを放つ
     * @param numFireballs ファイアボールの数
     */
    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence.(x$numFireballs)")
}