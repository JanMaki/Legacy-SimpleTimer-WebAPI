package dev.simpletimer.simpletimer_webapi

import dev.simpletimer.simpletimer_webapi.data.DataContainer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * メインクラス
 *
 */
@SpringBootApplication
class SimpleTimerWebAPI {
    companion object {
        /**
         * 全ての始まり
         *
         * @param args 引数
         */
        @JvmStatic
        fun main(args: Array<String>) {
            //データを読み込む
            DataContainer

            //アプリケーションを開始
            runApplication<SimpleTimerWebAPI>(*args)
        }

    }
}