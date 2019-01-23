### 배열 최소값 (Java 8’s Stream API)
```java
    int[] integers = new int[] { 20, 98, 12, 7, 35 };
     
    int min = Arrays.stream(integers)
      .min()
      .getAsInt();
```
