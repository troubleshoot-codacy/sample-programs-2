#include <cstring>
#include <iostream>
#include <vector>

void swap(int *xp, int *yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}

void bubbleSort(std::vector<int> &v, int n)
{
    int i, j;
    bool swapped;

    for (i = 0; i < n - 1; i++)
    {
        swapped = false;

        for (j = 0; j < n - i - 1; j++)
        {
            if (v[j] > v[j + 1])
            {
                swap(&v[j], &v[j + 1]);
                swapped = true;
            }
        }

        if (swapped == false)
        {
            break;
        }
    }
}

void print(std::vector<int> v, int size)
{
    for (int i = 0; i < size; i++)
        if (i == size - 1)
        {
            std::cout << v[i] << std::endl;
        }
        else
        {
            std::cout << v[i] << ", ";
        }
}

int main(int argc, char *argv[])
{
    // Validate arguments
    if (argc != 2 || argv[1] == nullptr)
    {
        std::cout << "Usage: please provide a list of at least two integers to "
                     "sort in the format \"1, 2, 3, 4, 5\""
                  << std::endl;
        return 1;
    }

    char *characters = argv[1];
    bool commaSeparated = false;
    int index = 1;
    std::vector<int> numbers;
    
    // Store string length once to avoid multiple strlen calls
    size_t characters_len = strlen(characters);

    // Validate that we have at least some input
    if (characters_len == 0)
    {
        std::cout << "Usage: please provide a list of at least two integers to "
                     "sort in the format \"1, 2, 3, 4, 5\""
                  << std::endl;
        return 1;
    }

    while (index < characters_len)
    {
        // Add bounds check to prevent buffer over-read
        if (characters[index] == ',' && index + 1 < characters_len && characters[index + 1] == ' ')
        {
            commaSeparated = true;
        }
        else
        {
            commaSeparated = false;
            break;
        }
        index += 3;
    }

    if (commaSeparated == true)
    {
        for (size_t i = 0; i < characters_len; i++)
        {
            if (characters[i] != ',' && characters[i] != ' ')
            {
                numbers.push_back(atoi(&characters[i]));
            }
        }
    }

    int size = numbers.size();
    if (size < 2)
    {
        std::cout << "Usage: please provide a list of at least two integers to "
                     "sort in the format \"1, 2, 3, 4, 5\""
                  << std::endl;
    }
    else
    {
        bubbleSort(numbers, size);
        print(numbers, size);
    }
    return 0;
}
