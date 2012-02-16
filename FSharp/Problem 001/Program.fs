// Project Euler
// Problem 1
//
// If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
// The sum of these multiples is 23.
//
// Find the sum of all the multiples of 3 or 5 below 1000.
#light

let is_mult5 x = (x % 5 = 0);
let is_mult3 x = (x % 3 = 0);
let is_mult x = ((is_mult5 x) || (is_mult3 x));

let sum = Seq.fold (fun acc i -> (if is_mult i then i+acc else acc)) 0 {1 .. 999};;