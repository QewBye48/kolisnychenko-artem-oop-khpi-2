# Requirements

## General

- Java 21
- Maven project
- Test framework: JUnit Jupiter
- Topic: Stream API in Java
- Variant: 5 — media library

## Domain model

The project implements a simple media library system.

Main classes:

- `Movie` — represents a movie
- `Episode` — represents a podcast episode
- `Podcast` — represents a podcast with a list of episodes
- `MediaLibrary` — provides stream-based data processing
- `Main` — demonstrates program execution

## Functional requirements

The program must support:

- creating a collection of movies
- creating a collection of podcasts
- filtering movies by genre
- getting movie titles sorted by rating
- counting movies by genre
- grouping movies by genre
- calculating average movie rating
- finding the longest movie
- getting all episode titles from all podcasts
- building a text report about movies
- comparing imperative and Stream API approaches

## Stream API requirements

The project must demonstrate the following Stream API operations:

- `filter()` — filtering movies by genre
- `map()` — transforming objects into titles
- `sorted()` — sorting movies by rating
- `count()` — counting elements
- `toList()` — collecting results into a list
- `collect()` — collecting results using collectors
- `groupingBy()` — grouping movies by genre
- `flatMap()` — getting episodes from all podcasts
- `max()` — finding the longest movie
- `joining()` — building a text report

## Service requirements

`MediaLibrary` must provide methods for:

- getting all movies
- getting all podcasts
- finding movies by genre
- getting movie titles sorted by rating
- getting top movies by rating
- counting movies by genre
- grouping movies by genre
- counting movies by genres
- calculating average movie rating
- finding the longest movie
- getting podcast titles
- getting all episode titles
- counting episodes by podcast
- building a movie report
- filtering movies by genre using an imperative loop

## Testing requirements

Unit tests must check:

- filtering movies by genre
- sorting movie titles by rating
- counting movies by genre
- grouping movies by genre
- calculating average rating
- finding the longest movie
- getting all episode titles
- building a movie report
- comparing imperative and Stream API results
- successful execution of `Main`

## Expected result

The program should demonstrate the use of Stream API for processing media library data.

The result should show:

- total number of movies
- movies filtered by genre
- movie titles sorted by rating
- movie count by genre
- grouped movies by genre
- average movie rating
- longest movie
- all podcast episode titles
- generated movie report
- comparison of loop-based and Stream API processing