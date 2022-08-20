package io.github.orioncraftmc.next.starshine.versions.model.manifest

import com.fasterxml.jackson.annotation.JsonCreator

enum class VersionManifestReleaseType {
    RELEASE,
    SNAPSHOT,
    OLD_BETA,
    OLD_ALPHA,
    UNKNOWN;

    companion object {
        @JsonCreator
        @JvmStatic
        fun create(value: String): VersionManifestReleaseType {
            return when (value) {
                "release" -> RELEASE
                "snapshot" -> SNAPSHOT
                "old_beta" -> OLD_BETA
                "old_alpha" -> OLD_ALPHA
                else -> UNKNOWN
            }
        }
    }
}