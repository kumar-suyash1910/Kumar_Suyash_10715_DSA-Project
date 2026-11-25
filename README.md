Daily Expense Analyzer
A simple Java console application that helps you keep track of your
daily spending. You can add expenses, view all saved expenses, sort them
by amount, search by category, and check your total and highest expense.

The project is made to show how basic Data Structures and Algorithms
(DSA) concepts can be used to solve a real-life problem.
About the Project
It is easy to forget small daily expenses such as food, travel, study
materials, and bills. These small amounts can add up over time.

The Daily Expense Analyzer gives you a simple way to record those
expenses and understand where your money is going. It uses an
ArrayList to store expense records, selection sort to arrange expenses
from highest to lowest, and linear search to find expenses by category.

Your records are saved in a text file, so they are still available the
next time you run the program.
Project Information
- Project name: Daily Expense Analyzer
- Language: Java
- Project type: Console-based application
- Main concepts: ArrayList, objects, sorting, searching, file
  handling, and input validation
- Recommended JDK: JDK 21
- Data file: expenses.txt
Features
1. Add an expense -- Enter a category and amount to save a new
   expense.
2. Display all expenses -- View all the expenses stored in the
   program.
3. Sort expenses -- Arrange expenses from highest amount to lowest
   amount.
4. Search by category -- Find expenses by entering a category, such
   as Food or Travel.
5. View total and highest expense -- See how much you have spent in
   total and which expense has the highest amount.
6. Save your data -- Store expenses in expenses.txt and load them
   again when the program starts.
7. Validate input -- Reject non-numeric, zero, and negative
   amounts.
Technologies and Concepts Used
  Technology / Concept                How it is used
  Java                                Main programming language

  ArrayList                         Stores the list of expense objects

  Classes and objects                 Represents each expense and manages
the application

  Selection sort                      Sorts expenses by amount in
descending order

  Linear search                       Searches for expenses by category

  File handling                       Reads from and writes to
expenses.txt

  Scanner                           Takes input from the user
Input validation                    Handles invalid menu choices and
expense amounts
How the Program Is Organized
The project is designed around three classes, each with a clear
responsibility:
1. DailyExpenseAnalyzer
This is the main class. It: - Displays the menu. - Takes input from the
user using Scanner. - Checks whether the entered amount is valid. -
Calls the required operation based on the user's menu choice.
2. ExpenseManager
This class manages the expense records. It: - Maintains the ArrayList
of expenses. - Adds and displays expenses. - Sorts expenses by amount. -
Searches for expenses by category. - Calculates the total and highest
expense. - Loads records from and saves records to expenses.txt.
3. Expense
This class represents one expense. Each expense contains: - ID: A
unique ID, starting from X101. - Category: The type of expense,
such as Food or Travel. - Amount: The amount spent.
How It Works
1. When the program starts, it creates an ArrayList.
2. It checks for expenses.txt and loads the saved records, if the
   file exists.
3. It displays the menu and asks the user to choose an operation.
4. It validates the input and performs the selected operation.
5. It displays the result or an error message.
6. The menu appears again until the user selects Exit.
7. When the program exits, all expense records are saved to
   expenses.txt.
If the file does not exist or is empty, the first expense gets the ID
X101. After that, the next ID continues from the highest saved ID.
Data Storage
Expenses are stored in a simple text file named expenses.txt.

Each line follows this format:
ID,Category,Amount
For example:
X101,Food,250
X102,Travel,400
When the application starts, it reads these lines and creates expense
objects. When the application exits, it writes the current records back
to the file.
Sorting and Searching
Sorting -- Selection Sort
The project uses selection sort to arrange expenses from highest
amount to lowest amount.

For example, if the amounts are:
250, 120, 400, 300
The sorted result is:
400, 300, 250, 120
The program uses its own loops and swapping logic instead of a built-in
sorting method. Selection sort takes O(n²) time.
Searching -- Linear Search
The program uses linear search to find expenses by category. It
checks the stored expenses one by one until it finds a matching
category.

For example, searching for Food displays the matching Food expense
records. Linear search takes O(n) time.
Time Complexity
Here, n means the number of expenses stored in the application.

  Operation                             Time complexity
  Add an expense at the end             O(1) on average
Display all expenses                  O(n)
Search by category                    O(n)
Calculate total and highest expense   O(n)
Load or save the file                 O(n)
Sort using selection sort             O(n²)
Space used to store expenses          O(n)
Requirements
- Java Development Kit (JDK) 21 is recommended.
- At least 4 GB RAM.
- Any Java IDE, such as IntelliJ IDEA, Eclipse, or Visual Studio Code.
- A terminal or command prompt.
The project uses Java's standard libraries, including java.util and
java.io. No external libraries or database are required.
How to Run
1. Make sure Java is installed.
2. Open the project folder in your IDE or terminal.
3. Compile the Java source file. Replace DailyExpenseAnalyzer.java
   below with the actual filename if it is different.
javac DailyExpenseAnalyzer.java
4. Run the compiled program:
java DailyExpenseAnalyzer
5. Follow the menu displayed on the screen.
Note: The presentation describes the application as a single Java
source file, but it also describes three classes. Those classes may be
written in the same .java file. The exact source filename should match
the file in your project.
Example Test Scenarios
These are the test scenarios described for the project:
Test 1 -- Add a normal expense
- Choose Add Expense.
- Enter category Food.
- Enter amount 250.
- Expected result: the expense is added with ID X101.
Test 2 -- Check total and highest expense
- Keep one expense: X101 | Food | 250.
- Choose Total Expense.
- Expected result: total is 250 and the highest expense is Food
  (250).
Test 3 -- Enter an invalid amount
- Choose Add Expense.
- Enter category Travel.
- Enter amount abc.
- Expected result: the program displays an invalid amount message and
  asks for a number.
Test 4 -- Add, sort, and search
- Start with X101 | Food | 250.
- Add Travel with amount 400.
- Expected new ID: X102.
- Sort by amount: Travel (400) appears before Food (250).
- Search for Food: the program finds X101 | Food | 250.
Current Scope and Limitations
This is the first version of the project. It focuses on the main DSA
concepts and basic expense tracking.

The current version does not include: - A graphical user
interface. - A database. - User login. - Online payments. - Editing or
deleting existing expenses. - AI/ML features or charts.
Future Improvements
Some features that could be added in a future version are:
- Edit or delete an existing expense.
- Save the date and a short description for each expense.
- Generate monthly and yearly expense reports.
- Use a faster sorting algorithm, such as merge sort.
- Store records in a database.
- Build a graphical user interface.
These are ideas for future development and are not part of the current
version.
Project Schedule
The planned development schedule is:

  Work                                 Planned time
  Planning and design                  Day 1
Expense class and ArrayList          Days 2--3
Sorting and searching                Days 3--5
File handling and input validation   Days 4--5
Testing and fixes                    Days 5--6
Documentation and GitHub upload      Days 6--7
Author
Kumar Suyash
B.Tech CSE with Google
Rungta International Skills University, Bhilai
ERP ID: RU-25-10715
Session: 2026--27

Project Guide: Mr. Abhijit Dutta
References
- Cormen, Leiserson, Rivest, and Stein, Introduction to Algorithms,
  4th edition, MIT Press, 2022.
- Sedgewick and Wayne, Algorithms, 4th edition, Addison-Wesley,
  2011.
- Oracle Java Documentation
- Java SE 21 API
  Specification
Thanks for checking out the Daily Expense Analyzer!
