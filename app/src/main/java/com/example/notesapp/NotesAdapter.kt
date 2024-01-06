package com.example.notesapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

/**
 * Here we'll be creating:
 * 1. ViewHolder
 * 2. Recycler adapter and its 3 method
 * 3. Lastly a refresh data function
 * */
class NotesAdapter(
    private var notes: List<NoteContent>,
    /**Here the context represents the notes adpater*/
    context: Context
) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.noteTitleId)
        val contentTextView: TextView = itemView.findViewById(R.id.noteContentId)
        val updateButton: ImageView = itemView.findViewById(R.id.editIconId)
        val deleteButton: ImageView = itemView.findViewById(R.id.deleteIconId)
    }

    /** In the onCreateViewHolder, we set up the item layout view*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.eachrow, parent, false)
        return NoteViewHolder(view)
    }


    /** Here in onBindViewHolder, we bind data on the element*/
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.titleTextView.text = note.title
        holder.contentTextView.text = note.noteDescription

        holder.updateButton.setOnClickListener {
            val intent = Intent(holder.itemView.context, UpdateActivity::class.java).apply {
                putExtra("note_id", note.id)
            }
            holder.itemView.context.startActivity(intent)
        }

        holder.deleteButton.setOnClickListener {

        }
    }


    /** The size is returned*/
    override fun getItemCount(): Int {
        return notes.size
    }

    @SuppressLint("NotifyDataSetChanged")
            /** refreshData function in NotesAdapter class is a custom method that we've added to facilitate updating the dataset and notifying the adapter that the data has changed. */
    fun refreshData(newNotes: List<NoteContent>) {
        notes = newNotes
        /**notifyDataSetChanged(): This method is called to inform the attached RecyclerView that the dataset has changed. When you call this method, it triggers the onBindViewHolder method to be called for each visible item in the RecyclerView, allowing the adapter to rebind the updated data to the corresponding views.*/
        notifyDataSetChanged()
    }

}