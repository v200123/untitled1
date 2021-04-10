import java.util.*
private var loop = true
private val mQueue = cicleQueue(5)
fun main(args: Array<String>) {

    println("""
        程序开始运行
        1.输入a/add添加数据
        2.输入g/get移除数据
        3.输入s/see查看数据
        4.输入e/exit退出程序
    """.trimIndent())

    while (loop) {
        val scanner = Scanner(System.`in`)
        when (scanner.next()) {
            "a","add" ->{
                val nextInt = scanner.nextInt()
                mQueue.addData(nextInt)
            }
            "g","get" ->{
                mQueue.getData()
            }
            "s","see" ->{

            }
            "e","exit" ->{
                loop = false
            }
        }
    }
}


class cicleQueue(private val mMaxSize:Int) {
    //指向队列的第一个数
    private var mFront:Int = 0
    //指向队列的最后一个数
    private var mRear:Int = 0
    private val mDataList by lazy { IntArray(mMaxSize) }

     fun isFull():Boolean{

        return (mRear + 1)%mMaxSize == mFront

    }

    fun isEmpty() = mRear == mFront
    fun addData(data:Int){
            if(isFull())
                throw IllegalStateException("队列已经满了")
        mDataList[mRear] = data
        mRear = (mRear +1)%mMaxSize
    }
    fun getData():Int{
        if(isEmpty())
            throw IllegalStateException("队列为空，不能取数据")
        mFront  = (mFront + 1) % mMaxSize;
        return mDataList[mFront]
    }

    fun seeAllData(){
        
    }


}
