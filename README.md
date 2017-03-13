# ClojureBridge NYC: Syllabus
# Advanced Track - Instructors' Notes

## Course Description

This course is for individuals with coding experience seeking to translate those skills into Clojure and learn more about Functional Programming.

## Requirements

+ Laptop
+ Java 1.8 or greater

## Topics Covered

### Up and Running

+ Introduction to Leiningen
  + Creating new projects
  + The project file: `project.clj`
  + The REPL
+ Introduction to namespaces
  + `(ns hello-world.core)`
  + `(require 'hello-world.core :reload)`

### Basics

+ S-expressions
  + Prefix notation
  + Homoiconicity and using `quote`
  + **Advanced Analogy**: a discussion on OOP message passing and Lisps
+ Primitive operators
  + Math
  + Boolean logic
  + Strings
+ Conditionals
  + `if` and `cond`
  + `cond`, `condp`, and `case`
  
### Functions

+ Defining functions
  + `fn` and `defn`
  + Anonymous function literals
  + Arguments, multi-arity
+ Recursion
  + `loop` and `recur`
  + Recursive functions for both recursive and iterative processes
  + Tail call optimization and the JVM (i.e. stack vs. register machines)
+ Bindings
  + `let` and `letfn`
  + Lexical scope
  + Efficiency
  + Destructuring
  
### Data Structures

+ Immutable state
+ Sequence and collection abstractions
+ Lists, vectors, and hash-maps
  + Implementations under the hood
+ Sequence functions:
  + `cons`, `conj`, `concat`, `first`, `next`, `rest`, etc.
+ Key-value functions: 
  + `assoc`, `assoc-in`, `update`, `update-in`, etc.
+ Lazy-seqs
  + `range`, `repeat`, `take`, `drop`, etc.
  + How is lazy evaluation implemented? (thunks)
  + Gotchas (i.e. realizing output of higher order functions)
   
### Higher order functions

+ `map`, `reduce`, `filter`, and `apply`
+ `for`, `doseq`, and `run!`
+ Solving problems functionally

### Advanced Clojure (time permitting)

+ Java interop
+ Mutability
  + Atoms
  + Transients
+ OOP
  + Protocols
  + Multimethods
+ Macros
