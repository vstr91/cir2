package br.com.vostre.circular.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.vostre.circular.model.SubTipoContato;
import br.com.vostre.circular.model.TipoContato;

/**
 * Created by Almir on 02/01/2018.
 */

@Dao
public interface SubTipoContatoDAO {

    @Query("SELECT * FROM sub_tipo_contato")
    List<SubTipoContato> getAll();

    @Query("SELECT * FROM sub_tipo_contato WHERE id IN (:userIds)")
    List<SubTipoContato> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM sub_tipo_contato WHERE nome LIKE :nome LIMIT 1")
    SubTipoContato findByName(String nome);

    @Insert
    void insertSubTipoContato(SubTipoContato subTipoContato);

    @Insert
    void insertAll(SubTipoContato... subTiposContatos);

    @Delete
    void delete(SubTipoContato subTiposContatos);

}
