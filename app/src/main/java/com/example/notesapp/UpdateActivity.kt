package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notesapp.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateBinding
    private lateinit var databaseHelper: NotesDatabaseHelper

    /**negative integer i.e = - 1 is the id that represents the value is empty. We will use it to deal with null values.*/
    private var noteId: Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = NotesDatabaseHelper(this)

        noteId = intent.getIntExtra("note_id", -1)

        /** if we don't receive the notes id, than we gotta finish the intent*/
        if (noteId == -1) {
            finish()
            return
        }

        /**But if notes id is received, we need to know which notes was clicked and based on that info we gotta display the title and notes description*/
        val note: NoteContent = databaseHelper.getNoteById(noteId)

    }
}