function fibonacci(num: number) {

  let n = Number(num);
  let elementOne = 0;
  let elementTwo = 1;
  let result = 0;

  for (let i = 1; i <= n; i++) {
    result = elementOne + elementTwo;
    elementOne = elementTwo;
    elementTwo = result;
    console.log(`Index: ${i}: ${elementOne}`);
  }

}

fibonacci(process.argv[2]);
