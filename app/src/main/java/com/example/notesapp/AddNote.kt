package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.notesapp.databinding.ActivityAddNoteBinding
import com.example.notesapp.databinding.ActivityMainBinding
import java.util.zip.Inflater

class AddNote : AppCompatActivity() {
    lateinit var binding: ActivityAddNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}