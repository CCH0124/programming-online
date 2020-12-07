package hamming

import "errors"

// Distance is Calculate string distance
func Distance(a, b string) (int, error) {
	if len(a) != len(b) {
		return 0, errors.New("different length")
	}
	aChars := []rune(a)
	bChars := []rune(b)
	distance := 0
	for i := range aChars {
		if aChars[i] != bChars[i] {
			distance++
		}
	}

	return distance, nil
}
