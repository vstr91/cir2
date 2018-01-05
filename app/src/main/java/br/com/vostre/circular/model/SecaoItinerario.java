package br.com.vostre.circular.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

/**
 * Created by Almir on 02/01/2018.
 */

@Entity(tableName = "secao_itinerario", foreignKeys = {@ForeignKey(entity = Parada.class, parentColumns = "id", childColumns = "parada_inicial"),
        @ForeignKey(entity = Parada.class, parentColumns = "id", childColumns = "parada_final"),
        @ForeignKey(entity = Itinerario.class, parentColumns = "id", childColumns = "itinerario")})
public class SecaoItinerario extends EntidadeBase {

    @ColumnInfo(name = "nome")
    @NonNull
    private String nome;

    @ColumnInfo(name = "ordem")
    @NonNull
    private Integer ordem;

    @ColumnInfo(name = "tarifa")
    private Double tarifa;

    @ColumnInfo(name = "parada_inicial")
    @NonNull
    private String paradaInicial;

    @ColumnInfo(name = "parada_final")
    @NonNull
    private String paradaFinal;

    @ColumnInfo(name = "itinerario")
    @NonNull
    private String itinerario;

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    @NonNull
    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(@NonNull Integer ordem) {
        this.ordem = ordem;
    }

    public Double getTarifa() {
        return tarifa;
    }

    public void setTarifa(Double tarifa) {
        this.tarifa = tarifa;
    }

    @NonNull
    public String getParadaInicial() {
        return paradaInicial;
    }

    public void setParadaInicial(@NonNull String paradaInicial) {
        this.paradaInicial = paradaInicial;
    }

    @NonNull
    public String getParadaFinal() {
        return paradaFinal;
    }

    public void setParadaFinal(@NonNull String paradaFinal) {
        this.paradaFinal = paradaFinal;
    }

    @NonNull
    public String getItinerario() {
        return itinerario;
    }

    public void setItinerario(@NonNull String itinerario) {
        this.itinerario = itinerario;
    }
}
