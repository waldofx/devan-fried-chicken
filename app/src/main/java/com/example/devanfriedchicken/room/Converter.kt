package com.example.devanfriedchicken.room

import androidx.room.TypeConverter
import java.util.Date

public class Converter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }
    @TypeConverter
    fun toTimestamp(value: Date?): Long? {
        return value?.let { value.time }
    }
}