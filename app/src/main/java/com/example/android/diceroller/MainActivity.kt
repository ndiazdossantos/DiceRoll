/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    //cargamos la imagen

    lateinit var diceImage: ImageView

    //hacemos un override(sobreescribimos) la función oncreate, llamando a la superclase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //cargamos el constructor
        setContentView(R.layout.activity_main) // cargamos el layour

        // creamos la variable del boton donde la llamamos

        val rollButton: Button = findViewById(R.id.roll_button)

        // Metodo encargado de lanzar el dado, cuando clikamos inicia rollDice
        rollButton.setOnClickListener {
            rollDice()
        }
        // Posteriormente Busca la vista del dado por la ID de la imagen dada
        diceImage = findViewById(R.id.dice_image)
    }
        // Metodo rollDice , en el que se genera mediante un numero aleatorio entre 1-6 elige una de las diferentes acciones
        // un funcionamiento de un switch
    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
         // cargamos las imagenes para cada caso
        diceImage.setImageResource(drawableResource)
    }
}
