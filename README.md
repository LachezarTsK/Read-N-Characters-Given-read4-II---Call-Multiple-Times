# Read-N-Characters-Given-read4-II---Call-Multiple-Times
Challenge at LeetCode.com. Tags: Data Stream, Simulation.

--------------------------------------------------------------------------------------------------------------------------------------------

As mentioned in the problem statement, read4 API is already defined.<br/>
The API just has to be applied in a way that solves the problem.

This problem is a harder version of “Read N Characters Given Read4” at https://github.com/LachezarTsK/Read-N-Characters-Given-Read4

The difference between “Read N Characters Given Read4” and “Read N Characters Given Read4 II” consists only in the volume of input and it is a clear demonstration that implementing a significant change in volume of input can result in a change of the difficulty of the problem and how it is approached by the solution.

In this case the volume of input is a little bit elusive to define but it is in the form of the number of calls on method “int read(char[] destinationBuffer, int numberOfCharsToRead)”. While the easier version has only one call on this method per test case, the harder version has multiple calls on it per test case.

Calls on method “int read(char[] destinationBuffer, int numberOfCharsToRead)” is not to be confused with calls on method “int read4(char[] buffer4)” defined in the parent class and implemented internally by Leetcode.

In both versions of the problem, on each call of method “int read(char[] destinationBuffer, int numberOfCharsToRead)”, method “int read4(char[] buffer4)” can be called as many times as necessary.
