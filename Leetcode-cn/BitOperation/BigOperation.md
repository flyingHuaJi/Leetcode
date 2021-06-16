### 位运算符

左移       <<         0011 => 0110
右移       >>         0110 => 0011

按位或      ｜        0011 ｜ 1011 => 1011
按位与      ｜        0011 &  1011 => 0011
按位取反     ~        ~0011 => 1100
按位异或     ^        0011 ^ 1011 => 1000


### 异或
异或操作的一些特点：

x ^ 0 = x
x ^ 1s = ~x   // 注意 1s = ~0
x ^ (~x) = 1s
x ^ x = 0

c = a ^ b => a^c = b, b^c = a  // 交换两个数 ???



### 指定位置的位运算
1. 将 x 最右边的 n 位清零: x & (~0 << n)
2. 获取 x 的第 n 位值 (0 或者 1) : (x >> n) & 1
3. 获取 x 的第 n 位的幂值：x & (1 << (n - 1))
4. 仅将 n 位置为 1： x | (1 << n)
5. 仅将 n 位置为 0：x & (~(1 << n))
6. 将 x 最高位至第 n 位（含）清零： x & ((1 << n) - 1)
7. 将第 n 位至第 0位（含）清零：x & (~((1 << (n+1)) - 1))


### 实战位运算要点
判断奇偶：
- 偶数：x & 1 == 1
- 奇数：x & 1 == 0

除以 2 -->> x >> 1

清零最低位的 1 --->>>> x = x & (x - 1)
得到最低位的 1 --->>>> x & -x