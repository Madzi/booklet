# Booklet

Booklet is a management system for e-books.

## Project Structure

Put project structure here

- `docs/` - Contains additional documentation
- `src/` - Contains project source files
- `pom.xml` - Configuration for Maven
- `makefile` - Build script for project

## Tech stack

Project build with `Maven` as primary build system
Project provide `makefile` for easy build management
Project use Java 25 as primary target platform
Console application use `picocli` library
Graphical application use `JavaFX` (`openjfx`) as GUI
For bean management and dependency injection used `CDI` (`weld-se` from `jboss`)
Unit tests use `JUnit Jupiter` framework
For interaction with LLM used `langchain4j`
For logging used `slf4j` as frontend and `logback` as backend

## Code Standards

- Use Java 25 modern features like **record**, **switch expression**, **virtual threads**
- Use Java Modular System (`module-info.java` files)
- Place interfaces in exposed packages and implementation of interfaces into sub-package `internal` without exposing

## Usage


Use `make`:

- `make build` - for project build
- `make run` - for project execution
