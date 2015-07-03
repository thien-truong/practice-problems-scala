package localhost.tt.replacecharacterinstring

class CharacterReplacement {
  def replaceCharacterUsingStringReplaceMethod(stringToBeAltered: String,
                                               characterToBeReplaced: Char,
                                               newCharacter: Char): String = {
    stringToBeAltered.replace('o', 'i')
  }

  def replaceCharacterUsingIteration(stringToBeAltered: String,
                                     characterToBeReplaced: Char,
                                     newCharacter: Char): String = {
    val resultingString = new StringBuilder()
    for (character <- stringToBeAltered) {
      if (character == characterToBeReplaced) {
        resultingString.append(newCharacter)
      } else {
        resultingString.append(character)
      }
    }
    resultingString.toString()
  }

}


