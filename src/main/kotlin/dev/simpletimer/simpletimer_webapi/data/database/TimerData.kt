package dev.simpletimer.simpletimer_webapi.data.database

/**
 * タイマーのデータ
 *
 * @property id 自動採番ID
 * @property seconds タイマーの時間
 * @property elapsedTime 経過時間　単位：ナノ秒
 * @property startNanoTime 開始時間 単位：ナノ秒
 * @property adjustTime　調整値　単位：ナノ秒
 * @property isMove　タイマーが動いているか
 * @property isFinish　タイマーが終了しているか
 */
data class TimerData(
    val id: Int,
    val seconds: Int,
    val elapsedTime: Long,
    val startNanoTime: Long,
    val adjustTime: Long,
    val isMove: Boolean,
    val isFinish: Boolean
)