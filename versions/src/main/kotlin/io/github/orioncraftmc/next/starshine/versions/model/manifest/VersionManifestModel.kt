package io.github.orioncraftmc.next.starshine.versions.model.manifest

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class VersionManifestModel(
    val latest: Map<VersionManifestReleaseType, String>,
    val versions: Map<String, VersionManifestVersionModel>,
) {
    companion object {
        @JsonCreator
        @JvmStatic
        fun create(
            @JsonProperty("latest") latest: Map<VersionManifestReleaseType, String>,
            @JsonProperty("versions") versionsList: List<VersionManifestVersionModel>,
        ): VersionManifestModel {
            return VersionManifestModel(latest, versionsList.associateBy { it.id })
        }
    }
}