package br.com.vostre.circular.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.vostre.circular.model.Pais;

/**
 * Created by Almir on 02/01/2018.
 */

@Dao
public interface PaisDAO {

    @Query("SELECT * FROM pais")
    List<Pais> getAll();

    @Query("SELECT * FROM pais WHERE id IN (:userIds)")
    List<Pais> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM pais WHERE nome LIKE :nome LIMIT 1")
    Pais findByName(String nome);

    @Insert
    void insertPais(Pais pais);

    @Insert
    void insertAll(Pais... paises);

    @Delete
    void delete(Pais paises);

}
