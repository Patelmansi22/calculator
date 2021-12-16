package com.example.calculatorapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button

private val Any.text: Any
    get() = Unit
private val Any.id: Any
    get() = Unit

class MainActivity : AppCompatActivity() {
var isNewOp = true
var oldNumber = ""
    var op = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun numberEvent(
        view: View,
        bu1: Any,
        bu2: Any,
        bu3: Any,
        bu4: Any,
        editText: Any,
        bu5: Any,
        bu6: Any,
        bu7: Any,
        bu8: Any,
        bu9: Any,
        bu0: Any,
        buDot: Any,
        buPlusMinus: Any
    ) {
        if (isNewOp)
            editText.setText("")
        isNewOp =false
        var buclick:String = editText.text.toString()
        var buselect:Button =view as Button
        when(buselect.id){
            bu1.id -> {buclick += "1"}
            bu2.id -> {buclick += "2"}
            bu3.id -> {buclick += "3"}
            bu4.id -> {buclick += "4"}
            bu5.id -> {buclick += "5"}
            bu6.id -> {buclick += "6"}
            bu7.id -> {buclick += "7"}
            bu8.id -> {buclick += "8"}
            bu9.id -> {buclick += "9"}
            bu0.id -> {buclick += "0"}
            buDot.id -> {buclick += "."}
            buPlusMinus.id ->{buclick = "-$buclick"}
        }
        editText.setText(buclick)
    }

    fun operatorEvent(
        view: View,
        editText: Any,
        buMultiply: Any,
        buPlus: Any,
        buMinus: Any,
        buDivide: Any
    ) {
        isNewOp =true
        oldNumber = editText.text.toString()
        var buSelect = view as Button
        when(buSelect.id){
            buMultiply.id -> {op="*"}
            buPlus.id ->{op= "+"}
            buMinus.id ->{op ="-"}
            buDivide.id ->{op="/"}
        }
    }

    fun EqualEvent(view: View, editText: Any) {
        var newnumber =editText.text.toString()
        var result =0.0
        when(op){
            "+"->{result =oldNumber.toDouble() + newnumber.toDoube()}
            "-"->{result =oldNumber.toDouble() - newnumber.toDoube()}
            "/"->{result =oldNumber.toDouble() / newnumber.toDoube()}
            "*"->{result =oldNumber.toDouble() * newnumber.toDoube()}
        }
        editText.setText(result.toString())
    }

    fun acEvent(view: View, editText: Any) {
        editText.setText("0")
        isNewOp =true
    }

    fun percentageEvent(view: View, editText: Any) {
        var no = editText.text.toString().toDouble()/100
        editText.setText(no.toString())
        isNewOp =true
    }

    fun numberEvent(view: View) {}
    fun percentageEvent(view: View) {}
    fun EqualEvent(view: View) {}
    fun operatorEvent(view: View) {}
    fun acEvent(view: View) {}


}

private fun String.toDoube(): Double {
    TODO("Not yet implemented")
}

private fun Any.setText(s: String) {

}
