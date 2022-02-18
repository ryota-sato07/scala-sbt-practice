/*
Futureの特徴
- Scalaで非同期処理定義を行う際に扱う
- 通常、処理をブロックせずに返り値の処理や合成ができる
- 非同期で行われる処理が完了すると、
　値がある時は成功、例外の時は失敗のであると表現される
- 1回だけ代入できる特性がある。不変なので上書きされない
*/

package practice

object Map1 {
  val num = Seq(1,2,3,4,5)

  def main(args: Array[String]): Unit = {
    println(this.intSeq(num))

    val result = num
      .foldLeft(Map.empty[Int, Seq[Int]])((stock, v) => {
      val key = v % 2
      stock.get(key) match {
        case None      => stock + (key -> List(v))
        case Some(num) => stock + (key -> (num :+ v))
      }
    })
    println(result)
  }

  def intSeq(numSeq: Seq[Int]):Map[Int, Seq[Int]]  = {
    numSeq.groupBy(_ % 2)
  }
}
