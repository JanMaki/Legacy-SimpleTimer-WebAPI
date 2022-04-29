package dev.simpletimer.simpletimer_webapi

import dev.simpletimer.simpletimer_webapi.data.DataContainer
import dev.simpletimer.simpletimer_webapi.data.database.ChannelData
import org.springframework.web.bind.annotation.*

/**
 * RESTAPIのコントローラー
 *
 */
@RestController
@CrossOrigin
class RestAPIController {

    /**
     * ChannelのTimerを取得する
     *
     * @param id ChannelのID[Long]
     * @return Channelのデータ
     */
    @GetMapping("/timers/{id}")
    fun getTimers(@PathVariable("id") id: Long): ChannelData {
        return DataContainer.getChannelData(id)
    }

    /**
     * タイマーのデータを更新する
     *
     * @param token トークン
     * @param channelData チャンネルのデータ
     */
    @PutMapping("/timers/{token}")
    fun putTimer(@PathVariable("token") token: String, @RequestBody channelData: ChannelData) {

        //tokenが有効化を確認
        if (!DataContainer.config.tokens.contains(token)) return

        //チャンネルのデータを更新
        DataContainer.setChannelData(channelData)
    }
}