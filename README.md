# Balance Transactions Program

## Description
The task for this school assignment was to write a Java program that processes daily transactions for a store owner. Each transaction includes an invoice number, the cash amount, and a letter indicating whether the amount was paid ("P") or received ("R").

The program performs the following tasks:
- Prompts the store owner for the starting cash amount, ending cash amount, and the name of the ledger file.
- Reads the transactions from the provided transactions.txt file.
- Validates the file format and calculates if the actual cash at the end of the day matches the expected amount.
- Handles errors gracefully:
    - If the transactions file is invalid, the user is allowed to choose another file.
    - If the transactions within the file are invalid, the program informs the user and terminates.

## What I Learned
In this week's lesson, I learned about using multiple exception handlers, which was a completely new concept for me. Prior to this, I didn't realize it was possible to have multiple catch blocks within a single try block. This was especially helpful because it enables handling different types of exceptions separately, depending on the error encountered.

For example, if a program is expecting an integer input and the user enters a string, an InputMismatchException could be caught to notify the user of invalid input. However, if the input is out of a specified range, a more general Exception could be caught to prompt the user to re-enter a valid value.