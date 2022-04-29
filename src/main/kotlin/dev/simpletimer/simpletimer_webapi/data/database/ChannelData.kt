package dev.simpletimer.simpletimer_webapi.data.database

/**
 * チャンネルのデータ
 *
 * @property channel チャンネルのID
 * @property timers タイマーの一覧
 */
data class ChannelData(
    val channel: Long,
    val timers: List<TimerData>
)