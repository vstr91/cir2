package br.com.vostre.circular.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

/**
 * Created by Almir on 02/01/2018.
 */

@Entity(tableName = "sub_tipo_contato", foreignKeys = @ForeignKey(entity = TipoContato.class, parentColumns = "id", childColumns = "tipo_contato"))
public class SubTipoContato extends EntidadeBase {

    @ColumnInfo(name = "nome")
    @NonNull
    private String nome;

    @ColumnInfo(name = "tipo_contato")
    @NonNull
    private String tipoContato;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NonNull
    public String getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(@NonNull String tipoContato) {
        this.tipoContato = tipoContato;
    }

}
