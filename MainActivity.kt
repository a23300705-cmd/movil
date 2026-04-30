package com.example.keopi

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var spinner: Spinner
    lateinit var spinner2: Spinner
    lateinit var spinner3: Spinner
    lateinit var spinner4: Spinner
    lateinit var spinner5: Spinner

    lateinit var etMarca: EditText
    lateinit var etPais: EditText
    lateinit var etEmpresa: EditText
    lateinit var etTelefono: EditText
    lateinit var etPrecio: EditText

    lateinit var btnRegistrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        spinner  = findViewById(R.id.spgrano)
        spinner2 = findViewById(R.id.sptostado)
        spinner3 = findViewById(R.id.spinten)
        spinner4 = findViewById(R.id.sppres)
        spinner5 = findViewById(R.id.sppeso)

        etMarca = findViewById(R.id.etMarca)
        etPais = findViewById(R.id.etPais)
        etEmpresa = findViewById(R.id.etEmpresa)
        etTelefono = findViewById(R.id.etTelefono)
        etPrecio = findViewById(R.id.etPrecio)


        btnRegistrar = findViewById(R.id.btnRegistrar)

        btnRegistrar.setOnClickListener { registrarCafe() }

        val grano = resources.getStringArray(R.array.Tipodegrano)
        val adapterGrano = ArrayAdapter(this, R.layout.spin, R.id.textoSPIN, grano)
        adapterGrano.setDropDownViewResource(R.layout.spin)
        spinner.adapter = adapterGrano

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "Tipo de grano: ${grano[position]}", Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        val tostado = resources.getStringArray(R.array.Niveltostado)
        val adapterTostado = ArrayAdapter(this, R.layout.spin, R.id.textoSPIN, tostado)
        adapterTostado.setDropDownViewResource(R.layout.spin)
        spinner2.adapter = adapterTostado

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(
                    this@MainActivity,
                    "Tostado: ${tostado[position]}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        val intensidad = resources.getStringArray(R.array.Intensidad)
        val adapterInten = ArrayAdapter(this, R.layout.spin, R.id.textoSPIN, intensidad)
        adapterInten.setDropDownViewResource(R.layout.spin)
        spinner3.adapter = adapterInten

        spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "Intensidad: ${intensidad[position]}", Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        val presentacion = resources.getStringArray(R.array.Presentan)
        val adapterPres = ArrayAdapter(this, R.layout.spin, R.id.textoSPIN, presentacion)
        adapterPres.setDropDownViewResource(R.layout.spin)
        spinner4.adapter = adapterPres

        spinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "Presentación: ${presentacion[position]}", Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        val peso = resources.getStringArray(R.array.Peso)
        val adapterPeso = ArrayAdapter(this, R.layout.spin, R.id.textoSPIN, peso)
        adapterPeso.setDropDownViewResource(R.layout.spin)
        spinner5.adapter = adapterPeso

        spinner5.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "Peso: ${peso[position]}", Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun registrarCafe() {

        val cafe = Cafe(
            etMarca.text.toString(),
            etPais.text.toString(),
            etEmpresa.text.toString(),
            etTelefono.text.toString(),
            spinner.selectedItem.toString(),
            spinner2.selectedItem.toString(),
            spinner3.selectedItem.toString(),
            etPrecio.text.toString(),
            spinner4.selectedItem.toString(),
            spinner5.selectedItem.toString()
        )

        Cafelst.listaCafes.add(cafe)

        Toast.makeText(this, "Registrado: ${cafe.marca}", Toast.LENGTH_SHORT).show()
    }
}