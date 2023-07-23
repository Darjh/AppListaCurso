package devandroid.darjh.applistacurso.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import devandroid.darjh.applistacurso.R;
import devandroid.darjh.applistacurso.controller.CursoController;
import devandroid.darjh.applistacurso.controller.PessoaController;
import devandroid.darjh.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    PessoaController controller;
    CursoController cursoController;

    Pessoa pessoa;
    List<String> nomesDosCursos;

    EditText editNome;
    EditText editSobreNome;
    EditText editNomeCurso;
    EditText editTelefone;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new PessoaController(MainActivity.this);
        controller.toString();

        cursoController = new CursoController();
        nomesDosCursos = cursoController.dadosDoCurso();


        pessoa = new Pessoa();
        controller.buscar(pessoa);

        editNome = findViewById(R.id.editNome);
        editSobreNome = findViewById(R.id.editSobreNome);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefone = findViewById(R.id.editTelefone);
        spinner = findViewById(R.id.spinner);

        editNome.setText(pessoa.getPriNome());
        editSobreNome.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefone.setText(pessoa.getTelContato());

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        //Adapter
        //Layout
        //Injetar o adapter ao Spinner - A lista será gerada

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                cursoController.dadosDoCurso());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);

        btnLimpar.setOnClickListener(view -> {
            editNome.setText("");
            editSobreNome.setText("");
            editNomeCurso.setText("");
            editTelefone.setText("");

            controller.limpar();
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

            controller.salvar(pessoa);

        });

        Log.i(
                "POOAndroid", "Objeto pessoa: " + pessoa.toString()
        );

    }
}