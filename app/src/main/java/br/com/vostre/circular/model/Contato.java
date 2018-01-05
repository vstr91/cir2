package br.com.vostre.circular.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

/**
 * Created by Almir on 02/01/2018.
 */

@Entity(foreignKeys = @ForeignKey(entity = SubTipoContato.class, parentColumns = "id", childColumns = "sub_tipo_contato"))
public class Contato extends EntidadeBase {

    @ColumnInfo(name = "titulo")
    @NonNull
    private String titulo;

    @ColumnInfo(name = "descricao")
    @NonNull
    private String descricao;

    @ColumnInfo(name = "sub_tipo_contato")
    @NonNull
    private String subTipoContato;

    @NonNull
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NonNull String titulo) {
        this.titulo = titulo;
    }

    @NonNull
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NonNull String descricao) {
        this.descricao = descricao;
    }

    @NonNull
    public String getSubTipoContato() {
        return subTipoContato;
    }

    public void setSubTipoContato(@NonNull String subTipoContato) {
        this.subTipoContato = subTipoContato;
    }

}
