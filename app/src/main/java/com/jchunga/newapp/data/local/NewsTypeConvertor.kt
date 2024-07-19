package com.jchunga.newapp.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.jchunga.newapp.data.dto.Source


@ProvidedTypeConverter
class NewsTypeConvertor {

    @TypeConverter
    fun sourceToString(source: Source): String {
        return "${source.id},${source.name}"
    }

    @TypeConverter
    fun stringToSource(source: String): Source{
        return source.split(",").let {
            Source(it[0], it[1])
        }
    }

}