1. Explain how you structured and implemented the Menu class, could you make it somewhat 
independent from the application code and easy to reuse?

The menu class is responsible for most of the functionality in the assignment. It renders all the output for the user, calls other classes, handles input, and sends data around the project. 
I started by constructing the menu, printing it, and then
managing the user's choice to decide which method to be used.
Was a bit hard to understand in the beginning, but i found this
way more intuitive after a while. Having most classes serving
as "skeletons" for the menu class to build on top of them
was fairly nice. With this it should be easy enough to adjust
and change things in a reasonable way.


2. Elaborate on how hard/easy it was to follow the class diagram.

This was the hardest part, following the diagram sort of helped
making the assignment harder to understand than what it actually
is. Pseudo-code and diagrams still leave a gap between the
language and what the code should be, and UML doesn't help as
much with that. The icons and arrows used to determine what is
what are a bit unecessary, i would much rather have it explicitly
say whats being asked.


3. Do you understand the concept of "dependency injection" and did you use it in your application, if so, explain how you used it?




4. Elaborate on what you find the most challenging parts with this task?

Getting started took a while. Comprehending the problem and
the guidance was a bit confusing, and the synthax in Java still
feels like dark magic. Keeping a mental track of how inputs
are being thrown around all the methods and classes is the hardest. I struggled figuring out how all the files were going to interact with each other.

5. What are your thoughts on writing comments like JavaDocs?

It is a bit verbose, but very useful. Sometimes it takes a while to know what to write in the comments without making it redundant but it is definitively a nice tool to use in developing.

6. Did you do the optional part, if so, elaborate on how you solved each of the optional parts.


7. What is your TIL?

Today i learned how to utilize classes, grab their functionalities, use it somewhere else in the codebase. Also practiced a fair bit of Java synthax and how to write more "Java-y" Java code.