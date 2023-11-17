package com.example.scrollingtext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button addButtonComment;
    private TextView comentarios;
    private int contadorMensajes = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.miEditText);
        addButtonComment = findViewById(R.id.addButtonComment);
        comentarios = findViewById(R.id.comentarios);

        addButtonComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setvisible();
                saveComment();
            }
        });
    }

    public void setvisible(){
        editText.setVisibility(View.VISIBLE);
        addButtonComment.setText("SEND COMMENT");
    }

    public void saveComment(){
        if(addButtonComment.getText().toString().equals("SEND COMMENT")){
            String nuevoMensaje = editText.getText().toString().trim();

            if (!nuevoMensaje.isEmpty()) {
                String mensajeConNumero = "Mensaje " + contadorMensajes + ": " + nuevoMensaje;
                contadorMensajes++;

                String mensajeExistente = comentarios.getText().toString();
                String mensajeCompleto;

                if (mensajeExistente.isEmpty()) {
                    mensajeCompleto = mensajeConNumero;
                } else {
                    mensajeCompleto = mensajeExistente + "\n\n" + mensajeConNumero;
                }

                comentarios.setText(mensajeCompleto);
                Log.i("EditText", editText.getText().toString());
            }
        }
    }
}
