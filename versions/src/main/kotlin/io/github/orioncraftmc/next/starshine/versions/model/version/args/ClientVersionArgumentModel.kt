package io.github.orioncraftmc.next.starshine.versions.model.version.args

import com.fasterxml.jackson.annotation.JsonCreator

class ClientVersionArgumentModel {
    companion object {
        @JsonCreator
        @JvmStatic
        fun create(value: String): ClientVersionArgumentModel {
            return ClientVersionArgumentModel()
        }
    }
}