package sg.edu.rp.c346.demoexplicitintent;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int requestCodeForSupermanStats = 1;
    int requestCodeForBatmanStats = 2;

    TextView tvSuperMan, tvBatMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSuperMan = findViewById(R.id.textViewSuperMan);
        tvBatMan = findViewById(R.id.textViewBatMan);

        tvSuperMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hero superman = new Hero("Superman", 100, 60);
                Intent i = new Intent(MainActivity.this,
                        HeroStatsActivity.class);
                // Put hero object in intent
                i.putExtra("hero", superman);
                startActivityForResult(i, requestCodeForSupermanStats);

            }
        });

        tvBatMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hero batman = new Hero("Batman", 60, 90);
                Intent i = new Intent(MainActivity.this,
                        HeroStatsActivity.class);
                // Put hero object in intent
                i.putExtra("hero", batman);
                // Start the activity
                startActivityForResult(i, requestCodeForBatmanStats);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode ==RESULT_OK){
            if (data != null){
                String like = data.getStringExtra("like");
                String statement = "";
                if (requestCode == requestCodeForSupermanStats){
                    statement = "You " + like + " Superman";
                }

                if (requestCode == requestCodeForBatmanStats){
                    statement = "You " + like + " Batman";
                }

                Toast.makeText(MainActivity.this, statement, Toast.LENGTH_LONG).show();
            }
        }
    }
}
