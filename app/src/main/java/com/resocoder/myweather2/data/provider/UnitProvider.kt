package com.resocoder.myweather2.data.provider

import com.resocoder.myweather2.internal.UnitSystem


interface UnitProvider {
    fun getUnitSystem(): UnitSystem
}