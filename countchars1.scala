import scala.io.Source

if (args.length > 0) {

  def widthOfLength(s: String) = s.length.toString.length

  val lines = Source.fromFile(args(0)).getLines.toList

  val longest = lines.reduceLeft((a,b) => if (a.length > b.length) a else b)
  val maxWidth = widthOfLength(longest)

  for (line <- lines) {
    val numSpaces = maxWidth - widthOfLength(line)
    val padding = " " * numSpaces
    println(padding + line.length + " | " + line)
  }
}
else
  Console.err.println("please enter filename")
