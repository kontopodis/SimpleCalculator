package com.kontopodis.simplecalculator

import org.jetbrains.annotations.TestOnly

class MathParser() {
    private val numbersStrings = charArrayOf('0','1','2','3','4','5','6','7','8','9','.')
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

        var index =0

        var iterator = cacheOperators.iterator()
        while (iterator.hasNext()) {
            val operator = iterator.next()


            if (operator == '*') {
                println(operator)
                println(cacheNumbers)
                val res = multiply(cacheNumbers[index], cacheNumbers[index + 1])
                cacheNumbers.removeAt(index + 1)
                cacheNumbers[index] = res

                   iterator.remove()
                index--

            }


            if (operator== '/') {
                println(operator)
                println(cacheNumbers)
                val res = divide(cacheNumbers[index], cacheNumbers[index + 1])
                cacheNumbers.removeAt(index + 1)
                cacheNumbers[index] = res
                iterator.remove()
                index--
            }

            index++
        }



        iterator = cacheOperators.iterator()
        index=0
        while (iterator.hasNext())  {
            val operator = iterator.next()

            if (operator == '+') {
                println(operator)
                println(cacheNumbers)
                val res = sum(cacheNumbers[index], cacheNumbers[index + 1])
                cacheNumbers.removeAt(index + 1)
                cacheNumbers[index] = res

                    iterator.remove()
                    index--

            }

            if(operator == '-'){
                println(cacheNumbers)
                println(operator)
                val res = sub(cacheNumbers[index], cacheNumbers[index+1])
                cacheNumbers.removeAt(index+1)
                cacheNumbers[index] = res
                iterator.remove()
                index--
            }

            index++
        }




        if (cacheNumbers.size == 1){
            result = cacheNumbers[0]
        }
        return result

    }


    private fun createArrays(equation:String){


        var num = ""
        var charCount = 0
        var forCount = 0
        var isFirstMinus = false
        for(i in equation){
            charCount++



            if(numbersStrings.contains(i)){
                num += i

            }
            if(operators.contains(i)){
                if(forCount == 0){
                    if(i == '-'){
                        isFirstMinus = true
                    }
                }else{
                    if(isFirstMinus){
                        num = "-$num"
                        cacheNumbers.add(num.toDouble())
                        cacheOperators.add(i)
                        num = ""
                    }else{
                        cacheNumbers.add(num.toDouble())
                        cacheOperators.add(i)
                        num = ""
                    }

                }

            }
            if(equation.toCharArray().size == charCount){
                cacheNumbers.add(num.toDouble())

            }
        forCount++
        }

    }

    fun isNumber(value:Char):Boolean{
        var result:Boolean = false
        if(value!='.')
        {result = numbersStrings.contains(value)}

        return result
    }

    fun getLastNumber(expression:String):Double{
        val iterator = expression.reversed().toCharArray().iterator()

        var result = ""

        var foundEnd = false
        while(iterator.hasNext()){
            val char = iterator.next()

            if(char == '/' || char == '*' || char == '-' || char=='+' || char=='.'){
                foundEnd = true
            } // cacheOperators.contains(char) doesn't work. No Idea why...

            if(char != '.'){
                if(isNumber(char)){
                    if(!foundEnd){
                        result += char
                    }

                }
            }

        }

        if(result == ""){result = "0"}
        return result.reversed().toDouble()
    }

    fun toPercent(value:Double):Double{
        return value/100
    }

    fun trimLastNumber(expression:String):String{
        val iterator = expression.reversed().toCharArray().iterator()

        var result = expression.reversed()

        var foundEnd = false
        while(iterator.hasNext()){
            val char = iterator.next()

            if(char == '/' || char == '*' || char == '-' || char=='+' || char=='.'){
                foundEnd = true
            } // cacheOperators.contains(char) doesn't work. No Idea why...

            if(char != '.'){
                if(isNumber(char)){
                    if(!foundEnd){
                      result = result.removeRange(0,1)
                    }

                }
            }

        }

        if(result == ""){result = "0"}
        return result.reversed()
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