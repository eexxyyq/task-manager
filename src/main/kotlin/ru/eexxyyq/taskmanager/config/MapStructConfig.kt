package ru.eexxyyq.taskmanager.config

import org.mapstruct.MapperConfig
import org.mapstruct.NullValueMappingStrategy

@MapperConfig(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
class MapStructConfig {
}