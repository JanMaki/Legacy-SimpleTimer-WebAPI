package dev.simpletimer.simpletimer_webapi.data.database

import dev.simpletimer.simpletimer_webapi.data.DataContainer
import org.jetbrains.exposed.sql.Database

/**
 * データベースへの接続を行う
 */
object Connector{
    fun connect(){
        //データベースのデータを取得
        val data = DataContainer.config.database

        //接続
        Database.connect(data.url, data.driver, data.userName, data.userPassword)
    }
}