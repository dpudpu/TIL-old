출처 : https://poiemaweb.com/es6-block-scope#12-%EC%A4%91%EB%B3%B5-%EC%84%A0%EC%96%B8-%EA%B8%88%EC%A7%80



대부분의 문제는 전역 변수로 인해 발생한다. 전역 변수는 간단한 애플리케이션의 경우, 사용이 편리하다는 장점이 있지만 불가피한 상황을 제외하고 사용을 억제해야 한다. 전역 변수는 유효 범위(scope)가 넓어서 어디에서 어떻게 사용될 것인지 파악하기 힘들며, [비순수 함수(Impure function)](https://github.com/nhnent/fe.javascript/wiki/April-11---April-15,-2016)에 의해 의도하지 않게 변경될 수도 있어서 복잡성을 증가시키는 원인이 된다. 따라서 변수의 유효 범위(scope)는 좁을수록 좋다.

ES6는 이러한 var의 단점을 보완하기 위해 let과 const 키워드를 도입하였다.





## 1. Let

let 키워드로 선언된 변수는 블록 레벨 스코프를 갖는다.  

#### 1.1 블록 레벨 스코프(Block-level scope)

코드 블록 내에서 선언된 변수는 코드 블록 내에서만 유효하며 코드 블록 외부에서는 참조할 수 없다.

```javascript
let foo = 123;
{
  let foo = 456;
  let bar = 456;
}
console.log(foo); // 123
console.log(bar); // ReferenceError: bar is not defined
```



#### 1.2 중복 선언 금지

```javascript
var foo = 123;
var foo = 456;  // 중복 선언 허용

let bar = 123;
let bar = 456;  // Uncaught SyntaxError: Identifier 'bar' has already been declared
```





#### 1.3 호이스팅

**let 키워드로 선언된 변수는 선언 단계와 초기화 단계가 분리되어 진행된다.** 즉, 스코프에 변수르 등록(선언단계)하지만 초기화 단계는 변수 선언문에 도달했을 때 이루어진다. 초기화 이전에 변수에 접근하려고 하면 참조 에러(ReferenceError)가 발생한다. 이는 변수가 아직 초기화되지 않았기 때문이다. 다시 말하면 변수를 위한 메모리 공간이 아직 확보되지 않았기 때문이다. 따라서 스코프의 시작 지점부터 초기화 시작 지점까지는 변수를 참조할 수 없다. 스코프의 시작 지점부터 초기화 시작 지점까지의 구간을 ‘일시적 사각지대(Temporal Dead Zone; TDZ)’라고 부른다.

```javascript
let foo = 1; // 전역 변수

{
  console.log(foo); // ReferenceError: foo is not defined
  let foo = 2; // 지역 변수
}
```



#### 1.4 클로저

자바스크립트의 함수 레벨 스코프로 인하여 for 루프의 초기화 식에 사용된 변수가 전역 스코프를 갖게 되어 발생하는 문제를 회피하기 위해 [클로저](https://poiemaweb.com/js-closure)를 활용한 방법이다.

ES6의 let 키워드를 for 루프의 초기화 식에 사용하면 클로저를 사용하지 않아도 위 코드와 동일한 동작을 한다.



#### 1.5 전역 객체와 let

let 키워드로 선언된 변수를 전역 변수로 사용하는 경우, let 전역 변수는 전역 객체의 프로퍼티가 아니다. 즉, window.foo와 같이 접근할 수 없다. let 전역 변수는 보이지 않는 개념적인 블록 내에 존재하게 된다.

```javascript
let foo = 123; // 전역변수

console.log(window.foo); // undefined
```





## 2. const

const는 상수(변하지 않는 값)를 위해 사용한다. 하지만 반드시 상수만을 위해 사용하지는 않는다. 이에 대해서는 후반부에 설명한다. const의 특징은 let과 대부분 동일하므로 let과 다른 점만 살펴보도록 하자.



#### 2.1 선언과 초기화

let은 재할당이 자유로우나 const는 재할당이 금지된다

주의할 점은 **const는 반드시 선언과 동시에 할당이 이루어져야 한다**는 것이다. 

또한, const는 let과 마찬가지로 블록 레벨 스코프를 갖는다.



#### 2.2 상수

상수는 가독성과 유지보수의 편의를 위해 적극적으로 사용해야 한다.  

ex)

````javascript
// 10의 의미를 알기 어렵기 때문에 가독성이 좋지 않다.
if (rows > 10) {
}

// 값의 의미를 명확히 기술하여 가독성이 향상되었다.
const MAXROWS = 10;
if (rows > MAXROWS) {
}
````



#### 2.3 const와 객체

const는 재할당이 금지된다. 이는 const 변수의 타입이 객체인 경우, 객체에 대한 참조를 변경하지 못한다는 것을 의미한다. 하지만 이때 **객체의 프로퍼티는 보호되지 않는다.** 다시 말하자면 재할당은 불가능하지만 할당된 객체의 내용(프로퍼티의 추가, 삭제, 프로퍼티 값의 변경)은 변경할 수 있다.

````javascript
const user = { name: 'Lee' };

// const 변수는 재할당이 금지된다.
// user = {}; // TypeError: Assignment to constant variable.

// 객체의 내용은 변경할 수 있다.
user.name = 'Kim';

console.log(user); // { name: 'Kim' }
````

객체의 내용이 변경되더라도 객체 타입 변수에 할당된 주소값은 변경되지 않는다. 따라서 **객체 타입 변수 선언에는 const를 사용하는 것이 좋다.** 만약에 명시적으로 객체 타입 변수의 주소값을 변경(재할당)하여야 한다면 let을 사용한다.

​	

# 3. var vs. let vs. const

var와 let, 그리고 const는 다음처럼 사용하는 것을 추천한다.

- ES6를 사용한다면 var 키워드는 사용하지 않는다.
- 재할당이 필요한 변수에는 let을 사용한다.
- 변경이 발생하지 않는(재할당이 필요 없는) 원시 타입과 객체 타입에는 const를 사용한다.