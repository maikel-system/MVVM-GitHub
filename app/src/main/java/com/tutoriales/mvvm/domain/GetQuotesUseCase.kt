package com.tutoriales.mvvm.domain

import com.tutoriales.mvvm.data.QuoteRepository
import com.tutoriales.mvvm.data.database.entities.toDatabase
import com.tutoriales.mvvm.domain.model.Quote
import javax.inject.Inject

//Al inyectar 'repository' no hace falta instanciarlo, sólo tipearlo
class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {

    /**
     * 'invoke' sirve para que al llamar a una instancia de GetQuotesUseCase(), se llame
     * automáticamente al contenido de 'invoke'
     *
     */

    //Corrutina
    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()

        return if (quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        } else {
            repository.getAllQuotesFromDatabase()
        }
    }

}