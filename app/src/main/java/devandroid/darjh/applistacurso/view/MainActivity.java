package devandroid.darjh.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.darjh.applistacurso.R;
import devandroid.darjh.applistacurso.controller.PessoaController;
import devandroid.darjh.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listavip";
    PessoaController controller;

    Pessoa pessoa;

    EditText editNome;
    EditText editSobreNome;
    EditText editNomeCurso;
    EditText editTelefone;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        SharedPreferences.Editor listaVip = preferences.edit();

        controller = new PessoaController();
        controller.toString();

        pessoa = new Pessoa();
        pessoa.setPriNome(preferences.getString("primeiroNome", " "));
        pessoa.setSobreNome(preferences.getString("sobreNome", " "));
        pessoa.setCursoDesejado(preferences.getString("nomeCurso", " "));
        pessoa.setTelContato(preferences.getString("telefone", " "));

        editNome = findViewById(R.id.editNome);
        editSobreNome = findViewById(R.id.editSobreNome);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefone = findViewById(R.id.editTelefone);

        editNome.setText(pessoa.getPriNome());
        editSobreNome.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefone.setText(pessoa.getTelContato());

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnLimpar.setOnClickListener(view -> {
            editNome.setText(" ");
            editSobreNome.setText(" ");
            editNomeCurso.setText(" ");
            editTelefone.setText(" ");
        });

        btnFinalizar.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Volte sempre", Toast.LENGTH_LONG).show();
            finish();
        });

        btnSalvar.setOnClickListener(view -> {

            pessoa.setPriNome(editNome.getText().toString());
            pessoa.setSobreNome(editSobreNome.getText().toString());
            pessoa.setCursoDesejado(editNomeCurso.getText().toString());
            pessoa.setTelContato(editTelefone.getText().toString());

            Toast.makeText(MainActivity.this, "Salvo" + pessoa.toString(), Toast.LENGTH_LONG).show();

            listaVip.putString("primeiroNome", pessoa.getPriNome());
            listaVip.putString("sobreNome", pessoa.getSobreNome());
            listaVip.putString("nomeCurso", pessoa.getCursoDesejado());
            listaVip.putString("telefone", pessoa.getTelContato());

            listaVip.apply();

            controller.salvar(pessoa);

        });

        Log.i(
                "POOAndroid", "Objeto pessoa: " + pessoa.toString()
        );

    }
}