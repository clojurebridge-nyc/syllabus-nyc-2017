

# Part II: Functions

---

## First Class

Prefix notation:

`(predicate argument argument ...)`

Pass a function as an argument:

`(predicate arguments (predicate (predicate arguments)))`
  
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

- Remember
    - Symbols are forms. They evaluate to what they name.
    - `inc` is a symbol that names a function
- `def`
    - Defines a symbol
    - `(def hello-world "Hello World!")`
    - `hello-world`
    - `> "Hello World!"`

---

# Creating Functions
## Symbols Revisited

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
## Optional Arguments

    (defn foo
      ([a]
          (foo a nil))
      ([a b]
          (println "Required argument a is" a)
          (println "Optional argument b is" b)))

---

# Creating Functions
## Multi-arity
## Faster

    (defn foo [a & [b]]
      (println "Required argument a is" a)
      (println "Optional argument b is" b))




---

# Destructuring

<!-- # Data: [Binding Forms and Destructuring](http://xahlee.info/clojure/clojure_binding_forms.html) -->

<!-- ## *binding form*: syntax for local variable assignment -->

<!--     (defn norm -->
<!--         [coordinate] -->
<!--         (let [x (nth coordinate 0) y (nth coordinate 1)] -->
<!--             (Math/sqrt (+ (Math/pow x 2) (Math/pow y 2)) ))) -->

<!--     (defn norm2 -->
<!--         [coordinate] -->
<!--         (let [[x y] coordinate] -->
<!--             (Math/sqrt (+ (Math/pow x 2) (Math/pow y 2))))) -->

<!--     (defn norm3 -->
<!--         [[x y]] -->
<!--         (Math/sqrt (+ (Math/pow x 2) (Math/pow y 2)) )) -->

<!--     (norm [3 4])                            ; 5.0 -->

---

## Recursion

<!-- - Recursive functions for both recursive and iterative processes -->
<!-- - `loop` and `recur` -->
<!-- - Tail call optimization and the JVM (i.e. stack vs. register machines) -->

<!-- ### [Proper Tail Recursion](http://www.schemers.org/Documents/Standards/R5RS/HTML/r5rs-Z-H-6.html#%_sec_3.5) -->

<!-- Must support an unbounded number of active tail calls (in Scheme) -->

<!-- - A call is active if the called procedure may still return. -->
<!--     - Includes calls that may be returned from either by the current continuation or -->
<!--     - By continuations captured earlier by call-with-current-continuation that are later invoked -->

<!-- In the absence of captured continuations, calls could return at most once and the active calls would be those that had not yet returned. -->

<!-- A tail call is a procedure call that occurs in a tail context. Tail contexts are defined inductively. Note that a tail context is always determined with respect to a particular lambda expression. -->

<!-- The last expression within the body of a lambda expression, shown as <tail expression> below, occurs in a tail context. -->

<!--     (lambda <formals> -->
<!--     <definition>* <expression>* <tail expression>) -->

<!-- Other examples: -->

<!--    (if <expression> <tail expression> <tail expression>) -->
<!--    (if <expression> <tail expression>) -->

<!--    (cond <cond clause>+) -->
<!--    (cond <cond clause>* (else <tail sequence>)) -->


<!-- etc... -->

<!-- ### Evlis Tail Recursion -->

<!-- Evlis tail recursion: when performing a procedure call and during the evaluation of the last subexpression, the calling environment is discarded as soon as it is not required. -->

<!-- The distinction between *evlis tail recursion* and *proper tail recursion* is subtle. Proper tail recursion requires only that the calling environment be discarded before the actual procedure call; evlis tail recursion discards the calling environment even sooner, if possible. -->

<!-- Consider the straightforward factorial implementation in Scheme: -->

<!--     (define (fact n) (if (<= n 1) 1 (* n (fact (- n 1))))) -->

<!-- It is not tail-recursive, since the recursive call is nested in another procedure call. However, it's almost tail-recursive; the call to * is a tail call, and the recursive call is its last subexpression, so it will be the last subexpression to be evaluated. -->

<!-- Recall what happens when a procedure call (represented as a list of subexpressions) is evaluated: each subexpression is evaluated, and the first result (the procedure) is passed the other results as arguments. -->

<!-- An example will help to clarify things. Given fact as defined above, say you evaluate (fact 10) and you're in the procedure call with n = 5. The -->
<!-- call stack of a properly tail-recursive interpreter would look like this: -->

<!--     evalExpr -->
<!--     -------- -->
<!--     env = { n: 10 } -> <top-level environment> -->
<!--     expr = '(* n (fact (- n 1)))' -->
<!--     proc = <native function: *> -->
<!--     args = [10, <pending evalExpr('(fact (- n 1))', env)>] -->

<!--     evalExpr -->
<!--     -------- -->
<!--     env = { n: 9 } -> <top-level environment> -->
<!--     expr = '(* n (fact (- n 1)))' -->
<!--     proc = <native function: *> -->
<!--     args = [9, <pending evalExpr('(fact (- n 1))', env)>] -->

<!--     ... -->

<!--     evalExpr -->
<!--     -------- -->
<!--     env = { n: 6 } -> <top-level environment> -->
<!--     expr = '(* n (fact (- n 1)))' -->
<!--     proc = <native function: *> -->
<!--     args = [6, <pending evalExpr('(fact (- n 1))', env)>] -->

<!--     evalExpr -->
<!--     -------- -->
<!--     env = { n: 5 } -> <top-level environment> -->
<!--     expr = '(if ...)' -->

<!-- whereas the call stack of an evlis tail-recursive interpreter would look like this: -->

<!--     evalExpr -->
<!--     -------- -->
<!--     env = { n: 5 } -> <top-level environment> -->
<!--     pendingProcedureCalls = [ -->
<!--       [<native function: *>, 10], -->
<!--       [<native function: *>, 9], -->
<!--       ... -->
<!--       [<native function: *>, 6] -->
<!--     ] -->
<!--     expr = (if ...) -->

<!-- In this implementation, the last subexpression of a procedure call is evaluated exactly like a tail expression, but the procedure call and non-last subexpressions are pushed onto a stack. Whenever an expression is reduced to a simple one and the stack is non-empty, a pending procedure call with its other args are popped off, and it is called with the reduced expression as the final argument. -->

<!-- Note that this didn't change the asymptotic behavior of the procedure; it still takes \(\Theta(n)\) memory to evaluate. However, only the bare minimum of information is saved: the list of pending functions and their arguments. Other auxiliary variables, and crucially the nested calling environments, aren't preserved, leading to a significant constant-factor reduction in memory. -->

<!-- ### Tail Call Optimizations and the JVM -->

<!-- (i.e. stack vs. register machines) -->

---

## Bindings

<!-- - `let` and `letfn` -->
<!-- - Mutual recursion -->
<!-- - Efficiency considerations -->

<!-- # Functions -->

<!-- ## Closures -->

<!-- ### let and letfn -->

<!-- `letfn` is intended for use in cases of mutual recursion: -->

<!--     (letfn [(is-even? [n] -->
<!--               (if (zero? n) -->
<!--                   true -->
<!--                   (is-odd? (dec n)))) -->
<!--             (is-odd? [n] -->
<!--               (if (zero? n) -->
<!--                 false -->
<!--                 (is-even? (dec n))))] -->
<!--             (is-even? 42)) -->

<!--       ;; => true -->

<!-- Don't use it at the top level. -->

<!-- `letfn` has slightly different syntax from `let`. While you can define a function like this in `let`: -->

<!--     (let [double (fn [x] (* 2 x))] (double 21)) -->

<!-- In `letfn`, it's like this: -->

<!--     (letfn [(double [x] (* 2 x))] (double 21)) -->

<!-- Example #2: -->

<!--     (defn ring [n] -->
<!--         (letfn [(a [n] (if (zero? n) n (b (dec n)))) -->
<!--               (b [n] (if (zero? n) n (c (dec n)))) -->
<!--               (c [n] (if (zero? n) n (a (dec n))))] -->
<!--              (c n))) -->
<!--     (ring 1000) -->

---
