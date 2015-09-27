# Composite

Lets clients treat individual objects and compositions of objects uniformly. So in other words methods on a type accepting the same type.

* Component
* Leaf
* Composite

## Composite in JDK

    javax.swing.JComponent#add(Component)
    java.awt.Container#add(Component)
    java.util.Map#putAll(Map)
    java.util.List#addAll(Collection)
    java.util.Set#addAll(Collection)
