# MovieMate

## Project Description

MovieMate is the implementation of a simple backend for a platform dedicated to streaming movies and TV series, similar to services like Netflix or HBO MAX. This project aims to provide a foundational structure for handling user interactions, recommendations, and various actions within the streaming platform.

## Design Pattern

The singleton pattern has been utilized in this project to instantiate the `Database` class. This class contains the entire page hierarchy within a dictionary, with each page associated with its name as the key. This design simplifies navigation between pages and ensures consistency in page management.

## Functionality

The project's code may appear complex, but it offers essential functionality for managing user interactions within the streaming platform. The `Output` class serves as the backbone of the project, while the `DoAction` class implements methods for modifying its instances based on user actions. Additionally, error handling has been integrated to reset errors, current movie lists, and current user information before generic error messages are displayed.

## DoAction

The `DoAction` class iterates through the actions array provided by the input file, executing each action and updating in-memory data accordingly. This class also generates action feedback in the output file, ensuring a seamless user experience.

## Output

The program utilizes an `ArrayNode` called "out" to maintain an elegant JSON format in the output file. The workflow involves instantiating an `ArrayNode`, parsing the actions using `DoAction`, creating nodes for each action, populating these nodes with the latest information from the `Output` class, and adding them to the `ArrayNode`. Finally, in the main program, the `ArrayNode` is written to the output file.

## Program Flow

The program's flow follows a pattern of identifying the type of action, whether it's "on page," "change page," or "database." Specific methods are then chosen to handle each action type, such as changing the current page or applying actions on the database or current page.