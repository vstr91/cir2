package br.com.vostre.circular.model.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import br.com.vostre.circular.model.Bairro;
import br.com.vostre.circular.model.Cidade;
import br.com.vostre.circular.model.Contato;
import br.com.vostre.circular.model.Empresa;
import br.com.vostre.circular.model.Estado;
import br.com.vostre.circular.model.HistoricoItinerario;
import br.com.vostre.circular.model.Horario;
import br.com.vostre.circular.model.HorarioItinerario;
import br.com.vostre.circular.model.Itinerario;
import br.com.vostre.circular.model.Mensagem;
import br.com.vostre.circular.model.Pais;
import br.com.vostre.circular.model.Parada;
import br.com.vostre.circular.model.ParadaItinerario;
import br.com.vostre.circular.model.Parametro;
import br.com.vostre.circular.model.PontoInteresse;
import br.com.vostre.circular.model.PontoInteresseParada;
import br.com.vostre.circular.model.SecaoItinerario;
import br.com.vostre.circular.model.SubTipoContato;
import br.com.vostre.circular.model.TipoAcessibilidade;
import br.com.vostre.circular.model.TipoContato;
import br.com.vostre.circular.model.TipoParada;
import br.com.vostre.circular.utils.Converters;

/**
 * Created by Almir on 02/01/2018.
 */

@Database(entities = {Parametro.class, Mensagem.class, TipoContato.class, SubTipoContato.class, Contato.class, Pais.class, Estado.class, Cidade.class, Bairro.class,
        Horario.class, Empresa.class, TipoParada.class, PontoInteresse.class, Parada.class, PontoInteresseParada.class, TipoAcessibilidade.class, Itinerario.class,
        ParadaItinerario.class, HistoricoItinerario.class, SecaoItinerario.class, HorarioItinerario.class}, version = 4)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract PaisDAO paisDAO();
    public abstract EstadoDAO estadoDAO();
    public abstract CidadeDAO cidadeDAO();
    public abstract BairroDAO bairroDAO();
    public abstract ParametroDAO parametroDAO();
    public abstract MensagemDAO mensagemDAO();
    public abstract TipoContatoDAO tipoContatoDAO();
    public abstract SubTipoContatoDAO subTipoContatoDAO();
    public abstract ContatoDAO contatoDAO();
    public abstract HorarioDAO horarioDAO();
    public abstract EmpresaDAO empresaDAO();
    public abstract TipoParadaDAO tipoParadaDAO();
    public abstract PontoInteresseDAO pontoInteresseDAO();
    public abstract ParadaDAO paradaDAO();
    public abstract PontoInteresseParadaDAO pontoInteresseParadaDAO();
    public abstract TipoAcessibilidadeDAO tipoAcessibilidadeDAO();
    public abstract ItinerarioDAO itinerarioDAO();
    public abstract ParadaItinerarioDAO paradaItinerarioDAO();
    public abstract HistoricoItinerarioDAO historicoItinerarioDAO();
    public abstract SecaoItinerarioDAO secaoItinerarioDAO();
    public abstract HorarioItinerarioDAO horarioItinerarioDAO();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "circular")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

}
