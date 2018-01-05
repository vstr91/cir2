package br.com.vostre.circular.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.vostre.circular.model.Contato;

/**
 * Created by Almir on 02/01/2018.
 */

@Dao
public interface ContatoDAO {

    @Query("SELECT * FROM contato")
    List<Contato> getAll();

    @Query("SELECT * FROM contato WHERE id IN (:userIds)")
    List<Contato> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM contato WHERE titulo LIKE :titulo LIMIT 1")
    Contato findByTitulo(String titulo);

    @Insert
    void insertContato(Contato contato);

    @Insert
    void insertAll(Contato... contatos);

    @Delete
    void delete(Contato contatos);

}
