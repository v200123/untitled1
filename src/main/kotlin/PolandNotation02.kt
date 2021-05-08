import java.util.Stack

fun main() {

    //分析 2+3*5(2+3)-1的计算结果

    /**
     * 步骤：
     * 1.遍历真个表达式
     * 2.若为数字，则压入数字栈
     * 3.若为符号，则判断是+,-,*,%，还是括号
     * 4.
     */

    // 等待计算的表达式  正确的答案为：1 2 3 + 4 * + 5 -
//    val waitCalulate = "1+((2+3)*4)-5"
    //正确答案为： 3 4 5 * +
    val waitCalulate = "3+4*5-(2+6)"
    val mSignStack = Stack<Char>()
    val mNumStack = Stack<Char>()

    waitCalulate.forEach {

        if (Regex("[0-9]").matches(it.toString())) {
            mNumStack.push(it)
        }
        else{
            println("当前的符号为：$it")
            //若符号栈为空则直接入栈
            if(mSignStack.isEmpty())
                mSignStack.push(it)
            else{
                if(it == '(')
                {
                    mSignStack.push(it)
                }else if(it == ')')
                {
                    while (mSignStack.peek() != '(')
                    {
                        mNumStack.push( mSignStack.pop())
                    }
                    mSignStack.pop()
                }else if(mSignStack.peek()=='(')
                {
                    mSignStack.push(it)
                }
                else if(checkSignPriority(mSignStack.peek())<checkSignPriority(it))
                {
                    while (mSignStack.isNotEmpty()&&checkSignPriority(mSignStack.peek())<checkSignPriority(it))
                    {
                        mNumStack.push(mSignStack.pop())
                    }
                    mSignStack.push(it)
                }else{
                    mNumStack.push(mSignStack.pop())
                    mSignStack.push(it)
                }

            }

        }

        println("数字栈中有")
        println(mNumStack.toString())
        println("符号栈中有")
        println(mSignStack.toString())

    }
    if(mSignStack.isNotEmpty())
    mNumStack.push(mSignStack.pop())
    println("最终数字栈中有")
    println(mNumStack.toString())
    println("最终符号栈中有")
    println(mSignStack.toString())
}

/**
 * 检查运算符的优先级
 */
fun checkSignPriority(sign:Char):Int{
    if(sign == '*' || sign == '%')
    {
        return 1
    }
    return -1
}