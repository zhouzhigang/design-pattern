# Prototype

Create new objects by copying this prototype.

## Prototype in JDK

    java.lang.Object#clone()
    java.lang.Cloneable

### Shadow Clone and Deep Clone

Deep Clone
1. Override clone method
2. Serialize and Deserialize(`Serializable`, `Externalizable`)

## When to use?
Create an object by `new` waster a lot of time, we will try to use prototype to clone an object.
