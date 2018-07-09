package if1001.android.bestiary3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;

    // URL to get monsters JSON
    private static String url = "https://dl.dropboxusercontent.com/s/iwz112i0bxp2n4a/5e-SRD-Monsters.json";

    ArrayList<HashMap<String, String>> monsterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monsterList = new ArrayList<>();

        lv = (ListView) findViewById(R.id.list);

        new GetMonster().execute();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(), "Clicou no item " + position, Toast.LENGTH_SHORT);
                Intent intent = new Intent(getApplicationContext(), ExibiMonstro.class);
                intent.putExtra("name",monsterList.get(position).get("name"));
                intent.putExtra("size",monsterList.get(position).get("size"));
                intent.putExtra("type", monsterList.get(position).get("type"));
                intent.putExtra("subtype",monsterList.get(position).get("subtype"));
                intent.putExtra("alignment",monsterList.get(position).get("alignment"));
                intent.putExtra("armor_class",monsterList.get(position).get("armor_class"));
                intent.putExtra("hit_points",monsterList.get(position).get("hit_points"));
                intent.putExtra("hit_dice",monsterList.get(position).get("hit_dice"));
                intent.putExtra("speed",monsterList.get(position).get("speed"));
                intent.putExtra("strength",monsterList.get(position).get("strength"));
                //intent.putExtra("strength_save",monsterList.get(position).get("strenght_save"));
                intent.putExtra("dexterity",monsterList.get(position).get("dexterity"));
                //intent.putExtra("dexterity_save",monsterList.get(position).get("dexterity_save"));
                intent.putExtra("constitution",monsterList.get(position).get("constitution"));
                //intent.putExtra("constitution_save",monsterList.get(position).get("constitution_save"));
                intent.putExtra("intelligence",monsterList.get(position).get("intelligence"));
                //intent.putExtra("intelligence_save",monsterList.get(position).get("intelligence_save"));
                intent.putExtra("wisdom",monsterList.get(position).get("wisdom"));
                //intent.putExtra("wisdom_save",monsterList.get(position).get("wisdom_save"));
                intent.putExtra("charisma",monsterList.get(position).get("charisma"));
                //intent.putExtra("charisma_save",monsterList.get(position).get("charisma_save"));
                intent.putExtra("perception",monsterList.get(position).get("perception"));
                //intent.putExtra("damage_vulnerabilities",monsterList.get(position).get("damage_vulnerabilities"));
                //intent.putExtra("damage_resistances",monsterList.get(position).get("damage_resistances"));
                //intent.putExtra("damage_immunities",monsterList.get(position).get("damage_immunities"));
                //intent.putExtra("condition_immunities",monsterList.get(position).get("condition_immunities"));
                //intent.putExtra("senses",monsterList.get(position).get("senses"));
                intent.putExtra("languages",monsterList.get(position).get("languages"));
                intent.putExtra("challenge_rating", monsterList.get(position).get("challenge_rating"));
                startActivity(intent);
            }
        });
    }

    public void AbrirMonsterCreater(View view){
        Intent intent = new Intent(getApplicationContext(),MonsterCreaterActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.Create_monster){
            Intent intent = new Intent(getApplicationContext(),MonsterCreaterActivity.class);
            startActivity(intent);
            return true;
        }
        return true;
    }

    private class GetMonster extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    //JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray monsters = new JSONArray(jsonStr);

                    // looping through All Contacts
                    for (int i = 0; i < monsters.length()-1; i++) {
                        JSONObject c = monsters.getJSONObject(i);
                        Log.d("porra",c+"");

                        String name = c.getString("name");
                        String size = c.getString("size");
                        String type = c.getString("type");
                        //String subtype = c.getString("subtype");
                        String alignment = c.getString("alignment");
                        String armor_class = c.getString("armor_class");
                        String hit_points = c.getString("hit_points");
                        String hit_dice = c.getString("hit_dice");
                        String speed = c.getString("speed");
                        String strength = c.getString("strength");
                        //String strength_save ="";
                        //strength_save = c.getString("strength_save");
                        String dexterity = c.getString("dexterity");
                        //String dexterity_save = c.getString("dexterity_save");
                        String constitution = c.getString("constitution");
                        //String constitution_save = c.getString("constitution_save");
                        String intelligence = c.getString("intelligence");
                        //String intelligence_save = c.getString("intelligence_save");
                        String wisdom = c.getString("wisdom");
                        //String wisdom_save = c.getString("wisdom_save");
                        String charisma = c.getString("charisma");
                        //String charisma_save = c.getString("charisma_save");
                        //String perception = c.getString("perception");
                        //String damage_vulnerabilities = c.getString("damage_vulnerabilities");
                        //String damage_resistances = c.getString("damage_resistances");
                        //String damage_immunities = c.getString("damage_immunities");
                        //String condition_immunities = c.getString("condition_immunities");
                        //String senses = c.getString("senses");
                        String languages = c.getString("languages");
                        String challenge_rating = c.getString("challenge_rating");

                        // tmp hash map for single monster
                        HashMap<String, String> monster = new HashMap<>();

                        // adding each child node to HashMap key => value
                        monster.put("name", name);
                        monster.put("size",size);
                        monster.put("type", type);
                        //monster.put("subtype",subtype);
                        monster.put("alignment",alignment);
                        monster.put("armor_class",armor_class);
                        monster.put("hit_points",hit_points);
                        monster.put("hit_dice",hit_dice);
                        monster.put("speed",speed);
                        monster.put("strength",strength);
                        //monster.put("strength_save",strength_save);
                        monster.put("dexterity",dexterity);
                        //monster.put("dexterity_save",dexterity_save);
                        monster.put("constitution",constitution);
                        //monster.put("constitution_save",constitution_save);
                        monster.put("intelligence",intelligence);
                        //monster.put("intelligence_save",intelligence_save);
                        monster.put("wisdom",wisdom);
                        //monster.put("wisdom_save",wisdom_save);
                        monster.put("charisma",charisma);
                        //monster.put("charisma_save",charisma_save);
                        //monster.put("perception",perception);
                        //monster.put("damage_vulnerabilities",damage_vulnerabilities);
                        //monster.put("damage_resistances",damage_resistances);
                        //monster.put("damage_immunities",damage_immunities);
                        //monster.put("condition_immunities",condition_immunities);
                        //monster.put("senses",senses);
                        monster.put("languages",languages);
                        monster.put("challenge_rating", challenge_rating);

                        // adding monster to monster list
                        monsterList.add(monster);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, monsterList,
                    R.layout.list_item, new String[]{"name", "type",
                    "challenge_rating"}, new int[]{R.id.name,
                    R.id.type, R.id.challenge_rating});

            lv.setAdapter(adapter);
        }

    }
}
