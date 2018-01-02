package br.com.vostre.circular.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

/**
 * Created by Almir on 02/01/2018.
 */

@Entity
public class Pais extends EntidadeBase {

    @ColumnInfo(name = "nome")
    @NonNull
    private String nome;

    @ColumnInfo(name = "iso_3")
    @NonNull
    private String iso3;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }
}
