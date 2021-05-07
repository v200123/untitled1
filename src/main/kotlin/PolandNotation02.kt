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

    // 等待计算的表达式
    val waitCalulate = "2+3*5(2+3)-1"
    val mSignStack = Stack<Char>()
    val mNumStack = Stack<Char>()

    waitCalulate.forEach {

        if(Regex("[0-9]").matches(it.toString()))
        {
            mNumStack.push(it)
        }
        else{
            if(mSignStack.empty())
            {
                mSignStack.push(it)
            }else{
                if(it =='(')
                {
                    mSignStack.push(it)
                }else if(it ==')')
                {
                    while (mSignStack.peek() != '(')
                    {
                        mNumStack.push(mSignStack.pop())
                    }
                }else
                    if(mSignStack.peek() == '(')
                    {
                        mSignStack.push(it)
                    }else if(checkSignPriority(mSignStack.peek()) < checkSignPriority(it))
                {
                    mSignStack.push(it)
                }else{
                        val pop = mNumStack.pop()
                        mNumStack.push(it)
                    }

            }
        }

    }

    println("数字栈中有")
    println(mNumStack.toString())


}

/**
 * 检查运算符的优先级
 */
fun checkSignPriority(sign:Char):Int{
    if(sign == '*' || sign == '%')
    {
        return 1
    }
    if(sign == '(' )
        return 2

    return -1
}