package br.com.vostre.circular;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import br.com.vostre.circular.model.Cidade;
import br.com.vostre.circular.model.Estado;
import br.com.vostre.circular.model.Pais;
import br.com.vostre.circular.model.dao.AppDatabase;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Almir on 02/01/2018.
 */

public class AppDatabaseTest {

    AppDatabase db;

    @Before
    public void initDb() throws Exception {
        db = Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getContext(),
                AppDatabase.class)
                .build();
    }

    @After
    public void closeDb() throws Exception {
        db.close();
    }

    @Test
    public void insertAndGetPais() {
        // When inserting a new user in the data source

        Pais pais = new Pais();

        pais.setId(UUID.randomUUID().toString());
        pais.setNome("Brasil");
        pais.setIso3("BRA");
        pais.setStatus(0);
        pais.setDataCadastro(Calendar.getInstance());
        pais.setUltimaAlteracao(Calendar.getInstance());
        pais.setDataLiberacao(Calendar.getInstance());

        db.paisDAO().insertPais(pais);

        List<Pais> paises = db.paisDAO().getAll();
        assertThat(paises.size(), is(1));
        Pais dbPais = paises.get(0);
        assertEquals(dbPais.getId(), pais.getId());
        assertEquals(dbPais.getNome(), pais.getNome());

    }

    @Test
    public void insertAndGetEstado() {
        // When inserting a new user in the data source

        Pais pais = new Pais();

        pais.setId(UUID.randomUUID().toString());
        pais.setNome("Brasil");
        pais.setIso3("BRA");
        pais.setStatus(0);
        pais.setDataCadastro(Calendar.getInstance());
        pais.setUltimaAlteracao(Calendar.getInstance());
        pais.setDataLiberacao(Calendar.getInstance());

        db.paisDAO().insertPais(pais);

        Estado estado = new Estado();

        estado.setId(UUID.randomUUID().toString());
        estado.setNome("Rio de Janeiro");
        estado.setSigla("RJ");
        estado.setStatus(0);
        estado.setDataCadastro(Calendar.getInstance());
        estado.setUltimaAlteracao(Calendar.getInstance());
        estado.setDataLiberacao(Calendar.getInstance());
        estado.setPais(pais.getId());

        db.estadoDAO().insertEstado(estado);

        List<Estado> estados = db.estadoDAO().getAll();
        assertThat(estados.size(), is(1));
        Estado dbEstado = estados.get(0);
        assertEquals(dbEstado.getId(), estado.getId());
        assertEquals(dbEstado.getNome(), estado.getNome());
        assertEquals(dbEstado.getPais(), pais.getId());

    }

    @Test
    public void insertAndGetCidade() {
        // When inserting a new user in the data source

        Pais pais = new Pais();

        pais.setId(UUID.randomUUID().toString());
        pais.setNome("Brasil");
        pais.setIso3("BRA");
        pais.setStatus(0);
        pais.setDataCadastro(Calendar.getInstance());
        pais.setUltimaAlteracao(Calendar.getInstance());
        pais.setDataLiberacao(Calendar.getInstance());

        db.paisDAO().insertPais(pais);

        Estado estado = new Estado();

        estado.setId(UUID.randomUUID().toString());
        estado.setNome("Rio de Janeiro");
        estado.setSigla("RJ");
        estado.setStatus(0);
        estado.setDataCadastro(Calendar.getInstance());
        estado.setUltimaAlteracao(Calendar.getInstance());
        estado.setDataLiberacao(Calendar.getInstance());
        estado.setPais(pais.getId());

        db.estadoDAO().insertEstado(estado);

        Cidade cidade = new Cidade();

        cidade.setId(UUID.randomUUID().toString());
        cidade.setNome("Barra do Piraí");
        cidade.setStatus(0);
        cidade.setDataCadastro(Calendar.getInstance());
        cidade.setUltimaAlteracao(Calendar.getInstance());
        cidade.setDataLiberacao(Calendar.getInstance());
        cidade.setEstado(estado.getId());

        db.cidadeDAO().insertCidade(cidade);

        List<Cidade> cidades = db.cidadeDAO().getAll();
        assertThat(cidades.size(), is(1));
        Cidade dbCidade = cidades.get(0);
        assertEquals(dbCidade.getId(), cidade.getId());
        assertEquals(dbCidade.getNome(), cidade.getNome());
        assertEquals(dbCidade.getEstado(), estado.getId());

    }

}
