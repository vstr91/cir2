package br.com.vostre.circular.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

import java.util.Calendar;

/**
 * Created by Almir on 02/01/2018.
 */

@Entity(tableName = "itinerario", foreignKeys = {@ForeignKey(entity = Empresa.class, parentColumns = "id", childColumns = "empresa"),
        @ForeignKey(entity = TipoAcessibilidade.class, parentColumns = "id", childColumns = "tipo_acessibilidade")})
public class Itinerario extends EntidadeBase {

    @ColumnInfo(name = "tarifa")
    @NonNull
    private Double tarifa;

    @ColumnInfo(name = "distancia")
    @NonNull
    private Double distancia;

    @ColumnInfo(name = "duracao")
    @NonNull
    private Calendar duracao;

    @ColumnInfo(name = "observacao")
    private String observacao;

    @ColumnInfo(name = "linha")
    private String linha;

    @ColumnInfo(name = "empresa")
    @NonNull
    private String empresa;

    @ColumnInfo(name = "tipo_acessibilidade")
    @NonNull
    private String tipoAcessibilidade;

    @NonNull
    public Double getTarifa() {
        return tarifa;
    }

    public void setTarifa(@NonNull Double tarifa) {
        this.tarifa = tarifa;
    }

    @NonNull
    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(@NonNull Double distancia) {
        this.distancia = distancia;
    }

    @NonNull
    public Calendar getDuracao() {
        return duracao;
    }

    public void setDuracao(@NonNull Calendar duracao) {
        this.duracao = duracao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    @NonNull
    public String getTipoAcessibilidade() {
        return tipoAcessibilidade;
    }

    public void setTipoAcessibilidade(@NonNull String tipoAcessibilidade) {
        this.tipoAcessibilidade = tipoAcessibilidade;
    }

    @NonNull
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(@NonNull String empresa) {
        this.empresa = empresa;
    }
}
