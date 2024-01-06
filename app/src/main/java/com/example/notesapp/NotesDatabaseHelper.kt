package com.example.notesapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Here we will do 3 imp things:
 * 1. First we'll extend sqliteopenhelper and create 2 method for DB related work
 * 2. Second, we'll create constant like: database name, version, table name, column name
 * 3. Third, we'll create a insertNote function where we'll be inserting our data into the DB.
 * */
class NotesDatabaseHelper(
    /**context is of type Context, that is the NotesDatabaseHelper class context*/
    context: Context
) : SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    /**cursor factory as null. The cursor factory creates cursor object and that cursor object acts as the pointer to read data from the DB, thus if we pass it a null value means we gonna use default cursor*/
    null,
    DATABASE_VERSION
) {
    companion object {
        private const val DATABASE_NAME = "notesapp.db"
        private const val DATABASE_VERSION = "1"
        private const val TABLE_NAME = "notestable"
        private const val COLUMN_ID = "id"
        private const val COLUMN_TITLE = "title"
        private const val COLUMN_CONTENT = "content"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery =
            "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_TITLE TEXT, $COLUMN_CONTENT TEXT)"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropQuery = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(dropQuery)
        onCreate(db)
    }

    fun insertNote(noteContent: NoteContent){

    }
}