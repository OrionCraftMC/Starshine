package io.github.orioncraftmc.next.starshine.versions.model.version

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.orioncraftmc.next.starshine.versions.model.manifest.VersionManifestReleaseType
import io.github.orioncraftmc.next.starshine.versions.model.version.args.ClientVersionArgumentModel

data class ClientVersionModel(
    val id: String,
    val mainClass: String,
    val type: VersionManifestReleaseType,
    val downloads: Map<String, ClientVersionDownloadModel>,
    val libraries: List<ClientVersionLibraryModel>,
    @JsonProperty("minecraftArguments") internal val legacyMinecraftArguments: ClientVersionArgumentModel?,
) {

    val minecraftArguments: ClientVersionArgumentModel
        get() = legacyMinecraftArguments ?: TODO("Parse Modern Arguments")

}

