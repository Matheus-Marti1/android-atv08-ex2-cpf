/*
@author:<Matheus Augusto Marti>
 */

package br.edu.fateczl.atv8ex2cpf;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.edu.fateczl.atv8ex2cpf.model.Pessoa;

public class LocalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_local);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvLocal = findViewById(R.id.tvLocal);
        tvLocal.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(bundle.getString("nome"));
        pessoa.setCpf(bundle.getString("cpf"));
        String local = bundle.getString("local");
        String res = pessoa.getNome() + "\n" + pessoa.getCpf() + "\nLocal: " + local;
        tvLocal.setText(res);
        btnVoltar.setOnClickListener(op -> voltar());
    }

    private void voltar() {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }
}