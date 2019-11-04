package com.dreamer.myweather2.internal

import java.io.IOException


class NoConnectivityException : IOException()
class LocationPermissionNotGrantedException : Exception()
class DateNotFoundException : Exception()