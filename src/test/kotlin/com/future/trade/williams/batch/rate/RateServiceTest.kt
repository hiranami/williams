package com.future.trade.williams.batch.rate

import com.future.trade.williams.batch.rate.model.Rate
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.Instant

@SpringBootTest
class RateServiceTest(@Autowired private val rateService: RateService) {
    @MockkBean
    private lateinit var mockRateRepositoy: RateRepositoy

    val testRate1 = Rate(id = 1, tradingDate = Instant.ofEpochMilli(0), openingPrice = 100, closingPrice = 150, highPrice = 200, lowPrice = 50)
    val testRate2 = Rate(id = 2, tradingDate = Instant.ofEpochMilli(0), openingPrice = 200, closingPrice = 250, highPrice = 300, lowPrice = 190)
    val testRates = listOf(testRate1, testRate2)

    @Test
    fun testFindAll() {
        every { mockRateRepositoy.findAll() } returns testRates
        val expectedRate1 = Rate(id = 2, tradingDate = Instant.ofEpochMilli(0), openingPrice = 100, closingPrice = 150, highPrice = 200, lowPrice = 50)
        val expectedRate2 = Rate(id = 4, tradingDate = Instant.ofEpochMilli(0), openingPrice = 200, closingPrice = 250, highPrice = 300, lowPrice = 190)
        val expectedRates = listOf(expectedRate1, expectedRate2)

        Assertions.assertEquals(expectedRates, rateService.findAll())
        verify { mockRateRepositoy.findAll() }
    }


}
