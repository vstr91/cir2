package br.com.vostre.circular.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

/**
 * Created by Almir on 02/01/2018.
 */

@Entity(foreignKeys = @ForeignKey(entity = Pais.class, parentColumns = "id", childColumns = "pais"))
public class Estado extends EntidadeBase {

    @ColumnInfo(name = "nome")
    @NonNull
    private String nome;

    @ColumnInfo(name = "sigla")
    @NonNull
    private String sigla;

    @ColumnInfo(name = "pais")
    @NonNull
    private String pais;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
