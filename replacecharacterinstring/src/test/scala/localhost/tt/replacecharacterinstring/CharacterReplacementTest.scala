package localhost.tt.replacecharacterinstring

import org.scalatest.{FunSpec, Matchers}

class CharacterReplacementTest extends FunSpec with Matchers {
  describe("CharacterReplacement") {
    it("replaces all occurrences of a character with another character in a string using String's replace method") {
      val characterReplacement = new CharacterReplacement()
      val expectedString: String = "Helli, I'm a miise"
      val resultingString: String =
        characterReplacement.replaceCharacterUsingStringReplaceMethod("Hello, I'm a moose", 'o', 'i')
      resultingString shouldBe expectedString
    }

    it("replaces all occurrences of a character with another character in a string using iteration") {
      val characterReplacement = new CharacterReplacement()
      val expectedString: String = "Bunbter hab 3 toeb"
      val resultingString: String =
        characterReplacement.replaceCharacterUsingIteration("Bunster has 3 toes", 's', 'b')
      resultingString shouldBe expectedString
    }

    it("replaces all occurrences of a character with another character in a string using collection pipeline") {
      val characterReplacement = new CharacterReplacement()
      val expectedString: String = "Funky bunvee jumpinv"
      val resultingString: String =
        characterReplacement.replaceCharacterUsingCollectionPipeline("Funky bungee jumping", 'g', 'v')
      resultingString shouldBe expectedString
    }

  }
}
