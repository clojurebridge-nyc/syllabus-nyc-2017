<div id="table-of-contents">
<h2>Table of Contents</h2>
<div id="text-table-of-contents">
<ul>
<li><a href="#org2d168de">1. Why learn to code?</a>
<ul>
<li><a href="#org745bcbe">1.1. Why you are here</a></li>
</ul>
</li>
<li><a href="#orgb0b5b13">2. Why clojure?</a>
<ul>
<li><a href="#org53abda6">2.1. What is Clojure?</a></li>
</ul>
</li>
<li><a href="#org5cfc793">3. But first, we have to start small</a>
<ul>
<li><a href="#org10ec7db">3.1. Walking before we run</a></li>
</ul>
</li>
<li><a href="#org7dac028">4. Data structures</a>
<ul>
<li><a href="#orge0ebabe">4.1. our building blocks</a></li>
</ul>
</li>
<li><a href="#org8dc2ba7">5. Functions</a>
<ul>
<li><a href="#org75cc19f">5.1. change the world</a></li>
</ul>
</li>
<li><a href="#org6c2fb5b">6. Building a project</a>
<ul>
<li><a href="#org33fa720">6.1. Clojure build tools</a></li>
</ul>
</li>
<li><a href="#orgb600b56">7. The turtles project</a>
<ul>
<li><a href="#org1afe8ed">7.1. Imperative Programming through Turtles</a></li>
<li><a href="#org5825843">7.2. Movement</a></li>
<li><a href="#orga782470">7.3. Our first programs</a></li>
<li><a href="#orge74d339">7.4. variations on the theme</a></li>
</ul>
</li>
<li><a href="#orga83a8db">8. reconsidering theory in light of turtles</a>
<ul>
<li><a href="#org7c94ef0">8.1. Data Structures revisited</a></li>
<li><a href="#org529736d">8.2. controlled evaluation</a></li>
<li><a href="#orgd2ab058">8.3. Higher order functions</a></li>
</ul>
</li>
<li><a href="#org2447d61">9. Our building blocks</a>
<ul>
<li><a href="#org9d99768">9.1. Base data types</a></li>
<li><a href="#org0bc6b3c">9.2. Keywords</a></li>
<li><a href="#org92ae298">9.3. Symbols</a></li>
<li><a href="#orgcc667ee">9.4. Strings</a></li>
<li><a href="#orgbac984d">9.5. Characters</a></li>
<li><a href="#orgdddb24f">9.6. Arithmetic in Clojure</a></li>
<li><a href="#orgc6e915c">9.7. Clojure has namespaces</a></li>
<li><a href="#org00fc23e">9.8. Compound data</a></li>
<li><a href="#orgff0dbd4">9.9. Clojure is functional</a></li>
<li><a href="#org5da5fbe">9.10. Multi-arity</a></li>
</ul>
</li>
</ul>
</div>
</div>


<a id="org2d168de"></a>

# Why learn to code?


<a id="org745bcbe"></a>

## Why you are here

-   You will understand more about how the world around you works
-   You might be able to get a job coding
-   You will understand how to break big problems into smaller ones
-   You will eventually build websites and phone apps


<a id="orgb0b5b13"></a>

# Why clojure?


<a id="org53abda6"></a>

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


<a id="org5cfc793"></a>

# But first, we have to start small


<a id="org10ec7db"></a>

## Walking before we run

-   simple values
-   booleans and nil
-   keywords
-   numbers and arithmetic


<a id="org7dac028"></a>

# Data structures


<a id="orge0ebabe"></a>

## our building blocks

-   lists
-   vectors
-   maps


<a id="org8dc2ba7"></a>

# Functions


<a id="org75cc19f"></a>

## change the world

-   What are functions?
-   Functions that take other functions
-   Predicate functions
-   Anonymous functions
-   Pure functions


<a id="org6c2fb5b"></a>

# Building a project


<a id="org33fa720"></a>

## Clojure build tools

-   Lennigen
-   the REPL
-   Namespaces


<a id="orgb600b56"></a>

# The turtles project


<a id="org1afe8ed"></a>

## [Imperative Programming through Turtles](https://github.com/ClojureBridge/welcometoclojurebridge/blob/master/outline/TURTLE-SAMPLES.md)

-   How to walk turtles
    -   initial state
    -   `undo`, `clean` and `home`
    -   `state`
    -   `doc`


<a id="org5825843"></a>

## Movement

-   Basic Movement - forward, backward right and left
-   Multiple turtles
    -   tilt
-   Add one more turtle and give them commands
-   Move all five turtles - Introduction to functions
    -   `map` higher order functions


<a id="orga782470"></a>

## Our first programs

-   Write a function that adds turtles
-   Functions with parameters
-   control flow with `if` to check input


<a id="orge74d339"></a>

## variations on the theme

-   Functions with five turtles moving in different directions
    -   use `map`
    -   use recursion


<a id="orga83a8db"></a>

# reconsidering theory in light of turtles


<a id="org7c94ef0"></a>

## Data Structures revisited

-   Immutable state
-   Sequence and collection abstractions
-   Lists, vectors, and hash-maps


<a id="org529736d"></a>

## controlled evaluation

-   Sequence functions
-   Key-value functions
-   Lazy evaluation


<a id="orgd2ab058"></a>

## Higher order functions

-   `map`, `reduce`, `filter`, `apply`, etc.
-   Solving problems functionally


<a id="org2447d61"></a>

# Our building blocks


<a id="org9d99768"></a>

## Base data types

-   Numbers

    '(12
     +12
     -100)

    (println  (+ 9 1))

    [1 2 3 4]


<a id="org0bc6b3c"></a>

## Keywords

-   **Keywords** are special words that name a part of a complicated data
    structure. They are clojures fast way to get to the data we need

    :foobar
    :2
    :?


<a id="org92ae298"></a>

## Symbols

-   **Symbols** evaluate to functions or variables

    sample-symbol
    f1
    swap!


<a id="orgcc667ee"></a>

## Strings

-   **Strings** are ordered collections of characters. We denote a string
    by putting it in double quotes

    (print "Hi Evan")


<a id="orgbac984d"></a>

## Characters

-   **Characters** are also a type. A character is just a single letter
-   it has a backslash in front of it.


<a id="orgdddb24f"></a>

## Arithmetic in Clojure

-   Computers were first used to do large arithmetic calculations.
-   Clojure uses **prefix notation** which means the operation is at the beginning

    (+ 1 3) 
    ;;NOT (1 + 3)


<a id="orgc6e915c"></a>

## Clojure has namespaces

-   A namespace is a container that makes it easier to create unique
    names for functions and symbols

    radio/change station
    clojure.core/- 


<a id="org00fc23e"></a>

## Compound data

-   Strings put individual characters together but we will want to put
    numbers and letters together.  Clojure has several compund data
    structures.
    1.  a list '(1 2 3 4)
    
    2.  a vector [1 2 3 4]
    
    3.  a set which has only unique elements #{1 2 3}
    
    4.  a map {:evan 1, :ray 3, :jeff 2} which maps names to values. In
        other languages this is called an associative array or a hash-map.


<a id="orgff0dbd4"></a>

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


<a id="org5da5fbe"></a>

## Multi-arity

-   if a function can take different numbers fo

