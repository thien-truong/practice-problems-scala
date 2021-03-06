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

    it("inserts an element into the middle of a list") {
      val linkedList = MyLinkedList("a", "b", "c")
      val expectedLinkedList = MyLinkedList("a", "b", "d", "c")
      linkedList.insert(2, "d")
      linkedList shouldBe expectedLinkedList
    }

    it("inserts an element into the beginning of a list") {
      val linkedList = MyLinkedList("a", "b", "c")
      val expectedLinkedList = MyLinkedList("d", "a", "b", "c")
      linkedList.insert(0, "d")
      linkedList shouldBe expectedLinkedList
    }

    it("throws an exception if the element to be inserted is out of bounds") {
      val linkedList = MyLinkedList("a", "b")
      intercept[IllegalArgumentException] {
        linkedList.insert(3, "c")
      }
    }

    it("removes an element at an index when the list has one element") {
      val linkedList = MyLinkedList("a")
      val expectedLinkedList = MyLinkedList()
      linkedList.remove(0)
      linkedList shouldBe expectedLinkedList
    }


  }
}
