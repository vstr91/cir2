package br.com.vostre.circular.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.Calendar;
import java.util.List;

import br.com.vostre.circular.model.Horario;

/**
 * Created by Almir on 02/01/2018.
 */

@Dao
public interface HorarioDAO {

    @Query("SELECT * FROM horario")
    List<Horario> getAll();

    @Query("SELECT * FROM horario WHERE id IN (:userIds)")
    List<Horario> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM horario WHERE nome LIKE :nome LIMIT 1")
    Horario findByName(Calendar nome);

    @Insert
    void insertHorario(Horario horario);

    @Insert
    void insertAll(Horario... horarios);

    @Delete
    void delete(Horario horarios);

}
