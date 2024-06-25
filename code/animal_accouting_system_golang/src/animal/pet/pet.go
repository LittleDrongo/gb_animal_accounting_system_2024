package pet

import (
	"aac/src/animal"
	"fmt"
	"time"
)

// Pet структура, встраивающая Animal
type Pet struct {
	animal.Animal // Композиция структуры Animal
	Name          string
	BirthDate     time.Time
	Type          string
	Commands      []string
}

// Новый метод для структуры Pet
func (p Pet) Play() {
	fmt.Printf("Playing")
}

func (p *Pet) AddCommands(commands ...string) {
	p.Commands = append(p.Commands, commands...)
}

func (p *Pet) GiveCommand(command string) {

	if p.HasCommand(command) {
		fmt.Println(p.Name, "выполняет команду:", command)
	} else {
		fmt.Println(p.Name, "не знает команду:", command)
	}
}

func (p *Pet) HasCommand(command string) bool {
	for _, c := range p.Commands {
		if c == command {
			return true
		}
	}
	return false
}
