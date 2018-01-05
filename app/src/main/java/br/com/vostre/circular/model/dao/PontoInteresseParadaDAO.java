package br.com.vostre.circular.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.vostre.circular.model.PontoInteresseParada;

/**
 * Created by Almir on 02/01/2018.
 */

@Dao
public interface PontoInteresseParadaDAO {

    @Query("SELECT * FROM ponto_interesse_parada")
    List<PontoInteresseParada> getAll();

    @Query("SELECT * FROM ponto_interesse_parada WHERE id IN (:userIds)")
    List<PontoInteresseParada> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM ponto_interesse_parada WHERE parada LIKE :parada")
    PontoInteresseParada findByParada(String parada);

    @Insert
    void insertPontoInteresseParada(PontoInteresseParada pontoInteresseParada);

    @Insert
    void insertAll(PontoInteresseParada... pontosInteresseParada);

    @Delete
    void delete(PontoInteresseParada pontoInteresseParada);

}
