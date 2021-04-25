/**
 *
 * 使用单链表做的栈
 *
 */

fun main() {

    val stack = Stack()
    stack.pullNode(Node(1, "1dsf"))
    stack.pullNode(Node(2, "1sdfer"))
    stack.pullNode(Node(3, "1xcvsdf"))
    stack.pullNode(Node(4, "1dsfs"))
    stack.pullNode(Node(5, "1"))
    stack.pullNode(Node(6, "1"))
    stack.pullNode(Node(7, "1sdfsdf"))
    stack.pullNode(Node(8, "1 v xcv"))
    stack.pullNode(Node(9, "1xcv "))
    stack.pullNode(Node(10, "1sdfsdf"))
    stack.pullNode(Node(11, "xcv1"))
    stack.pullNode(Node(12, "1sdf"))
    stack.pullNode(Node(13, "1"))
    stack.pullNode(Node(14, "1"))
    stack.pullNode(Node(15, "1"))
    stack.pullNode(Node(16, "1"))
    stack.showAllList()

    println("开始推出")
    println(stack.pushNode()!!.message)
    println(stack.pushNode()!!.message)
    println(stack.pushNode()!!.message)
    println(stack.pushNode()!!.message)
    println(stack.pushNode()!!.message)
    println(stack.pushNode()!!.message)
    println("推出完成")

    stack.showAllList()
}


open class Stack() {

    var mHeaderNode: Node? = null


    fun pullNode(node: Node) {
        if (mHeaderNode != null) {
            node.nextNode = mHeaderNode
            mHeaderNode = node
        }
        else
            mHeaderNode = node
    }

    fun pushNode(): Node? {
        if(mHeaderNode!=null)
        {
            val mTempNode = mHeaderNode
            val nextNode = mHeaderNode!!.nextNode
            if(nextNode !=null)
            {
                mHeaderNode = nextNode
            }else{
                println("已经退出所有的Node")
                return null
            }
            return mTempNode
        }else{
            println("请先添加Node")
            return null

        }


    }

    fun showAllList() {
        var tempNode: Node = mHeaderNode!!

        while (tempNode.nextNode != null) {
            println(tempNode.message + "\t\t")
            tempNode = tempNode.nextNode!!
        }
        println(tempNode.message + "\t\t")

    }


}