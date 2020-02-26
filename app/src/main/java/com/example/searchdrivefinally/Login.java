package com.example.searchdrivefinally;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
        e1 = (EditText)findViewById(R.id.editText2);
        e2 = (EditText)findViewById(R.id.editText3);
        b1 = (Button)findViewById(R.id.girisbutton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean checkemailpassord = db.emailpassword(email,password);
                if(checkemailpassord==true) {
                    Toast.makeText(getApplicationContext(), "Giriş Başarılı", Toast.LENGTH_SHORT).show();
                    Intent gecisYap = new Intent(Login.this, Hakkimizda.class);
                    startActivity(gecisYap);
                }
                else
                    Toast.makeText(getApplicationContext(),"Giriş Başarısız",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
