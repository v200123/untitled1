fun main() {
    val numStack:calaStack = calaStack()
    val signStack:calaStack = calaStack()
    val matchReg = "[0-9]"
    val mTemp  = "2+4+3+2-5-8*5-2"
    mTemp.forEachIndexed { i: Int, c: Char ->
        if(Regex(matchReg).matches(c.toString()))
        {
            numStack.pullNode(Node(i,c.toString()))
        }else{
            signStack.pullNode(Node(1,c.toString()))
        }
    }
    println("循环完毕，检查是否正确")
    println("检查数据")
    numStack.showAllList()
    println("检查运算")
    signStack.showAllList()
    println("开始运算")
    val size = numStack.getSize()
    var firstNum = -1
    var secondNum = -1
    var tempResult = 0
    for(index in 0 until size)
    {
        if(firstNum == -1)
        {
            firstNum = numStack.pushNode()!!.message.toInt()
        }else{
            val sign = signStack.pushNode()!!.message
            when(sign){
                "+","-" ->{
                    if(sign == "+")
                    {
                    }

                }
            }
        }
    }
}





class calaStack : Stack(){

    public fun  getSize():Int {
        var tempNode: Node = mHeaderNode!!
        var index = 0
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode!!
            index++
        }
        return index
    }

}