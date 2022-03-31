package com.kontopodis.simplecalculator

import org.junit.Assert.*

import org.junit.Test

class MathHandlerTest {

    @Test
    fun sum() {
       val math = MathParser().sum(1.0,1.0)
        assertEquals(math,2.0,00.1)
    }

    @Test
    fun multiply() {
        val math = MathParser().multiply(2.0,2.0)
        assertEquals(math,4.0,0.001)
    }

    @Test
    fun divide() {
        val math = MathParser().divide(2.0,2.0)
        assertEquals(math,1.0,0.001)
    }

    @Test
    fun sub() {
        val math = MathParser().sub(2.0,2.0)
        assertEquals(math,0.0,0.001)
    }

    @Test
    fun `String summary`() {
        val math = MathParser().mathFromString("1a1+1")
        assertEquals(12.0,math,0.001)
    }
    @Test
    fun `When String is empty`(){
        val math = MathParser().mathFromString("")
        assertEquals(0.0,math,0.001)
    }

    @Test
    fun `String minus`(){
        val string = "2-2"

        val math:Double = MathParser().mathFromString(string)
        assertEquals(4.0,math,0.001)
    }

    @Test
    fun `Numbers list is not null`(){
        var numbers = ArrayList<Double>()
       val list:ArrayList<Double> =  MathParser().getNumbersLists("12+8")
       assertNotNull(list)

    }

    @Test
    fun `Numbers list returns 2 numbers and 1 operator`(){
        var numbers = arrayListOf<Double>(12.0,8.0)
        var operators = arrayListOf<Char>('+')
        val numbersList:ArrayList<Double> =  MathParser().getNumbersLists("12+8")
        val operatorList:ArrayList<Char> =  MathParser().getOperatorsLists("12+8")
        assertEquals(numbers,numbersList)
        assertEquals(operators,operatorList)

    }

    @Test
    fun `Numbers list returns 3 numbers ans 2 operators`(){
        var numbers = arrayListOf<Double>(12.0,8.0,2.0)
        val list:ArrayList<Double> =  MathParser().getNumbersLists("12+8-2")
        assertEquals(numbers,list)

    }

    @Test
    fun `Numbers list returns 4 numbers ans 3 operators`(){
        var numbers = arrayListOf<Double>(12.0,8.0,2.0,5.0)
        val list:ArrayList<Double> =  MathParser().getNumbersLists("12+8-2-5")
        assertEquals(numbers,list)

    }
}