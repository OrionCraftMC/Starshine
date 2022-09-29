package io.github.orioncraftmc.next.starshine.versions

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonMapperBuilder
import com.fasterxml.jackson.module.kotlin.kotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import io.github.orioncraftmc.next.starshine.versions.model.manifest.VersionManifestModel
import java.net.URL

/**
 * Entry-point for the Starshine versions library.
 *
 * This class handles the fetching of the version manifest and the parsing of it.
 */
object StarshineVersions {

    /**
     * Abstraction of a URL fetcher.
     *
     * This is used to allow for interception of any fetching process so things like caching can be implemented.
     */
    fun interface UrlFetcher {
        companion object : UrlFetcher {
            override fun fetchUrlText(url: URL): String {
                return url.readText(Charsets.UTF_8)
            }
        }

        /**
         * Fetches the text from the given URL.
         * @param url The URL to fetch the text from.
         *
         * @return The text from the URL.
         */
        fun fetchUrlText(url: URL): String
    }

    private val mapper = jacksonMapperBuilder()
        .addModule(kotlinModule())
        .addModule(JavaTimeModule())
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
        .build()

    @JvmStatic
    var urlFetcher: UrlFetcher = UrlFetcher.Companion

    fun fetchVersionManifest(): VersionManifestModel = fetchUrl(URL(StarshineConstants.VERSION_MANIFEST_URL))

    internal inline fun <reified T> fetchUrl(url: URL): T {
        return mapper.readValue(urlFetcher.fetchUrlText(url))
    }

}