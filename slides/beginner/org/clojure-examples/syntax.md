<div id="table-of-contents">
<h2>Table of Contents</h2>
<div id="text-table-of-contents">
<ul>
<li><a href="#orgadbcbb3">1. Why learn to code?</a>
<ul>
<li><a href="#orga8bce8f">1.1. Why you are here</a></li>
</ul>
</li>
<li><a href="#orgdf5bcf4">2. Why clojure?</a>
<ul>
<li><a href="#org4c162fd">2.1. What is Clojure?</a></li>
</ul>
</li>
<li><a href="#org2b5e912">3. But first, we have to start small</a>
<ul>
<li><a href="#org9271e41">3.1. Walking before we run</a></li>
</ul>
</li>
<li><a href="#org5f0aa70">4. Data structures</a>
<ul>
<li><a href="#org1d7b9dd">4.1. our building blocks</a></li>
</ul>
</li>
<li><a href="#org2c67898">5. Functions</a>
<ul>
<li><a href="#orgfd66d40">5.1. change the world</a></li>
</ul>
</li>
<li><a href="#org06f9f23">6. Building a project</a>
<ul>
<li><a href="#org81e1cd6">6.1. Clojure build tools</a></li>
</ul>
</li>
<li><a href="#org2aa27e5">7. The turtles project</a>
<ul>
<li><a href="#org80b5379">7.1. Imperative Programming through Turtles</a></li>
<li><a href="#org8adc22c">7.2. Movement</a></li>
<li><a href="#orgcbd7821">7.3. Our first programs</a></li>
<li><a href="#orgeea8956">7.4. variations on the theme</a></li>
</ul>
</li>
<li><a href="#org6af91a9">8. reconsidering theory in light of turtles</a>
<ul>
<li><a href="#org6ce510b">8.1. Data Structures revisited</a></li>
<li><a href="#org080a406">8.2. controlled evaluation</a></li>
<li><a href="#orgffbcff8">8.3. Higher order functions</a></li>
</ul>
</li>
<li><a href="#orgc0b2086">9. Our building blocks</a>
<ul>
<li><a href="#org37b10a3">9.1. Base data types</a></li>
<li><a href="#org38cfd16">9.2. Keywords</a></li>
<li><a href="#org3bd7831">9.3. Symbols</a></li>
<li><a href="#org3f7f555">9.4. Strings</a></li>
<li><a href="#org322c71a">9.5. Characters</a></li>
<li><a href="#org5236e5f">9.6. Arithmetic in Clojure</a></li>
<li><a href="#org652f1f7">9.7. Clojure has namespaces</a></li>
<li><a href="#orgd496d9e">9.8. Compound data</a></li>
<li><a href="#org8659f80">9.9. Clojure is functional</a></li>
<li><a href="#org420b709">9.10. Multi-arity</a></li>
<li><a href="#orge7832dd">9.11. Variadic Functions</a></li>
<li><a href="#org42cee46">9.12. Anonymous functions</a></li>
<li><a href="#org3ac74eb">9.13. Anonymous and variadic</a></li>
<li><a href="#org9a00c6c">9.14. Pure functions in Clojure</a></li>
</ul>
</li>
</ul>
</div>
</div>


<a id="orgadbcbb3"></a>

# Why learn to code?


<a id="orga8bce8f"></a>

## Why you are here

-   You will understand more about how the world around you works
-   You might be able to get a job coding
-   You will understand how to break big problems into smaller ones
-   You will eventually build websites and phone apps


<a id="orgdf5bcf4"></a>

# Why clojure?


<a id="org4c162fd"></a>

## What is Clojure?

-   Clojure is a hosted language that can compile to Java or Javascript
    which allows us to build rich web or phone apps that run in many
    environments.
-   Clojure is a functional programming language which allows us to
    build complex solutions from simple ones.
-   Clojure has immutable data structures which makes it easier to
    reason about programs and helps with performance
-   We can change the state of the program through a series of immutable
    values over time
-   Clojure evaluates programs using its own types allowing us to write
    programs that write programs
-   Clojure has an elegant way of doing asynchronos programming which is
    necessary both for large data and uncertain execution environments
    like the web


<a id="org2b5e912"></a>

# But first, we have to start small


<a id="org9271e41"></a>

## Walking before we run

-   simple values
-   booleans and nil
-   keywords
-   numbers and arithmetic


<a id="org5f0aa70"></a>

# Data structures


<a id="org1d7b9dd"></a>

## our building blocks

-   lists
-   vectors
-   maps


<a id="org2c67898"></a>

# Functions


<a id="orgfd66d40"></a>

## change the world

-   What are functions?
-   Functions that take other functions
-   Predicate functions
-   Anonymous functions
-   Pure functions


<a id="org06f9f23"></a>

# Building a project


<a id="org81e1cd6"></a>

## Clojure build tools

-   Lennigen
-   the REPL
-   Namespaces


<a id="org2aa27e5"></a>

# The turtles project


<a id="org80b5379"></a>

## [Imperative Programming through Turtles](https://github.com/ClojureBridge/welcometoclojurebridge/blob/master/outline/TURTLE-SAMPLES.md)

-   How to walk turtles
    -   initial state
    -   `undo`, `clean` and `home`
    -   `state`
    -   `doc`


<a id="org8adc22c"></a>

## Movement

-   Basic Movement - forward, backward right and left
-   Multiple turtles
    -   tilt
-   Add one more turtle and give them commands
-   Move all five turtles - Introduction to functions
    -   `map` higher order functions


<a id="orgcbd7821"></a>

## Our first programs

-   Write a function that adds turtles
-   Functions with parameters
-   control flow with `if` to check input


<a id="orgeea8956"></a>

## variations on the theme

-   Functions with five turtles moving in different directions
    -   use `map`
    -   use recursion


<a id="org6af91a9"></a>

# reconsidering theory in light of turtles


<a id="org6ce510b"></a>

## Data Structures revisited

-   Immutable state
-   Sequence and collection abstractions
-   Lists, vectors, and hash-maps


<a id="org080a406"></a>

## controlled evaluation

-   Sequence functions
-   Key-value functions
-   Lazy evaluation


<a id="orgffbcff8"></a>

## Higher order functions

-   `map`, `reduce`, `filter`, `apply`, etc.
-   Solving problems functionally


<a id="orgc0b2086"></a>

# Our building blocks


<a id="org37b10a3"></a>

## Base data types

-   Numbers

    '(12
     +12
     -100)

    (println  (+ 9 1))

    [1 2 3 4]


<a id="org38cfd16"></a>

## Keywords

-   **Keywords** are special words that name a part of a complicated data
    structure. They are clojures fast way to get to the data we need

    :foobar
    :2
    :?


<a id="org3bd7831"></a>

## Symbols

-   **Symbols** evaluate to functions or variables

    sample-symbol
    f1
    swap!


<a id="org3f7f555"></a>

## Strings

-   **Strings** are ordered collections of characters. We denote a string
    by putting it in double quotes

    (print "Hi Evan")


<a id="org322c71a"></a>

## Characters

-   **Characters** are also a type. A character is just a single letter
-   it has a backslash in front of it.


<a id="org5236e5f"></a>

## Arithmetic in Clojure

-   Computers were first used to do large arithmetic calculations.
-   Clojure uses **prefix notation** which means the operation is at the beginning

    (+ 1 3) 
    ;;NOT (1 + 3)


<a id="org652f1f7"></a>

## Clojure has namespaces

-   A namespace is a container that makes it easier to create unique
    names for functions and symbols

    radio/change station
    clojure.core/- 


<a id="orgd496d9e"></a>

## Compound data

-   Strings put individual characters together but we will want to put
    numbers and letters together.  Clojure has several compund data
    structures.
    1.  a list '(1 2 3 4)
    
    2.  a vector [1 2 3 4]
    
    3.  a set which has only unique elements #{1 2 3}
    
    4.  a map {:evan 1, :ray 3, :jeff 2} which maps names to values. In
        other languages this is called an associative array or a hash-map.


<a id="org8659f80"></a>

## Clojure is functional

-   Clojure is a functional language.  In practical terms this means
    that it accomplishes its work by dividing its tasks onto functions
    which transform data from input to output.  The next few slides will
    help us understand how to read and write our own functions.

-   `defn` defines a named functions

    (defn greet [name] (str "Welcome, " name))

-   Our functions name is greet
-   It takes a single parameter 'name'
-   It does not return anything, only nil
-   It prints which is considered a side effect


<a id="org420b709"></a>

## Multi-arity

-   A function can take different numbers of arguements
-   Functions must be defined with `defn`
-   Doing this twice replaces the function definition
    -   Slow down! This is strange/weird
        -   One arity c-a-n c-a-l-l a-n-o-t-h-e-r

    (defn myGreeterWdefault
      ([]     (myGreeterWdefault "Where's lunch?"))
      ([msg]  (println msg)))


<a id="orge7832dd"></a>

## Variadic Functions

-   *Variadic* functions have an undefined number of parameters which
    are collected into a sequnce and used by the function. The ampersand
    `&` does not appear when you call the function.
-   The collected arguements come after a '&'

    (defn myGreetingWdefault [greeting & who]
      (println greeting who))

    (hello "Hello" "world" "class")


<a id="org42cee46"></a>

## Anonymous functions

-   *Anonymous* functions can be created and called for a single purpose
-   can be defined with `fn` or `#()`

-   So:

    (=
     (fn [x y] (+ x y))
     #(+ %1 %2))


<a id="org3ac74eb"></a>

## Anonymous and variadic

-   These functions can be expressed as

    (=
     (fn [x y & zs] (println x y zs))
     #(println %1 %2 %&)
    )


<a id="org9a00c6c"></a>

## Pure functions in Clojure

-   *Side Effects* are ways in which the your program interacts with the
    outside world such as printing or writitng to and reading from disk.
    These are necessary but it is impossible to know if they will
    succeed.
-   *Pure* functions are ones that just return a value and have no side effects.

