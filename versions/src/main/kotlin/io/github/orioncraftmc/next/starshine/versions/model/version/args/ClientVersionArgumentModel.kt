package io.github.orioncraftmc.next.starshine.versions.model.version.args

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class ClientVersionArgumentModel(val game: List<LaunchArgument>, val jvm: List<LaunchArgument>) {
    companion object {

        @JsonCreator
        @JvmStatic
        fun parseModernArguments(@JsonProperty("game") gameArgs: List<LaunchArgument>, @JsonProperty("jvm") jvmArgs: List<LaunchArgument>): ClientVersionArgumentModel {
            return ClientVersionArgumentModel(gameArgs, jvmArgs)
        }

        @JsonCreator
        @JvmStatic
        fun parseLegacyArguments(value: String): ClientVersionArgumentModel {
            val gameArgs = value.split(" ").map { LaunchArgument.parseSingleArgument(it) }
            return ClientVersionArgumentModel(game = gameArgs, jvm = emptyList())
        }
    }
}