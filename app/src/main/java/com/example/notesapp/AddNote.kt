package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import com.example.notesapp.databinding.ActivityAddNoteBinding
import com.example.notesapp.databinding.ActivityMainBinding
import java.util.zip.Inflater

class AddNote : AppCompatActivity() {
    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var database: NotesDatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = NotesDatabaseHelper(this)

        binding.addDoneBtnId.setOnClickListener {
            addNotesTODB()
        }
    }

    private fun addNotesTODB() {
        val noteTitle = binding.addNoteTitleId.text.toString()
        val noteDescription = binding.addNoteContentId.text.toString()

        val isNotEmpty = noteDescription.isNotEmpty() && noteTitle.isNotEmpty()

        if (isNotEmpty) {
            val noteContent = NoteContent(0, noteTitle, noteDescription)
            database.insertNote(noteContent)
            finish()
            Toast.makeText(this, "Note is added", Toast.LENGTH_SHORT).show()
            Log.d("received", "$noteTitle && $noteDescription")
        } else {
            finish()
            Toast.makeText(this, "Empty field isn't allowed", Toast.LENGTH_SHORT).show()
        }
    }
}