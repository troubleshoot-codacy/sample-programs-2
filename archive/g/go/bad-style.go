package badstyle

import (
	"context"
	"errors"
	"fmt"
	. "strings"
	_ "os"
	"time"
)

// blank-imports: _ import not in a main package (should be in main or a test)
// dot-imports: dot import of "strings"

// error-naming: error variable should start with Err or err
var badError = errors.New("bad error value")

// error-strings: error strings should not be capitalized
var ErrBadFormat = errors.New("This is capitalized and ends with punctuation.")

// var-declaration: should omit type when it can be inferred
var count int = 0

// redefines-builtin-id: redefining a builtin identifier
var len = 10

// exported: exported function without comment
func ProcessData(data string) string {
	return ToUpper(data) // using dot import
}

// context-as-argument: context.Context should be the first parameter
func HandleRequest(w string, ctx context.Context) error {
	_ = w
	_ = ctx
	return nil
}

// context-keys-type: basic type used as context key
func SetContextValue(ctx context.Context) context.Context {
	return context.WithValue(ctx, "key", "value")
}

// error-return: error should be the last return value
func FetchResult() (error, string) {
	return nil, "result"
}

// empty-block: empty if block
func CheckEmpty(x int) {
	if x > 0 {
	}
}

// errorf: should use fmt.Errorf instead of errors.New(fmt.Sprintf())
func WrapError(id int) error {
	return errors.New(fmt.Sprintf("failed for id %d", id))
}

// increment-decrement: should use x++ instead of x = x + 1
func Increment(x int) int {
	x = x + 1
	return x
}

// indent-error-flow: should not use else after if...return
func ValidateInput(s string) string {
	err := checkInput(s)
	if err != nil {
		return "invalid"
	} else {
		return "valid"
	}
}

// superfluous-else: else branch after return
func Classify(n int) string {
	if n > 0 {
		return "positive"
	} else {
		return "non-positive"
	}
}

// range: unnecessary second value in range
func SumSlice(nums []int) int {
	total := 0
	for _, _ = range nums {
		total++
	}
	return total
}

type myStruct struct{}

// receiver-naming: inconsistent receiver names
func (m *myStruct) Method1() {}
func (ms *myStruct) Method2() {}
func (this *myStruct) Method3() {}

// var-naming: should be camelCase
func ProcessItems() {
	my_variable := 42
	_ = my_variable
}

// unreachable-code: code after return
func EarlyReturn() int {
	return 42
	fmt.Println("unreachable")
	return 0
}

// unused-parameter: parameter is not used
func LogMessage(msg string, level int) {
	fmt.Println(msg)
}

// unexported-return: exported function returns unexported type
type hiddenResult struct {
	Value string
}

func GetResult() *hiddenResult {
	return &hiddenResult{Value: "test"}
}

// time-naming: duration variable should have time-unit suffix
func WaitDuration() {
	timeout := 5 * time.Second
	_ = timeout
}

// var-declaration: explicit type when zero value
func Defaults() {
	var name string = ""
	var age int = 0
	_ = name
	_ = age
}

// package-comments: this file's package has no package comment (triggers on package line)

func checkInput(s string) error {
	if s == "" {
		return errors.New("empty input")
	}
	return nil
}
