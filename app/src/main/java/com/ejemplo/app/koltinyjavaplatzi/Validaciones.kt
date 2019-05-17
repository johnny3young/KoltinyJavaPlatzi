package com.ejemplo.app.koltinyjavaplatzi

import android.widget.EditText

//Singleton

    fun EditText.passwordValida():Boolean{
        return this.text.toString().isNotEmpty() && this.text.toString().length.compareTo(6) == 1
    }