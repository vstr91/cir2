package br.com.vostre.circular.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.vostre.circular.model.Parada;
import br.com.vostre.circular.model.ParadaItinerario;

/**
 * Created by Almir on 02/01/2018.
 */

@Dao
public interface ParadaItinerarioDAO {

    @Query("SELECT * FROM parada_itinerario")
    List<ParadaItinerario> getAll();

    @Query("SELECT * FROM parada_itinerario WHERE id IN (:userIds)")
    List<ParadaItinerario> loadAllByIds(int[] userIds);

    @Insert
    void insertParadaItinerario(ParadaItinerario paradaItinerario);

    @Insert
    void insertAll(ParadaItinerario... paradasItinerarios);

    @Delete
    void delete(ParadaItinerario paradaItinerario);

}
