package br.com.vostre.circular.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.vostre.circular.model.Cidade;

/**
 * Created by Almir on 02/01/2018.
 */

@Dao
public interface CidadeDAO {

    @Query("SELECT * FROM cidade")
    List<Cidade> getAll();

    @Query("SELECT * FROM cidade WHERE id IN (:userIds)")
    List<Cidade> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM cidade WHERE nome LIKE :nome LIMIT 1")
    Cidade findByName(String nome);

    @Insert
    void insertCidade(Cidade cidade);

    @Insert
    void insertAll(Cidade... cidadees);

    @Delete
    void delete(Cidade cidadees);

}
