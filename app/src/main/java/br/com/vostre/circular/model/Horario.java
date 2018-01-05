package br.com.vostre.circular.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import java.util.Calendar;

/**
 * Created by Almir on 02/01/2018.
 */

@Entity
public class Horario extends EntidadeBase {

    @ColumnInfo(name = "nome")
    @NonNull
    private Calendar nome;

    @NonNull
    public Calendar getNome() {
        return nome;
    }

    public void setNome(@NonNull Calendar nome) {
        this.nome = nome;
    }

}
