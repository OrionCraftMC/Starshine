package io.github.orioncraftmc.next.starshine.versions.model.version.args

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

sealed class LaunchArgument {
    open fun flatten(): List<LaunchArgument> = listOf(this)

    data class Raw(val value: String) : LaunchArgument()
    data class Variable(val name: String) : LaunchArgument()
    data class Group(private val args: List<LaunchArgument>) : LaunchArgument() {
        override fun flatten(): List<LaunchArgument> = args.flatMap { it.flatten() }
    }

    companion object {
        @JvmStatic
        @JsonCreator
        fun parseSingleArgument(argument: String): LaunchArgument {
            val variableName = argument.removeSurrounding("\${", "}")

            return if (variableName != argument) {
                Variable(variableName)
            } else {
                Raw(argument)
            }
        }

        @JsonCreator
        @JvmStatic
        fun parseModernArgument(@JsonProperty("value") value: Array<String>,
                                @JsonProperty("rules") rules: Any): LaunchArgument {
            //TODO: Rules
            return Group(value.map { parseSingleArgument(it) })
        }
    }
}