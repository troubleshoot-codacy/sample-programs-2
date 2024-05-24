const myStr = "hello world";

const capitalize = (str = "no input was provided") => str[0].toUpperCase() + str.slice(1);

console.log(capitalize(myStr));