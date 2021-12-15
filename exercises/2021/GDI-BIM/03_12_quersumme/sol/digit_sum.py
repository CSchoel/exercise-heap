def digit_sum(n):
	# // operator performs integer division
	return n if (n <= 9) else (n % 10 + digit_sum(n // 10))