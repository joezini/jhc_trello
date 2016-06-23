package trello
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by edwardsj on 23/06/2016.
  */
class BoardSpec extends FlatSpec with Matchers{
  "A board" should "be able to add a new column" in {
    val board2 = blankBoard.addColumn(Column("Test1"))
    board2.columns.size shouldBe 1
  }

  it should "have the ability to change a column's title" in {
    val board1 = blankBoard.addColumn(Column("Test1"))
    val board2 = board1.updateColumn(Column("Test1"), Column("Test2"))
    board2.columns.size shouldBe 1
    board2.columns should contain(Column("Test2"))
  }

  it should "be able to create new cards" in {
    val board = blankBoard.addColumn(Column("Test1")).withNewCard(Column("Test1"))
    board.cards.size shouldBe 1
  }

  "A card" should "be able to move between lists" in {
    val board = blankBoard
      .addColumn(Column("Test1"))
      .addColumn(Column("Test2"))
      .withNewCard(Column("Test1"))
    board.cards.size shouldBe 1
    board.cards should contain(Card(Column("Test1")))
    val board2 = board.moveCard(Card(Column("Test1")), Column("Test2"))
    board2.cards.size shouldBe 1
    board.cards should contain(Card(Column("Test2")))
  }

  val blankBoard = Board(Set.empty, List.empty)
}
