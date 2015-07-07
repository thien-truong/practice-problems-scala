package localhost.tt.linkedlist

// a linked list is always initiated with a HEAD
case class MyLinkedList(var head: Option[Node]) {

  def insert(index: Int, value: String): Unit = {

//    if (head.isEmpty) {
//      head = Some(Node(value, None))
//    } else {
//      head = this.head
//      var currentNode: Node = head.get
//      for (numberOfElement <- 0 until index) {
//        currentNode = currentNode.next.get
//        if (currentNode.next == None) {
//          var nodeToInsert: Node = Node(value, None)
//          currentNode = nodeToInsert
//        }
//      }
//    }

    head match {
      case Some(head) =>
        var currentNode: Node = head
        traverseAndInsert(currentNode)
//        if (currentNode.next == None) {
//          var nodeToInsert = Node(value, None)
//          currentNode.next = Some(nodeToInsert)
//        } else {
//          currentNode = currentNode.next.get
//          if (currentNode.next == None) {
//            var nodeToInsert = Node(value, None)
//            currentNode.next = Some(nodeToInsert)
//          }
//        }
        def traverseAndInsert(currentNode: Node): Unit = {
          if (currentNode.next == None) {
            var nodeToInsert = Node(value, None)
            currentNode.next = Some(nodeToInsert)
          } else {
            traverseAndInsert(currentNode.next.get)
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




