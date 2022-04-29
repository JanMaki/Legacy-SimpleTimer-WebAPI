package dev.simpletimer.simpletimer_webapi.data.config

import kotlinx.serialization.Serializable

/**
 * データベースのデータ
 *
 * @property url URL
 * @property driver driver
 * @property userName ユーザー名
 * @property userPassword ユーザーのパスワード
 * @constructor Create empty Data base data
 */
@Serializable
data class DataBaseData(
    val url: String = "",
    val driver: String = "",
    val userName: String = "",
    val userPassword: String = ""
)