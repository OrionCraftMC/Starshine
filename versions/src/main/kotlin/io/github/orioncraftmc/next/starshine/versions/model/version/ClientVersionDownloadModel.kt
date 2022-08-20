package io.github.orioncraftmc.next.starshine.versions.model.version

import java.net.URL

data class ClientVersionDownloadModel(
    val url: URL,
    val size: Long,
    val sha1: String,
)