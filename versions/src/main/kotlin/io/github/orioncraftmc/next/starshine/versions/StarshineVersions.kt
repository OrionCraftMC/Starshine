package io.github.orioncraftmc.next.starshine.versions

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonMapperBuilder
import com.fasterxml.jackson.module.kotlin.kotlinModule

object StarshineVersions {

    val mapper = jacksonMapperBuilder()
        .addModule(kotlinModule())
        .addModule(JavaTimeModule())
        .disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES)
        .build()

}