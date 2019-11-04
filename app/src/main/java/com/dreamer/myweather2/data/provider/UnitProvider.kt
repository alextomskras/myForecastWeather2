package com.dreamer.myweather2.data.provider

import com.dreamer.myweather2.internal.UnitSystem


interface UnitProvider {
    fun getUnitSystem(): UnitSystem
}