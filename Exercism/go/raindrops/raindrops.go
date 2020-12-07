package raindrops

import "strconv"

var primes = []struct {
	input    int
	expected string
}{
	{input: 3, expected: "Pling"},
	{input: 5, expected: "Plang"},
	{input: 7, expected: "Plong"},
}

// Convert determine if it is "raindrops".
func Convert(num int) string {
	var res string
	for _, v := range primes {
		if num%v.input == 0 {
			res += v.expected
		}
	}
	if res == "" {
		return strconv.Itoa(num)
	}

	return res
}
