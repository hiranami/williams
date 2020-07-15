package com.future.trade.williams.batch.rate

import org.springframework.stereotype.Service

@Service
class RateService(private val rateRepositoy: RateRepositoy){
    fun findAll() = rateRepositoy.findAll().map {
        it.copy(id = it.id * 2)
    }
}
