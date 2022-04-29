package dev.simpletimer.simpletimer_webapi.data.database

/**
 * タイマーのデータ
 *
 * @property seconds 残り時間
 * @property timeStamp 更新時間
 * @property isMove　タイマーが動いているか
 * @property isFinish　タイマーが終了しているか
 */
data class TimerData(
    val seconds: Int,
    val timeStamp: Long,
    val isMove: Boolean,
    val isFinish: Boolean
)