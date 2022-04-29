package dev.simpletimer.simpletimer_webapi.data.config

import kotlinx.serialization.Serializable

/**
 * コンフィグのデータ
 *
 * @property database データベース
 * @property tokens 接続が許可されているトークン
 */
@Serializable
data class ConfigData(
    val database: DataBaseData = DataBaseData(),
    val tokens: List<String> = arrayListOf()
)