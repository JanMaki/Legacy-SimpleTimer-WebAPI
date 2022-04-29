package dev.simpletimer.simpletimer_webapi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * RESTAPIのコントローラー
 *
 */
@RestController
class RestAPIController {
    @GetMapping("status")
    fun getStatus(): Boolean {
        return true
    }
}