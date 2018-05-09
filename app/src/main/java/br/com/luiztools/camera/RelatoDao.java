package br.com.luiztools.camera;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class RelatoDao {
    private static final String TAG = RelatoDao.class.getSimpleName();

    private SQLiteDatabase db;

    public RelatoDao(SQLiteDatabase db) {
        this.db = db;
    }

    public List<Relato> readAllRelatos() {
        List<Relato> relatos = new ArrayList<>();
        Cursor cursor = this.db.query(Bb.tipos.NAME,
                Bb.tipos.ALL_COLUMNS, null, null, null, null, null);

        while (cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndex(Bb.tipos._ID));
            String text = cursor.getString(cursor.getColumnIndex(Bb.tipos.TEXT));
            Relato relato = new Relato(id, text);

            relatos.add(relato);
        }
        return relatos;
    }

    public void createNew(Relato relato) {
        ContentValues values = new ContentValues();

        values.putNull(Bb.tipos._ID);
        values.put(Bb.tipos.TEXT, relato.getText());

        long newRowId = this.db.insert(Bb.tipos.NAME, null, values);

        if (newRowId == -1) {
            Log.e(TAG, "Error inserting note.");
        } else {
            relato.setId(newRowId);
        }
    }
}
