package devandroid.darjh.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import devandroid.darjh.applistacurso.R;
import devandroid.darjh.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    Pessoa outraPessoa;
    String dadosPessoa;
    String dadosOutraPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        //Atribuir conteúdo, dados, valores para o objeto
        //conforme o seu Modelo, template.
        pessoa.setPriNome("Marco");
        pessoa.setSobreNome("Maddo");
        pessoa.setCursoDesejado("Android");
        pessoa.setTelContato("41-99836-9387");

        outraPessoa = new Pessoa();
        outraPessoa.setPriNome("Darjh");
        outraPessoa.setSobreNome("Zhora");
        outraPessoa.setCursoDesejado("Java");
        outraPessoa.setTelContato("41-99836-9387");

        dadosPessoa = "Primeiro nome: ";
        dadosPessoa += pessoa.getPriNome();
        dadosPessoa += " Sobrenome: ";
        dadosPessoa += pessoa.getSobreNome();
        dadosPessoa += " Curso desejado: ";
        dadosPessoa += pessoa.getCursoDesejado();
        dadosPessoa += " Telefone de contato: ";
        dadosPessoa += pessoa.getTelContato();


        dadosOutraPessoa = "Primeiro nome: ";
        dadosOutraPessoa += outraPessoa.getPriNome();
        dadosOutraPessoa += " Sobrenome: ";
        dadosOutraPessoa += outraPessoa.getSobreNome();
        dadosOutraPessoa += " Curso desejado: ";
        dadosOutraPessoa += outraPessoa.getCursoDesejado();
        dadosOutraPessoa += " Telefone de contato: ";
        dadosOutraPessoa += outraPessoa.getTelContato();
    }
}