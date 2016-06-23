package trello

/**
  * Created by edwardsj on 23/06/2016.
  */
case class Board(columns: Set[Column], cards: List[Card]) {

  def addColumn(col: Column) = this.copy(columns = columns + col)

  def updateColumn(col: Column, newCol: Column) =
    this.copy(columns = columns - col + newCol)

  def withNewCard(column: Column) = this.copy(cards = Card(column) :: cards)

  def moveCard(card: Card, col: Column) =
    this.copy(cards = cards.map {
      case oldCard if oldCard == card => oldCard.copy(column = col)
      case x => x
    })

}

case class Column(name: String)

case class Card(column: Column, title: String = "", description: String = "")