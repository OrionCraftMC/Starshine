package io.github.orioncraftmc.next.starshine.versions.model.manifest

import com.fasterxml.jackson.annotation.JsonFormat
import io.github.orioncraftmc.next.starshine.versions.StarshineVersions
import io.github.orioncraftmc.next.starshine.versions.model.version.ClientVersionModel
import java.net.URL
import java.time.Instant

data class VersionManifestVersionModel(
    val id: String,
    val type: VersionManifestReleaseType,
    val url: URL,
    val time: Instant,
    val releaseTime: Instant,
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT) val complianceLevel: Boolean,
    val sha1: String
) {
    val clientVersionModel by lazy {
        StarshineVersions.fetchUrl<ClientVersionModel>(url)
    }
}