package com.jmarara529.examen.miscelanea;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;

    private static final String DATAVASE_NAME="usuarios.db";

    private AdminSQLiteOpenHelper sqlhleper;

    public static final String TABLE_NAME1="alumnos";

    public static final String COLUM_IDALUMNO="usuario";

    public static final String COLUM_PASSWORD="contraseña";

    public static final String COLUM_NOMBRE="nombre";

    public static final String COLUM_APELLIDOS="apellidos";

    public static final String COLUMN_SEXO="sexo";

    public static final String TABLE_NAME2="notas";

    public static final String COLUMN_MATEMATICAS="matematicas";

    public static final String COLUMN_LENGUA="lengua";

    public static final String COLUMN_INFORMATICA="informatica";

    public static final String COLUMN_INGLES="ingles";

    private static final String CREATE_TABLE1 =
            "CREATE TABLE " + TABLE_NAME1 + " ("+
                    COLUM_IDALUMNO + " TEXT PRIMARY KEY"+
                    COLUM_PASSWORD + " TEXT NOT NULL"+
                    COLUM_NOMBRE + " TEXT NOT NULL"+
                    COLUM_APELLIDOS + " TEXT NOT NULL"+
                    COLUMN_SEXO + " TEXT NOT NULL"+
                    ");";

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /*private static final String CREATE_TABLE1 =
            "CREATE TABLE" + TABLE_NAME2 + " ("+
                    COLUM_IDALUMNO + " TEXT PRI"

*/

    /*

    NO ME HA DADO TIEMPO A SEGUIR

     */
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
