package br.com.vostre.circular.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.vostre.circular.model.HorarioItinerario;
import br.com.vostre.circular.model.ParadaItinerario;

/**
 * Created by Almir on 02/01/2018.
 */

@Dao
public interface HorarioItinerarioDAO {

    @Query("SELECT * FROM horario_itinerario")
    List<HorarioItinerario> getAll();

    @Query("SELECT * FROM horario_itinerario WHERE id IN (:userIds)")
    List<HorarioItinerario> loadAllByIds(int[] userIds);

    @Insert
    void insertHorarioItinerario(HorarioItinerario horarioItinerario);

    @Insert
    void insertAll(HorarioItinerario... horariosItinerarios);

    @Delete
    void delete(HorarioItinerario horarioItinerario);

}
