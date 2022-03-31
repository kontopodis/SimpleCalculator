package com.kontopodis.simplecalculator

import org.jetbrains.annotations.TestOnly

class MathParser() {
    private val numbersStrings = charArrayOf('0','1','2','3','4','5','6','7','8','9')
    private val operators = charArrayOf('*','/','+','-')
    private var cacheNumbers = ArrayList<Double>()
    private var cacheOperators = ArrayList<Char>()

    fun sum(a:Double,b:Double ):Double {
        return a+b
    }


    fun sub(a:Double,b:Double ):Double {
        return a-b
    }


    fun multiply(a:Double,b:Double ):Double {
        return a*b
    }

    fun divide(a:Double,b:Double ):Double {
        return a/b
    }

    fun mathFromString(equation:String):Double {

            if(equation==""){return 0.0}
        var result : Double = 0.0

        createArrays(equation)



        return result

    }


    private fun createArrays(equation:String){


        var num = ""
        var charCount = 0
        for(i in equation){
            charCount++


            if(numbersStrings.contains(i)){
                num += i

            }
            if(operators.contains(i)){
                cacheNumbers.add(num.toDouble())
                cacheOperators.add(i)
                num = ""
            }
            if(equation.toCharArray().size == charCount){
                cacheNumbers.add(num.toDouble())

            }

        }

    }


    @TestOnly
    fun getNumbersLists(value:String):ArrayList<Double>{
        createArrays(value)
        return cacheNumbers
    }

    @TestOnly
    fun getOperatorsLists(value:String):ArrayList<Char>{
        createArrays(value)
        return cacheOperators
    }
}