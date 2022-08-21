package io.github.orioncraftmc.next.starshine.versions.model.assets

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy::class)
data class AssetIndexModel(
    val mapToResources: Boolean = false,
    val objects: Map<String, AssetModel>,
)