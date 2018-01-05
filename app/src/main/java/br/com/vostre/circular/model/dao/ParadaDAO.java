package br.com.vostre.circular.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.vostre.circular.model.Parada;

/**
 * Created by Almir on 02/01/2018.
 */

@Dao
public interface ParadaDAO {

    @Query("SELECT * FROM parada")
    List<Parada> getAll();

    @Query("SELECT * FROM parada WHERE id IN (:userIds)")
    List<Parada> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM parada WHERE nome LIKE :nome LIMIT 1")
    Parada findByName(String nome);

    @Insert
    void insertParada(Parada parada);

    @Insert
    void insertAll(Parada... paradas);

    @Delete
    void delete(Parada paradas);

}
