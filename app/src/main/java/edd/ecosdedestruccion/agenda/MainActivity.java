package edd.ecosdedestruccion.agenda;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Agenda básica para el uso de SharedPreferences
 */
public class MainActivity extends AppCompatActivity {

    //Variables para los componentes
    private EditText edt_nombre;
    private EditText edt_email;
    private EditText edt_tel;
    private EditText edt_coment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Relación de componentes con lógica
        edt_nombre = (EditText) findViewById(R.id.txt_nombre);
        edt_email = (EditText) findViewById(R.id.txt_email);
        edt_tel = (EditText) findViewById(R.id.txt_tel);
        edt_coment = (EditText) findViewById(R.id.txt_coment);


    }
    /*
    Método para guardar los datos de la agenda
     */
    public void guradar(View view){

        //Variables de almacenamiento temporal
        String nombre = edt_nombre.getText().toString();
        String coment = edt_coment.getText().toString();


        //Objeto para guaradar la info
        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferencias.edit();  //Editamos
        obj_editor.putString(nombre, coment);
        obj_editor.commit();

        Toast.makeText(this, "Usuario guardado", Toast.LENGTH_SHORT).show();
    }

    /*
    Método para la búsqueda de la información de los contactos
     */
    public void buscar(View view){
        //variable para recuperar datos
        String nombre = edt_nombre.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String datos = preferencias.getString(nombre, "");

        if(datos.isEmpty()){
            Toast.makeText(this, "No existen datos", Toast.LENGTH_SHORT).show();
        }
        else{
            //Variables para la extracción de la información del ArrayList
            edt_coment.setText(datos);
        }

    }


}
