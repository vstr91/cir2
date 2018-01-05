package br.com.vostre.circular.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.vostre.circular.model.Bairro;

/**
 * Created by Almir on 02/01/2018.
 */

@Dao
public interface BairroDAO {

    @Query("SELECT * FROM bairro")
    List<Bairro> getAll();

    @Query("SELECT * FROM bairro WHERE id IN (:userIds)")
    List<Bairro> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM bairro WHERE nome LIKE :nome LIMIT 1")
    Bairro findByName(String nome);

    @Insert
    void insertBairro(Bairro bairro);

    @Insert
    void insertAll(Bairro... bairroes);

    @Delete
    void delete(Bairro bairroes);

}
