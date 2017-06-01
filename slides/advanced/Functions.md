<!-- $theme: gaia
 template: gaia
 -->

# Functions

---

## First Class

Prefix notation:

`(predicate argument argument ...)`

Pass a function as an argument:

`(predicate arguments`
`(predicate (predicate arguments)))`

---

## First Class

- Homoiconicity
    - Arguments are data
    - Operators are data
- &there4; functions are treated like any other object
    - Passed as an argument
    - Returned as a result
    - Created at runtime

---

## Pure

- Pure function: compiled &rarr; evaluated &rarr; result
- Side effects
    - Possible in Clojure
    - Do not change the program's state, unless *explicitly* made to do so
    - Example: `println`

---

# Creating Functions
## `fn`

`(fn [x] x)` - `(predicate argument argument)`

---

# Creating Functions
## Anonymous Functions

- `((fn [x] x) 2)` &rArr; `2`
    - `((predicate argument argument) argument)`
- Parameters can be functions
    - `((fn [x] (zero? x)) 0)` &rArr; `true`
    - `((fn [x] (zero? x)) 4)` &rArr; `false`

---

# Creating Functions
## Anonymous Functions

- `#()` - for short functions passed as arguments
    - It takes arguments named `%`, `%2`, `%3` ... `%n`.
    - `(#(* 2 %) 3)` &rArr; `6`
    - `((fn [x] (even? x)) (#(* 2 %) 3))` &rArr; `true`
- An anonymous function has no name, so you don't know what to "call" it!

---

# Creating Functions
## Forms Revisited

> A form can be converted into a function if we can determine the correspondence between the *variables* occurring in the *form* and the *ordered list of arguments* of the desired function.

**John McCarthy** *Recursive Functions of Symbolic Expressions and Their Computation by Machine, Part I* (1960)

---

# Creating Functions
## Forms Revisited &rarr; Functions

- `((fn [x y] (* (* 2 y) x)) -1 6)` &rArr; `-12`
    - *Form* - `(* (* 2 y) x)`
    - *Variables* - `[x y]`
    - *Ordered list of arguments* - `-1 6`

---

# Creating Functions
## Symbolic Expressions vs. Functions

Symbolic expressions are:

1. Atomic symbols
    - `> 3` &rArr; `3`
    - `> 3 y` (two expressions, not one)
        - &rArr; `3`
        - &rArr; `Unable to resolve symbol: y`

---

# Creating Functions
## Symbolic Expressions vs. Functions

Symbolic expressions are:

2. Formed by using the special characters `(`, `)`, and an infinite set of distinguishable atomic symbols separated by blanks.
    - `'(3 4)` &rArr; `(3 4)`
    - A single form

---

# Creating Functions
## Symbols Revisited
## `def`

- **Def**ines a symbol
- `(def hello-world "Hello World!")`
- `hello-world` &rArr; `"Hello World!"`

---

# Creating Functions
## `def`

- Creates or locates a **global var** with the name of **symbol**
- Can name a scalar: `(def x 1)`: `x` &rArr; `1`
- Can name a collection: `(def x '(+ 2 3))`: `x` &rArr; `(+ 2 3)`
- Can name a function: `(def double-num (fn [x] (* x 2)))`: `(double-num 2)` &rArr; `4`

---

# Creating Functions
## Symbols Revisited

- Symbols are forms. They evaluate to what they *name*.
- Example: `inc` and `+` are symbols that *name* a function
    - `(inc 2)` &rArr; `3`
    - `(+ 2 1)` &rArr; `3`
    - `inc` &rArr; `#object[clojure.core$inc...]`

---

# Creating Functions
## The Fast Way
## `defn`

`(defn double-num [x] (* x 2))`
&nbsp;&nbsp;&nbsp;&nbsp;&equiv;
`(def double-num (fn [x] (* x 2)))`

    (double-num 3)
    > 6

---

# Creating Functions
## Multi-arity

    (defn do-something
      ([] "nothing")
      ([one] "one parameter")
      ([one two] "two parameters")
      ([one two & more] "more than two parameters!"))

    (do-something)
    > "nothing"
    (do-something 1)
    > "one parameter"
    (do-something 1 2)
    > "two parameters"
    (do-something 1 2 3 4)
    > "more than two parameters"

---

# Creating Functions
## Multi-arity
## Faster

    (defn do-something [a & [b c]]
      (str "Required argument a is " a
           ". Optional argument b is " b
           ". C, optional, is " c "."))

    (do-something 1 2)

    > "Required argument a is 1.
       Optional argument b is 2. C, optional, is ."


---

## Local Bindings
### Special Form
### `let`

<!-- Evaluates the exprs in a lexical context in which the symbols in the binding-forms are bound to their respective init-exprs or parts therein. -->

- Bindings are sequential
- Pairs: `symbols` and `init-exprs`

```
(let [x (+ 1 0)
      y x]
  y)

> 1
```

---

## Local Bindings
### Special Form

### `let`

`(let [double (fn [x] (* 2 x))] (double 21))` &rArr; `42`

### `letfn`

`(letfn [(double [x] (* 2 x))] (double 21))` &rArr; `42`

---

## Controlling Flow
### `do`

- `let` is an implicit `do`
- Evaluates expressions in order
- Fundmentally *imperative*
- Often used to create side effects (ex: print or i/o)

---

## Controlling Flow
### `do`

    (if true (println "This is true: ") (+ 1 1))
    > This is true:
    > nil
    > ;; nil is the return value

vs.

    (if true (do (println "This is true: ") (+ 1 1)))
    > This is true:
    > 2
    > ;; 2 is the return value

---

## Controlling Flow and Scope

```
(defn y [] 
  (let [x 1]
    (println x)
    (def x 2) 
    x)) 
```
&rArr; `1`

```
(defn y [] 
  (let [x 1]
    (println x)
    (def x 2) 
    x)
  x)
```
&rArr; `2`

---

# :arrows_counterclockwise: Recursion

---

# :arrows_counterclockwise: Recursion

- Each recursive call is added to the stack
- Each function is sequentially popped after the final call
 

    (defn factorial
     [n]
     (if (== 1 n)
       n
       (* n (factorial (- n 1)))))

    (factorial 10)
    > 3628800

    (factorial 5000)
    > ERROR: Stack Overflow

---

# :arrows_counterclockwise: Recursion
## Mutual recursion

    (letfn [(is-even? [n]
              (if (zero? n)
                  true
                  (is-odd? (dec n))))
            (is-odd? [n]
              (if (zero? n)
                false
                (is-even? (dec n))))]
            (is-even? 42))

    > true

---

# :arrows_counterclockwise: Recursion
## `loop` and `recur`

- `recur` must be the last expression evaluated aka the "tail position"
- Form: `loop` &asymp; `let`
- Arity: the number of bindings.


    (loop [x 10]
      (when (> x 1)
        (println x)
        (recur (- x 2))))

---

# :arrows_counterclockwise: Recursion
## `loop` and `recur`

    (def factorial
      (fn [n]
        (loop [cnt n
               acc 1N]
          (if (>= 0 cnt)
              acc
            (recur (dec cnt) (* acc cnt))))))

    (factorial 5000)
    > 42285779266055435222...

<!-- 1N is a number literal called BigInt. Longs are default. A byproduct of the JVM and performance. -->

<!-- Does not loop endlessly on a negative value, unlike zero? -->

<!-- Integer/MAX_VALUE -->


---

# :arrows_counterclockwise: Recursion
## `loop` and `recur`
### `recur`

- The only non-stack-consuming looping construct in Clojure
- Use in tail-position is verified by the compiler
- Since Clojure uses the Java calling conventions, tail call optimization must be made explicit by `recur`

---

# Recursion vs. Looping
## Style: Declarative vs. Imperative

*Imperative* - uses statements that change a program's state by describing the program's flow

    var numbers = [1,2,3]
    var total = 0

    for(var i = 0; i < numbers.length; i++) {
      total += numbers[i]
    }

Note: `n` and `total` are modified in the loop

---

# Recursion vs. Looping
## Style: Declarative vs. Imperative

*Declarative* - the function expresses the logic of a computation without describing its control flow


    (fn [numbers]
      (loop [n numbers
             total 0]
        (if (empty? n)
          total
          (recur (rest n) (+ total (first n))))))

Note: `n` and `total` are *not variables*, they are new local bindings in every recursive call

---

# Recursion vs. Looping
## Style: Declarative vs. Imperative

**Equivalent Functional Solution**

`(reduce + '(1 2 3))` &rArr; `6`

Note: this is idiomatic Clojure, more on this later!
