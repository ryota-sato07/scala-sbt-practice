/*
Futureの特徴
- Scalaで非同期処理定義を行う際に扱う
- 通常、処理をブロックせずに返り値の処理や合成ができる
- 非同期で行われる処理が完了すると、
　値がある時は成功、例外の時は失敗のであると表現される
- 1回だけ代入できる特性がある。不変なので上書きされない



*/

package practice

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Future1 {
  def main(args: Array[String]): Unit = {

    //初期化
    val future = Future("hoge")
    println(future) 
  }
}

//[info] Future(Success(hoge))
