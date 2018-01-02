package br.com.vostre.circular.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.vostre.circular.model.Estado;

/**
 * Created by Almir on 02/01/2018.
 */

@Dao
public interface EstadoDAO {

    @Query("SELECT * FROM estado")
    List<Estado> getAll();

    @Query("SELECT * FROM estado WHERE id IN (:userIds)")
    List<Estado> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM estado WHERE nome LIKE :nome LIMIT 1")
    Estado findByName(String nome);

    @Insert
    void insertEstado(Estado estado);

    @Insert
    void insertAll(Estado... estadoes);

    @Delete
    void delete(Estado estadoes);

}
