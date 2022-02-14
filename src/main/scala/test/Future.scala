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

  case class Student (
    id:              Long,   // 生徒ID
    classId:         String, // クラス名
    studentName:     String  // 生徒名
  )

  object Database {
    def getStudentById(studentId: Long): Future[Student] =
      Future {
        Thread.sleep(1000)
        Student(
          id             = 1,
          classId        = 1,
          studentName    = "山田"
        )
      }
  }

  def output(outputId: Long): Unit = {
    for {
      studentInfo <- Database.getStudentById(id)
      } yield {
        println(studentInfo.studentName)
      }

  }

  def main(args: Array[String]): Unit = {

    output(1.toLong)
    Thread.sleep(3000)
  }
}
