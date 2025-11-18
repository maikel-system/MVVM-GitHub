package com.tutoriales.mvvm.domain.model

import com.tutoriales.mvvm.data.database.entities.QuoteEntity
import com.tutoriales.mvvm.data.model.QuoteModel

data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)
