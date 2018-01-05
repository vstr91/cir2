package br.com.vostre.circular.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.vostre.circular.model.ParadaItinerario;
import br.com.vostre.circular.model.SecaoItinerario;

/**
 * Created by Almir on 02/01/2018.
 */

@Dao
public interface SecaoItinerarioDAO {

    @Query("SELECT * FROM secao_itinerario")
    List<SecaoItinerario> getAll();

    @Query("SELECT * FROM secao_itinerario WHERE id IN (:userIds)")
    List<SecaoItinerario> loadAllByIds(int[] userIds);

    @Insert
    void insertSecaoItinerario(SecaoItinerario secaoItinerario);

    @Insert
    void insertAll(SecaoItinerario... secoesItinerarios);

    @Delete
    void delete(SecaoItinerario secaoItinerario);

}
