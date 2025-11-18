package com.tutoriales.mvvm.data

import com.tutoriales.mvvm.data.database.dao.QuoteDao
import com.tutoriales.mvvm.data.database.entities.QuoteEntity
import com.tutoriales.mvvm.data.model.QuoteModel
import com.tutoriales.mvvm.data.model.QuoteProvider
import com.tutoriales.mvvm.data.network.QuoteService
import com.tutoriales.mvvm.domain.model.Quote
import com.tutoriales.mvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
){

    //Corrutina
    suspend fun getAllQuotesFromApi(): List<Quote> {
        //Llamo al backend
        val response: List<QuoteModel> = api.getQuotes()
        //Llamo al provider (actuando como una base de datos en memoria): quoteProvider.quotes = response

        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes() {
        quoteDao.deleteAllQuotes()
    }
}