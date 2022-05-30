package com.example.vk_business

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DB_Helper_LAP(var context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    // Создаем таблицу
    override fun onCreate(db: SQLiteDatabase) {

        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LOGIN_COL + " TEXT, " +
                PASS_COL + " TEXT, " +
                IMAGE_PATH_COL + " TEXT" + ")")

        db.execSQL(query)
    }

    // Не создаем таблицу, если она уже существует
    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    // Добавляем данные
    fun addPerson(login : String, pass : String, image_path: String){

        // Словарик
        val values = ContentValues()
        values.put(LOGIN_COL, login)
        values.put(PASS_COL, pass)
        values.put(IMAGE_PATH_COL, image_path)

        // Объявляем ДБ под запись
        val db = this.writableDatabase
        var result = db.insert(TABLE_NAME, null, values)
        if (result == -1.toLong()){
            Toast.makeText(context, "Что-то не так (БД)!", Toast.LENGTH_LONG).show()}

        // Закрываем
        db.close()
    }

    // Забираем данные
    fun getPerson(): Cursor? {

        // Открывем БД на чтение
        val db = this.readableDatabase

        // Создаем запрос на все позиции базы
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null)

    }

    companion object{
        // Основные данные для таблицы
        private val DATABASE_NAME = "LOG_AND_PASS"
        private val DATABASE_VERSION = 100
        val TABLE_NAME = "lap_table"
        val ID_COL = "id"
        val LOGIN_COL = "login"
        val PASS_COL = "password"
        val IMAGE_PATH_COL = "image"
    }
}