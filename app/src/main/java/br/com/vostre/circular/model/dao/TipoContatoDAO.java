package br.com.vostre.circular.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.vostre.circular.model.Pais;
import br.com.vostre.circular.model.TipoContato;

/**
 * Created by Almir on 02/01/2018.
 */

@Dao
public interface TipoContatoDAO {

    @Query("SELECT * FROM tipo_contato")
    List<TipoContato> getAll();

    @Query("SELECT * FROM tipo_contato WHERE id IN (:userIds)")
    List<TipoContato> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM tipo_contato WHERE nome LIKE :nome LIMIT 1")
    TipoContato findByName(String nome);

    @Insert
    void insertTipoContato(TipoContato tipoContato);

    @Insert
    void insertAll(TipoContato... tiposContatos);

    @Delete
    void delete(TipoContato tiposContatos);

}
