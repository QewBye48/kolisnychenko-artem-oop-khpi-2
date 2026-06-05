# Requirements

## General

- Java 21
- Maven project
- Test framework: JUnit Jupiter
- Project branch: `lab11`
- Topic: Collections Framework in Java
- Variant: 5 — game profile

## Domain model

The project implements a simple game profile system.

Main classes:

- `Player` — represents a game player
- `GameItem` — represents an item in the player's inventory
- `Achievement` — represents a player's achievement
- `GameProfileService` — manages the player's profile data
- `Main` — demonstrates program execution

## Collections used

Standard Java collections used in the project:

- `List<GameItem>`
- `Set<Achievement>`
- `Map<String, String>`

## Collection roles

- `List<GameItem>` stores player items in the order they were added.
- `Set<Achievement>` stores unique achievements and prevents duplicates.
- `Map<String, String>` is used in `Main` to demonstrate key-value storage and iteration through `entrySet()`.

## Functional requirements

The program must support:

- creating a player profile
- adding game items
- finding an item by name
- removing an item by name
- adding achievements
- preventing duplicate achievements
- viewing all items
- viewing all achievements
- showing full player profile information
- demonstrating iteration through collections

## Service requirements

`GameProfileService` must provide methods for:

- adding an item
- finding an item by name
- removing an item by name
- adding an achievement
- checking if an achievement exists
- getting all items
- getting all achievements
- getting item count
- getting achievement count
- showing profile information

## Testing requirements

Unit tests must check:

- adding items
- finding items
- removing items
- adding achievements
- duplicate achievement handling
- profile text generation
- successful execution of `Main`

## Expected result

The program should demonstrate the use of Java Collections Framework in a game profile system.

The result should show:

- player information
- list of game items
- set of unique achievements
- item search result
- item removal result
- explanation of used collections