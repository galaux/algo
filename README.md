Some algorithms implementation just for fun
===========================================

Except for the Quick sort, all algorithms should be coded in Scala.

- s01: Simple Divide and Conquer
- s02: Quick sort (implemented in Go to try out Go)
- s03: Random Contraction

About the go implementation of the Quick Sort
---------------------------------------------
Use the following one liner to 'continuously' build and run the app (thanks [0]):
```inotifywait -m -r -e close_write --exclude '.*\.sw[a-z]' src/ | while read line; do make; done```

[0] http://notes.kel.pe/post/14062831170/continuous-compilation
