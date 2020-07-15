package com.future.trade.williams.batch.rate

import com.future.trade.williams.batch.rate.model.Rate
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.web.reactive.server.WebTestClient
import java.time.Instant


@WebFluxTest
class RateControllerTest(@Autowired private val webTestClient: WebTestClient) {
    @MockkBean
    lateinit var mockRateService: RateService

    @DisplayName("全件取得")
    @Nested
    inner class GetList {
        private val getListUri = "/rate"

        val testRate1 = Rate(id = 1, tradingDate = Instant.ofEpochMilli(0), openingPrice = 100, closingPrice = 150, highPrice = 200, lowPrice = 50)
        val testRate2 = Rate(id = 2, tradingDate = Instant.ofEpochMilli(0), openingPrice = 200, closingPrice = 250, highPrice = 300, lowPrice = 190)
        val testRates = listOf(testRate1, testRate2)

        @DisplayName("正常系")
        @Test
        fun success() {
            every { mockRateService.findAll() } returns testRates

            val expectResponce = """
                [
                    {
                        "id":1,
                        "tradingDate":"1970-01-01T00:00:00Z",
                        "openingPrice":100,
                        "highPrice":200,
                        "lowPrice":50,
                        "closingPrice":150
                    },
                    {
                        "id":2,
                        "tradingDate":"1970-01-01T00:00:00Z",
                        "openingPrice":200,
                        "highPrice":300,
                        "lowPrice":190,
                        "closingPrice":250
                    }
                ]
            """.trimIndent()

            webTestClient.get().uri(getListUri).exchange()
                    .expectStatus().isOk
                    .expectBody().json(expectResponce)

            verify { mockRateService.findAll() }
        }


    }
}
