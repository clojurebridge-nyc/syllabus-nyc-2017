<!-- $theme: gaia
 template: gaia
 -->

# Higher Order Functions

---

# Higher Order Functions

##

---

# Map

## Applies a function to the elements of one or more collections in order and returns the results as a lazy sequence.

### Note: if one wants to take and return vectors, use `mapv` instead.

```
(defn map 
  [f coll]
  (if (empty? coll)
      nil
      (conj (f (first coll))
            (map f (rest coll)))))
```

### Examples:
-

---

# Reduce

## Applies a function to one or more sequential arguments in a collection, building up the result. 

### Referred to as "fold" or "accumulate" in some other languages

### For optimal performance, uses Java Iterators on collections that implement the Iterable interface. Otherwise uses first/next recursion.

### Note: to reduce associative collections, use `reduce-kv`.

```
(defn reduce 
  [f coll)
  (if (empty? coll)
      nil
      (f (first coll)
          (reduce f (rest coll)))))
```

### Examples:
- 

---

# Filter

## Takes a predicate and a collection and returns a lazy sequence of the items for which the predicate returns true.

### Note: if one wants to take and return vectors, use `filterv` instead.

```
(defn filter 
  [pred coll]
  (cond 
    (empty? coll) nil
    (pred (first coll)) (conj (first coll)
                              (filter pred (rest coll)))
    :else (filter pred (rest coll))))

```

### Examples:
-

---

# Apply

## Passes the elements in a collection to a variadic function as arguments.

### Examples:
-

---

# For

## Called a "list comprehension" in languages such as Haskell and Python. Syntax is same as set-builder notation. 

## Takes a vector of bindings, followed by keyword modifiers (`:let`, `:when`, and/or `:while`), and output form. Iterates through all elements in the bindings according to the modifiers and returns a lazy sequence of the results.

### Examples:
-

---

# DoSeq

## Takes a vector of bindings and a body of expressions and repeatedly executes the body with the bindings as arguments, returning `nil`.

### Examples:
-

---

# Run!

## Applies a function to each element in one collection (using reduce), generally for the purpose of side-effects.

### Referred to as "for-each" or "iterate" in other languages.

``` 
(defn run!
   [f coll] 
   (if (empty? coll) 
       nil 
      (do
        (f (first coll)) 
        (for-each f (next coll))))) 
```


### Examples:
-

---
