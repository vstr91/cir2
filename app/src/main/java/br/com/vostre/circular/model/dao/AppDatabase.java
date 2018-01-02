package br.com.vostre.circular.model.dao;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

import br.com.vostre.circular.model.Cidade;
import br.com.vostre.circular.model.Estado;
import br.com.vostre.circular.model.Pais;
import br.com.vostre.circular.utils.Converters;

/**
 * Created by Almir on 02/01/2018.
 */

@Database(entities = {Pais.class, Estado.class, Cidade.class}, version = 4)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract PaisDAO paisDAO();
    public abstract EstadoDAO estadoDAO();
    public abstract CidadeDAO cidadeDAO();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "circular")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

}
