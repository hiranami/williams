package com.future.trade.williams.batch.rate

import com.future.trade.williams.batch.rate.RateRepositoy
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class RateController(private val rateService: RateService) {
    @GetMapping("/rate")
    suspend fun getList() = rateService.findAll()
}
