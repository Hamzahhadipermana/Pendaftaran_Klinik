package id.ac.unpas.functionalcompose.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class pendaftaranklinik(
    @PrimaryKey val id: String,
    val nama: String,
    val tanggal_lahir: String,
    val jenis_kelamin: String,
    val alamat: String
)
