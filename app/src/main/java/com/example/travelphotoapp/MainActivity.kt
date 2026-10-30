package com.example.travelphotoapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

   private var currentImage = 0
    lateinit var image : ImageView
    var places = arrayOf("Hampi","India Gate", "Mahabalipuram Temple","Qutub Minar","Taj Mahal")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val next  =findViewById<ImageButton>(R.id.btnNext)
        val previous  =findViewById<ImageButton>(R.id.btnPrev)
        val placeName= findViewById<TextView>(R.id.textView2)

        next.setOnClickListener {
            //i want to get the next image
            var idCurrentImageString= "pic$currentImage"

            //i have to get the integer address associated with each view

            var idCurrentImageInt= this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image= findViewById(idCurrentImageInt)
            image.alpha=0f

            currentImage= (5+currentImage+1)%5 // after 4 i will again get 0
            var idImageToShowString="pic$currentImage"
            var idImageToShowInt= this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image= findViewById(idImageToShowInt)
            image.alpha=1f

            placeName.text= places[currentImage]


        }

        previous.setOnClickListener {
            // i want to see the previous image
            var idCurrentImageString= "pic$currentImage"

            //i have to get the integer address associated with each view

            var idCurrentImageInt= this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image= findViewById(idCurrentImageInt)
            image.alpha=0f

            currentImage= (5+currentImage-1)%5 // after 0 i will get 4
            var idImageToShowString="pic$currentImage"
            var idImageToShowInt= this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image= findViewById(idImageToShowInt)
            image.alpha=1f
            placeName.text= places[currentImage]
        }
    }
}
