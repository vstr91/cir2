package br.com.vostre.circular.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.vostre.circular.model.Parametro;

/**
 * Created by Almir on 02/01/2018.
 */

@Dao
public interface ParametroDAO {

    @Query("SELECT * FROM parametro")
    List<Parametro> getAll();

    @Query("SELECT * FROM parametro WHERE id IN (:userIds)")
    List<Parametro> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM parametro WHERE nome LIKE :nome LIMIT 1")
    Parametro findByName(String nome);

    @Insert
    void insertParametro(Parametro parametro);

    @Insert
    void insertAll(Parametro... parametros);

    @Delete
    void delete(Parametro parametros);

}
