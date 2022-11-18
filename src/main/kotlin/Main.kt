const val MAX_EXPERIENCE: Int = 5000

fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false


    // Aura
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    // Player status
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

    castFireball(5)
}

/**
 * プレイヤーのステータスを出力する
 */
private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println("(Aura: $auraColor) " + "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}

/**
 * @param healthPoints 体力
 * @param isBlessed 祝福の有無
 * @return 残り体力の状態
 */
private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String = when (healthPoints) {
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
 * オーラの色を決定する
 * @param isBlessed 祝福の有無
 * @param healthPoints 体力
 * @param isImmortal 不死性の有無
 * @return オーラの色
 */
private fun auraColor(
    isBlessed: Boolean,
    healthPoints: Int,
    isImmortal: Boolean
): String = if (isBlessed && healthPoints > 50 || isImmortal) {
    "GREEN"
} else {
    "NONE"
}

/**
 * ファイアボールを放つ
 * @param numFireballs ファイアボールの数
 */
private fun castFireball(numFireballs: Int = 2) =
    println("A glass of Fireball springs into existence.(x$numFireballs)")
