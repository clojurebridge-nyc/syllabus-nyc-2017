# ClojureBridge NYC: Syllabus
# Advanced Track

## Course Description

This course is for individuals with coding experience seeking to translate those skills into Clojure and learn more about Functional Programming.

## Requirements

+ Laptop
+ Java 1.6 or greater

## Topics Covered

### Up and Running

+ Introduction to Leiningen
  + Creating new projects
  + The project file: `project.clj`
  + The REPL
+ Introduction to namespaces
  + `(ns hello-world.core)`
  + `(require 'hello-world.core :reload)`

### The Language

+ S-expressions
  + Prefix notation
  + Homoiconicity and using `quote`
  + **Advanced Analogy**: a discussion on OOP message passing and Lisps
+ Functions
  + Defining functions: `fn` and `defn`
  + Closures: `let`
    + Lexical scope
    + Efficiency
    + Destructuring
  + Calling functions
    + Anonymous function literals
    + Working with first class functions
    + Arguments, multi-arity
  + `loop` and `recur` and `letfn`
    + Recursive functions for both recursive and iterative processes
    + Proper tail recursion
    + Evlis tail recursion
    + Tail Call Optimizations and the JVM (i.e. stack vs. register machines)
    + Mutually referential functions
+ Conditionals
  + `if` and `cond`
  + `cond`, `condp`, and `case`

### Data Structures

+ Data structures
  + Immutable state
  + Sequence and collection abstractions
  + Lazy evaluation
    + Heads and Thunks
    + Gotchas
    + `range`, `repeat`, `take`, and `drop`
  + Lists, vectors, and hash-maps
    + Implementation: S-expressions and trees
    + **Advanced Analogy**: differences from other data structures, like C++ vectors
    + Sequence functions: `cons`, `conj`, `concat`, `first`, `next`, `rest`, etc.
    + Key-value functions: `assoc`, `assoc-in`, `update`, `update-in`, etc.
+ Higher order functions:
  + `map`, `reduce`, `filter`, and `apply`
  + `for`, `doseq`, and `run!`

### Advanced Clojure

+ Interop: Java math library
+ Mutability
  + Atoms
  + Transients
+ Polymorphism
  + Protocols
  + Multimethods
+ Macros
