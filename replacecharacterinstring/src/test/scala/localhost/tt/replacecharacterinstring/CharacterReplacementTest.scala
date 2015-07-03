package localhost.tt.replacecharacterinstring

import org.scalatest.{FunSpec, Matchers}

class CharacterReplacementTest extends FunSpec with Matchers{
  describe("CharacterReplacement") {
    it("replaces all occurrences of a character with another character in a string") {
      val characterReplacement = new CharacterReplacement()
      val expectedString: String = "Helli, I'm a miise"
      val resultingString: String =
        characterReplacement.replaceCharacterUsingStringReplaceMethod("Hello, I'm a moose", 'o', 'i')
      resultingString shouldBe expectedString
    }
  }
}
