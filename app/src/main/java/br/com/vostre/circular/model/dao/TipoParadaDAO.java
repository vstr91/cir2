package br.com.vostre.circular.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.vostre.circular.model.TipoParada;

/**
 * Created by Almir on 02/01/2018.
 */

@Dao
public interface TipoParadaDAO {

    @Query("SELECT * FROM tipo_parada")
    List<TipoParada> getAll();

    @Query("SELECT * FROM tipo_parada WHERE id IN (:userIds)")
    List<TipoParada> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM tipo_parada WHERE nome LIKE :nome LIMIT 1")
    TipoParada findByName(String nome);

    @Insert
    void insertTipoParada(TipoParada tipoParada);

    @Insert
    void insertAll(TipoParada... tiposParadas);

    @Delete
    void delete(TipoParada tiposParadas);

}
