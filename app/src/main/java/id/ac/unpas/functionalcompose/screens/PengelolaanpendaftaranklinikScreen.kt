package id.ac.unpas.functionalcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.room.Room
import id.ac.unpas.functionalcompose.model.pendaftaranklinik
import id.ac.unpas.functionalcompose.persistences.AppDatabase
import id.ac.unpas.functionalcompose.persistences.pendaftaranklinikDao

@Composable
fun PengelolaanpendaftaranklinikScreen() {
    val context = LocalContext.current
    val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "pendaftaranklinik"
    ).build()
    val pendaftaranklinikDao: pendaftaranklinikDao = db.pendaftaranklinikDao()
    val list : LiveData<List<pendaftaranklinik>> =  pendaftaranklinikDao.loadAll()
    val items: List<pendaftaranklinik> by list.observeAsState(initial = listOf())

    Column(modifier = Modifier.fillMaxWidth()) {
        Formpendaftaranklinik(pendaftaranklinikDao)
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items = items, itemContent = { item ->
                Row(modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()) {

                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "nama", fontSize = 14.sp)
                        Text(text = item.nama, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "tanggal_lahir", fontSize = 14.sp)
                        Text(text = item.tanggal_lahir, fontSize = 16.sp, fontWeight =
                        FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "jenis_kelamin", fontSize = 14.sp)
                        Text(text = "${item.jenis_kelamin}", fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "alamat", fontSize = 14.sp)
                        Text(text = "${item.alamat }", fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                }
                Divider(modifier = Modifier.fillMaxWidth())
            })
        }
    }
}


