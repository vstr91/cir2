package br.com.vostre.circular.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.vostre.circular.model.Empresa;

/**
 * Created by Almir on 02/01/2018.
 */

@Dao
public interface EmpresaDAO {

    @Query("SELECT * FROM empresa")
    List<Empresa> getAll();

    @Query("SELECT * FROM empresa WHERE id IN (:userIds)")
    List<Empresa> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM empresa WHERE nome LIKE :nome LIMIT 1")
    Empresa findByName(String nome);

    @Insert
    void insertEmpresa(Empresa empresa);

    @Insert
    void insertAll(Empresa... empresas);

    @Delete
    void delete(Empresa empresas);

}
