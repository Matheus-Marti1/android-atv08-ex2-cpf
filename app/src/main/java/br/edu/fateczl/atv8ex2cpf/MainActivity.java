/*
@author:<Matheus Augusto Marti>
 */

package br.edu.fateczl.atv8ex2cpf;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etCpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNome = findViewById(R.id.etNome);
        etCpf = findViewById(R.id.etCpf);
        Button btnLocal = findViewById(R.id.btnLocal);
        btnLocal.setOnClickListener(op -> encontrarLocal());
    }

    private void encontrarLocal() {
        String nome = etNome.getText().toString();
        String cpf = etCpf.getText().toString();
        String[] digitoSplit = cpf.split("");
        String digito = digitoSplit[8];
        String[] estados = new String[]{"Rio Grande do Sul", "Distrito Federal, Goiás, Mato Grosso, Mato Grosso do Sul e Tocantins", "Pará, Amazonas, Acre, Amapá, Rondônia e Roraima", "Ceará, Maranhão e Piauí", "Pernambuco, Rio Grande do Norte, Paraíba e Alagoas", "Bahia e Sergipe", "Minas Gerais", "Rio de Janeiro e Espírito Santo", "São Paulo", "Paraná e Santa Catarina"};
        String local = estados[Integer.parseInt(digito)];

        Bundle bundle = new Bundle();
        bundle.putString("nome", nome);
        bundle.putString("cpf", cpf);
        bundle.putString("local", local);

        troca(bundle);
    }

    private void troca(Bundle bundle) {
        Intent i = new Intent(this, LocalActivity.class);
        i.putExtras(bundle);
        this.startActivity(i);
        this.finish();
    }
}