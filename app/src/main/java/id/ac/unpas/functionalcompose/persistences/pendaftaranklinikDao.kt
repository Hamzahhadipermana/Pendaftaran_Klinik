package id.ac.unpas.functionalcompose.persistences


import androidx.lifecycle.LiveData
import androidx.room.*
import id.ac.unpas.functionalcompose.model.pendaftaranklinik

@Dao
interface pendaftaranklinikDao {


    @Query("SELECT * FROM pendaftaranklinik")
    fun loadAll(): LiveData<List<pendaftaranklinik>>
    @Query("SELECT * FROM pendaftaranklinik WHERE id = :id")
    fun find(id: String): pendaftaranklinik?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: pendaftaranklinik)
    @Delete
    fun delete(item: pendaftaranklinik)


}
