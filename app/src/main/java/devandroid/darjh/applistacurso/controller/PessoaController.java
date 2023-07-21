package devandroid.darjh.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.darjh.applistacurso.model.Pessoa;
import devandroid.darjh.applistacurso.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {

        Log.i("MVC_Controller", "Controller iniciada...");

        return super.toString();
    }

    public void salvar(Pessoa pessoa) {

        Log.i("MVC_Controller", "Salvo: " + pessoa.toString());

        listaVip.putString("primeiroNome", pessoa.getPriNome());
        listaVip.putString("sobreNome", pessoa.getSobreNome());
        listaVip.putString("nomeCurso", pessoa.getCursoDesejado());
        listaVip.putString("telefone", pessoa.getTelContato());

        listaVip.apply();
    }

    public Pessoa buscar(Pessoa pessoa) {
        pessoa.setPriNome(preferences.getString("primeiroNome", ""));
        pessoa.setSobreNome(preferences.getString("sobreNome", ""));
        pessoa.setCursoDesejado(preferences.getString("nomeCurso", ""));
        pessoa.setTelContato(preferences.getString("telefone", ""));

        return pessoa;
    }

    public void limpar() {

        listaVip.clear();
        listaVip.apply();
    }
}
