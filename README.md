# Booklet

Booklet is a management system for e-books

## Architecture

Project build with `Maven` as primary build system
Project provide `makefile` for easy build management
Project use Java 25 as primary target platform
Console application use `picocli` library
Graphical application use `JavaFX` (`openjfx`) as GUI
For bean management and dependency injection used `CDI` (`weld-se` from `jboss`)
Unit tests use `JUnit Jupiter` framework
For interaction with LLM used `langchain4j`
For logging used `slf4j` as frontend and `logback` as backend

## Quick start

Use `make`:

- `make build` - for project build
- `make run` - for project execution

