package br.com.vostre.circular.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

/**
 * Created by Almir on 02/01/2018.
 */

@Entity(tableName = "historico_itinerario", foreignKeys = {@ForeignKey(entity = Empresa.class, parentColumns = "id", childColumns = "empresa"),
        @ForeignKey(entity = Itinerario.class, parentColumns = "id", childColumns = "itinerario")})
public class HistoricoItinerario extends EntidadeBase {

    @NonNull
    @ColumnInfo(name = "tarifa")
    private Double tarifa;

    @ColumnInfo(name = "empresa")
    @NonNull
    private String empresa;

    @ColumnInfo(name = "itinerario")
    @NonNull
    private String itinerario;

    @NonNull
    public Double getTarifa() {
        return tarifa;
    }

    public void setTarifa(@NonNull Double tarifa) {
        this.tarifa = tarifa;
    }

    @NonNull
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(@NonNull String empresa) {
        this.empresa = empresa;
    }

    @NonNull
    public String getItinerario() {
        return itinerario;
    }

    public void setItinerario(@NonNull String itinerario) {
        this.itinerario = itinerario;
    }
}
