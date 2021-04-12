fun main(args: Array<String>) {


    val nodeList = SingleNodeList()
    nodeList.addNode(Node(1,"王二"))
    nodeList.addNode(Node(2,"里二"))
    nodeList.addNode(Node(3,"张二"))
    nodeList.addNode(Node(4,"好二"))
    nodeList.addNode(Node(5,"过的二"))
    nodeList.addNode(Node(6,"儿童二"))
    nodeList.addNode(Node(7,"好的二"))
    nodeList.addNode(Node(8,"参数二"))
    nodeList.addNode(Node(9,"王二"))
    nodeList.addNode(Node(10,"哈哈哈二"))
    nodeList.addNode(Node(11,"吧仓储部二"))
    nodeList.addNode(Node(12,"王二"))
    nodeList.showAllList()
    nodeList.deleteNode(12)
    println()
    nodeList.showAllList()

}


class SingleNodeList(){

    var headNode = Node(0,"")

    fun addNode(node: Node){
        var tempNode:Node = headNode
        while (tempNode.nextNode != null)
        {
            tempNode = tempNode.nextNode!!
        }
        tempNode.nextNode = node
    }

    fun deleteNode(id:Int)
    {

        var tempNode:Node = headNode
        var oldNode:Node = headNode
        while (tempNode.nextNode != null)
        {
            if(tempNode.id == id)
            {
                oldNode.nextNode = tempNode.nextNode
            }
            oldNode = tempNode
            tempNode = tempNode.nextNode!!
        }
    }

    fun showAllList(){
        var tempNode:Node = headNode

        while (tempNode.nextNode != null){
            print(tempNode.message + "\t\t")
            tempNode = tempNode.nextNode!!
        }
    }
}


class Node(val id:Int,  val message:String){
     var nextNode: Node? = null
    override fun toString(): String {
        return """
            当前Node的内容是：$message,下一个Node的内容是:${nextNode?:""}
        """.trimIndent()
    }
}
