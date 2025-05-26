
/* test the correct conversion of lazy list to strict list */

let l = 1:?2;
let v = 3::4::l;
match l {
    nil -> println(nil)
|   x::y -> println(x); println(y)
};
match v {
    nil -> println(nil)
|   x::y -> println(x); println(y)
};;


