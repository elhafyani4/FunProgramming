#include <string>;

using namespace std;

class Problem168 {
public:
    string convertToTitle(int columnNumber) {
       std:string result = "";
        while (columnNumber > 0)
        {
            if (columnNumber > 26)
            {
                short temp = columnNumber % 26;
                char c = (char)64;
                if (temp == 0)
                {
                    temp = 26;
                }
                char t = c + (char)temp;
                result = t + result;
                columnNumber = (columnNumber -  temp)/26;
                continue;
            }

            char c = (char)64;
            char t = c + (char)columnNumber;
            result = t + result;
            columnNumber = 0;
        }

        return result;
    }
};