package com.example.uriatmosphere.data.user

import androidx.room.Entity
import java.time.LocalDateTime


@Entity
data class User(
    val lastStationDataUpdateDate: LocalDateTime,
)