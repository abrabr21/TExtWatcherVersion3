package com.example.textwatcherversion3

sealed class AdapterModel {
    class CarModel (car :Car):AdapterModel()
    class ManualCarModel( manualCar: ManualCar):AdapterModel()
}