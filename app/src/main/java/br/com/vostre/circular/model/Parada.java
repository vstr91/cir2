package br.com.vostre.circular.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

/**
 * Created by Almir on 02/01/2018.
 */

@Entity(tableName = "parada", foreignKeys = {@ForeignKey(entity = Bairro.class, parentColumns = "id", childColumns = "bairro"),
        @ForeignKey(entity = TipoParada.class, parentColumns = "id", childColumns = "tipo_parada")})
public class Parada extends EntidadeBase {

    @ColumnInfo(name = "nome")
    @NonNull
    private String nome;

    @ColumnInfo(name = "latitude")
    @NonNull
    private String latitude;

    @ColumnInfo(name = "longitude")
    @NonNull
    private String longitude;

    @ColumnInfo(name = "taxa_embarque")
    private String taxaEmbarque;

    @ColumnInfo(name = "slug")
    private String slug;

    @ColumnInfo(name = "imagem")
    private String imagem;

    @ColumnInfo(name = "observacao")
    private String observacao;

    @ColumnInfo(name = "tipo_parada")
    @NonNull
    private String tipoParada;

    @ColumnInfo(name = "bairro")
    @NonNull
    private String bairro;

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    @NonNull
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(@NonNull String latitude) {
        this.latitude = latitude;
    }

    @NonNull
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(@NonNull String longitude) {
        this.longitude = longitude;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @NonNull
    public String getBairro() {
        return bairro;
    }

    public void setBairro(@NonNull String bairro) {
        this.bairro = bairro;
    }

    public String getTaxaEmbarque() {
        return taxaEmbarque;
    }

    public void setTaxaEmbarque(String taxaEmbarque) {
        this.taxaEmbarque = taxaEmbarque;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @NonNull
    public String getTipoParada() {
        return tipoParada;
    }

    public void setTipoParada(@NonNull String tipoParada) {
        this.tipoParada = tipoParada;
    }
}
