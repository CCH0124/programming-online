package space

type Planet string

const earthPeriodSec float64 = 31557600

var planetAge = map[Planet]float64{
	"Earth":   earthPeriodSec,
	"Mercury": earthPeriodSec * 0.2408467,
	"Venus":   earthPeriodSec * 0.61519726,
	"Mars":    earthPeriodSec * 1.8808158,
	"Jupiter": earthPeriodSec * 11.862615,
	"Saturn":  earthPeriodSec * 29.447498,
	"Uranus":  earthPeriodSec * 84.016846,
	"Neptune": earthPeriodSec * 164.79132,
}

func Age(ageSeconds float64, planet Planet) float64 {
	return ageSeconds / planetAge[planet]
}
