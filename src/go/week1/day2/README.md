# :no_entry_sign: Try 1

```
	 static int factorial(int n) {
		 if (n<=1) return 1;
		 return factorial(n-1)*n;
	}
```

```
			String a =String.valueOf(factorial(n));
			int idx = a.length();
			int res = 0
			for(int i = idx-1; i>=0; i--) {
				if (a.charAt(i)!='0') break;
				else res++;
			}
			System.out.println(res);
```

- 팩토리얼을 직접 구했지만, int범위때문에 올바른 값이 나오지 않았다.
- number값인 파이썬으로 테스트가 되었는데, **BigInteger라는 객체**라는 사용하면 factorial를 사용해도 될 거 같다.

# :heavy_check_mark: Try 2



```
	        int n = Integer.parseInt(st.nextToken());
			int res = n/5+n/25+n/125;
			System.out.println(res);
```

- 실제로 팩토리얼 25까지의 Output을 보고 0의 규칙성을 확인하였고, 5의 배수마다 res+1를 추가했다.
- 5^3까지만 더하였는데 n의 범위가 500까지기 때문에이다. 만약 1000의 범위라면 n/625 마다 res+1 해주면 될 것같다.