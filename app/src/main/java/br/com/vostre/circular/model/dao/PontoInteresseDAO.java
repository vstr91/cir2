package br.com.vostre.circular.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.vostre.circular.model.PontoInteresse;

/**
 * Created by Almir on 02/01/2018.
 */

@Dao
public interface PontoInteresseDAO {

    @Query("SELECT * FROM ponto_interesse")
    List<PontoInteresse> getAll();

    @Query("SELECT * FROM ponto_interesse WHERE id IN (:userIds)")
    List<PontoInteresse> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM ponto_interesse WHERE nome LIKE :nome LIMIT 1")
    PontoInteresse findByName(String nome);

    @Insert
    void insertPontoInteresse(PontoInteresse pontoInteresse);

    @Insert
    void insertAll(PontoInteresse... pontosInteresse);

    @Delete
    void delete(PontoInteresse pontosInteresse);

}
