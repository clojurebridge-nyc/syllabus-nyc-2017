<!-- $theme: gaia
 template: gaia
 -->

# Part II: Functions

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
    - Do not change the program's state, unless **explicitly** made to do so
    - Example: `println`

---

# Creating Functions

`fn`

- `(fn [x] x)` - `(predicate argument argument)`
- `((fn [x] x) 2)`
    - &rArr; `2`
    - `((predicate argument argument) argument))`

---

# Creating Functions
## Anonymous Functions

- Parameters can be functions
    - `((fn [x] (zero? x)) 0)` &rArr; `true`
    - `((fn [x] (zero? x)) 4)` &rArr; `false`

---

# Creating Functions
## Anonymous Functions

- `#()` - for short functions passed as arguments
    - It takes arguments named `%`, `%2`, `%3`, `%n` ... `%&`.
    - `(#(* 2 %) 3)` &rArr; `6`
    - `((fn [x] (even? x)) (#(* 2 %) 3))` &rArr; `true`
- An anonymous function has no name, so you don't know what to "call" it!

---

# Creating Functions
## Symbols Revisited

Remember: 

- Symbols are forms. They evaluate to what they name.
- `inc` is a symbol that names a function

---

# Creating Functions
## Symbols Revisited

`def`

- Defines a symbol
- `(def hello-world "Hello World!")`
- `hello-world`
- `> "Hello World!"`

---

# Creating Functions

`def`

- Creates or locates a **global var** with the name of **symbol**
- Can name a scalar: `(def x 1)`: `x` &rArr; `1`
- Can name a collection: `(def x '(+ 2 3))`: `x` &rArr; `(+ 2 3)`
- Can name a function: `(def double-num (fn [x] (* x 2)))`: `(double-num 2)` &rArr; `4`

---

# Creating Functions
## The Fast Way

`defn`

- `(defn double-num [x] (* x 2))` &equiv; `(def double-num (fn [x] (* x 2)))`

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

`do`

---

## Local Bindings
### Special Form

`let`

<!-- Evaluates the exprs in a lexical context in which the symbols in the binding-forms are bound to their respective init-exprs or parts therein. -->
<!-- Let:  The exprs are contained in an implicit do -->

- Immutable
- Bindings are sequential
- Pairs: `symbols` and `init-exprs`


    (let [x 1
          y x]
      y)

    > 1


---

## Local Bindings
### Special Form


let:

`(let [double (fn [x] (* 2 x))] (double 21))` &rArr; `42`

letfn:

`(letfn [(double [x] (* 2 x))] (double 21))` &rArr; `42`

---


# Recursion

    (defn factorial
     [n]
     (if (== 1 n)
       n
       (* n (factorial (- n 1)))))

    (factorial 10)
    > 3628800

    (factorial 20000)
    > ERROR: Stack Overflow

<!-- Each recursive call is sequentially added to the stack, until we get to the final call, at which point the result is returned and the stack is popped, one function return at a time. -->

---

# Recursion
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

# Recursion
## Loop and Recur

- `recur` must be the last expression evaluated aka the "tail position"
- Form: `loop` &asymp; `let`
- Arity: the number of bindings.
 

    (loop [x 10]
      (when (> x 1)
        (println x)
        (recur (- x 2))))

---

# Recursion
## Loop and Recur


    (def factorial
      (fn [n]
        (loop [cnt n
               acc 1N]
          (if (zero? cnt)
              acc
            (recur (dec cnt) (* acc cnt))))))

    (factorial 2000)0
    > 18192063202303451348...


<!-- 1N is a number literal called BigInt. Longs are default. A byproduct of the JVM and performance. -->

<!-- Integer/MAX_VALUE -->

---

# Recursion
## Loop and Recur

Tail Recursion

- ? Function calls are not duplicated on the stack
- Final answer obtained when the bottom of the recursive chain is reached
- No need to climb all the way back up to the top of the chain again

---

# Recursion
## Loop and Recur

`recur`

- The only non-stack-consuming looping construct
- Use in tail-position is verified by the compiler

<!-- - Tail call optimization and the JVM (i.e. stack vs. register machines) -->

---

# Recursion
## Evlis Tail Recursion

- Proper tail recursion requires only that the calling environment be discarded before the actual procedure call
- Evlis tail recursion discards the calling environment even sooner, if possible.

`(defn factorial [n] (if (== 1 n)   n   (* n (factorial (- n 1)))))`

`(fact 10)` and you're in the procedure call with n = 5

    evalExpr
    --------
    env = { n: 10 } -> <top-level environment>
    expr = '(* n (fact (- n 1)))'
    proc = <native function: *>
    args = [10, <pending evalExpr('(fact (- n 1))', env)>]

    evalExpr
    --------
    env = { n: 9 } -> <top-level environment>
    expr = '(* n (fact (- n 1)))'
    proc = <native function: *>
    args = [9, <pending evalExpr('(fact (- n 1))', env)>]

    ...

    evalExpr
    --------
    env = { n: 6 } -> <top-level environment>
    expr = '(* n (fact (- n 1)))'
    proc = <native function: *>
    args = [6, <pending evalExpr('(fact (- n 1))', env)>]

    evalExpr
    --------
    env = { n: 5 } -> <top-level environment>
    expr = '(if ...)'

whereas the call stack of an evlis tail-recursive interpreter would look like this:

    evalExpr
    --------
    env = { n: 5 } -> <top-level environment>
    pendingProcedureCalls = [
      [<native function: *>, 10],
      [<native function: *>, 9],
      ...
      [<native function: *>, 6]
    ]
    expr = (if ...)

In this implementation, the last subexpression of a procedure call is evaluated exactly like a tail expression, but the procedure call and non-last subexpressions are pushed onto a stack. Whenever an expression is reduced to a simple one and the stack is non-empty, a pending procedure call with its other args are popped off, and it is called with the reduced expression as the final argument.

Note that this didn't change the asymptotic behavior of the procedure; it still takes \(\Theta(n)\) memory to evaluate. However, only the bare minimum of information is saved: the list of pending functions and their arguments. Other auxiliary variables, and crucially the nested calling environments, aren't preserved, leading to a significant constant-factor reduction in memory.

---

### Tail Call Optimizations and the JVM

(i.e. stack vs. register machines)
