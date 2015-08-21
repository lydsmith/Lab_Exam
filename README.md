# Lab_Exam
Three questions answered for the 'lab exam' 

Advanced Programming (M)

Question 1:

You are to write a simple higher/lower game. The GUI for the game consists of a text field, a
submit button and two labels the countdown label and the response label. The behaviour of the game is as follows.
•The game generates a random integer between 0 and 50.
•The player enters a guess of the value of the integer and clicks the submit button.
•The game checks the entered value of the integer and reports whether the guess is higher, lower, or equal to the game’s value in one of the labels.
•As the game progresses, a countdown in one of the labels decreases every second. The countdown timer starts at 30 seconds.
•The game is over when the user guesses the number correctly, or the countdown reaches zero.
•When the game is over, a message is displayed in the console either telling the player they failed (if the countdown has reached zero) or congratulating them on their win (and reporting how long it took) if they guessed correctly.
Implement this game in Java. We suggest that you implement each aspect of the behaviour described above in turn, testing it to make sure it works. Note the following points:
•You are expected to ensure that your GUI remains responsive at all times.
•You are expected to adhere to the thread safety rules of Swing.
•Your GUI should be as simple as possible– don’t waste time making it beautiful in any way.



QUESTION 2

The aim of this question is to implement a client/server system. The server adds or subtracts integers. The client sends a string to the server, consisting of either two integers and a ‘+’ sign separated by commas (e.g. ‘5,3,+’) or two integers and a ‘-‘ sign (e.g. ‘5,3,-‘)and the server responds by sending the resulting integer as a string. Within a single session, the server should allow repeated interaction, until the client sends a special message indicating that the session should terminate.
(a)Designa suitable protocol for this system. The protocol will probablyneed to include additional
messages, as well as the strings described above.
(b)Implement a single-threaded server, and a client that tests it.Include a clear description of yourprotocol as comments in both the client and the server code. Your test client should use both options of the server at least once, and then terminate the session. You do not need to implement error handling

QUESTION 3


This question considers a model of a disk filing system. A resource is either a document or a folder.
A document has a name, and a size in bytes. A folder has a name and contains a collection of
resources. The whole filing system itself is represented as a folder.
(a)
Using the Composite pattern, give Java definitions to represent the structure of the
filing system.
(b)Use the Composite pattern to implement the following operations.
  (i)Print on standard output the contents of a resource, i.e. the names and contents of all resources within it. Use indentation to show the structure, for example:
MyDocument
TestDocument
Folder: MyFolder containing:
  AnotherDocument
  AgainAnotherDocument
    Folder: AnotherFolder containing:
      MoreWork
    Folder: AnotherFolder containing:
      BigDocument
      LittleDocument
      LastDocument
      
(ii) Calculate the total size of a resource, in bytes. The size of a folder is the sum of the sizes of all the resources within it.
(iii) Calculate the total number of documents within a resource.

