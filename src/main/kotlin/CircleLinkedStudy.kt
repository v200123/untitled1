/**
 * 双向的循环链表
 */

fun main(args: Array<String>) {

    val dobleNodeList = dobleNodeList()
    dobleNodeList.insertNode(doubleCicleNode(1,"张三","男"))
    dobleNodeList.insertNode(doubleCicleNode(2,"张三","男"))
    dobleNodeList.insertNode(doubleCicleNode(3,"张三","男"))
    dobleNodeList.insertNode(doubleCicleNode(4,"张三","男"))
    dobleNodeList.insertNode(doubleCicleNode(5,"张三","男"))
    dobleNodeList.insertNode(doubleCicleNode(6,"张三","男"))
    dobleNodeList.insertNode(doubleCicleNode(7,"张三","男"))
    dobleNodeList.insertNode(doubleCicleNode(8,"张三","男"))
    dobleNodeList.insertNode(doubleCicleNode(9,"张三","男"))
    dobleNodeList.insertNode(doubleCicleNode(10,"张三","男"))
    dobleNodeList.insertNode(doubleCicleNode(11,"张三","男"))
    dobleNodeList.insertNode(doubleCicleNode(12,"张三","男"))
    dobleNodeList.insertNode(doubleCicleNode(13,"张三","男"))
    dobleNodeList.showAllNode()
    dobleNodeList.deleteNode(10)
    println("删除之后的结果")
    dobleNodeList.showAllNode()

}

class dobleNodeList(){

    var headNode = doubleCicleNode(0,"","").apply { mFront = this }

    fun deleteNode(id:Int){
        var tempNode:doubleCicleNode = headNode

        while (tempNode.mFront !=headNode)
        {
            println("循环中")
            if(tempNode.id == id)
            {
                tempNode.mFront!!.mNear = tempNode.mNear
                tempNode.mNear!!.mFront = tempNode.mFront
                tempNode.mFront = null
                tempNode.mNear = null
                println("删除成功")
                break
            }else
            tempNode = tempNode.mNear!!
        }
    }

    fun insertNode(node:doubleCicleNode,position:Int = -1){
        var tempNode:doubleCicleNode = headNode

        if(position == -1)
         {

             while (tempNode.mNear !=headNode)
             {
                 println("循环中")

                 tempNode = tempNode.mNear!!
             }
             tempNode.mFront = node
             node.mNear = tempNode
             node.mFront = headNode
         }else{
             var index = 0
            while (tempNode.mNear !=headNode)
            {
                if(position == index)
                {
                    node.mFront = tempNode
                    tempNode = tempNode.mNear!!
                    node.mNear = tempNode
                }else{
                    index++
                }
            }
         }
    }

    fun showAllNode(){
        var tempNode:doubleCicleNode = headNode

        if(headNode.mFront == headNode)
        {
            println("请先插入链表再输出")
        }
        else{
            tempNode = tempNode.mNear!!
            while (tempNode !=headNode)
            {
                println("当前结点的编号：${tempNode.id},名字：${tempNode.name},简称：${tempNode.nickName}")
                tempNode = tempNode.mNear!!
            }
        }
    }
}

class doubleCicleNode( var id :Int ,var nickName:String,var name: String)
{
    //前
    var mFront : doubleCicleNode? = null
    //后
    var mNear : doubleCicleNode? = null
}
