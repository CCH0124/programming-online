// This is a "stub" file.  It's a little start on your solution.
// It's not a complete solution though; you have to write some code.

// Package proverb should have a package comment that summarizes what it's about.
// https://golang.org/doc/effective_go.html#commentary
package proverb

import "fmt"

// Proverb should have a comment documenting it.
func Proverb(rhyme []string) []string {
	result := []string{}
	for i := 1; i <= len(rhyme); i++ {
		if i == len(rhyme) {
			result = append(result, fmt.Sprintf("And all for the want of a %s.", rhyme[0]))
		} else {
			result = append(result, fmt.Sprintf("For want of a %s the %s was lost.", rhyme[i-1], rhyme[i]))
		}
	}
	return result
}
