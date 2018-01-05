package br.com.vostre.circular.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

/**
 * Created by Almir on 02/01/2018.
 */

@Entity(tableName = "horario_itinerario", foreignKeys = {@ForeignKey(entity = Horario.class, parentColumns = "id", childColumns = "horario"),
        @ForeignKey(entity = Itinerario.class, parentColumns = "id", childColumns = "itinerario")})
public class HorarioItinerario extends EntidadeBase {

    @ColumnInfo(name = "domingo")
    @NonNull
    private Boolean domingo;

    @ColumnInfo(name = "segunda")
    @NonNull
    private Boolean segunda;

    @ColumnInfo(name = "terca")
    @NonNull
    private Boolean terca;

    @ColumnInfo(name = "quarta")
    @NonNull
    private Boolean quarta;

    @ColumnInfo(name = "quinta")
    @NonNull
    private Boolean quinta;

    @ColumnInfo(name = "sexta")
    @NonNull
    private Boolean sexta;

    @ColumnInfo(name = "sabado")
    @NonNull
    private Boolean sabado;

    @ColumnInfo(name = "horario")
    @NonNull
    private String horario;

    @ColumnInfo(name = "itinerario")
    @NonNull
    private String itinerario;

    @ColumnInfo(name = "observacao")
    private String observacao;

    @NonNull
    public Boolean getDomingo() {
        return domingo;
    }

    public void setDomingo(@NonNull Boolean domingo) {
        this.domingo = domingo;
    }

    @NonNull
    public Boolean getSegunda() {
        return segunda;
    }

    public void setSegunda(@NonNull Boolean segunda) {
        this.segunda = segunda;
    }

    @NonNull
    public Boolean getTerca() {
        return terca;
    }

    public void setTerca(@NonNull Boolean terca) {
        this.terca = terca;
    }

    @NonNull
    public Boolean getQuarta() {
        return quarta;
    }

    public void setQuarta(@NonNull Boolean quarta) {
        this.quarta = quarta;
    }

    @NonNull
    public Boolean getQuinta() {
        return quinta;
    }

    public void setQuinta(@NonNull Boolean quinta) {
        this.quinta = quinta;
    }

    @NonNull
    public Boolean getSexta() {
        return sexta;
    }

    public void setSexta(@NonNull Boolean sexta) {
        this.sexta = sexta;
    }

    @NonNull
    public Boolean getSabado() {
        return sabado;
    }

    public void setSabado(@NonNull Boolean sabado) {
        this.sabado = sabado;
    }

    @NonNull
    public String getHorario() {
        return horario;
    }

    public void setHorario(@NonNull String horario) {
        this.horario = horario;
    }

    @NonNull
    public String getItinerario() {
        return itinerario;
    }

    public void setItinerario(@NonNull String itinerario) {
        this.itinerario = itinerario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
