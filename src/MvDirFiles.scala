/**
 * **********************
 * ����f�B���N�g���ȉ��̃t�@�C���̊K�w���A
 * ��i�グ��N���X�B
 *
 * **********************
 */
import scala.sys.process._

object MvDirFiles {
  var i = 0;
  val out_put_dir = "/Users/maruya/Downloads/hoge/"
  val num = 1
  def main(args: Array[String]): Unit = {
    val pwd = Process("pwd").lines.toList.head
    val ls = Process("ls").lines.toList
    ls.foreach(dir => {
      if (dir.charAt(0) != '.') {
        val dir_path = pwd + "/" + dir + "/"
        val files = Process("ls " + dir_path).lines.toList;
        myFiles(dir_path, files, 1)
      }
    })
  }

  //dir_path : �Ώۃf�B���N�g���̃p�X,ls : �Ώۃf�B���N�g���̃t�@�C���ꗗ, num: �o�͂���摜�̖���
  def myFiles(dir_path: String, ls: List[String], j: Int): Unit = {
    ls match {
      case Nil => Nil
      case h :: t => {
        if (j > num) Nil
        else {
          val file_path = dir_path + h
          Process("cp " + file_path + " " + out_put_dir + i.toString + ".jpg").run
          i = i + 1
          myFiles(dir_path, t, j + 1)
        }
      }
    }
  }
}