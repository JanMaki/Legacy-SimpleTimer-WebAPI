package dev.simpletimer.simpletimer_webapi.data

import com.charleskorn.kaml.Yaml
import dev.simpletimer.simpletimer_webapi.data.config.ConfigData
import java.io.File
import java.nio.file.Paths

object DataContainer {
    //jarがあるディレクトリ
    private val parentDirectory: File =
        File(Paths.get(javaClass.protectionDomain.codeSource.location.toURI()).toString()).parentFile

    //コンフィグを保管するファイル
    private val configFile = File(parentDirectory, "config.yml")

    val config: ConfigData

    init {
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
}