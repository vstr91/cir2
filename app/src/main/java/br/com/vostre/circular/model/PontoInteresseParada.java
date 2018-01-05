package br.com.vostre.circular.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

/**
 * Created by Almir on 02/01/2018.
 */

@Entity(tableName = "ponto_interesse_parada", foreignKeys = {@ForeignKey(entity = PontoInteresse.class, parentColumns = "id", childColumns = "ponto_interesse"),
        @ForeignKey(entity = Parada.class, parentColumns = "id", childColumns = "parada")})
public class PontoInteresseParada extends EntidadeBase {

    @ColumnInfo(name = "ponto_interesse")
    @NonNull
    private String pontoInteresse;

    @ColumnInfo(name = "parada")
    @NonNull
    private String parada;

    @NonNull
    public String getPontoInteresse() {
        return pontoInteresse;
    }

    public void setPontoInteresse(@NonNull String pontoInteresse) {
        this.pontoInteresse = pontoInteresse;
    }

    @NonNull
    public String getParada() {
        return parada;
    }

    public void setParada(@NonNull String parada) {
        this.parada = parada;
    }

}
