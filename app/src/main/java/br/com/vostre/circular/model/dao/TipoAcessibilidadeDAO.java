package br.com.vostre.circular.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.vostre.circular.model.TipoAcessibilidade;

/**
 * Created by Almir on 02/01/2018.
 */

@Dao
public interface TipoAcessibilidadeDAO {

    @Query("SELECT * FROM tipo_acessibilidade")
    List<TipoAcessibilidade> getAll();

    @Query("SELECT * FROM tipo_acessibilidade WHERE id IN (:userIds)")
    List<TipoAcessibilidade> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM tipo_acessibilidade WHERE nome LIKE :nome LIMIT 1")
    TipoAcessibilidade findByName(String nome);

    @Insert
    void insertTipoAcessibilidade(TipoAcessibilidade tipoAcessibilidade);

    @Insert
    void insertAll(TipoAcessibilidade... tiposAcessibilidades);

    @Delete
    void delete(TipoAcessibilidade tipoAcessibilidade);

}
