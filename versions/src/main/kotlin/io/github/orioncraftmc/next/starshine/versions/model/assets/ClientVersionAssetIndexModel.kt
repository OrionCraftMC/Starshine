package io.github.orioncraftmc.next.starshine.versions.model.assets

import com.fasterxml.jackson.module.kotlin.readValue
import io.github.orioncraftmc.next.starshine.versions.StarshineVersions
import java.net.URL

data class ClientVersionAssetIndexModel(
    val id: String,
    val sha1: String,
    val size: Long,
    val totalSize: Long,
    val url: URL
) {
    val assetModel by lazy {
        StarshineVersions.mapper.readValue<AssetIndexModel>(url)
    }
}

