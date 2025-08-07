package com.elizabeth.contenidoeducativo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform