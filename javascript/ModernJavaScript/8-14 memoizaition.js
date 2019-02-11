function memorize(f) {
    let cache = {};
    return function (x) {
        if (cache[x] == undefined) cache[x] = f(x);
        return cache[x];
    };
}

function isPrime(n) {
    if (n < 2) return false;
    let m = Math.sqrt(n);
    for (let i = 2; i <= m; i++)
        if (n % i == 0) return false;
    return true;
}

let isPrime_memo = memorize(isPrime);
let N = 1000;
for(let i = 2; i<=N; i++) isPrime_memo(i);

for(let i=2; i+2<=N; i++){
     if(isPrime_memo(i) && isPrime_memo(i+2))
     console.log(i+", "+(i+2));
}