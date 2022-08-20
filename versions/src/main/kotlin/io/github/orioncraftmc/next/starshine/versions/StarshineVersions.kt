package io.github.orioncraftmc.next.starshine.versions

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonMapperBuilder
import com.fasterxml.jackson.module.kotlin.kotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import io.github.orioncraftmc.next.starshine.versions.model.manifest.VersionManifestModel
import java.net.URL

object StarshineVersions {

    internal val mapper = jacksonMapperBuilder()
        .addModule(kotlinModule())
        .addModule(JavaTimeModule())
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .build()

    fun readVersionManifestModel(url: URL = URL(StarshineConstants.VERSION_MANIFEST_URL)): VersionManifestModel {
        return mapper.readValue(url)
    }

}