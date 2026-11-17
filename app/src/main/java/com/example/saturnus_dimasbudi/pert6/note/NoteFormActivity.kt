package com.example.saturnus_dimasbudi.pert6.note

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import com.example.saturnus_dimasbudi.R
import com.example.saturnus_dimasbudi.pert6.data.AppDatabase
import com.example.saturnus_dimasbudi.pert6.data.entity.NoteEntity
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NoteFormActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_form)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val etTitle = findViewById<TextInputEditText>(R.id.etTitle)
        val etContent = findViewById<TextInputEditText>(R.id.etContent)
        val btnSaveNote = findViewById<Button>(R.id.btnSaveNote)

        // Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = "Tambah Catatan"
            setDisplayHomeAsUpEnabled(true)
        }
        toolbar.setNavigationOnClickListener { finish() }

        // Inisialisasi DB
        db = AppDatabase.getInstance(this)

        btnSaveNote.setOnClickListener {
            val title = etTitle.text.toString().trim()
            val content = etContent.text.toString().trim()

            if (title.isNotBlank() && content.isNotBlank()) {
                lifecycleScope.launch(Dispatchers.IO) {
                    val note = NoteEntity(
                        title = title,
                        content = content,
                        createdAt = System.currentTimeMillis()
                    )
                    db.noteDao().insert(note)
                    withContext(Dispatchers.Main) {
                        finish()
                    }
                }
            } else {
                Toast.makeText(this, "Isi semua kolom!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
