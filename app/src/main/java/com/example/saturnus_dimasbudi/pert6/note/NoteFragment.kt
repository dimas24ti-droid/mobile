package com.example.saturnus_dimasbudi.pert6.note

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.saturnus_dimasbudi.R
import com.example.saturnus_dimasbudi.pert6.data.AppDatabase
import com.example.saturnus_dimasbudi.pert6.data.entity.NoteEntity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NoteFragment : Fragment() {

    private lateinit var adapter: NoteAdapter
    private lateinit var db: AppDatabase
    private val notes = mutableListOf<NoteEntity>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        val rvNotes = view.findViewById<RecyclerView>(R.id.rvNotes)
        val fabAddNote = view.findViewById<FloatingActionButton>(R.id.fabAddNote)

        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Catatan / Note Room"

        // Inisialisasi AppDatabase & Adapter
        db = AppDatabase.getInstance(requireContext())
        adapter = NoteAdapter(notes, this)

        rvNotes.layoutManager = LinearLayoutManager(requireContext())
        rvNotes.adapter = adapter

        // Garis pemisah
        val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        rvNotes.addItemDecoration(dividerItemDecoration)

        fetchNotes()

        fabAddNote.setOnClickListener {
            startActivity(Intent(requireContext(), NoteFormActivity::class.java))
        }
    }

    fun deleteNote(note: NoteEntity) {
        lifecycleScope.launch(Dispatchers.IO) {
            db.noteDao().delete(note)
            withContext(Dispatchers.Main) {
                fetchNotes()
            }
        }
    }

    private fun fetchNotes() {
        lifecycleScope.launch(Dispatchers.IO) {
            val data = db.noteDao().getAll()
            withContext(Dispatchers.Main) {
                notes.clear()
                notes.addAll(data)
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        fetchNotes()
    }
}
