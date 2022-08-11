package com.example.textwatcherversion3

import android.widget.ImageView

sealed class AdapterModel {
    class Car(var description: String, var imageView: Int) :AdapterModel()
    class ManualCar(var description: String):AdapterModel()
}