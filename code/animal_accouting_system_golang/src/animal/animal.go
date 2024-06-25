package animal

import (
	"fmt"
)

type Animal struct {
	Name string
	Type string
}

// Метод Speak для структуры Animal
func (a Animal) Speak() {
	fmt.Printf("Animal %s makes a sound.\n", a.Name)
}

// Метод Eat для структуры Animal
func (a Animal) Eat() {
	fmt.Printf("Animal %s is eating.\n", a)
}

func (a Animal) String() string {
	str := fmt.Sprintf("%T", a)
	return str
}
