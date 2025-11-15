
using System;

/**
 * ----- Comment from Leetcode ----- 
 *
 * The Read4 API is defined in the parent class Reader4.
 *     int Read4(char[] buf4);
 */

public class Solution : Reader4
{
    private static readonly int MAX_READ_CHARS_PER_CALL_OF_READ4 = 4;
    private readonly char[] bufferRead4 = new char[MAX_READ_CHARS_PER_CALL_OF_READ4];

    private int indexInBufferRead4;
    private int numberCharsInBufferRead4;

    public int Read(char[] destinationBuffer, int numberOfCharsToRead)
    {
        int indexInDestinationBuffer = 0;
        int numberOfCharsSentToDestinationBuffer = 0;

        while (numberOfCharsToRead > 0)
        {
            while (numberCharsInBufferRead4 > 0 && numberOfCharsToRead > 0)
            {
                destinationBuffer[indexInDestinationBuffer] = bufferRead4[indexInBufferRead4];

                ++indexInBufferRead4;
                ++indexInDestinationBuffer;
                ++numberOfCharsSentToDestinationBuffer;

                --numberOfCharsToRead;
                --numberCharsInBufferRead4;
            }

            if (numberCharsInBufferRead4 == 0)
            {
                indexInBufferRead4 = 0;
            }
            if (numberOfCharsToRead > 0)
            {
                numberCharsInBufferRead4 = Read4(bufferRead4);
            }
            if (numberCharsInBufferRead4 == 0)
            {
                break;
            }
        }

        return numberOfCharsSentToDestinationBuffer;
    }
}
