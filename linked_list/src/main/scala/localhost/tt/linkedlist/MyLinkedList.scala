package localhost.tt.linkedlist

// a linked list is always initiated with a HEAD
case class MyLinkedList(var head: Option[Node]) {

  def insert(index: Int, value: String): Unit = {

    head match {
      case Some(head0) =>
        val currentNode: Node = head0
        val count: Int = 1

        if (index == 0) {
          val nodeToInsert = Node(value, Some(currentNode))
          head = Some(nodeToInsert)
        } else {
          traverseAndInsert(currentNode, count)
        }

        def traverseAndInsert(currentNode: Node, count: Int): Unit = {
          if (currentNode.next == None) {
            val nodeToInsert = Node(value, None)
            currentNode.next = Some(nodeToInsert)
          } else if (count == index) {
            val nodeToInsert = Node(value, currentNode.next)
            currentNode.next = Some(nodeToInsert)
          } else {
            traverseAndInsert(currentNode.next.get, count + 1)
          }
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




