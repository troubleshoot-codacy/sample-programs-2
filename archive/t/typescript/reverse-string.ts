let myString = "Hello World";

const reverse = ( str = "no string was provided" ) => str.split("").reverse().join("");

console.log(reverse(myString));
