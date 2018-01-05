package br.com.vostre.circular.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

/**
 * Created by Almir on 02/01/2018.
 */

@Entity(tableName = "parada_itinerario", foreignKeys = {@ForeignKey(entity = Parada.class, parentColumns = "id", childColumns = "parada"),
        @ForeignKey(entity = Itinerario.class, parentColumns = "id", childColumns = "itinerario")})
public class ParadaItinerario extends EntidadeBase {

    @ColumnInfo(name = "ordem")
    @NonNull
    private Integer ordem;

    @ColumnInfo(name = "tarifa_setor_anterior")
    private Double tarifaSetorAnterior;

    @ColumnInfo(name = "tarifa_setor_seguinte")
    private Double tarifaSetorSeguinte;

    @NonNull
    @ColumnInfo(name = "destaque")
    private Boolean destaque;

    @ColumnInfo(name = "parada")
    @NonNull
    private String parada;

    @ColumnInfo(name = "itinerario")
    @NonNull
    private String itinerario;

    @NonNull
    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(@NonNull Integer ordem) {
        this.ordem = ordem;
    }

    public Double getTarifaSetorAnterior() {
        return tarifaSetorAnterior;
    }

    public void setTarifaSetorAnterior(Double tarifaSetorAnterior) {
        this.tarifaSetorAnterior = tarifaSetorAnterior;
    }

    public Double getTarifaSetorSeguinte() {
        return tarifaSetorSeguinte;
    }

    public void setTarifaSetorSeguinte(Double tarifaSetorSeguinte) {
        this.tarifaSetorSeguinte = tarifaSetorSeguinte;
    }

    @NonNull
    public Boolean getDestaque() {
        return destaque;
    }

    public void setDestaque(@NonNull Boolean destaque) {
        this.destaque = destaque;
    }

    @NonNull
    public String getParada() {
        return parada;
    }

    public void setParada(@NonNull String parada) {
        this.parada = parada;
    }

    @NonNull
    public String getItinerario() {
        return itinerario;
    }

    public void setItinerario(@NonNull String itinerario) {
        this.itinerario = itinerario;
    }

}
