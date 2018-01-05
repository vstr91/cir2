package br.com.vostre.circular.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.vostre.circular.model.Mensagem;

/**
 * Created by Almir on 02/01/2018.
 */

@Dao
public interface MensagemDAO {

    @Query("SELECT * FROM mensagem")
    List<Mensagem> getAll();

    @Query("SELECT * FROM mensagem WHERE id IN (:userIds)")
    List<Mensagem> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM mensagem WHERE titulo LIKE :titulo LIMIT 1")
    Mensagem findByTitulo(String titulo);

    @Insert
    void insertMensagem(Mensagem mensagem);

    @Insert
    void insertAll(Mensagem... mensagens);

    @Delete
    void delete(Mensagem mensagens);

}
