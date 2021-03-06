package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sql.esquemas.Asignatura;
import com.example.sql.esquemas.Calificacion;
import com.example.sql.esquemas.OperacionesCRUD;

public class MainActivity2 extends AppCompatActivity {

    private EditText codigo, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        codigo = findViewById(R.id.codigo);
        descripcion = findViewById(R.id.descripcion);
    }
    public void insertar(View v){
        OperacionesCRUD instacia = new OperacionesCRUD(this, "BDTEST", null, 9);

        ContentValues datosAsignatura = new ContentValues();
        datosAsignatura.put(Asignatura.Esquema.CODIGO, codigo.getText().toString());
        datosAsignatura.put(Asignatura.Esquema.DESCRIPCION, descripcion.getText().toString());

        long id_asignatura_insertado = instacia.insertTabla(datosAsignatura, Asignatura.Esquema.TABLA_ASIGNATURA);
        Toast.makeText(this, "ID: "+id_asignatura_insertado,Toast.LENGTH_SHORT).show();
    }

    public void volver(View v){
        Intent i= new Intent(this,ListaAsignaturas.class);
        startActivity(i);
    }
}