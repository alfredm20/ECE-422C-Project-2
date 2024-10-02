# ECE-422C-Project-2

The purpose of this assignment is to design and implement an Object-Oriented program with
multiple classes to play a text-based version of the board game called Mastermind. You are free
to use whatever classes and methods from the JAVA library you wish to use.

The version of the game you implement will have the following properties:
• The computer will randomly generate the secret code.
• The player will try to guess the secret code.
• The player has 12 guesses to guess the code correctly. This number should be easily
  changeable by modifying your code.
• If the player does not guess the code correctly in 12 or fewer guesses they lose the game.
• The secret code consists of 4 colored pegs in specific position order.
• The valid colors for the pegs are blue, green, orange, purple, red, and yellow. Capital
  letters will be used in the examples to indicate colors. B for blue, R for red, and so forth.
  The number of colors should be changeable for full credit. The selection of the number of
  colors, like the number of guesses and the number of pegs, should be changeable through
  the provided class GameConfiguration.java, by changing the code and re-building.
• The results of a guess are displayed with black and white pegs. The Wikipedia article
  refers to the results as feedback.
• A black peg indicates one of the pegs in the player's guess is the correct color and in the
  correct position.
• A white peg indicates one of the pegs in the player's guess is the correct color, but is out of
  position.
• A peg in the guess will generate feedback of either: 1 black peg, 1 white peg, or no pegs. A
  single peg in the guess cannot generate more than 1 feedback peg.
• The order of the feedback does not give any information about which pegs in the guess
  generated which feedback pegs. In your feedback, you must give the number of black pegs
  (if any) first, and then the number of white ones, if any.
• The player's guesses must be error checked to ensure that they are of the correct length
  and only contain valid characters.

