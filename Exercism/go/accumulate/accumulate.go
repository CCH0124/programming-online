package accumulate

func Accumulate(s []string, converter func(string) string) []string {
	length := len(s)
	result := make([]string, length, length)
	for i, r := range s {
		result[i] = converter(r)
	}
	return result
}
