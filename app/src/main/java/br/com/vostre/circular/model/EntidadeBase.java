package br.com.vostre.circular.model;

import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Calendar;

/**
 * Created by Almir on 02/01/2018.
 */

public class EntidadeBase {

    @PrimaryKey
    @NonNull
    private String id;

    @NonNull
    private Integer status;

    @NonNull
    private Calendar dataCadastro;

    @NonNull
    private Calendar ultimaAlteracao;

    @NonNull
    private Calendar dataLiberacao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Calendar getUltimaAlteracao() {
        return ultimaAlteracao;
    }

    public void setUltimaAlteracao(Calendar ultimaAlteracao) {
        this.ultimaAlteracao = ultimaAlteracao;
    }

    public Calendar getDataLiberacao() {
        return dataLiberacao;
    }

    public void setDataLiberacao(Calendar dataLiberacao) {
        this.dataLiberacao = dataLiberacao;
    }
}
