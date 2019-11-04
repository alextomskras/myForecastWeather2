package com.resocoder.myweather2.internal

import java.io.IOException


class NoConnectivityException : IOException()
class LocationPermissionNotGrantedException : Exception()
class DateNotFoundException : Exception()