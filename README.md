# syllabus-may-2017

+ Leiningen basics:
  + creating new projects
  + quick project.clj overview
  + using the REPL
+ s-expressions:
  + prefix notation
  + homoiconicity and using `quote`
  + for advanced track show an example (I like to use message passing to draw a connection with OOP)
  + I would omit `syntax-quote` and `unquote` and not cover macros, but imagine that will be up for debate
+ namespaces:
  + keep this *very* brief
  + `(ns hello-world.core)`
  + `(require 'hello-world.core :reload)`
+ functions:
  + `defn`, `fn`, and anonymous function literals
  + how to work with first class functions
  + `loop` and `recur`
    + using recursive functions to generate both recursive and iterative processes
    + what counts as proper tail position
    + for advanced track talk about why the JVM doesn't have TCO by default and the difference between proper tail recursion and evlis tail recursion (i.e. stack vs. register machines)
+ conditionals:
  + `if` and `cond`
  + for advanced cover differences between `cond`, `condp`, and `case`
+ data structures:
  + how to work with immutable state
  + sequence and collection abstractions
  + what is lazy evaluation and how is it implemented in Clojure?
    + for beginners keep this very brief, i.e. gotchas related to realizing the output of higher order functions
    + for advanced cover lazy-seqs (`range`, `repeat`, `take`, and `drop`) as well as implementation via thunks
  + lists, vectors, and hash-maps
    + don't cover sets
    + for advanced explain how each is actually implemented (vectors are nothing like C++ vectors)
  + sequence functions: `cons`, `conj`, `concat`, `first`, `next`, `rest`, etc.
  + key-value functions: `assoc`, `assoc-in`, `update`, `update-in`, etc.
  + use graphics for each data structure and how common functions work on them (should be easy to find online)
+ higher order functions:
  + `map`, `reduce`, `filter`, and `apply`
  + for advanced track possibly add `for`, `doseq`, and `run!` (they may already be familiar with list comprehensions and for-each)
+ very basic Java/JavaScript interop:
  + use Java math library as example
+ Should we cover protocols and multimethods or not?
+ Should the advanced track cover mutability (i.e. atoms and transients)?
