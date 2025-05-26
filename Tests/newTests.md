
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


let l = 1:?2:?3:?4:?5:?nil;
let v = 1:?2:?3:?4:?5:?nil;
let lmap = fn f, l => {
    match l {
        nil -> nil
        | 
        x::y -> (f(x))::(lmap(f)(y))
    }
};
let doubled = lmap(fn x => { x*2 })(l);
println(v);
println(l);
doubled;;


let l = 1:?2:?3:?4:?5:?6:?nil;
let lfilter = fn f, l => {
    match l {
        nil -> nil
        | x::y -> if (f(x)) { 
            x:: (lfilter(f) (y)) 
            } else { 
                lfilter(f) (y) 
            }
    }
};
let evens = lfilter(fn x => { (x/2)*2 == x }) (l);
evens;;


let mkll = fn n => {
    if (n==0) { 
        nil 
    } else { 
        n:? (mkll(n-1)) 
    }
};
let outer = mkll(3);
let nested = outer :? (outer :? nil);
match nested {
    nil -> println(nil)
  | x::y -> println(x); println(y)
};;


let mkprintll = fn n => {
    if (n==0) { 
        nil 
    } else { 
        n:? (mkprintll(n-1)) 
    }
};
let l = mkprintll(3);
match l {
    nil -> println(nil)
    | 
    x::xs -> println(x); match xs {
        nil -> println(nil)
      | y::ys -> println(y)
    }
};
l;;



