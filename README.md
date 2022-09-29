# Starshine

Starshine is a group of tools designed specifically to aid with implementing Minecraft PvP clients that support multiple
game versions.

This project exists to help organize OrionCraft and its versioned implementations, but can be used
on any other similar project that has the same requirements.

## Goals

* Provide a common base for implementing Minecraft PvP clients.
* Provide an easy way to manage multiple game version implementations.
* Provide a pluggable architecture for adding new game versions.
* Provide a way to easily manage and upgrade game version dependencies.

## Modules

### Versions

The versions module contains the implementation for parsing minecraft manifests.