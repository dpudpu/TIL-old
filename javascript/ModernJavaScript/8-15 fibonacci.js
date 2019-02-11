function memorize(f) {
    let cache = {};
    return function (x) {
        if (cache[x] == undefined) cache[x] = f(x);
        return cache[x];
    }
}

let fibonacci = memorize(function (n) {
    if (n < 2) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
});

for (let i = 0; i <= 20; i++)
    console.log((" " + i).slice(-2) + ":" + fibonacci(i));
