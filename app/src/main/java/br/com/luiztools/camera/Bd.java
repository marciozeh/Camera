package br.com.luiztools.camera;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

class Bb extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DB_NAME = "app";

    public static class tipos implements BaseColumns {
        public static final String NAME = "tipos";

        public static final String TEXT = "tipo";
        public static final String[] ALL_COLUMNS = {
                _ID, TEXT
        };

        public static final String CREATE =
                "CREATE TABLE " + NAME + " (" +
                        "    " + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                        "    " + TEXT + " TEXT)\n";

        public static final String DROP =
                "DROP TABLE IF EXISTS " + NAME;
    }


    public Bb(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tipos.CREATE);
        db.execSQL("INSERT INTO note VALUES (NULL, 'Buraco')");
        db.execSQL("INSERT INTO note VALUES (NULL, 'Lixo')");
        db.execSQL("INSERT INTO note VALUES (NULL, 'Arvore Caida')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(tipos.DROP);
        onCreate(db);
    }
}
