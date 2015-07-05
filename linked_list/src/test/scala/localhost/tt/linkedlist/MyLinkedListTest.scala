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
  }
}
