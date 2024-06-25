package dog

import (
	"aac/src/animal/pet"
	"time"
)

type Dog struct {
	pet.Pet
}

func NewDog(name string, birthDate time.Time) Dog {
	return Dog{
		Pet: pet.Pet{
			Name:      name,
			BirthDate: birthDate,
			Type:      "Dog",
		},
	}
}
