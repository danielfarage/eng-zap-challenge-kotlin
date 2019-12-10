package com.farage.daniel.eng_zap_challenge_kotlin.domain.utils

import java.text.NumberFormat
import java.util.*


fun Int.toMoney(): String {
    val numberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
    return numberFormat.format(this)
}