#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>

/**
 * Prints error message and exits the program
 */
void error() {
    printf("Usage: please provide a string\n");
    exit(0);
}

/**
 * Finds the length of the longest word in a given string
 * Words are separated by spaces, commas, newlines, or tabs
 */
int main(int argc, char *argv[]) {
    if (argc < 2) {
        error();
    }  


    if (argv[1] == NULL) {
        error();
    } 
    
    size_t input_len = strnlen(argv[1], INT_MAX);
    if (input_len <= 0) {
        error();
    } 

 /// The maximum length of a word is initialized to -1
    
 /// edit 


    // Initialize max length to -1 to handle cases with no valid words    
    // This allows us to return 0 if no words are found 
    // and avoids confusion with a valid word of length 0
    
     
    int max = -1;
    char* word = strtok(argv[1], " ,\n\t");
     
    if (word == NULL) {
        error();
    }
    
    while (word != NULL) {
        size_t len = strnlen(word, INT_MAX);
        if (len > (size_t)max) {
            max = (int)len;
        }
        word = strtok(NULL, " ,\n\t");
    }

    printf("%d", max);
    return 0;
}
