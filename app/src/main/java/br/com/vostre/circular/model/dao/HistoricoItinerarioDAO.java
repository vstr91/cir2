package br.com.vostre.circular.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.vostre.circular.model.HistoricoItinerario;
import br.com.vostre.circular.model.ParadaItinerario;

/**
 * Created by Almir on 02/01/2018.
 */

@Dao
public interface HistoricoItinerarioDAO {

    @Query("SELECT * FROM historico_itinerario")
    List<HistoricoItinerario> getAll();

    @Query("SELECT * FROM historico_itinerario WHERE id IN (:userIds)")
    List<HistoricoItinerario> loadAllByIds(int[] userIds);

    @Insert
    void insertHistoricoItinerario(HistoricoItinerario historicoItinerario);

    @Insert
    void insertAll(HistoricoItinerario... historicosItinerarios);

    @Delete
    void delete(HistoricoItinerario historicoItinerario);

}
