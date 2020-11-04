package com.ediperturk.movy.api.serializer

import com.ediperturk.movy.api.data.model.Media
import com.ediperturk.movy.api.data.model.Movie
import com.ediperturk.movy.api.data.model.Person
import com.ediperturk.movy.api.data.model.TVShow
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

object MediaSerializer : KSerializer<Media> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Media", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Media) {
        when (value) {
            is Movie -> encoder.encodeSerializableValue(Movie.serializer(), value)
            is TVShow -> encoder.encodeSerializableValue(TVShow.serializer(), value)
            is Person -> encoder.encodeSerializableValue(Person.serializer(), value)
        }
    }

    override fun deserialize(decoder: Decoder): Media {

        val input = decoder as? JsonDecoder ?: throw SerializationException("Expected JsonInput for ${decoder::class}")
        val jsonObject = input.decodeJsonElement() as? JsonObject ?: throw SerializationException("Expected JsonObject for ${input.decodeJsonElement()::class}")

        val type = jsonObject.jsonObject["media_type"]

        return when (type?.jsonPrimitive?.content) {
            "movie" -> decoder.json.decodeFromJsonElement(Movie.serializer(), jsonObject)
            "tv" -> decoder.json.decodeFromJsonElement(TVShow.serializer(), jsonObject)
            "person" -> decoder.json.decodeFromJsonElement(Person.serializer(), jsonObject)
            else -> throw SerializationException("Type $type not supported")
        }
    }
}
