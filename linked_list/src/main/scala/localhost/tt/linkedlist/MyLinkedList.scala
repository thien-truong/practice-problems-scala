package localhost.tt.linkedlist

// a linked list is always initiated with a HEAD
case class MyLinkedList(var head: Option[Node]) {
  def insert(index: Int, value: String): Unit = {
    val nodeToInsert: Node = Node(value, None)
    head = Some(nodeToInsert)
  }
}

object MyLinkedList {
  def apply(elements: String*): MyLinkedList = {
    if (elements.isEmpty) {
      new MyLinkedList(None)
    } else {
      new MyLinkedList(Some(Node(elements(0), None)))
    }
  }
}

