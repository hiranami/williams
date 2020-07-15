package com.future.trade.williams.batch.rate

import com.future.trade.williams.batch.rate.model.Rate
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RateRepositoy: CrudRepository<Rate, Int>
