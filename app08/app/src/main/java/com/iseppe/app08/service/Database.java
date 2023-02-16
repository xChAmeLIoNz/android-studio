package com.iseppe.app08.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.iseppe.app08.model.Promemoria;

import java.util.Date;

public class Database extends SQLiteOpenHelper {

    //costanti statiche di connessione
    private final static int VERSION = 1;
    private final static String DB_NAME = "app_08";

    //costruttore
    public Database(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    //generiamo la tabella necessaria se non esiste già
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql = "CREATE TABLE IF NOT EXISTS promemoria (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " data DATE NOT NULL, oggetto TEXT NOT NULL)";

        sqLiteDatabase.execSQL(sql);
    }

    //metodo invocato all'aggiornamento della versione del db
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String sql = "DROP TABLE promemoria";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);

    }

    //metodo per leggere l'intero contenuto della tabella

    public void leggiPromemoria() {

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("promemoria", null, null, null,
                null, null, "data DESC");

        Promemoria.getElenco().clear();

        while (cursor.moveToNext()) {

            Promemoria promemoria = new Promemoria();
            promemoria.setId(cursor.getInt(0));
            promemoria.setData(new Date(cursor.getLong(1)));
            promemoria.setOggetto(cursor.getString(2));
            Promemoria.getElenco().add(promemoria);
        }
    }

    //metodo per creare un nuovo promemoria
    public void creaPromemoria(Promemoria promemoria) {

        SQLiteDatabase database = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("data", promemoria.getData().getTime());
        cv.put("oggetto", promemoria.getOggetto());

        database.insert("promemoria", null, cv);
    }

    //metodo per cancellare un promemoria
    public void cancellaPromemoria(int idPromemoria) {

        //eliminazione da collezione statica
        for (Promemoria p : Promemoria.getElenco()) {
            if (p.getId() == idPromemoria) {
                Promemoria.getElenco().remove(p);
                break;
            }

            //eliminazione da database
            SQLiteDatabase database = getWritableDatabase();
            database.delete("promemoria", "_id=?", new String[] {String.valueOf(idPromemoria)});
        }
    }

    //metodo per modificare un promemoria
    public void modificaPromemoria(Promemoria promemoria) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("data", promemoria.getData().getTime());
        cv.put("oggetto", promemoria.getOggetto());
        database.update("promemoria", cv, "_id=?", new String[] {String.valueOf(promemoria.getId())});
    }

}
