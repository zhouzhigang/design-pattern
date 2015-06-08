# Singleton pattern

## Common uses
The `Abstract Factory`, `Builder`, and `Prototype` patterns can use `Singletons` in their implementation.
`Facade` objects are often singletons because only one Facade object is required.
`State` objects are often singletons.
Singletons are often preferred to global variables because:
They do not pollute the global namespace (or, in languages with namespaces, their containing namespace) with unnecessary variables.
They permit lazy allocation and initialization, whereas global variables in many languages will always consume resources.

## Implementation

### Lazy initialization

### Eager initialization

### Static block initialization

### Initialization-on-demand holder idiom

### The enum way

## Reference
* [Singleton Pattern - WikiPedia](http://en.wikipedia.org/wiki/Singleton_pattern)

