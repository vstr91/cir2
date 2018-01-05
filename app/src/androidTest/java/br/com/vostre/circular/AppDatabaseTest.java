package br.com.vostre.circular;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.UUID;

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
    public void insertAndGetParametro() {
        // When inserting a new user in the data source

        Parametro parametro = new Parametro();

        parametro.setId(UUID.randomUUID().toString());
        parametro.setNome("url");
        parametro.setValor("localhost");
        parametro.setStatus(0);
        parametro.setDataCadastro(Calendar.getInstance());
        parametro.setUltimaAlteracao(Calendar.getInstance());
        parametro.setDataLiberacao(Calendar.getInstance());

        db.parametroDAO().insertParametro(parametro);

        List<Parametro> parametros = db.parametroDAO().getAll();
        assertThat(parametros.size(), is(1));
        Parametro dbParametro = parametros.get(0);
        assertEquals(dbParametro.getId(), parametro.getId());
        assertEquals(dbParametro.getNome(), parametro.getNome());

    }

    @Test
    public void insertAndGetMensagem() {
        // When inserting a new user in the data source

        Mensagem mensagem = new Mensagem();

        mensagem.setId(UUID.randomUUID().toString());
        mensagem.setTitulo("Título");
        mensagem.setDescricao("Descrição");
        mensagem.setStatus(0);
        mensagem.setDataCadastro(Calendar.getInstance());
        mensagem.setUltimaAlteracao(Calendar.getInstance());
        mensagem.setDataLiberacao(Calendar.getInstance());

        db.mensagemDAO().insertMensagem(mensagem);

        List<Mensagem> mensagens = db.mensagemDAO().getAll();
        assertThat(mensagens.size(), is(1));
        Mensagem dbMensagem = mensagens.get(0);
        assertEquals(dbMensagem.getId(), mensagem.getId());
        assertEquals(dbMensagem.getTitulo(), mensagem.getTitulo());

    }

    @Test
    public void insertAndGetTipoContato() {
        // When inserting a new user in the data source

        TipoContato tipoContato = new TipoContato();

        tipoContato.setId(UUID.randomUUID().toString());
        tipoContato.setNome("Sugestão");
        tipoContato.setStatus(0);
        tipoContato.setDataCadastro(Calendar.getInstance());
        tipoContato.setUltimaAlteracao(Calendar.getInstance());
        tipoContato.setDataLiberacao(Calendar.getInstance());

        db.tipoContatoDAO().insertTipoContato(tipoContato);

        List<TipoContato> tiposContato = db.tipoContatoDAO().getAll();
        assertThat(tiposContato.size(), is(1));
        TipoContato dbTipoContato = tiposContato.get(0);
        assertEquals(dbTipoContato.getId(), tipoContato.getId());
        assertEquals(dbTipoContato.getNome(), tipoContato.getNome());

    }

    @Test
    public void insertAndGetSubTipoContato() {
        // When inserting a new user in the data source

        TipoContato tipoContato = new TipoContato();

        tipoContato.setId(UUID.randomUUID().toString());
        tipoContato.setNome("Sugestão");
        tipoContato.setStatus(0);
        tipoContato.setDataCadastro(Calendar.getInstance());
        tipoContato.setUltimaAlteracao(Calendar.getInstance());
        tipoContato.setDataLiberacao(Calendar.getInstance());

        db.tipoContatoDAO().insertTipoContato(tipoContato);

        SubTipoContato subTipoContato = new SubTipoContato();

        subTipoContato.setId(UUID.randomUUID().toString());
        subTipoContato.setNome("Melhoria");
        subTipoContato.setStatus(0);
        subTipoContato.setTipoContato(tipoContato.getId());
        subTipoContato.setDataCadastro(Calendar.getInstance());
        subTipoContato.setUltimaAlteracao(Calendar.getInstance());
        subTipoContato.setDataLiberacao(Calendar.getInstance());

        db.subTipoContatoDAO().insertSubTipoContato(subTipoContato);

        List<SubTipoContato> subTiposContato = db.subTipoContatoDAO().getAll();
        assertThat(subTiposContato.size(), is(1));
        SubTipoContato dbSubTipoContato = subTiposContato.get(0);
        assertEquals(dbSubTipoContato.getId(), subTipoContato.getId());
        assertEquals(dbSubTipoContato.getNome(), subTipoContato.getNome());

    }

    @Test
    public void insertAndGetContato() {
        // When inserting a new user in the data source

        TipoContato tipoContato = new TipoContato();

        tipoContato.setId(UUID.randomUUID().toString());
        tipoContato.setNome("Sugestão");
        tipoContato.setStatus(0);
        tipoContato.setDataCadastro(Calendar.getInstance());
        tipoContato.setUltimaAlteracao(Calendar.getInstance());
        tipoContato.setDataLiberacao(Calendar.getInstance());

        db.tipoContatoDAO().insertTipoContato(tipoContato);

        SubTipoContato subTipoContato = new SubTipoContato();

        subTipoContato.setId(UUID.randomUUID().toString());
        subTipoContato.setNome("Melhoria");
        subTipoContato.setStatus(0);
        subTipoContato.setTipoContato(tipoContato.getId());
        subTipoContato.setDataCadastro(Calendar.getInstance());
        subTipoContato.setUltimaAlteracao(Calendar.getInstance());
        subTipoContato.setDataLiberacao(Calendar.getInstance());

        db.subTipoContatoDAO().insertSubTipoContato(subTipoContato);

        Contato contato = new Contato();

        contato.setId(UUID.randomUUID().toString());
        contato.setTitulo("Nova Funcionalidade");
        contato.setDescricao("Adicionar funcionalidade X");
        contato.setStatus(0);
        contato.setSubTipoContato(subTipoContato.getId());
        contato.setDataCadastro(Calendar.getInstance());
        contato.setUltimaAlteracao(Calendar.getInstance());
        contato.setDataLiberacao(Calendar.getInstance());

        db.contatoDAO().insertContato(contato);

        List<Contato> contatos = db.contatoDAO().getAll();
        assertThat(contatos.size(), is(1));
        Contato dbContato = contatos.get(0);
        assertEquals(dbContato.getId(), contato.getId());
        assertEquals(dbContato.getTitulo(), contato.getTitulo());

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

    @Test
    public void insertAndGetBairro() {
        // When inserting a new user in the data source

        Bairro bairro = criarBairro();

        List<Bairro> bairros = db.bairroDAO().getAll();
        assertThat(bairros.size(), is(1));
        Bairro dbBairro = bairros.get(0);
        assertEquals(dbBairro.getId(), bairro.getId());
        assertEquals(dbBairro.getNome(), bairro.getNome());

    }

    @Test
    public void insertAndGetHorario() {

        Horario horario = criarHorario();

        List<Horario> horarios = db.horarioDAO().getAll();
        assertThat(horarios.size(), is(1));
        Horario dbHorario = horarios.get(0);
        assertEquals(dbHorario.getId(), horario.getId());
        assertEquals(dbHorario.getNome(), horario.getNome());

    }

    @Test
    public void insertAndGetEmpresa() {

        Empresa empresa = criarEmpresa();

        List<Empresa> empresas = db.empresaDAO().getAll();
        assertThat(empresas.size(), is(1));
        Empresa dbEmpresa = empresas.get(0);
        assertEquals(dbEmpresa.getId(), empresa.getId());
        assertEquals(dbEmpresa.getNome(), empresa.getNome());

    }

    @Test
    public void insertAndGetTipoParada() {

        TipoParada tipoParada = new TipoParada();

        tipoParada.setId(UUID.randomUUID().toString());
        tipoParada.setNome("Rodoviária");
        tipoParada.setStatus(0);
        tipoParada.setDataCadastro(Calendar.getInstance());
        tipoParada.setUltimaAlteracao(Calendar.getInstance());
        tipoParada.setDataLiberacao(Calendar.getInstance());

        db.tipoParadaDAO().insertTipoParada(tipoParada);

        List<TipoParada> tiposParada = db.tipoParadaDAO().getAll();
        assertThat(tiposParada.size(), is(1));
        TipoParada dbTipoParada = tiposParada.get(0);
        assertEquals(dbTipoParada.getId(), tipoParada.getId());
        assertEquals(dbTipoParada.getNome(), tipoParada.getNome());

    }

    @Test
    public void insertAndGetPontoInteresse() {

        PontoInteresse pontoInteresse = criarPontoInteresse();

        List<PontoInteresse> pontosInteresse = db.pontoInteresseDAO().getAll();
        assertThat(pontosInteresse.size(), is(1));
        PontoInteresse dbPontoInteresse = pontosInteresse.get(0);
        assertEquals(dbPontoInteresse.getId(), pontoInteresse.getId());
        assertEquals(dbPontoInteresse.getNome(), pontoInteresse.getNome());

    }

    @Test
    public void insertAndGetParada() {

        Parada parada = criarParada();

        List<Parada> paradas = db.paradaDAO().getAll();
        assertThat(paradas.size(), is(1));
        Parada dbParada = paradas.get(0);
        assertEquals(dbParada.getId(), parada.getId());
        assertEquals(dbParada.getNome(), parada.getNome());

    }

    @Test
    public void insertAndGetPontoInteresseParada() {

        PontoInteresse pontoInteresse = criarPontoInteresse();
        Parada parada = criarParada();

        PontoInteresseParada pontoInteresseParada = new PontoInteresseParada();
        pontoInteresseParada.setId(UUID.randomUUID().toString());
        pontoInteresseParada.setPontoInteresse(pontoInteresse.getId());
        pontoInteresseParada.setParada(parada.getId());
        pontoInteresseParada.setStatus(0);
        pontoInteresseParada.setDataCadastro(Calendar.getInstance());
        pontoInteresseParada.setDataLiberacao(Calendar.getInstance());
        pontoInteresseParada.setUltimaAlteracao(Calendar.getInstance());

        db.pontoInteresseParadaDAO().insertPontoInteresseParada(pontoInteresseParada);

        List<PontoInteresseParada> pontosInteresseParada = db.pontoInteresseParadaDAO().getAll();
        assertThat(pontosInteresseParada.size(), is(1));
        PontoInteresseParada dbPontoInteresseParada = pontosInteresseParada.get(0);
        assertEquals(dbPontoInteresseParada.getId(), pontoInteresseParada.getId());
        assertEquals(dbPontoInteresseParada.getParada(), parada.getId());
        assertEquals(dbPontoInteresseParada.getPontoInteresse(), pontoInteresse.getId());

    }

    @Test
    public void insertAndGetTipoAcessibilidade() {

        TipoAcessibilidade tipoAcessibilidade = new TipoAcessibilidade();

        tipoAcessibilidade.setId(UUID.randomUUID().toString());
        tipoAcessibilidade.setNome("Sempre");
        tipoAcessibilidade.setCodigo(0);
        tipoAcessibilidade.setStatus(0);
        tipoAcessibilidade.setDataCadastro(Calendar.getInstance());
        tipoAcessibilidade.setUltimaAlteracao(Calendar.getInstance());
        tipoAcessibilidade.setDataLiberacao(Calendar.getInstance());

        db.tipoAcessibilidadeDAO().insertTipoAcessibilidade(tipoAcessibilidade);

        List<TipoAcessibilidade> tiposAcessibilidade = db.tipoAcessibilidadeDAO().getAll();
        assertThat(tiposAcessibilidade.size(), is(1));
        TipoAcessibilidade dbTipoAcessibilidade = tiposAcessibilidade.get(0);
        assertEquals(dbTipoAcessibilidade.getId(), tipoAcessibilidade.getId());
        assertEquals(dbTipoAcessibilidade.getNome(), tipoAcessibilidade.getNome());

    }

    @Test
    public void insertAndGetItinerario() {

        Itinerario itinerario = criarItinerario();

        List<Itinerario> itinerarios = db.itinerarioDAO().getAll();
        assertThat(itinerarios.size(), is(1));
        Itinerario dbItinerario = itinerarios.get(0);
        assertEquals(dbItinerario.getId(), itinerario.getId());

    }

    @Test
    public void insertAndGetParadaItinerario() {

        Itinerario itinerario = criarItinerario();
        Parada parada = criarParada();

        ParadaItinerario paradaItinerario = new ParadaItinerario();

        paradaItinerario.setId(UUID.randomUUID().toString());
        paradaItinerario.setParada(parada.getId());
        paradaItinerario.setItinerario(itinerario.getId());
        paradaItinerario.setDestaque(false);
        paradaItinerario.setOrdem(1);
        paradaItinerario.setStatus(0);
        paradaItinerario.setDataCadastro(Calendar.getInstance());
        paradaItinerario.setUltimaAlteracao(Calendar.getInstance());
        paradaItinerario.setDataLiberacao(Calendar.getInstance());

        db.paradaItinerarioDAO().insertParadaItinerario(paradaItinerario);

        List<ParadaItinerario> paradasItinerarios = db.paradaItinerarioDAO().getAll();
        assertThat(paradasItinerarios.size(), is(1));
        ParadaItinerario dbParadaItinerario = paradasItinerarios.get(0);
        assertEquals(dbParadaItinerario.getId(), paradaItinerario.getId());

    }

    @Test
    public void insertAndGetHistoricoItinerario() {

        Itinerario itinerario = criarItinerario();
        Empresa empresa = criarEmpresa();

        HistoricoItinerario historicoItinerario = new HistoricoItinerario();

        historicoItinerario.setId(UUID.randomUUID().toString());
        historicoItinerario.setTarifa(23.70);
        historicoItinerario.setEmpresa(empresa.getId());
        historicoItinerario.setItinerario(itinerario.getId());
        historicoItinerario.setStatus(0);
        historicoItinerario.setDataCadastro(Calendar.getInstance());
        historicoItinerario.setUltimaAlteracao(Calendar.getInstance());
        historicoItinerario.setDataLiberacao(Calendar.getInstance());

        db.historicoItinerarioDAO().insertHistoricoItinerario(historicoItinerario);

        List<HistoricoItinerario> historicosItinerarios = db.historicoItinerarioDAO().getAll();
        assertThat(historicosItinerarios.size(), is(1));
        HistoricoItinerario dbHistoricoItinerario = historicosItinerarios.get(0);
        assertEquals(dbHistoricoItinerario.getId(), historicoItinerario.getId());

    }

    @Test
    public void insertAndGetSecaoItinerario() {

        Itinerario itinerario = criarItinerario();
        Parada paradaInicial = criarParada();
        Parada paradaFinal = criarParada();

        SecaoItinerario secaoItinerario = new SecaoItinerario();

        secaoItinerario.setId(UUID.randomUUID().toString());
        secaoItinerario.setNome("Barra do Piraí x Santa Catarina");
        secaoItinerario.setTarifa(5.90);
        secaoItinerario.setParadaInicial(paradaInicial.getId());
        secaoItinerario.setParadaFinal(paradaFinal.getId());
        secaoItinerario.setOrdem(0);
        secaoItinerario.setItinerario(itinerario.getId());
        secaoItinerario.setStatus(0);
        secaoItinerario.setDataCadastro(Calendar.getInstance());
        secaoItinerario.setUltimaAlteracao(Calendar.getInstance());
        secaoItinerario.setDataLiberacao(Calendar.getInstance());

        db.secaoItinerarioDAO().insertSecaoItinerario(secaoItinerario);

        List<SecaoItinerario> secoesItinerarios = db.secaoItinerarioDAO().getAll();
        assertThat(secoesItinerarios.size(), is(1));
        SecaoItinerario dbSecaoItinerario = secoesItinerarios.get(0);
        assertEquals(dbSecaoItinerario.getId(), secaoItinerario.getId());

    }

    @Test
    public void insertAndGetHorarioItinerario() {

        Itinerario itinerario = criarItinerario();
        Horario horario = criarHorario();

        HorarioItinerario horarioItinerario = new HorarioItinerario();

        horarioItinerario.setId(UUID.randomUUID().toString());
        horarioItinerario.setHorario(horario.getId());
        horarioItinerario.setItinerario(itinerario.getId());
        horarioItinerario.setDomingo(false);
        horarioItinerario.setSegunda(true);
        horarioItinerario.setTerca(true);
        horarioItinerario.setQuarta(true);
        horarioItinerario.setQuinta(true);
        horarioItinerario.setSexta(true);
        horarioItinerario.setSabado(false);
        horarioItinerario.setStatus(0);
        horarioItinerario.setDataCadastro(Calendar.getInstance());
        horarioItinerario.setUltimaAlteracao(Calendar.getInstance());
        horarioItinerario.setDataLiberacao(Calendar.getInstance());

        db.horarioItinerarioDAO().insertHorarioItinerario(horarioItinerario);

        List<HorarioItinerario> horariosItinerarios = db.horarioItinerarioDAO().getAll();
        assertThat(horariosItinerarios.size(), is(1));
        HorarioItinerario dbHorarioItinerario = horariosItinerarios.get(0);
        assertEquals(dbHorarioItinerario.getId(), horarioItinerario.getId());

    }

    //##################### HELPERS ##########################

    private Bairro criarBairro(){
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

        Bairro bairro = new Bairro();

        bairro.setId(UUID.randomUUID().toString());
        bairro.setNome("Centro");
        bairro.setStatus(0);
        bairro.setDataCadastro(Calendar.getInstance());
        bairro.setUltimaAlteracao(Calendar.getInstance());
        bairro.setDataLiberacao(Calendar.getInstance());
        bairro.setCidade(cidade.getId());

        db.bairroDAO().insertBairro(bairro);

        return bairro;
    }

    private PontoInteresse criarPontoInteresse(){
        Bairro bairro = criarBairro();

        PontoInteresse pontoInteresse = new PontoInteresse();

        pontoInteresse.setId(UUID.randomUUID().toString());
        pontoInteresse.setNome("Lanchonete");
        pontoInteresse.setLatitude("-22.33545");
        pontoInteresse.setLongitude("-46.36495");
        pontoInteresse.setBairro(bairro.getId());
        pontoInteresse.setStatus(0);
        pontoInteresse.setDataCadastro(Calendar.getInstance());
        pontoInteresse.setUltimaAlteracao(Calendar.getInstance());
        pontoInteresse.setDataLiberacao(Calendar.getInstance());

        db.pontoInteresseDAO().insertPontoInteresse(pontoInteresse);

        return pontoInteresse;
    }

    private Parada criarParada(){
        Bairro bairro = criarBairro();

        TipoParada tipoParada = new TipoParada();

        tipoParada.setId(UUID.randomUUID().toString());
        tipoParada.setNome("Rodoviária");
        tipoParada.setStatus(0);
        tipoParada.setDataCadastro(Calendar.getInstance());
        tipoParada.setUltimaAlteracao(Calendar.getInstance());
        tipoParada.setDataLiberacao(Calendar.getInstance());

        db.tipoParadaDAO().insertTipoParada(tipoParada);

        Parada parada = new Parada();

        parada.setId(UUID.randomUUID().toString());
        parada.setNome("Praça");
        parada.setLatitude("-22.33545");
        parada.setLongitude("-46.36495");
        parada.setBairro(bairro.getId());
        parada.setTipoParada(tipoParada.getId());
        parada.setStatus(0);
        parada.setDataCadastro(Calendar.getInstance());
        parada.setUltimaAlteracao(Calendar.getInstance());
        parada.setDataLiberacao(Calendar.getInstance());

        db.paradaDAO().insertParada(parada);

        return parada;
    }

    private Empresa criarEmpresa(){
        Empresa empresa = new Empresa();

        empresa.setId(UUID.randomUUID().toString());
        empresa.setNome("Teste");
        empresa.setStatus(0);
        empresa.setDataCadastro(Calendar.getInstance());
        empresa.setUltimaAlteracao(Calendar.getInstance());
        empresa.setDataLiberacao(Calendar.getInstance());

        db.empresaDAO().insertEmpresa(empresa);

        return empresa;
    }

    private Itinerario criarItinerario(){
        TipoAcessibilidade tipoAcessibilidade = new TipoAcessibilidade();

        tipoAcessibilidade.setId(UUID.randomUUID().toString());
        tipoAcessibilidade.setNome("Sempre");
        tipoAcessibilidade.setCodigo(0);
        tipoAcessibilidade.setStatus(0);
        tipoAcessibilidade.setDataCadastro(Calendar.getInstance());
        tipoAcessibilidade.setUltimaAlteracao(Calendar.getInstance());
        tipoAcessibilidade.setDataLiberacao(Calendar.getInstance());

        db.tipoAcessibilidadeDAO().insertTipoAcessibilidade(tipoAcessibilidade);

        Calendar duracao = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        try {
            duracao.setTime(dateFormat.parse("00:45"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Empresa empresa = criarEmpresa();

        Itinerario itinerario = new Itinerario();

        itinerario.setId(UUID.randomUUID().toString());
        itinerario.setDistancia(35.0);
        itinerario.setTarifa(12.95);
        itinerario.setLinha("A274");
        itinerario.setEmpresa(empresa.getId());
        itinerario.setTipoAcessibilidade(tipoAcessibilidade.getId());
        itinerario.setDuracao(duracao);
        itinerario.setStatus(0);
        itinerario.setDataCadastro(Calendar.getInstance());
        itinerario.setUltimaAlteracao(Calendar.getInstance());
        itinerario.setDataLiberacao(Calendar.getInstance());

        db.itinerarioDAO().insertItinerario(itinerario);

        return itinerario;
    }

    private Horario criarHorario(){

        Calendar hora = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        try {
            hora.setTime(dateFormat.parse("23:37"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Horario horario = new Horario();

        horario.setId(UUID.randomUUID().toString());
        horario.setNome(hora);
        horario.setStatus(0);
        horario.setDataCadastro(Calendar.getInstance());
        horario.setUltimaAlteracao(Calendar.getInstance());
        horario.setDataLiberacao(Calendar.getInstance());

        db.horarioDAO().insertHorario(horario);

        return horario;

    }

}
