# SNHU Computer Science Portfolio

This repository contains my portfolio projects from the SNHU Computer Science program. Each course includes an artifact and a written reflection that explains the work, the skills demonstrated, and what I learned throughout the development process.

---

## CS210 – Corner Grocer Project

**Artifact:**  
[Corner Grocer Project](CS210/githubCornerGrocer.zip)

**Reflection:**  
For my CS210 portfolio submission, I selected the Corner Grocer project. The goal of this program was to read a text file of grocery items, track how many times each item appeared, and present the results in a user‑friendly way. The project solved the problem of turning raw, unstructured input into organized data that could be searched, displayed, and written back out in a clean format. It also reinforced the importance of building programs that handle real‑world input reliably.

One thing I did particularly well was keeping the code readable and organized. I used clear function names, consistent formatting, and comments that explain the purpose of each major step. This made the program easier to follow and easier to debug. I also handled file input and output carefully, which helped prevent common issues like missing files or incorrect formatting.

There are still areas where I could enhance the code. For example, I could improve efficiency by using more robust data structures, such as unordered maps, to speed up lookups. I could also add stronger input validation and error handling to make the program more secure and resilient. These improvements would help the program scale better and handle unexpected input more gracefully.

The most challenging part of the project was managing the file operations and making sure the program handled all possible edge cases. I overcame this by testing with different input files and reviewing documentation on file streams and data structures. I also relied on online references, class materials, and debugging tools, which I plan to keep using as part of my support network moving forward.

The skills I practiced in this project—working with data structures, file I/O, modular design, and input validation—will transfer well to future coursework and real development work. I made the program maintainable and adaptable by separating logic into functions, keeping the code clean, and writing comments that explain the intent behind each part of the program.

---

## CS230 – Software Design Document (The Gaming Room)

**Artifact:**  
[Software Design Document](CS230/CS%20230%20Project%20Software%20Design.docx)

**Reflection:**  
For this course, I added my completed software design document for *The Gaming Room* to my portfolio. The client wanted to bring their game, *Draw It or Lose It*, to a web‑based environment that could support multiple teams, unique game and team names, and consistent behavior across different operating systems. Their main goal was to expand the game beyond a single‑platform setup and make it scalable, organized, and easy to maintain.

One thing I did well in the design document was breaking down the system into clear sections that explained the requirements, constraints, and recommended architecture. This helped me understand the project more deeply and made the document something a development team could actually use. Working through the design before writing any code was helpful because it forced me to think about structure, data flow, and platform differences early on.

If I were to revise one part of the document, I would expand the recommendations section. I would compare alternative architectural choices in more detail and explain why the chosen approach was the best fit. Adding that level of justification would make the document stronger for future reference.

Interpreting the user’s needs meant focusing on what the client actually wanted the game to do, not just what seemed interesting to build. Translating their goals into clear requirements ensured the design supported the gameplay experience they envisioned. Considering user needs is essential because software that doesn’t solve the user’s problem fails no matter how well it’s built.

My approach to designing the software was to break the problem into smaller pieces, analyze each requirement, and map out how the system should behave. Techniques like identifying constraints, outlining classes, and thinking through platform differences helped shape the final design. In the future, I would continue using this structured approach, but I would also include more diagrams and early prototypes to visualize the system even better.

---

## CS300 – Analysis and Design

**Artifact:**  
[ProjectTwo.cpp](CS300/ProjectTwo.cpp)

**Reflection:**  
For CS300, I developed the Advising Assistance Program, a command‑line application designed to help academic advisors quickly access course information, prerequisites, and a full sorted list of courses in the Computer Science curriculum. The program reads a CSV file of course data, stores it in a hash table for efficient lookup, and provides a menu‑driven interface for interacting with the data.

One of the strengths of this project is the use of a hash table to achieve fast search performance, even as the dataset grows. I also implemented a two‑pass file‑loading system to validate prerequisites and ensure data integrity before inserting anything into the structure. This approach made the program more robust and prevented common issues such as missing or invalid prerequisite references.

I focused heavily on writing clean, readable, and maintainable code. This included adding detailed comments, using meaningful variable names, and organizing the logic into well‑defined functions. I also ensured that the program followed industry best practices by validating user input, handling errors gracefully, and matching the exact output format required by the project rubric.

If I were to continue improving this project, I would consider adding support for additional data fields, expanding the menu options, or creating a graphical interface to make the tool even more user‑friendly. I could also enhance the sorting logic or explore alternative data structures to compare performance.

This project strengthened my skills in algorithm design, data structures, file parsing, and user‑interface logic. It also reinforced the importance of writing code that is both functional and maintainable—qualities that are essential in real‑world software development.

---

