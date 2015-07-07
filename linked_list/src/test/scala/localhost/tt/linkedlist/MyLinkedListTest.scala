package localhost.tt.linkedlist

import org.scalatest.{Matchers, FunSpec}

class MyLinkedListTest extends FunSpec with Matchers {
  describe("LinkedList") {
    it("inserts an element into an empty list") {
      val linkedList = MyLinkedList()
      val expectedLinkedList = MyLinkedList("a")
      linkedList.insert(0, "a")
      linkedList shouldBe expectedLinkedList
    }

    it("inserts an element into the end of a list with 1 elements") {
      val linkedList = MyLinkedList("a")
      val expectedLinkedList = MyLinkedList("a", "b")
      linkedList.insert(1, "b")
      linkedList shouldBe expectedLinkedList
    }

    it("inserts an element into the end of a list with 2 elements") {
      val linkedList = MyLinkedList("a", "b")
      val expectedLinkedList = MyLinkedList("a", "b", "c")
      linkedList.insert(2, "c")
      linkedList shouldBe expectedLinkedList
    }
  }
}
