package if1001.android.bestiary3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ExibiMonstro extends AppCompatActivity {
    int posicaoM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibi_monstro);

        Intent it = getIntent();
        TextView err = (TextView) findViewById(R.id.name);
        err.setText("Name: "+it.getStringExtra("name"));
        err = (TextView) findViewById(R.id.size);
        err.setText("Size: "+it.getStringExtra("size"));
        err = (TextView) findViewById(R.id.type);
        err.setText("Type: "+it.getStringExtra("type"));
        err = (TextView) findViewById(R.id.alignment);
        err.setText("Alignment: "+it.getStringExtra("alignment"));
        err = (TextView) findViewById(R.id.armor_class);
        err.setText("Armor_class: "+it.getStringExtra("armor_class"));
        err = (TextView) findViewById(R.id.hit_points);
        err.setText("Hit_points: "+it.getStringExtra("hit_points"));
        err = (TextView) findViewById(R.id.hit_dice);
        err.setText("Hit_dice: "+it.getStringExtra("hit_dice"));
        err = (TextView) findViewById(R.id.speed);
        err.setText("Speed: "+it.getStringExtra("speed"));
        err = (TextView) findViewById(R.id.strength);
        err.setText("Strength: "+it.getStringExtra("strength"));
        err = (TextView) findViewById(R.id.dexterity);
        err.setText("Dexterity: "+it.getStringExtra("dexterity"));
        err = (TextView) findViewById(R.id.constitution);
        err.setText("Constitution: "+it.getStringExtra("constitution"));
        err = (TextView) findViewById(R.id.intelligence);
        err.setText("Intelligence: "+it.getStringExtra("intelligence"));
        err = (TextView) findViewById(R.id.wisdom);
        err.setText("Wisdom: "+it.getStringExtra("wisdom"));
        err = (TextView) findViewById(R.id.charisma);
        err.setText("Charisma: "+it.getStringExtra("charisma"));
        err = (TextView) findViewById(R.id.languages);
        err.setText("Languages: "+it.getStringExtra("languages"));
        err = (TextView) findViewById(R.id.challenge_rating);
        err.setText("Challenge_rating: "+it.getStringExtra("challenge_rating"));



    }
}
