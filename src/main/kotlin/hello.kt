import java.util.*
import kotlin.collections.ArrayList

fun main() {
        val createArray = createArray()
        for (index in 0 .. 5){
            createArray.add(IntArray(5))
        }
        createArray[3][2] = 1
        createArray[1][2] = 2
        createArray[1][3] = 1
        println("\n原始数据")
        printArray(createArray)
        val saveArray = saveArray(createArray)
        decodeArray(saveArray)
    }
    fun createArray() = arrayListOf<IntArray>()
    fun printArray(list:ArrayList<IntArray>){
        list.forEach {
            it.forEach{ print("$it\t\t") }
            println("\n")
        }
    }
    fun saveArray(list:ArrayList<IntArray>):ArrayList<IntArray>{
        var noZeroSum = 0
        val array = ArrayList<IntArray>()
        array.add(IntArray(3))
        array[0][0] = list.size
        array[0][1] = list[0].size
        list.forEach { originList ->
            originList.forEach {item -> if(item !=0)noZeroSum++ }
        }
        array[0][2] = noZeroSum
        println("这是第一步后的结果")
        println("行\t\t列\t\t值")
        list.forEachIndexed { index: Int, originList: IntArray ->
            originList.forEachIndexed{ innerIndex: Int, i1: Int ->
                if(i1 !=0)
                {
                    array.add(IntArray(3))
                    array[array.size-1][0] = index
                    array[array.size-1][1] = innerIndex
                    array[array.size-1][2] = i1
                }
            }
        }
        printArray(array)
        return array
    }

    fun decodeArray(encodeList:ArrayList<IntArray>){
        val array = ArrayList<IntArray>(encodeList[0][0])
        for (index in 0 until encodeList[0][0]){
            array.add(IntArray(encodeList[0][1]))
        }
        for(index in 1 .. encodeList.size-1){
            val a = encodeList[index]
            array[a[0]][a[1]] = a[2]
        }

        println("\n解密后的结果")
        printArray(array)



    }
