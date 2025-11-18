package com.tutoriales.mvvm.domain

import com.tutoriales.mvvm.data.QuoteRepository
import com.tutoriales.mvvm.data.model.QuoteModel
import com.tutoriales.mvvm.data.model.QuoteProvider
import com.tutoriales.mvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (0..quotes.size - 1).random()
            return quotes[randomNumber]
        }
        return null
    }
}