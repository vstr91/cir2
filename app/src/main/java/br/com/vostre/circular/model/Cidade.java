package br.com.vostre.circular.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

/**
 * Created by Almir on 02/01/2018.
 */

@Entity(foreignKeys = @ForeignKey(entity = Estado.class, parentColumns = "id", childColumns = "estado"))
public class Cidade extends EntidadeBase {

    @ColumnInfo(name = "nome")
    @NonNull
    private String nome;

    @ColumnInfo(name = "slug")
    private String slug;

    @ColumnInfo(name = "brasao")
    private String brasao;

    @ColumnInfo(name = "estado")
    @NonNull
    private String estado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getBrasao() {
        return brasao;
    }

    public void setBrasao(String brasao) {
        this.brasao = brasao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
