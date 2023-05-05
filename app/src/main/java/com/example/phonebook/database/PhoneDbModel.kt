package com.example.phonebook.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PhoneDbModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "tag") val tag: String,
    @ColumnInfo(name = "color_id") val colorId: Long,
    @ColumnInfo(name = "in_trash") val isInTrash: Boolean
) {
    companion object {
        val DEFAULT_PHONES = listOf(
            PhoneDbModel(1, "Kimmy", "0912345678", "Mobile", 4, false),
            PhoneDbModel(2, "Bills", "0912434324", "Home", 2, false),
            PhoneDbModel(3, "Pancake", "0912331128", "Work", 3, false),
            PhoneDbModel(4, "Mark", "0610391832", "Mobile", 5, false),
        )
    }
}
