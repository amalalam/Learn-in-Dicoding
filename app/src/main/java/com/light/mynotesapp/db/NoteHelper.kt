package com.light.mynotesapp.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.light.mynotesapp.db.DatabaseContract.NoteColumns.Companion.TABLE_NAME
import com.light.mynotesapp.db.DatabaseContract.NoteColumns.Companion._ID
import java.sql.SQLException

class NoteHelper(context: Context) {

    init{
        dataBaseHelper = DatabaseHelper(context)
    }

    @Throws(SQLException::class)
    fun open(){
        database = dataBaseHelper.writableDatabase
    }

    fun close(){
        dataBaseHelper.close()

        if(database.isOpen) database.close()
    }

    fun queryAll(): Cursor {
        return database.query(
            DATABASE_TABLE,
            null,
            null,
            null,
            null,
            null,
            "$_ID ASC"
        )
    }

    fun queryById(id: String): Cursor{
        return database.query(
            DATABASE_TABLE,
            null,
            "$_ID = ?",
            arrayOf(id),
            null,
            null,
            null,
            null
        )
    }

    fun insert(values: ContentValues?): Long = database.insert(DATABASE_TABLE, null, values)

    fun update(id: String, values: ContentValues?): Int = database.update(DATABASE_TABLE, values,
        "$_ID = ?" , arrayOf(id))

    fun deleteById(id: String): Int = database.delete(TABLE_NAME, "$_ID = $id", null)

    companion object{
        private const val DATABASE_TABLE = TABLE_NAME
        private lateinit var dataBaseHelper: DatabaseHelper
        private lateinit var database: SQLiteDatabase

        private var INSTANCE: NoteHelper? = null
        fun getInstance(context: Context): NoteHelper{
            return INSTANCE?: synchronized(this){
                INSTANCE ?: NoteHelper(context)
            }

        }
    }
}