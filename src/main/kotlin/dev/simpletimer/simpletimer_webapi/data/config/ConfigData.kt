package dev.simpletimer.simpletimer_webapi.data.config

import kotlinx.serialization.Serializable

/**
 * コンフィグのデータ
 *
 * @property tokens 更新が許可されているトークン
 */
@Serializable
data class ConfigData(
    val tokens: List<String> = arrayListOf()
)