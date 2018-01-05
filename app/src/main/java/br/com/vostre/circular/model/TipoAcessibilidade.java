package br.com.vostre.circular.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

/**
 * Created by Almir on 02/01/2018.
 */

@Entity(tableName = "tipo_acessibilidade")
public class TipoAcessibilidade extends EntidadeBase {

    @ColumnInfo(name = "nome")
    @NonNull
    private String nome;

    @ColumnInfo(name = "codigo")
    @NonNull
    private Integer codigo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NonNull
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(@NonNull Integer codigo) {
        this.codigo = codigo;
    }
}
