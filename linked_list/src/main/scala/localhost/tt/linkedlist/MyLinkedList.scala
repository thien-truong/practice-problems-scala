package localhost.tt.linkedlist

// a linked list is always initiated with a HEAD
case class MyLinkedList(var head: Option[Node]) {
  def remove(index: Int): Unit = {
    head match {
      case None =>
        throw new IllegalArgumentException("Linked list is empty.")
      case Some(currentNode) =>
        val currentIndex = 0
        if (index == 0 && currentNode.next.isEmpty) {
          head = None
        }
    }
  }


  def insert(index: Int, value: String): Unit = {

    def traverseAndInsert(currentNode: Node, currentIndex: Int): Unit = {
      (currentNode.next.isEmpty, currentIndex == index) match {
        case (true, false) =>
          throw new IllegalArgumentException("Index is out of bounds.")
        case (true, true) =>
          val nodeToInsert = Node(value, None)
          currentNode.next = Some(nodeToInsert)
        case (false, true) =>
          val nodeToInsert = Node(value, currentNode.next)
          currentNode.next = Some(nodeToInsert)
        case (false, false) =>
          traverseAndInsert(currentNode.next.get, currentIndex + 1)
      }
    }

    head match {
      case Some(currentNode) =>
        val currentIndex: Int = 1

        if (index == 0) {
          val nodeToInsert = Node(value, Some(currentNode))
          head = Some(nodeToInsert)
        } else {
          traverseAndInsert(currentNode, currentIndex)
        }

      case None =>
        head = Some(Node(value, None))
    }
  }

}

object MyLinkedList {
  def apply(elements: String*): MyLinkedList = {
    if (elements.isEmpty) {
      new MyLinkedList(None)
    } else {
      new MyLinkedList(Some(createNode(elements: _*)))
    }
  }

  def createNode(elements: String*): Node = {
    if (elements.tail.length < 1) {
      Node(elements.head, None)
    } else {
      Node(elements.head, Some(createNode(elements.tail: _*)))
    }
  }
}




