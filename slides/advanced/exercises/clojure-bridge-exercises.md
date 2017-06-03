# Basics

- Use `(type )` to return the type of:
    - `true`, `0`, `0.0`, `0N`, `0.0M`, `1/2`, `\f`, `"f"`
- Pass a **list** to `(type )` to return:
    - `clojure.lang.PersistentList$EmptyList`
    - `clojure.lang.PersistentList`
- Write a boolean `if` function that returns the string:
    - "This is true!" when true
    - "This is false!" when false
    - For the condition, simply use the Clojure primitives for truth and falsity
- Compare `1/2` and `0.5` using an `if` statement. Can you make it return true?
- Use `cond` or `condp` to map out your day:
    - For temperatures greater than `65`, return `"I'll go to the park."`
    - For temperatures greater than `32` but less than `65`, return `"I'll watch some football."`
    - For temperatures less than `32`, return `"I'll build a snowwoman."`
    - Pass a temperature to return each of these values, one at a time, in the REPL.




    user=> (type '()) ; empty list
    user=> (type '(1 2)) ; persistent list

    (if false "I'll go to a park." "I'll go to a cafe.")
    (if (== 1/2 0.5) true false)

        (cond
         (> temp 65) "I'll enjoy walking at a park."
         (> temp 45) "I'll spend time at a cafe."
         :else "I'll curl up in my bed.")

        (condp < temp
               65 "I'll enjoy walking at a park."
               45 "I'll spend time at a cafe."
               "I'll curl up in my bed")

user=> (not= nil 0)
true

# Functions

## `def`/`defn`

- Write a function that returns an argument multiplied by 10 using `def`.
- Write a function that returns an argument multiplied by 10 using `defn`.

## Recursion

- Write a recursive function that sums a list of numbers with out `recur`.
- Write a recursive function that sums a list of numbers using `loop` and `recur`.


## Answers

    user=> (def ten-times (fn [x] (* 10 x)))
    #'user/ten-times
    user=> (ten-times 6)
    60


### Recursion

Previously, we defined recursive functions by having those functions call themselves explicitly.

    (defn sum [numbers]
      (if-let [n (first numbers)]
        (+ n (sum (rest numbers)))
        0))

    user=> (sum (range 10))
    45

But this approach breaks down when we have the function call itself deeply, over and over again.

    user=> (sum (range 100000)) StackOverflowError clojure.core/range/fn--4269 (core.clj:2664)

Every time you call a function, the arguments for that function are stored in memory, in a region called the stack. They remain there for as long
as the function is being called–including any deeper function calls.

    (+ n (sum (rest numbers)))

In order to add n and (sum (rest numbers)), we have to call sum first–while holding onto the memory for n and numbers. We can’t re-use that memory
until every single recursive call has completed. Clojure complains, after tens of thousands of stack frames are in use, that it has run out of
space in the stack and can allocate no more.

But consider this variation on sum:

    (defn sum
        ([numbers]
            (sum 0 numbers))
        ([subtotal numbers]
            (if-let [n (first numbers)]
                (recur (+ subtotal n) (rest numbers)) subtotal)))

    user=> (sum (range 100000)) 4999950000

We’ve added an additional parameter to the function. In its two-argument form, sum now takes an accumulator, subtotal, which represents the count
so far. In addition, recur has taken the place of sum. Notice, however, that the final expression to be evaluated is not +, but sum (viz recur)
itself. We don’t need to hang on to any of the variables in this function any more, because the final return value won’t depend on them. recur
hints to the Clojure compiler that we don’t need to hold on to the stack, and can re-use that space for other things. This is called a
tail-recursive function, and it requires only a single stack frame no matter how deep the recursive calls go.

Use recur wherever possible. It requires much less memory and is much faster than the explicit recursion.

You can also use recur within the context of the loop macro, where it acts just like an unnamed recursive function with initial values provided.
Think of it, perhaps, like a recursive let.

    user=> (loop [i 0
                  nums []]
             (if (< 10 i)
               nums
               (recur (inc i) (conj nums i))))
    [0 1 2 3 4 5 6 7 8 9 10]
