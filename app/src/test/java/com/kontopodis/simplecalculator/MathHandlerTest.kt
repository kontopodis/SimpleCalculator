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
    fun `When String is empty`(){
        val math = MathParser().mathFromString("")
        assertEquals(0.0,math,0.001)
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

    @Test
    fun `String minus`(){
        val string = "2-2"

        val math:Double = MathParser().mathFromString(string)
        assertEquals(0.0,math,0.001)
    }

    @Test
    fun `String summary`() {
        val math = MathParser().mathFromString("11+1")
        assertEquals(12.0,math,0.001)
    }

    @Test
    fun `String multiply`() {
        val math = MathParser().mathFromString("2*3")
        assertEquals(6.0,math,0.001)
    }

    @Test
    fun `String divide`() {
        val math = MathParser().mathFromString("6/2")
        assertEquals(3.0,math,0.001)
    }

    @Test
    fun `1 Division and 1 Summary`() {
        val math = MathParser().mathFromString("6/2+2")
        assertEquals(5.0,math,0.001)
    }

    @Test
    fun `1 Subtraction and 1 Division`() {
        val math = MathParser().mathFromString("2-6/2")
        assertEquals(-1.0,math,0.001)
    }

    @Test
    fun `1 Division 1 Subtraction`() {
        val math = MathParser().mathFromString("6/2-2")
        assertEquals(1.0,math,0.001)
    }

    @Test
    fun `1 multiply 1 summary`(){
        val math = MathParser().mathFromString("6*2+2")
        assertEquals(14.0,math,0.001)
    }

    @Test
    fun `1 summary 1 multiply`(){
        val math = MathParser().mathFromString("2+6*2")
        assertEquals(14.0,math,0.001)
    }

    @Test
    fun `1 addition 1 subtraction`(){
        val math = MathParser().mathFromString("2-6+2")
        assertEquals(-2.0,math,0.001)
    }

    @Test
    fun `1  multiply 1 division`(){
        val math = MathParser().mathFromString("6/2*2")
        assertEquals(6.0,math,0.001)
    }

    @Test
    fun `1  multiply 1 division 1 addition`(){
        val math = MathParser().mathFromString("6/2*2+4")
        assertEquals(10.0,math,0.001)
    }

    @Test
    fun `1  multiply 1 division 1 subtraction 1 addition`(){
        val math = MathParser().mathFromString("20-6/2*2+4")
        assertEquals(18.0,math,0.001)
    }

    @Test
    fun `long expression 1`(){
        val math = MathParser().mathFromString("20-6/2*2+4/2+100*30+22")
        assertEquals(3038.0,math,0.001)
    }

    @Test
    fun `decimal`(){
        val math = MathParser().mathFromString("0.2*25+3-3/4")
        assertEquals(7.25,math,0.001)
    }

    @Test
    fun `is number 0 return true`(){
        val char = '0'
        val math = MathParser().isNumber(char)
        assertEquals(true,math)
    }


    @Test
    fun `is number plus sign returns false`(){
        val char = '0'
        val math = MathParser().isNumber(char)
        assertEquals(true,math)
    }


    @Test
    fun `get last number returns 1 digital number`(){
        val expression = "12+2"
        val math = MathParser().getLastNumber(expression)
        assertEquals(2.0,math,0.001)
    }

    @Test
    fun `get last number returns 2 digital number`(){
        val expression = "12+12"
        val math = MathParser().getLastNumber(expression)
        assertEquals(12.0,math,0.001)
    }

    @Test
    fun `get last number returns 0 number when given wrong parameters`(){
        val expression = "12."
        val math = MathParser().getLastNumber(expression)
        assertEquals(0.0,math,0.001)
    }

    @Test
    fun `get last number returns 3 digital numbers`(){
        val expression = "12+234"
        val math = MathParser().getLastNumber(expression)
        assertEquals(234.0,math,0.001)
    }

    @Test
    fun `makes percent`(){
        val math = MathParser().toPercent(20.0)
        assertEquals(0.2,math,0.001)
    }

    @Test
    fun `trims last number`(){
        val math = MathParser().trimLastNumber("12+45")
        assertEquals("12+",math)
    }

    @Test
    fun `First is a minus number`(){
        val math = MathParser().mathFromString("-10+20")
        assertEquals(10.0,math,0.001)
    }
}