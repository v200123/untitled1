import java.util.Stack

fun main() {

    val stack = Stack<String>()
    //计算 5+4*6+9
    val arrayListOf = arrayListOf<String>("4", "6", "*", "5", "+", "9", "+")
    arrayListOf.forEach {
        if(Regex("[0-9]").matches(it))
        {
            stack.push(it)
        }else{
            val num1 = stack.pop().toInt()
            val num2 = stack.pop().toInt()
            var result = 0
            when(it){
                "*"->{
                    result = num1*num2
                }

                "+"->{
                    result = num1+num2
                }

            }
            stack.push(result.toString())
        }
    }
    println("当前计算结果为:${stack.pop()}")
}