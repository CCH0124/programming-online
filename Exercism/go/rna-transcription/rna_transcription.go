package strand

var dNAToRNA = map[string]string{
	"G": "C",
	"C": "G",
	"T": "A",
	"A": "U",
}

func ToRNA(dna string) string {
	result := ""
	if dna == "" {
		return result
	}
	if len(dna) == 1 {
		return dNAToRNA[dna]
	}

	for _, ch := range dna {
		result += dNAToRNA[string(ch)]
	}

	return result
}
