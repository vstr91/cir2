package br.com.vostre.circular.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.vostre.circular.model.Itinerario;

/**
 * Created by Almir on 02/01/2018.
 */

@Dao
public interface ItinerarioDAO {

    @Query("SELECT * FROM itinerario")
    List<Itinerario> getAll();

    @Query("SELECT * FROM itinerario WHERE id IN (:userIds)")
    List<Itinerario> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM itinerario WHERE empresa LIKE :empresa LIMIT 1")
    Itinerario findByEmpresa(String empresa);

    @Insert
    void insertItinerario(Itinerario itinerario);

    @Insert
    void insertAll(Itinerario... itinerarios);

    @Delete
    void delete(Itinerario itinerario);

}
