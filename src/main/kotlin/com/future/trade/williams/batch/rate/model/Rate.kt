package com.future.trade.williams.batch.rate.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant

@Table("rate")
data class Rate(
        @Id val id: Int,
        val tradingDate: Instant,
        val openingPrice: Int,
        val highPrice: Int,
        val lowPrice: Int,
        val closingPrice: Int
)

