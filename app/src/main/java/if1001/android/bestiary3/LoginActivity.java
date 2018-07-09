package if1001.android.bestiary3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void AbrirCadastroUsuario(View view){
        Intent intent = new Intent(getApplicationContext(),CadastroActivity.class);
        startActivity(intent);
    }

    public void AbrirTelaPrincipal(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
