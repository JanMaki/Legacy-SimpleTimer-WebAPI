package dev.simpletimer.simpletimer_webapi.data

import com.charleskorn.kaml.Yaml
import dev.simpletimer.simpletimer_webapi.data.config.ConfigData
import dev.simpletimer.simpletimer_webapi.data.database.ChannelData
import java.io.File

/**
 * データのコンテナ
 *
 */
object DataContainer {

    //コンフィグ
    val config: ConfigData

    //データの一覧
    private val channelDataList = mutableListOf<ChannelData>()

    init {
        val configFile = File("config.yml")

        //ファイルがあるかを確認
        if (!configFile.exists()) {
            //ファイルを作成
            configFile.createNewFile()

            //デフォルトのデータを書き込み
            val configFileOutputStream = configFile.outputStream()
            Yaml.default.encodeToStream(ConfigData.serializer(), ConfigData(), configFileOutputStream)
            configFileOutputStream.close()
        }

        //ファイルを読み込み
        val configFileInputSimpleTimer = configFile.inputStream()
        config = Yaml.default.decodeFromStream(ConfigData.serializer(), configFileInputSimpleTimer)
        configFileInputSimpleTimer.close()
    }

    /**
     * チャンネルのデータを取得
     *
     * @param channelId チャンネルのID
     * @return [ChannelData]
     */
    fun getChannelData(channelId: Long): ChannelData {
        //データを取得
        return channelDataList.filter { it.channel == channelId }.toMutableList().apply {
            //中身がないかを確認
            if (isEmpty()) {
                //空白のデータを入れる
                add(ChannelData(channelId, mutableListOf()))
            }
        }.first()
    }

    /**
     * チャンネルのデータを設定
     *
     * @param channelData チャンネルのデータ
     */
    fun setChannelData(channelData: ChannelData) {
        //データを削除
        channelDataList.removeAll(channelDataList.filter { it.channel == channelData.channel })

        //データを設定
        channelDataList.add(channelData)
    }
}