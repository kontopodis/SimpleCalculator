package com.kontopodis.simplecalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //numbers
        val zero = findViewById<Button>(R.id.zero)
        val one = findViewById<Button>(R.id.one)
        val two = findViewById<Button>(R.id.two)
        val three = findViewById<Button>(R.id.three)
        val four = findViewById<Button>(R.id.four)
        val five = findViewById<Button>(R.id.five)
        val six = findViewById<Button>(R.id.six)
        val seven = findViewById<Button>(R.id.seven)
        val eight = findViewById<Button>(R.id.eight)
        val nine= findViewById<Button>(R.id.nine)


        val addition = findViewById<Button>(R.id.plus)
        val subtraction = findViewById<Button>(R.id.minus)
        val multiply = findViewById<Button>(R.id.multiply)
        val division = findViewById<Button>(R.id.division)

        val percent = findViewById<Button>(R.id.percent) // this has to create a double out.
        val clear = findViewById<Button>(R.id.erase)
        val delete = findViewById<Button>(R.id.delete)
        val decimal = findViewById<Button>(R.id.decimal)
        val equal= findViewById<Button>(R.id.equal)
        val oposite = findViewById<Button>(R.id.oposite)

        val panel = findViewById<TextView>(R.id.panel)

        zero.setOnClickListener{addValue("0", panel)}
        one.setOnClickListener{addValue("1", panel)}
        two.setOnClickListener{addValue("2", panel)}
        three.setOnClickListener{addValue("3", panel)}
        four.setOnClickListener{addValue("4", panel)}
        five.setOnClickListener{addValue("5", panel)}
        six.setOnClickListener{addValue("6", panel)}
        seven.setOnClickListener{addValue("7", panel)}
        eight.setOnClickListener{addValue("8", panel)}
        nine.setOnClickListener{addValue("9", panel)}

        delete.setOnClickListener { deleteValue( panel ) }
        clear.setOnClickListener { clearAllValues(panel) }
        addition.setOnClickListener { addValue("+",panel) }
        subtraction.setOnClickListener { addValue("-",panel) }
        multiply.setOnClickListener { addValue("*",panel) }
        division.setOnClickListener { addValue("/",panel) }
        decimal.setOnClickListener { addValue(".",panel) }

        equal.setOnClickListener { executeMath(panel) }

    }

    private fun executeMath( panel:TextView){
        val result = MathParser().mathFromString(panel.text.toString())
        panel.text = result.toString()

    }
   private fun addValue(value:String, view:TextView ){
       val text = "${view.text}${value}"
       view.text = text
    }

    private fun deleteValue(view:TextView){
        if( view.text == "" ){
        this.toast("No values to delete")
        }
        else{
            val text = view.text.toString().subSequence(0,view.text.toString().length -1)
            view.text = text
        }

    }

    private fun clearAllValues(view:TextView){
        if( view.text == "" ){
            this.toast("Is ampty. No values to delete")
        }
        view.text = ""
    }




    // TODO: percent check and create the decimal
    // TODO: restrict the insertion of 2+ operators
    // TODO: the oposite has to add a - operator


}
fun Context.toast(message: CharSequence) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()


