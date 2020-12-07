// This is a "stub" file.  It's a little start on your solution.
// It's not a complete solution though; you have to write some code.

// Package triangle should have a package comment that summarizes what it's about.
// https://golang.org/doc/effective_go.html#commentary
package triangle

import "math"

// Notice KindFromSides() returns this type. Pick a suitable data type.
type Kind int

const (
	NaT Kind = iota
	Equ
	Iso
	Sca
)

// KindFromSides should have a comment documenting it.
func KindFromSides(a, b, c float64) Kind {
	if !((a+b >= c) && (b+c >= a) && (a+c >= b) && isSideVaild(a) && isSideVaild(b) && isSideVaild(c)) {
		return NaT
	} else {
		if isEqu(a, b, c) {
			return Equ
		} else if isIso(a, b, c) {
			return Iso
		} else if isSca(a, b, c) {
			return Sca
		}
	}
	return NaT
}

func isEqu(a, b, c float64) bool {
	return (a == b) && (a == c) && (b == c)
}

func isIso(a, b, c float64) bool {
	return (a == b) || (b == c) || (c == a)
}

func isSca(a, b, c float64) bool {
	return (a != b) && (a != c) && (b != c)
}

func isSideVaild(side float64) bool {
	return side > 0 && !math.IsNaN(side) && !math.IsInf(side, 1)
}
