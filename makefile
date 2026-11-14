# Variables - Default configuration
MVN := ./mvnw
MVN_ARGS ?=
JVM_ARGS ?=

# Default target (runs when you type just 'make')
.DEFAULT_GOAL := help

.PHONY: help
help: ## Display this shelp screen
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-15s\033[0m %s\n", $$1, $$2}'

.PHONY: compile
compile: ## Compile the source code of project
	$(MVN) $(MVN_ARGS) compile

.PHONY: test
test: ## Run tests using Surefire
	$(MVN) $(MVN_ARGS) test

.PHONY: package
package: ## Package the application into a JAR/WAR file
	$(MVN) $(MVN_ARGS) package -DskipTests=true

.PHONY: build
build: ## Clean and build the project with tests
	$(MVN) $(MVN_ARGS) clean verify

.PHONY: run
run: ## Run the project locally
	$(MVN) $(MVN_ARGS) exec:java

.PHONY: clean
clean: ## Remove the target directory and build artifacts
	$(MVN) clean

