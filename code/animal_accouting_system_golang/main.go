package main

import (
	"aac/src/animal/pet/dog"
	"time"
)

func main() {
	dog := dog.NewDog("Бобик", time.Now())
	dog.Eat()

	dog.AddCommands("сидеть", "лежать", "стоять")

	// jsn.ColorPrint(dog)
	dog.GiveCommand("летать")

}
